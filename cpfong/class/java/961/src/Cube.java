import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FiveYearResult extends JFrame implements ActionListener{
	private JButton but;

	public static void main(String[] args){
		FiveYearResult frame=new FiveYearResult();
		frame.setSize(400,300);
		frame.createGUI(frame);
		frame.setVisible(true);
	}

	private void createGUI(FiveYearResult mw){
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		mw.setLayout(new FlowLayout());

		but = new JButton("���ڭp�⥻���Q���M");
		mw.add(but);
		but.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e){
		double radius, area, vol;
		String radiusString;

		radiusString=JOptionPane.showInputDialog("��l����:"); radius=Double.parseDouble(radiusString);
		vol  = calVol(radius);
		JOptionPane.showMessageDialog(null, "�����" +  radiusString + "���ߤ���,\n��n�� " + vol);
	}

	private double calVol(double x){
		return (x * x * x);
	}
}
