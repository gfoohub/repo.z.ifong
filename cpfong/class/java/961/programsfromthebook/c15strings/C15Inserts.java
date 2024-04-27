import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class C15Inserts extends JFrame implements ActionListener {

    private JTextField string1Field, string2Field, resultField;
    private JLabel string1Label, string2Label, resultLabel;
    private JButton goButton; 

    public static void main(String[] args) {
        C15Inserts frame = new C15Inserts();
        frame.setSize(250, 250);
        frame.createGUI();
        frame.setVisible(true);
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        string1Label = new JLabel("Type string1: ");
        window.add(string1Label);

        string1Field = new JTextField(20);
        window.add(string1Field);

        string2Label = new JLabel("Type string2: ");
        window.add(string2Label);

        string2Field = new JTextField(20);
        window.add(string2Field);

        resultLabel = new JLabel("result is:    ");
        window.add(resultLabel);

        resultField = new JTextField(20);    
        window.add(resultField);

        goButton = new JButton("do it");
        window.add(goButton);
        goButton.addActionListener(this); 
    }

    public void actionPerformed(ActionEvent event) {
        String result ="";
        if (event.getSource() == goButton) {
            String string1 = string1Field.getText();
            String string2 = string2Field.getText();

            // string example - equals
            //.... insert your code here
            if(string1.equals(string2))
                result="They are equal.";
            else
                result="They are not equal.";
            // end of example

            resultField.setText(result);
        }   
    }


    private void inserts(){

//-------------STARTEXTRACT=declarestrings.xtr
        String x, y;
        String myCity;
        String myName = "Parr";
        String myCountry = new String("Japan");
//---------------ENDEXTRACT=declarestrings.xtr

//----------------STARTEXTRACT=arraydec.xtr
        String[] cities = new String[10]; // 10 elements, 0 to 9
//------------------ENDEXTRACT=arraydec.xtr
        String string1 = "", string2="", result;


        //-------------STARTEXTRACT=equals.xtr
        // String example - equals
        if (string1.equals(string2))
            result = "They are equal.";
        else
            result = "They are not equal.";
        // end of example
        //---------------ENDEXTRACT=equals.xtr


        //---------------------STARTEXTRACT=compareto.xtr
        // String example - compareTo
        int n = string1.compareTo(string2);
        if (n == 0)
            result = "they are equal";
        else if (n < 0)
            result = "string1 precedes string2";
        else
            result = "string2 precedes string1";
        // end of example
        //---------------ENDEXTRACT=compareto.xtr


        //----------STARTEXTRACT=replace.xtr
        // String example - replace
        result = string1.replace('a', 'A'); //replace every 'a' by 'A'
        // end of example
        //---------------ENDEXTRACT=replace.xtr

        //-------STARTEXTRACT=tolower.xtr
        // String example - toLowerCase
        result = string1.toLowerCase();
        // end of example
        //---------------ENDEXTRACT=tolower.xtr

        //-----STARTEXTRACT=toupper.xtr
        string1 = "Java";
        result = string1.toUpperCase();
        //---------------ENDEXTRACT=toupper.xtr

        //-----------STARTEXTRACT=trim.xtr
        // String example - trim
        result = string1.trim();
        // end of example
        //---------------ENDEXTRACT=trim.xtr

        //-----------STARTEXTRACT=length.xtr
        // String example - length
        result = "length is " + string1.length();
        // end of example
        //---------------ENDEXTRACT=length.xtr

        //-------STARTEXTRACT=substringeg.xtr
        string1 = "position";
        result = string1.substring(2,5);
        //---------------ENDEXTRACT=substringeg.xtr

        //---------STARTEXTRACT=substring.xtr
        // String example - substring
        result = string1.substring(1, string1.length()-1);
        //---------------ENDEXTRACT=substring.xtr


        //---------STARTEXTRACT=substringquest.xtr
        String word = "position";
        String s = word.substring(2, word.length() );
        //---------------ENDEXTRACT=substringquest.xtr


        //---------STARTEXTRACT=charat.xtr
        char c1,c2;
        string1 = "position";
        c1 = string1.charAt(1);    // c1 becomes 'o'
        c2 = string1.charAt(4);    // c2 becomes 't'
        //---------------ENDEXTRACT=charat.xtr

        //-----STARTEXTRACT=indexof.xtr
        // string example - indexOf
        if (string1.indexOf(string2, 0) >= 0)
            result = string2 + " exists in " + string1;
        else
            result = string2 + " does not exist in " + string1;
        // end of example
        //---------------ENDEXTRACT=indexof.xtr


        //---------STARTEXTRACT=lastindex.xtr
        int place = "//a.b.c/directory/file".lastIndexOf("/");
        //---------------ENDEXTRACT=lastindex.xtr


        //------STARTEXTRACT=endswith.xtr
        // string example - endsWith
        if (string1.endsWith(string2))
            result = "string1 ends with " + string2;
        else
            result = "string1 does not end with " + string2;
        // end of example
        //---------------ENDEXTRACT=endswith.xtr


        //-----------STARTEXTRACT=token.xtr
        String example1 = "January 21 5";
        String month, day, hours;
        StringTokenizer sunData = new StringTokenizer(example1, " ");
        month = sunData.nextToken();
        day = sunData.nextToken();
        hours = sunData.nextToken();
        //---------------ENDEXTRACT=token.xtr
    }


    private void tokenStuff(){
        //-------------STARTEXTRACT=tokenloop.xtr
        String example2 = "4,6 ,7,10,10,12,13, 15, 21,20,19, 8";
        String item;
        StringTokenizer numberList = new StringTokenizer(example2, " ,");
        while (numberList.hasMoreTokens()) {
            item = numberList.nextToken();
            // .... process item

        }
        //-----------------ENDEXTRACT=tokenloop.xtr
    }

}

