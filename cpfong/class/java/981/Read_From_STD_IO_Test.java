import java.awt.*;
import java.io.*;

public class Read_From_STD_IO_Test {
	public static void main(String[] args){
		int in=0;

		System.out.println("�� STDIO ��J���:  ");
      		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		try { 
			in = Integer.parseInt(br.readLine()); 
		} catch (IOException ioe) { 
			System.out.println("IO error trying to read your name!"); 
			System.exit(1); 
		} 

		System.out.println("ok, �z��J�F: " + in);
		System.exit(0);
	}
}

