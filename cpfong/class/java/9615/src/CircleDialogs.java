import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CircleDialogs extends JFrame implements ActionListener{
	private JButton but;

	public static void main(String[] args){
		CircleDialogs frame=new CircleDialogs();
		frame.setSize(400,300);
		frame.createGUI(frame);
		frame.setVisible(true);
	}

	private void createGUI(CircleDialogs mw){
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		mw.setLayout(new FlowLayout());

		but = new JButton("���ڭp��ꪺ���n�M��n");
		mw.add(but);
		but.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e){
		double radius, area, vol;
		String radiusString;

		radiusString=JOptionPane.showInputDialog("�b�|:"); radius=Double.parseDouble(radiusString);
		area = Math.PI * radius * radius;
		vol  = (4 * Math.PI)/3 * radius * radius * radius;
		JOptionPane.showMessageDialog(null, "�b�|��" +  radiusString + "����,\n���n�� " + area + "\n��n = " + vol);
	}
}
