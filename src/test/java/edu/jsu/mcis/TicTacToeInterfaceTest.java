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
		gameInterface.checkForWin();
		gameInterface.sendDataToBoard(0,0);
		assertEquals("X",gameInterface.whoControlsThisTile(0,0));
	}	
	
	@Test
	public void testNoPlacesOnceGameIsOver(){
		TicTacToeInterface gameInterface = new TicTacToeInterface();
		gameInterface.sendDataToBoard(0,1);
		gameInterface.sendDataToBoard(0,0);		
		gameInterface.sendDataToBoard(1,1);
		gameInterface.sendDataToBoard(0,2);
		gameInterface.sendDataToBoard(2,1);	
		gameInterface.checkForWin();
		gameInterface.sendDataToBoard(2,2);
		assertEquals(" ",gameInterface.whoControlsThisTile(2,2));		
	}
}