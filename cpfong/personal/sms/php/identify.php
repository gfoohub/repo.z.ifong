<?php

include ('connection.inc'	);
								/********* global vars ***************/
$g_pid = 0;							// personal id i.e. A123032xxx
$g_id  = 0;							// id ie cpfong
$g_bir = 0;							// birthday 520323
$g_tab = "cpfriends";
								/********** main *********************/
vars_init();
pid_valid() or die("�b���Ψ������r���αK�X�����D");
disp_info();
// end main

function disp_info(){
	global $g_pid, $g_tab, $g_id;

//	echo "
print <<<_HTML
	<form action=twsms.php method=post>
		����H�O:<SELECT name=phone_num>
				<OPTION value=1234567890 checked>�ۦ��J�ܸ�
				<OPTION value=0928726326>�@��
				<OPTION value=0928686021>�@�Y
				<OPTION value=0937692695>���j
				<OPTION value=0928766928>���M
				<OPTION value=0919205977>�j��
				<OPTION value=0928766969>�v��
			</SELECT>
		��²�T�誺�q�ܬ�:<input type=text name=phone_self size=50 value='0928123456,0919789012'><br>
		²�T���e:<input type=text name=msg size=100 value=�ڬO�v��><br><br>
		<input type=submit value=�e²�T�F></input>
	</form>
_HTML;
//	";
	

} // end disp_info

function pid_valid(){
	global $g_pid, $g_id, $g_bir, $g_tab;
        go_c_db();						// connect to database

	if (strlen($g_id)) {
		// �ϥέӤH���b��ñ�J ex: cpfong
		$sql = "select * from $g_tab where userid ='$g_id'  and bir='$g_bir'";
	}
	else {
		// �ϥΨ������r�� A123456789
		$sql = "select * from $g_tab where pid='$g_pid' and bir='$g_bir'";
	}
	// debug
	// echo "pid_valid sql = " . $sql . "<br>";
	$res = sql_query($sql);
	return ($res);
} // end pid_valid
								/********** vars_init ****************/
function vars_init(){
	global $g_pid, $g_bir, $g_id;

	$g_bir  = trim($_POST['bir']);
	$tmp1   = trim($_POST['pid']);
	$tmp2   = trim($_POST['id']);
	$g_pid	= strtoupper($tmp1);
	$g_id	= strtolower($tmp2);
} // end vars_init

?>
