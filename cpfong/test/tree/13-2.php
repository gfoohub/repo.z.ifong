<html>
<head>
<title>class.tree ���ι��</title>
<?
   require ("class.tree/class.tree.php3");
   $tree = new Tree();
?>
</head>
<body>
<?
   /* �𪬥ؿ����]�p, �ϥ� PHP �P class.tree */

   //���ͮڥؿ�

   $root  = $tree->open_tree("PHP �����{�����_�c", "");

   //�b�ڥؿ��W�s�W��Ƨ�

   $node1 = $tree->add_folder($root, "�ͬ���T", "");

   //�b��Ƨ��̭��[�W�s������

   $tree->add_document($node1, "�_����H", "http://weather.kimo.com.tw/");
   $tree->add_document($node1, "�_���ѥ�", "http://stock.kimo.com.tw/");
   $tree->add_document($node1, "�x�_���q�l�a��", "http://gis.tpc.gov.tw/Map/index.asp");
   $tree->add_document($node1, "�Y�ɸ��p", "http://road.iot.gov.tw/");
   $tree->add_document($node1, "���ڸ�Ʈw", "http://www.acce.com.tw/");

   //�A�s�W�t�@�Ӹ�Ƨ� (node2), �@�ˬO�s�W�b "PHP �����{���]�p���_�c"
   //�o�Ӽ��D�U, �]�� parent �٬O $root

   //�I�� "PHP �u�����" ��Ƨ��|�嵲�� PHP �x����� (www.php.net)

   $node2 = $tree->add_folder($root, "PHP �u�����", "http://www.php.net");

   //�b $node2 ���U�W�[����
   $tree->add_document($node2, "PHP Wizard", "http://www.phpwizard.com/");
   $tree->add_document($node2, "PHP Builder", "http://www.phpbuilder.com/");

   //�̫�n�O�o�I�s close_tree() �o�� member function
   $tree->close_tree ( );
?>
</body>
</html>
