import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Quiz3 extends JFrame implements ActionListener{
	private JButton but;

	public static void main(String[] args){
		Quiz3 frame=new Quiz3();
		frame.setSize(400,300);
		frame.createGUI(frame);
		frame.setVisible(true);
	}

	private void createGUI(Quiz3 mw){
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		mw.setLayout(new FlowLayout());

		but = new JButton("�п�J�T�Ӽ�");
		mw.add(but);
		but.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e){
		int i,j,k;
		double d;
		String t;

		t=JOptionPane.showInputDialog("�п�J�Ĥ@�Ӽ�"); i=Integer.parseInt(t);
		t=JOptionPane.showInputDialog("�п�J�ĤG�Ӽ�"); j=Integer.parseInt(t);
		t=JOptionPane.showInputDialog("�п�J�ĤT�Ӽ�"); k=Integer.parseInt(t);

		d = ((double)i+(double)j+(double)k)/3;
		JOptionPane.showMessageDialog(null, "" + i + " " + j + " " + k + " ��������: " + d);
	}
}
