<?php
	/****************************************************
	 function:	forget_passwd
	 object:	another way to login
	****************************************************/

	echo "�ѰO�K�X�Q�n�J�t�� <br><br>";

	form();

	function form(){
		echo '
			<form action="t.php" method="post">
				�b�@�@��: <input type="text" name="acc"><br>
				��������: <input type="text" name="pp"><br>
				�ͤ���: <select name="mon[]">
						<option value="jan"> �@��
						<option value="feb"> �G��
						<option value="mar"> �T��
						<option value="apr"> �|��
						<option value="may"> ����
						<option value="jun"> ����
						<option value="jul"> �C��
						<option value="aug"> �K��
						<option value="sep"> �E��
						<option value="oct"> �Q��
						<option value="nov"> �Q�@��
						<option value="dev"> �Q�G��
					  </select><br>
						
				�K�X����: 
						<select name="cc[]">
							<option value="birthday"> �ڪ��X�ͦa ?
							<option value="monther"> �ڥ��˪��m ?
							<option value="pri"> ��Ū���p�� ?
							<option value="star"> �ڳ̤��N�����P ?
						</select><br>
				���@�@��: <input type="text" name="ans"><br><br>
				<input type="submit" value="�n�J">
			</form>
		';
	} // end form
?>
