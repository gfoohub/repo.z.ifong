#!/usr/bin/perl

$target = shift @ARGV;

while (<>){
	chomp;
	($u, @useless) = split;
	if ($u =~ /^$target$/){
		print "$target �b�u�W\n";
		$hit = 1;
		last;
	}
}

print "�ؼ� $target ���b�u�W\n" unless $hit;
