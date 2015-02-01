package edu.jsu.mcis;
  
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.io.IOException;
import java.awt.Dimension;

public class TicTacToeInterface extends JPanel{		
	private TicTacToe game;
	public JButton[][] ticTacToeButtons;
	public JLabel displayLabel;
	
	public TicTacToeInterface(){
		game = new TicTacToe();
		ticTacToeButtons = new JButton[3][3];
		displayLabel = new JLabel("It is currently " + game.getTurnPlayer() + "\'s turn.");
		
		setLayout(new GridLayout(3,3));
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				ticTacToeButtons[i][j] = new JButton(game.getTileAt(i,j));
				ticTacToeButtons[i][j].addActionListener(new ButtonListener(i,j));
				ticTacToeButtons[i][j].setName("Location" + i + j);
				add(ticTacToeButtons[i][j]);
			}
		}
		setSize(300,300);
	}
	
	public void sendDataToBoard(int row, int column){
		game.markLocation(row, column);
		ticTacToeButtons[row][column].setText(game.getTileAt(row,column));
	}
	
	public String whoControlsThisTile(int row, int column){
		return ticTacToeButtons[row][column].getText();
	}
	
	public void checkForWin(){
		game.checkForGameOver();
		if(isTheGameOver()){
			
		}
	}
	
	public static void main(String[] args){		
		TicTacToeInterface gameInterface = new TicTacToeInterface();
		JFrame frame = new JFrame("Tic Tac Toe :^)");
		frame.add(gameInterface);		

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setResizable(false);
		frame.setSize(300,300);
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
			checkForGameOver();
		}
	}
}