/* (swing1.1.1) */
//package jp.gr.java_conf.tame.swing.examples;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.plaf.metal.*;

/**
 * @version 1.0 08/23/99
 */
public class ColorTabbedPaneExample extends JFrame {

  String[] titles = {"blue","cyan","green","yellow",
                     "orange","pink","red"};
  Color[]  colors = {Color.blue, Color.cyan, Color.green, Color.yellow,
                    Color.orange,Color.pink, Color.red };
  JTabbedPane tabbedPane;      
               
  public ColorTabbedPaneExample() {
    super("ColorTabbedPaneExample (Metal)");
        
    UIManager.put("TabbedPane.selected", colors[0]);
    tabbedPane = new JTabbedPane() {
      public void updateUI(){
        setUI(new ColoredTabbedPaneUI());
      }
    };
    for (int i=0;i<titles.length;i++) {
      tabbedPane.addTab(titles[i], createPane (titles[i], colors[i]));
      tabbedPane.setBackgroundAt(i, colors[i].darker());
    }
    tabbedPane.setSelectedIndex(0);
    
    tabbedPane.addChangeListener(new ChangeListener() {
      public void stateChanged(ChangeEvent e) {
        int i = tabbedPane.getSelectedIndex();
        ((ColoredTabbedPaneUI)tabbedPane.getUI()).setSelectedTabBackground(colors[i]);
        tabbedPane.revalidate();
        tabbedPane.repaint();
      }
    });
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
    
  class ColoredTabbedPaneUI extends MetalTabbedPaneUI {
    public void setSelectedTabBackground(Color color) {
      selectColor = color;
    }
    protected void paintFocusIndicator(Graphics g, int tabPlacement,
                                       Rectangle[] rects, int tabIndex, 
                                       Rectangle iconRect, Rectangle textRect,
                                       boolean isSelected) {
    }
  }
  
  public static void main(String[] args) {
    JFrame frame = new ColorTabbedPaneExample();
    frame.addWindowListener( new WindowAdapter() {
      public void windowClosing( WindowEvent e ) {
        System.exit(0);
      }
    });
    frame.setSize( 360, 100 );
    frame.setVisible(true);
  } 
}
