import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class test extends JApplet implements ActionListener {
   // constant variables for status of game
   final int WON = 0, LOST = 1, CONTINUE = 2;  

   // other variables used in program
   boolean firstRoll = true;   // true if first roll
   int sumOfDice = 0;          // sum of the dice
   int myPoint = 0;   // point if no win/loss on first roll
   int gameStatus = CONTINUE;  // game not over yet

   // graphical user interface components 
   JLabel die1Label, die2Label, sumLabel, pointLabel;
   JTextField firstDie, secondDie, sum, point;
   JButton roll;

   // setup graphical user interface components
   public void init()
   {
	// ���o ContentPane ����B�n�D�t�Φ۰ʳ]�w�ƦC�覡
      Container c = getContentPane();
      c.setLayout( new FlowLayout() );

	// �Х� (Label) �� ��J�� (Edit field)
	// 1. �ͦ����� 2. �[�J container ��
      die1Label = new JLabel( "Die 1" );
      c.add( die1Label );

	// 1.�ͦ����� 2.�h�]�w�@���ݩ� 2.�[�J container ��
      firstDie = new JTextField( 5 );
      firstDie.setEditable( false );
      c.add( firstDie );

      die2Label = new JLabel( "Die 2" );
      c.add( die2Label );
      secondDie = new JTextField( 5 );
      secondDie.setEditable( false );
      c.add( secondDie );

      sumLabel = new JLabel( "Sum is" );
      c.add( sumLabel );
      sum = new JTextField( 5 );
      sum.setEditable( false );
      c.add( sum );

      pointLabel = new JLabel( "Point is" );
      c.add( pointLabel );
      point = new JTextField( 5 );
      point.setEditable( false );
      c.add( point );

	// ���s
	// 1.�ͦ����� 2.�h�]�@���ݩ� 3.�[�J container
      roll = new JButton( "Roll Dice" );
      roll.addActionListener( this );
      c.add( roll );
   }

   // call method play when button is pressed
   public void actionPerformed( ActionEvent e )
   {
      play();
   }

   // process one roll of the dice
   public void play()
   {
      if ( firstRoll ) {             // �Y�@�D�_ ?
         sumOfDice = rollDice();        
   
         switch ( sumOfDice ) {
            case 7: case 11:         // 7,11 �ҥH�� (���a) Ĺ�F
               gameStatus = WON;
               point.setText( "" );  // clear point text field
               break;
            case 2: case 3: case 12: // �� (���a) ��F
               gameStatus = LOST;
               point.setText( "" );  // clear point text field
               break;
            default:                 // remember point
               gameStatus = CONTINUE;
               myPoint = sumOfDice;  // �����ܼ� myPoint �O��o�ӭ�	
               point.setText( Integer.toString( myPoint ) );
               firstRoll = false;
               break;
         }
      }
      else { // ���O�Ĥ@���F ! 
         sumOfDice = rollDice();
      
         if ( sumOfDice == myPoint )    // win by making point
            gameStatus = WON;
         else
            if ( sumOfDice == 7 )       // lose by rolling 7
               gameStatus = LOST;
      }

	// �ⴣ�����a���Ʃ�b status ���W
      switch ( gameStatus ) {
		case CONTINUE:
			showStatus( "Roll again." ); 
			break;
		case LOST:
			showStatus( "Player loses. " + "Click Roll Dice to play again." );
     			firstRoll = true;
			break;
		case WON:
			showStatus( "Player wins. " + "Click Roll Dice to play again." );
     			firstRoll = true;
			break;
		default:
			break;
     }
   }
   
   // roll the dice
   public int rollDice()
   {
      int die1, die2, workSum;   

      die1 = 1 + ( int ) ( Math.random() * 6 );
      die2 = 1 + ( int ) ( Math.random() * 6 );
      workSum = die1 + die2;

      firstDie.setText( Integer.toString( die1 ) );
      secondDie.setText( Integer.toString( die2 ) );
      sum.setText( Integer.toString( workSum ) );

      return workSum;
   }
}
