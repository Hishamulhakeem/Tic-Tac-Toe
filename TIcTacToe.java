import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;


public class TIcTacToe implements ActionListener {
	
	
	Random random =new Random();
	JFrame frame = new JFrame();
	JPanel title_pan = new JPanel();
	JPanel button_pan= new JPanel();
	JLabel textfield =new JLabel();
	JButton[] buttons = new JButton[9];
	boolean Player1_Turn;
	
	TIcTacToe(){
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800,800);
		frame.getContentPane().setBackground(new Color(0,150,150));  // Color.red 
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		
		textfield.setBackground(new Color(198, 92, 92));
		textfield.setForeground(new Color(25,255,0));
		textfield.setFont(new Font("Ink Free",Font.BOLD,75));
		textfield.setHorizontalAlignment(JLabel.CENTER);
		textfield.setText("Tic-Tac-Toe");
		textfield.setOpaque(true);
		
		title_pan.setLayout(new BorderLayout());
		title_pan.setBounds(0,0,800,100);
		
		button_pan.setLayout(new GridLayout(3,3));
		button_pan.setBackground(new Color(150,150,150));
		
		for(int i=0;i<9;i++) {
			buttons[i]= new JButton();
			button_pan.add(buttons[i]);
			buttons[i].setFont(new Font("Arial",Font.BOLD,120));
			buttons[i].setFocusable(false);
			buttons[i].addActionListener(this);
		}
		
		title_pan.add(textfield);
		frame.add(title_pan,BorderLayout.NORTH);
		frame.add(button_pan);
		
		firstTurn();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		for(int i=0;i<9;i++) {
			if(e.getSource()==buttons[i]) {
				if(Player1_Turn) {
					if(buttons[i].getText()=="") {
						buttons[i].setForeground(new Color(255,0,0));
						buttons[i].setText("X");
						Player1_Turn=false;
						textfield.setText("O turn");
						check();
					}
				}else {
					if(buttons[i].getText()=="") {
						buttons[i].setForeground(new Color(0,0,255));
						buttons[i].setText("O");
						Player1_Turn=true;
						textfield.setText("X turn");
						check();
					}
					
				}
			}
		}
	} 
	
	public void firstTurn() {
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(random.nextInt(2)==0) {
			
			Player1_Turn=true;
			textfield.setText(" X turn");
		}
		else {
			Player1_Turn=false;
			textfield.setText(" O turn");
		}
		
	}
	
	public void check() {
		//checks X wins
		if(
				(buttons[0].getText()=="X")&&
				(buttons[1].getText()=="X")&&
				(buttons[2].getText()=="X")
				) {
			xWins(0,1,2);
		}
		if(
				(buttons[3].getText()=="X")&&
				(buttons[4].getText()=="X")&&
				(buttons[5].getText()=="X")
				) {
			xWins(3,4,5);
		}
		if(
				(buttons[6].getText()=="X")&&
				(buttons[7].getText()=="X")&&
				(buttons[8].getText()=="X")
				) {
			xWins(6,7,8);
		}
		if(
				(buttons[0].getText()=="X")&&
				(buttons[3].getText()=="X")&&
				(buttons[6].getText()=="X")
				) {
			xWins(0,3,6);
		}
		if(
				(buttons[1].getText()=="X")&&
				(buttons[4].getText()=="X")&&
				(buttons[7].getText()=="X")
				) {
			xWins(1,4,7);
		}
		if(
				(buttons[2].getText()=="X")&&
				(buttons[5].getText()=="X")&&
				(buttons[8].getText()=="X")
				) {
			xWins(2,5,8);
		}
		if(
				(buttons[0].getText()=="X")&&
				(buttons[4].getText()=="X")&&
				(buttons[8].getText()=="X")
				) {
			xWins(0,4,8);
		}
		if(
				(buttons[2].getText()=="X")&&
				(buttons[4].getText()=="X")&&
				(buttons[6].getText()=="X")
				) {
			xWins(2,4,6);
		}
		//checks O wins condition
		if(
				(buttons[0].getText()=="O")&&
				(buttons[1].getText()=="O")&&
				(buttons[2].getText()=="O")
				) {
			oWins(0,1,2);
		}
		if(
				(buttons[3].getText()=="O")&&
				(buttons[4].getText()=="O")&&
				(buttons[5].getText()=="O")
				) {
			oWins(3,4,5);
		}
		if(
				(buttons[6].getText()=="O")&&
				(buttons[7].getText()=="O")&&
				(buttons[8].getText()=="O")
				) {
			oWins(6,7,8);
		}
		if(
				(buttons[0].getText()=="O")&&
				(buttons[3].getText()=="O")&&
				(buttons[6].getText()=="O")
				) {
			oWins(0,3,6);
		}
		if(
				(buttons[1].getText()=="O")&&
				(buttons[4].getText()=="O")&&
				(buttons[7].getText()=="O")
				) {
			oWins(1,4,7);
		}
		if(
				(buttons[2].getText()=="O")&&
				(buttons[5].getText()=="O")&&
				(buttons[8].getText()=="O")
				) {
			oWins(2,5,8);
		}
		if(
				(buttons[0].getText()=="O")&&
				(buttons[4].getText()=="O")&&
				(buttons[8].getText()=="O")
				) {
			oWins(0,4,8);
		}
		if(
				(buttons[2].getText()=="O")&&
				(buttons[4].getText()=="O")&&
				(buttons[6].getText()=="O")
				) {
			oWins(2,4,6);
			boolean man=buttons[5].isContentAreaFilled();
			System.out.println(man);
		}
		if(
			(buttons[1].isContentAreaFilled())&&
			(buttons[2].isContentAreaFilled())&&
			(buttons[3].isContentAreaFilled())&&
			(buttons[4].isContentAreaFilled())&&
			(buttons[5].isContentAreaFilled())&&
			(buttons[6].isContentAreaFilled())&&
			(buttons[7].isContentAreaFilled())&&
			(buttons[8].isContentAreaFilled())&&
			(buttons[9].isContentAreaFilled())
		){
			draw();
		}
	}
	
	public void xWins(int a,int b,int c) {
		buttons[a].setBackground(Color.GREEN);
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);
		
		for(int i =0;i<9;i++) {
			buttons[i].setEnabled(false);
		}
		textfield.setText("X wins");
	}
	
    public void oWins(int a,int b,int c) {
    	buttons[a].setBackground(Color.GREEN);
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);
		
		if(buttons[a].isContentAreaFilled()==false)
			textfield.setText("draw");
		
		for(int i =0;i<9;i++) {
			buttons[i].setEnabled(false);
		}
		textfield.setText("O wins");
		
	}
    public void draw() {
    	textfield.setText("draw");
    }

}
