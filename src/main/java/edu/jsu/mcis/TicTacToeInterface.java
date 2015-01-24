package edu.jsu.mcis;

import java.util.Scanner;

public class TicTacToeInterface{		
	private TicTacToe game;
	private String previousPlayer;
	
	public TicTacToeInterface(){		
		game = new TicTacToe();
		previousPlayer = " ";
	}
	
	public void playGame(){		
		while(!game.isTheGameOver()){
			getUserInput();
		}
		if(!game.whoIsTheWinner().equals(game.EMPTY_SPACE_SYMBOL)){
			System.out.println(whoWon() + " is the Winner!");
		}else{
			System.out.println(whoWon() + " game!");
		}
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
				rowInput = Integer.parseInt(input.next());
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
	
	public String whoControlsThisTile(int row, int column){
		return game.whoControlsTheTileAt(row, column);
	}
	
	public String whoWon(){
		return game.whoIsTheWinner();
	}
	
	public void drawBoard(){
		System.out.println();
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				System.out.print(whoControlsThisTile(i,j));
				if(j != 2){
					System.out.print("|");
				}
			}
			System.out.println();
			if(i != 2){
				System.out.println("-----");
			}
		}
		System.out.println();
	}
	
	public static void main(String[] args){
		System.out.println();
		TicTacToeInterface gameInterface = new TicTacToeInterface();
		gameInterface.playGame();
	}
}