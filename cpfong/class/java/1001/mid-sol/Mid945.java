/*
31. �ҥ� 5-31 �� ���D 5.9
32. �ҥ� 5-30 �� ���D 5.7
33. �ҥ� 5-31 �� ���D 5.10
34. �ҥ� 5-31 �� ���D 5.12

*/
import java.awt.*;
import java.io.*;

public class Mid945 {
	public static void main(String[] args){
		Mid945 t = new Mid945();
		double d = t.areaCircle(1.25);
		System.out.println("r= 1.25 area = " + d);
		System.exit(0);
	}
	private double areaCircle(double r){
		return (Math.PI*r*r);
	}
}

