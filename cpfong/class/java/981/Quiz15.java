import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Quiz15 extends JFrame implements ActionListener {

    private JButton button1, button2, button3;
    private Random random;
    private JLabel l;

    public static void main(String[] args) {
        Quiz15 demo = new Quiz15();
        demo.setSize(200,100);
        demo.createGUI();
        demo.setVisible(true);
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        button1 = new JButton("�ŤM");window.add(button1);button1.addActionListener(this);
        button2 = new JButton("���Y");window.add(button2);button2.addActionListener(this);
        button3 = new JButton("��"  );window.add(button3);button3.addActionListener(this);
	l = new JLabel("���G�� ..."); window.add(l);
        
        random = new Random();
    }

    public void actionPerformed(ActionEvent event) {
	Object s=event.getSource();
	int comp = random.nextInt(3);
	int me;
	String res="";

	if (s == button1) { me=0; res = winOrlost(comp,me); l.setText("�A�X0�ŤM, " + res); }
	else if (s == button2) { me=1; res = winOrlost(comp,me); l.setText("�A�X1���Y, " + res); }
	else { me=2; res = winOrlost(comp,me); l.setText("�A�X2��, " + res); }

    }

    private String winOrlost(int c, int m){
	if (c == m) { return "�q�� " + c + " -> ����" ; }
	else if ( (c-m) == 1 || (m-c) == 1 ) { if (c>m) {return "�q��" + c + " -> �A��";} else {return "�q��" + c + " -> �AĹ"; } }
	else { if (c>m) {return "�q��" + c + " -> �AĹ"; } else {return "�q��" + c + " -> �A��";} }
    }	
}
