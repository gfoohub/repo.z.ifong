#!/usr/bin/perl

print "�}�l�Ȭ�: "; chomp($start=<STDIN>);
print "�����Ȭ�: "; chomp($end=<STDIN>);

sub level{
	my $tot=1; 
	my ($s, $e)=@_;my $now=$s;
	
	while ($now <= $e){
		$tot *= $now;
		$now++;
	}
	$tot;
}

$res = level $start,$end;
print " $start to $end ���G�� $res \n";
