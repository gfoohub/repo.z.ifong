/*
 * If You can accept all cells have same Height.
 */
/* (swing1.1beta3) */
//package jp.gr.java_conf.tame.swing.examples;

import javax.swing.*;
import javax.swing.table.*;
import javax.swing.border.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import jp.gr.java_conf.tame.swing.table.*;

/**
 * @version 1.0 11/09/98
 */
public class MultiLineCellExample extends JFrame {
  MultiLineCellExample() {
    super( "Multi-Line Cell Example" );

    DefaultTableModel dm = new DefaultTableModel() {
      public Class getColumnClass(int columnIndex) {
        return String.class;
      }
    };
    dm.setDataVector(new Object[][]{{"a\na","b\nb","c\nc"},
                                    {"A\nA","B\nB","C\nC"}},
                     new Object[]{"1","2","3"});

    JTable table = new JTable( dm );
    
    int lines = 2;
    table.setRowHeight( table.getRowHeight() * lines);
    
    //
    // table.setRowHeight(0);
    //
    // I got "java.lang.IllegalArgumentException: New row height less than 1"
    //
    table.setDefaultRenderer(String.class, new MultiLineCellRenderer());
    JScrollPane scroll = new JScrollPane( table );
    getContentPane().add( scroll );
    setSize( 400, 130 );
    setVisible(true);
  }

  public static void main(String[] args) {
    MultiLineCellExample frame = new MultiLineCellExample();
    frame.addWindowListener( new WindowAdapter() {
      public void windowClosing( WindowEvent e ) {
        System.exit(0);
      }
    });
  }
}