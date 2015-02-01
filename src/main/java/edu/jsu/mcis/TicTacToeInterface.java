package edu.jsu.mcis;
  
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;

public class TicTacToeInterface extends JPanel{		
	private TicTacToe game;
	public JButton[][] ticTacToeButtons;
	public JLabel currentTurnLabel;
	
	public TicTacToeInterface(){		
		game = new TicTacToe();
		ticTacToeButtons = new JButton[3][3];
		
		setLayout(new GridLayout(3,3));
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				ticTacToeButtons[i][j] = new JButton(game.whoControlsTheTileAt(i,j));
				ticTacToeButtons[i][j].addActionListener(new ButtonListener(i,j));
				ticTacToeButtons[i][j].setName("Location" + i + j);
				add(ticTacToeButtons[i][j]);
			}
		}
	}
	
	public void sendDataToBoard(int row, int column){
		game.markLocation(row, column);
	}
	
	public String whoControlsThisTile(int row, int column){
		return ticTacToeButtons[row][column].getText();
	}
	
	public static void main(String[] args){		
		TicTacToeInterface gameInterface = new TicTacToeInterface();
		JFrame frame = new JFrame("Tic Tac Toe :^)");
		frame.add(gameInterface);		

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.pack();
		frame.setSize(600,600);
		frame.setVisible(true);
	}
	
	public class ButtonListener implements ActionListener{
		int row, column;
		public ButtonListener(int row, int column){
			this.row = row;
			this.column = column;
		}
		
		public void actionPerformed(ActionEvent e){
			sendDataToBoard(row, column);
			ticTacToeButtons[row][column].setText(game.whoControlsTheTileAt(row,column));
		}
	}
}