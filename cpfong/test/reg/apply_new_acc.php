<?php
	/****************************************************
	 function:	apply_new_acc.php
	 object:	1st time login
	****************************************************/

	echo "�ӽбb�� <br><br>";

	form();

	function form(){
		echo '
			<form action="t.php" method="post">
				�b�@�@��: <input type="text" name="acc"><br>
				�]�ж�J3��16�Ӧr�����p�g�^��r���B�Ʀr�B�H�� _ �Ÿ��A�Ĥ@�Ӧr���ݬ��^��r���C�^<br><br>


				�K�@�@�X: <input type="password" name="pp"><br>
				�]��J 6 �Ӧr���H�W���^��r���B�Ʀr�B�H�ΦU�زŸ��զX�A�����t�ť���B�Ρu"�v�C�^<br><br>
				

				�K�X�T�{: <input type="password" name="con"><br>
				�]�ЦA��J�@���K�X�^<br><br>

				�K�X����: 
						<select name="cc[]">
							<option value="birthday"> �ڪ��X�ͦa ?
							<option value="monther"> �ڥ��˪��m ?
							<option value="pri"> ��Ū���p�� ?
							<option value="star"> �ڳ̤��N�����P ?
						</select><br>
				���@�@��: <input type="text" name="ans"><br>
				�]��A�ѰO�K�X�ɨϥΡ^<br><br>
				<input type="submit" value="�e�X���">
			</form>
		';
	} // end form
?>
