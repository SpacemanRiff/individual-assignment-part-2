package edu.jsu.mcis;

public class TicTacToe{
	private int currentTurn;
	private String winner;
	private boolean isTheGameStillGoing;
	private final String PLAYER_1_SYMBOL;
	private final String PLAYER_2_SYMBOL;
	private final String EMPTY_SPACE_SYMBOL;
	private String[][] board;
	
	public TicTacToe(){
		currentTurn = 0;
		winner = "TIE";
		isTheGameStillGoing = true;
		PLAYER_1_SYMBOL = "X";
		PLAYER_2_SYMBOL = "O";
		EMPTY_SPACE_SYMBOL = " ";
		
		board = new String[3][];
		for(int row = 0; row < 3; row++){
			board[row] = new String[3];
			for(int col = 0; col < 3; col++){
				board[row][col] = " ";
			}
		}
	}
		
	public void markLocation(int row, int col){
		if(board[row][col].equals(EMPTY_SPACE_SYMBOL) && isTheGameStillGoing){
			if(row >= 0 && row < 3 && col >= 0 && col < 3){
				switch(currentTurn%2){
					case 0: 
						board[row][col] = PLAYER_1_SYMBOL;
						break;
					case 1: 
						board[row][col] = PLAYER_2_SYMBOL;
						break;
				}
				System.out.print(board[row][col] + " ");
				checkToSeeIfTheGameIsOver();
				currentTurn++;
			}
		}
	}
	
	public String whoControlsTheTileAt(int row, int col){
		return board[row][col];
	}
	
	public void checkToSeeIfTheGameIsOver(){
		if(isThereADiagonalWinner() || isThereAHorizontalWinner() || isThereAVerticalWinner()){
			isTheGameStillGoing = false;
		}
	}
	
	public boolean isThereADiagonalWinner(){
		if(board[0][0].equals(board[1][1]) && board[0][0].equals(board[2][2]) && !board[0][0].equals(EMPTY_SPACE_SYMBOL)){
			winner = board[0][0];
			return true;
		}else if(board[0][2].equals(board[1][1]) && board[0][2].equals(board[2][0]) && !board[0][2].equals(EMPTY_SPACE_SYMBOL)){
			winner = board[0][2];
			return true;
		}else{		
			return false;
		}
	}
	
	public boolean isThereAHorizontalWinner(){
		for(int i = 0; i < 3; i++){
			if(board[i][0].equals(board[i][1]) && board[i][0].equals(board[i][2]) && !board[i][0].equals(EMPTY_SPACE_SYMBOL)){
				winner = board[i][0];
				return true;
			}
		}
		return false;
	}
	
	public boolean isThereAVerticalWinner(){
		for(int i = 0; i < 3; i++){
			if(board[0][i].equals(board[1][i]) && board[0][i].equals(board[2][i]) && !board[0][i].equals(EMPTY_SPACE_SYMBOL)){
				winner = board[0][i];
				return true;
			}
		}
		return false;
	}
	
	public boolean isTheBoardFull(){
		boolean thereAreNoEmptySpaces = true;
		int i = 0;
		while(i<3 && thereAreNoEmptySpaces){
			int j = 0;
			while(j<3 && thereAreNoEmptySpaces){
				if(board[i][j].equals(EMPTY_SPACE_SYMBOL)){
					thereAreNoEmptySpaces = false;
				}
				j++;
			}
			i++;
		}
		return thereAreNoEmptySpaces;
	}
	
	public String whoseTurnIsIt(){
		if(currentTurn%2 == 0){
			return PLAYER_1_SYMBOL;
		}else if(currentTurn%2 == 1){
			return PLAYER_2_SYMBOL;
		}else{
			return EMPTY_SPACE_SYMBOL;
		}
	}
	
	public boolean isTheGameOver(){
		return !isTheGameStillGoing;
	}
	
	public String whoIsTheWinner(){
		return winner;
	}
}