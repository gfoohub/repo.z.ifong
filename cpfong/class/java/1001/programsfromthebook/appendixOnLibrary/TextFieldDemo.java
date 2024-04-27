
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TextFieldDemo extends JFrame implements ActionListener {

    private JButton button;
    private JTextField input, output;

    public static void main(String[] args) {
        TextFieldDemo frame = new TextFieldDemo();
        frame.setSize(400,300);
        frame.createGUI();
        frame.show();
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        input = new JTextField(8);
        window.add(input);

        button = new JButton("press");
        window.add(button);
        button.addActionListener(this);

        output = new JTextField(8);
        window.add(output);

    }

    public void actionPerformed(ActionEvent event) {
        String text;
        text = input.getText();
        output.setText(text);
    }
}
