<?
        $input_num  = $_POST['phone_self'];
	$pre_num    = $_POST['phone_num'];

	$self = strcmp($pre_num, '1234567890');
	if ($self == 0){$g_mobile = $input_num;}
	else {$g_mobile = $pre_num;}

        $g_message= $_POST['msg'];
	$username = "cpfong";		# �b��
	$password = "640601";		# �K�X
	$type =	 "now";			# �o�e���A
	$mobile = $g_mobile;		# �q��
	$message = $g_message;		# ²�T���e
	$encoding = "big5";		# ²�T���e�s�X
	$popup = "";			# �ϥ� POPUP ���
	$mo = "";			# �ϥ����V²�T
	$vldtime = "";			# ²�T���Ĵ���
	$dlvtime = "";			# �w���ɶ�

	$msg = "username=".$username."&password=".$password."&type=".$type."&encoding=".$encoding."&popup=".$popup."&mo=".$mo."&mobile=".$mobile."&message=".$message."&vldtime=".$vldtime."&dlvtime=".$dlvtime;
$num = strlen($msg);		

	// debug
	// echo $msg;
	// return 0;

	// ���} API �h�D
	$fp = fsockopen ("api.twsms.com", 80);
	if ($fp) {
		$MSGData .= "POST /send.php HTTP/1.1\r\n";
		$MSGData .= "Host: api.twsms.com\r\n";
		$MSGData .= "Content-Length: ".$num."\r\n";
		$MSGData .= "Content-Type: application/x-www-form-urlencoded\r\n";
		$MSGData .= "Connection: Close\r\n\r\n";
		$MSGData .= $msg."\r\n";
		fputs ($fp, $MSGData);

		// ���X�^�ǭ�
		while (!feof($fp)) $Tmp[]=fgets ($fp,128); 

		// �����h�D
		fclose ($fp);

		// ��ܦ^�ǭ�
		$CheckRes = split("=",$Tmp[9]);

		if (intval($CheckRes[1]) <= 0){
			echo "�ǰe����:".$CheckRes[1];
		}
		else {
			echo "�ǰe����:".$CheckRes[1];
		}
	}
	else {
		echo "�z�L�k�s�� TwSMS API Server";
	}
?>
