package edu.jsu.mcis;
  
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.JOptionPane;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.event.*;

public class TicTacToeInterface extends JFrame{		
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

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Tic Tac Toe");
		setName("Tic Tac Toe");
		pack();
		setResizable(false);
		setSize(300,300);
		setVisible(true);
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
		if(game.isTheGameOver()){
            int delay = 1000;
            ActionListener taskPerformer = new ActionListener(){
                public void actionPerformed(ActionEvent evt){
                    JOptionPane.showMessageDialog(null, "The winner is " + game.getWinner(), "Game Over", JOptionPane.PLAIN_MESSAGE);	                    
                }
            };
            Timer myTimer = new Timer(delay, taskPerformer);
            myTimer.setRepeats(false);
            myTimer.start();
		}
	}
	
	public static void main(String[] args){		
		TicTacToeInterface gameInterface = new TicTacToeInterface();
	}
	
	public class ButtonListener implements ActionListener{
		int row, column;
		public ButtonListener(int row, int column){
			this.row = row;
			this.column = column;
		}
		
		public void actionPerformed(ActionEvent e){
			sendDataToBoard(row, column);
			checkForWin();
		}
	}
}