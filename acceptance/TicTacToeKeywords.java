import edu.jsu.mcis.*;

public class TicTacToeKeywords{
	private TicTacToeInterface ticTacToe;
	
	public void startNewGame(){
		ticTacToe = new TicTacToeInterface();
	}
	
	public void markLocation(int row, int column){
		ticTacToe.sendDataToBoard(row, column);
	}
	
	public boolean locationShouldBe(int row, int column, String shouldBe){
		return ticTacToe.whoControlsThisTile(row, column).equals(shouldBe);
	}
	
	public boolean winnerShouldBe(String shouldBe){
		return ticTacToe.whoWon().equals(shouldBe);
	}
}