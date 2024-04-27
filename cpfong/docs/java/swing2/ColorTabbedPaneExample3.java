/* (swing1.1.1) */
//package jp.gr.java_conf.tame.swing.examples;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 * @version 1.0 08/23/99
 */
public class ColorTabbedPaneExample3 extends JFrame {

  String[] titles = {"blue",   "cyan", "green", "yellow",
                     "orange", "pink", "red"};
  Color[]  colors = {Color.blue,   Color.cyan, Color.green, Color.yellow,
                     Color.orange, Color.pink, Color.red };
  JTabbedPane tabbedPane;      
               
  public ColorTabbedPaneExample3() {
    super("ColorTabbedPaneExample (windows)");
           
    tabbedPane = new ColoredTabbedPane();
    for (int i=0;i<titles.length;i++) {
      tabbedPane.addTab(titles[i], createPane (titles[i], colors[i]));
      tabbedPane.setBackgroundAt(i, colors[i].darker());
    }
    tabbedPane.setSelectedIndex(0);
    
    getContentPane().add(tabbedPane);
  }
  
  JPanel createPane(String title, Color color) {
    JPanel panel = new JPanel();
    panel.setBackground(color);
    JLabel label = new JLabel(title);
    label.setOpaque(true);
    label.setBackground(Color.white);
    panel.add(label);
    return panel;
  }
    
  class ColoredTabbedPane extends JTabbedPane {
    public Color getBackgroundAt(int index) {
      if (index == getSelectedIndex()) {
        return colors[index];
      } else {
        return super.getBackgroundAt(index);
      }
    }
  }
  
  public static void main(String[] args) {
    try {
      UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    JFrame frame = new ColorTabbedPaneExample3();
    frame.addWindowListener( new WindowAdapter() {
      public void windowClosing( WindowEvent e ) {
        System.exit(0);
      }
    });
    frame.setSize( 360, 100 );
    frame.setVisible(true);
  } 
}
