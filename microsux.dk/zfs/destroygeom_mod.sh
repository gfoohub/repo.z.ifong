#!/bin/sh
# $Id: destroygeom 89 2010-09-06 08:17:15Z mm $
#
# mfsBSD ZFS pool and geom partition deleting
#
# Copyright (c) 2010 Georges Discry <murmex at gathex.net>
#		     Martin Matuska <mm at FreeBSD.org>
#
# Modified by Mikkel Georgsen <mikkel at georgsen.dk>

usage () {
	echo "Usage: $0 [-h] -d geom [-d geom ...] [-p zpool ...]"
}

help () {
	echo; echo "Destroy all partitions on geom provider(s)"
	echo; echo "Required flags:"
	echo "-d geom     : geom provider(s) to clear"
	echo;echo "Optional flags:"
	echo "-p zpool    : zpool(s) installed on the geom providers to clear"
	echo;echo "Examples:"
        echo "Destroy all partitions on ad4 and ad6:"
        echo "$0 -d ad4 -d ad6"
        echo "Destroy ZFS pool tank and all partitions on ada0:"
        echo "$0 -p tank -d ada0"
}

while getopts d:p:h o; do
	case "$o" in
		d) DEVS="$DEVS ${OPTARG##/dev/}" ;;
		p) POOLS="$POOLS ${OPTARG}" ;;
		h) help; exit 1;;
		[?]) usage; exit 1;;
	esac
done

if [ -z "$DEVS" ]; then
	usage
	exit 1
fi


for DEV in ${DEVS}; do
	if ! [ -c "/dev/${DEV}" ]; then
		echo "error: /dev/${DEV} is not a block device"
		exit 1
	fi
done

for POOL in ${POOLS}; do
	if ! zpool list -H ${POOL} > /dev/null 2> /dev/null; then
		echo "warning: pool does not exist"
		continue
	fi

	echo -n "Destroying ZFS pool ${POOL} ..."
	if ! zpool destroy -f ${POOL} > /dev/null 2> /dev/null; then
		echo " error"
		exit 1
	fi
	echo " done"
done


for DEV in ${DEVS}; do
	GEOMS=`gpart show | tail -r | grep '=>' | awk '{print $4}' | grep "^${DEV}" | uniq`
	for GEOM in ${GEOMS}; do
		echo "Destroying geom ${GEOM}:"
		PARTS=`gpart show ${GEOM} | grep -v '=>\|- free -' | awk '{if ($3 ~ /[0-9]+/) print $3}' | sort -n | uniq`
		for PART in ${PARTS}; do
			echo -n "    Deleting partition ${PART} ..."
			if ! gpart delete -i${PART} ${GEOM} > /dev/null 2> /dev/null; then
				echo " error"
				exit 1
			fi
			echo " done"
		done
		if ! gpart destroy ${GEOM} > /dev/null 2> /dev/null; then
			echo "error: could not destroy geom ${GEOM}"
			exit 1
		fi
	done
done
