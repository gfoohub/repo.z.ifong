import javax.swing.*;
import java.awt.*;
import java.util.*;

public class TwoDices{
	public static void main(String args[]){
		TwoDices t=new TwoDices();
		int a,b;

		a=t.read_in();
		b=t.read_in();
		System.out.println("�Ĥ@�Ӽ�=" + a  + " �ĤG�Ӽ�=" + b + ", total = " + (a+b));
	}

	private int read_in(){
		int r; 
		Random random=new Random();
		r=1+random.nextInt(6-1+1);
		return(r);
	}
}
