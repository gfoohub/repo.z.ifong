#!/usr/bin/perl

print "��J�n�d���b��: "; chomp($in = <STDIN>);

open WHO, "<x"; 
$e = 0;

while (<WHO>){
	chomp;
	@n = split;
	if ($n[0] =~ /^$in$/){
		$e = 1;
		print "$in on line\n";
		last;
	}
}

print "$in ���b�u�W\n" if ($e == 0);
