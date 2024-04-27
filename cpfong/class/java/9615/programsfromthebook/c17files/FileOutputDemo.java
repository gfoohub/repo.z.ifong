import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*; 
import java.io.*;

public class FileOutputDemo extends JFrame 
implements ActionListener {
    private JTextArea textArea; 
    private JButton saveButton;
    private JTextField nameField;
    private JLabel nameLabel;
    private PrintWriter outFile;

    public static void main(String [] args) {
        FileOutputDemo frame = new FileOutputDemo();
        frame.setSize(400, 300);
        frame.createGUI();
        frame.setVisible(true);
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        nameLabel = new JLabel("File name:  ");
        window.add(nameLabel);

        nameField = new JTextField(20);
        window.add(nameField);

        textArea = new JTextArea(10,30);
        JScrollPane scrollPane = new JScrollPane(textArea);
        window.add(scrollPane);

        saveButton = new JButton("save");
        window.add( saveButton);
        saveButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent event) { 
        if (event.getSource() == saveButton ) {
            try{

                outFile = new PrintWriter(
                    new FileWriter(nameField.getText()), true);
                outFile.print(textArea.getText());
                outFile.close();
            }
            catch (IOException e) {
                JOptionPane.showMessageDialog(null, 
                    "File Error: " + e.toString());
            }
        }
    }
}




