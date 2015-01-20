package edu.jsu.mcis;

public class TicTacToe{
	private String[][] board;
	private int currentTurn;
	private String winner; //winner chicken dinner
	private final String PLAYER_1_SYMBOL;
	private final String PLAYER_2_SYMBOL;
	
	public TicTacToe(){
		currentTurn = 0;
		winner = "no one";
		PLAYER_1_SYMBOL = "X";
		PLAYER_2_SYMBOL = "O";
		
		board = new String[3][];
		for(int row = 0; row < 3; row++){
			board[row] = new String[3];
			for(int col = 0; col < 3; col++){
				board[row][col] = " ";
			}
		}
	}
		
	public void markLocation(int row, int col){
		switch(currentTurn%2){
			case 0: 
				board[row][col] = PLAYER_1_SYMBOL;
				break;
			case 1: 
				board[row][col] = PLAYER_2_SYMBOL;
				break;
		}
		currentTurn++;
	}
	
	public String whoControlsTheTileAt(int row, int col){
		return board[row][col];
	}
	
	private
	
	public String whoHasWon(){
		return "nah";
	}
}