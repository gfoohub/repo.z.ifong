public class find_sub_cat_str{
	public static void main(String args[]){
		String s = new String("this is a test");
	
		// find char ��
		System.out.println(s.indexOf	('i'));
		System.out.println(s.lastIndexOf('i'));
		System.out.println(s.indexOf	('i', 4));

		// find string
		System.out.println(s.indexOf	("is"));

		// sub string �䳡��
		String n = s.substring(5,7);
		System.out.println(n);

		// concat �۳s
		n = s.substring(4,s.length());
		System.out.println("that".concat(n));
	}
}
