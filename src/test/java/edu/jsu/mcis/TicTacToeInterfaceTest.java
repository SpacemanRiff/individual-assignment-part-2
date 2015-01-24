package edu.jsu.mcis;

import org.junit.*;
import static org.junit.Assert.*;

public class TicTacToeInterfaceTest{
	
	@Test
	public void testTileWrittenWithX(){
		TicTacToeInterface gameInterface = new TicTacToeInterface();	
		gameInterface.sendDataToBoard(0,0);
		assertEquals("X",gameInterface.whoControlsThisTile(0,0));
	}
	
	@Test
	public void testTileWrittenWithO(){
		TicTacToeInterface gameInterface = new TicTacToeInterface();	
		gameInterface.sendDataToBoard(0,0);
		gameInterface.sendDataToBoard(1,0);
		assertEquals("O",gameInterface.whoControlsThisTile(1,0));
	}
	
	@Test
	public void testTileCannotBeOverWritten(){
		TicTacToeInterface gameInterface = new TicTacToeInterface();	
		gameInterface.sendDataToBoard(0,0);		
		gameInterface.sendDataToBoard(0,0);
		assertEquals("X",gameInterface.whoControlsThisTile(0,0));
	}	
	@Test
	public void testIfXHasWonThroughTheInterface(){
		TicTacToeInterface gameInterface = new TicTacToeInterface();		
		gameInterface.sendDataToBoard(0,1);
		gameInterface.sendDataToBoard(0,0);		
		gameInterface.sendDataToBoard(1,1);
		gameInterface.sendDataToBoard(0,2);
		gameInterface.sendDataToBoard(2,1);
		assertEquals("X",gameInterface.whoWon());
	}
	
	@Test
	public void testColumnThreeWin(){	
		TicTacToeInterface gameInterface = new TicTacToeInterface();	
		gameInterface.sendDataToBoard(1,1);
		gameInterface.sendDataToBoard(0,2);
		gameInterface.sendDataToBoard(0,0);
		gameInterface.sendDataToBoard(1,2);
		gameInterface.sendDataToBoard(0,1);
		gameInterface.sendDataToBoard(2,2);
		assertEquals("O",gameInterface.whoWon());
	}
	
	@Test
	public void testIsTheBoardFullThroughTheInterface(){		
		TicTacToeInterface gameInterface = new TicTacToeInterface();		
		gameInterface.sendDataToBoard(0,0);			
		gameInterface.sendDataToBoard(0,1);	
		gameInterface.sendDataToBoard(0,2);	
		gameInterface.sendDataToBoard(2,0);			
		gameInterface.sendDataToBoard(2,1);	
		gameInterface.sendDataToBoard(2,2);
		gameInterface.sendDataToBoard(1,0);			
		gameInterface.sendDataToBoard(1,1);	
		gameInterface.sendDataToBoard(1,2);
		assertEquals("TIE",gameInterface.whoWon());
	}
}