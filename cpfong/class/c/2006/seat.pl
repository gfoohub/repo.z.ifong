#!/usr/bin/perl

$i=0;
while (<>){
	chomp;
	s/^\s+//;
	($idx, $sid, $n, @u) = split;
	$nh{$sid} = $n  ;
	$ih{$idx} = $sid;
	$arr[$i++]=$idx;
}
#10 952136110 ���ɪ� �G�޸�@��

$count = keys %ih;
foreach (0..$count){
	my $r = int rand($count);
	($arr[$_], $arr[$r]) = ($arr[$r], $arr[$_]); 
}

foreach (0..$count){
	print $arr[$_] . " " . $ih{$arr[$_]} . " " . $nh{$ih{$arr[$_]}} . "\n";
}
