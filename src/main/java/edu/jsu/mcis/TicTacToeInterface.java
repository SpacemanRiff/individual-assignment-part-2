package edu.jsu.mcis;

import java.util.Scanner;

public class TicTacToeInterface{		
	TicTacToe game;
	String previousPlayer;
	
	public TicTacToeInterface(){		
		game = new TicTacToe();
		previousPlayer = " ";
	}
	
	public void playGame(){		
		while(!game.isTheGameOver()){
			getUserInput();
		}
		
		System.out.println(game.whoIsTheWinner());
	}
	
	public void getUserInput(){
		Scanner input = new Scanner(System.in);
		int rowInput = -1; 
		int columnInput = -1;
		if(previousPlayer.equals(game.whoseTurnIsIt())){			
			System.out.println("That space was not available.");
		}
		
		System.out.println("It is player " + game.whoseTurnIsIt() + "\'s turn.");
		System.out.print("Please enter your desired row: ");
		while(rowInput == -1){
			try{
				rowInput = input.nextInt();
			}catch(Exception ex){
				System.out.print("Invalid input. Please try again: ");
			}
		}
		
		System.out.print("Please enter your desired column: ");
		while(columnInput == -1){
			try{
				columnInput = input.nextInt();
			}catch(Exception ex){
				System.out.print("Invalid input. Please try again: ");
			}
		}

		previousPlayer = game.whoseTurnIsIt();
		
		sendDataToBoard(rowInput, columnInput);
	}
	
	public void sendDataToBoard(int row, int column){
		game.markLocation(row, column);
		drawBoard();
	}
	
	public void drawBoard(){
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				System.out.print(game.whoControlsTheTileAt(i,j));
				if(j != 2){
					System.out.print("|");
				}
			}
			if(i != 2){
				System.out.print("-----");
			}
		}
	}
	
	public static void main(String[] args){
		TicTacToeInterface gameInterface = new TicTacToeInterface();
		gameInterface.playGame();
	}
}