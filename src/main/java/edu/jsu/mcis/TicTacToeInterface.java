package edu.jsu.mcis;

import java.util.Scanner;

public class TicTacToeInterface{
	
	private void getUserInput(TicTacToe game){
		Scanner input = new Scanner(System.in);
		int rowInput = -1; 
		int columnInput = -1;
		
		System.out.println("It is player " + game.whoseTurnIsIt() + "\'s turn.");
	}
	
	public static void main(String [] args){
		TicTacToe game = new TicTacToe();
		while(!game.isTheGameOver){
			getUserInput(game);
		}
	}
}