<?php
	/****************************************************
	 function:	login.php
	 object:	allow those who have account to login
	****************************************************/

	echo "�M�K�޳N�ǰ|�������W�t�� <br>";

	name_passwd_form();

	function name_passwd_form(){
		echo '
			<form action="t.php" method="post">
				�b��: <input type="text" name="acc"><br>
				�K�X: <input type="password" name="pp"><br>
				<input type="submit" value="�n�J"><br>
			</form>
			<a href=./apply_new_acc.php><font color="red">�ߧY���U</font></a>(�Ĥ@���n�J, �|�L�b����)<br>
			<a href=./forget_passwd.php>�ѰO�K�X</a><br>
		';
	}
?>

