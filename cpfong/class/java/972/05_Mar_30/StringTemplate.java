public class StringTemplate{
	public static void main(String args[]){
		String x="this";	
		String y="this";
		String z="sum";

		// �`�N: �ܼ� x �� String ������, �ҥH�i�H�~�� equals �o�Ӥ�k
		if (x.equals(y) == true) { System.out.println("�۵�"); }
		else { System.out.println ("no equal"); }

		// �`�N: ���A���M�S�A�����ϧO
		System.out.println(z + 2 + 3);
		System.out.println(z + (2 + 3));

		String SArray[]=new String[2];
		SArray[0]="this is a test";
		SArray[1]="that is a test";
	}
}
