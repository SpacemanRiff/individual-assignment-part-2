import edu.jsu.mcis.*;

public class TicTacToeKeywords{
	private TicTacToeInterface ticTacToe;
	
	public void startNewGame(){
		ticTacToe = new TicTacToeInterface();
	}
	
	public void markLocation(int row, int column){
		ticTacToe.sendDataToBoard(row, column);
	}
	
	public String getTileOwner(int row, int column){
		return ticTacToe.whoControlsThisTile(row, column);
	}
	
	public String getWinner(){
		return ticTacToe.whoWon();
	}
}