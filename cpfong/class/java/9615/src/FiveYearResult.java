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
		double am, rate, tot;
		String st;

		st = JOptionPane.showInputDialog("��l����:"); am=Double.parseDouble(st);
		tot  = calRes(am , 1.5);
		tot  = calRes(tot, 1.5);
		JOptionPane.showMessageDialog(null, "��l����" +  st + "���\n�`���B�� " + tot);
	}

	private double calRes(double a, double interest){
		a = a * (1 + interest/100);
		return (a);
	}
}
