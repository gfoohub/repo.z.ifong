#!/usr/bin/perl

%do = qw !	center.fjtc.edu.tw	163.15.196.1
		dns.fjtc.edu.tw		163.15.196.2
		ftp.fjtc.edu.tw		163.15.196.3
		cpfong.fjtc.edu.tw	163.15.196.110 !;

%ip = reverse %do;

print "��J�D���W: "; chomp($domain=<STDIN>) ;
print "��Jip��}: "; chomp($ipaddr=<STDIN>) ;

print "�D���� $domain ���}�� $do{$domain} \n";
print "ip  �� $ipaddr ��D���� $ip{$ipaddr} \n";

