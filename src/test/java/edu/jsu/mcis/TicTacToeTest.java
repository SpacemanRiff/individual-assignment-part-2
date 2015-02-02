package edu.jsu.mcis;

import org.junit.*;
import static org.junit.Assert.*;

public class TicTacToeTest{
	TicTacToe game;
	
	@Before
	public void setupTests(){
		game = new TicTacToe();
	}
	
	@Test
	public void testTileWrittenWithX(){
		setupTests();
		game.markLocation(0,0);
        assertEquals("O",game.getTurnPlayer());
		assertEquals("X",game.getTileAt(0,0));
	}
	
	@Test
	public void testTileWrittenWithO(){
		setupTests();
		game.markLocation(0,0);
		game.markLocation(1,0);
        assertEquals("X",game.getTurnPlayer());
		assertEquals("O",game.getTileAt(1,0));
	}
	
	@Test
	public void testTileCannotBeOverWritten(){
		setupTests();
		game.markLocation(0,0);		
		game.markLocation(0,0);
        game.checkForGameOver();
        game.isTheGameOver();
		assertEquals("X",game.getTileAt(0,0));
	}
	
	@Test
	public void testXTileCannotBePlacedOffBoard(){		
		setupTests();
		game.markLocation(-1,-1);
		game.markLocation(3,3);
		game.markLocation(-1,3);
		game.markLocation(3,-1);
		game.markLocation(0,3);
		game.markLocation(0,-1);
		game.markLocation(-1,0);
		game.markLocation(3,0);
        assertEquals("X",game.getTurnPlayer());
	}
	
	@Test
	public void testOTileCannotBePlacedOffBoard(){
		setupTests();
		game.markLocation(0,0);
		game.markLocation(-1,-1);
		game.markLocation(3,3);
		game.markLocation(-1,3);
		game.markLocation(3,-1);
		game.markLocation(0,3);
		game.markLocation(0,-1);
		game.markLocation(-1,0);
		game.markLocation(3,0);
        assertEquals("O",game.getTurnPlayer());
	}
	
	@Test
	public void testNoWinnersAtStart(){
		setupTests();
		game.checkForGameOver();
		assertEquals(false, game.isTheGameOver());
	}
	
	@Test
	public void testTopLeftToBottomRightWin(){
		setupTests();		
		game.markLocation(0,0);
		game.markLocation(1,0);		
		game.markLocation(1,1);
		game.markLocation(2,0);
		game.markLocation(2,2);
        game.checkForGameOver();
		assertEquals("X",game.getWinner());
	}
	
	@Test
	public void testTopRightToBottomLeftWin(){
		setupTests();		
		game.markLocation(0,2);
		game.markLocation(1,0);		
		game.markLocation(1,1);
		game.markLocation(0,1);
		game.markLocation(2,0);
        game.checkForGameOver();
		assertEquals("X",game.getWinner());
	}
	
	@Test
	public void testRowOneWin(){
		setupTests();		
		game.markLocation(0,0);
		game.markLocation(1,0);		
		game.markLocation(0,1);
		game.markLocation(2,0);
		game.markLocation(0,2);
        game.checkForGameOver();
		assertEquals("X",game.getWinner());
	}
	
	@Test
	public void testRowTwoWin(){
		setupTests();		
		game.markLocation(1,0);
		game.markLocation(0,0);		
		game.markLocation(1,1);
		game.markLocation(0,1);
		game.markLocation(1,2);
        game.checkForGameOver();
		assertEquals("X",game.getWinner());
	}
	
	@Test
	public void testRowThreeWin(){
		setupTests();		
		game.markLocation(0,0);
		game.markLocation(2,0);
		game.markLocation(0,1);		
		game.markLocation(2,1);
		game.markLocation(1,0);
		game.markLocation(2,2);
        game.checkForGameOver();
		assertEquals("O",game.getWinner());
	}
	
	@Test
	public void testColumnOneWin(){
		setupTests();		
		game.markLocation(0,0);
		game.markLocation(0,1);		
		game.markLocation(1,0);
		game.markLocation(0,2);
		game.markLocation(2,0);
        game.checkForGameOver();
		assertEquals("X",game.getWinner());
	}
	
	@Test
	public void testColumnTwoWin(){
		setupTests();		
		game.markLocation(0,1);
		game.markLocation(0,0);		
		game.markLocation(1,1);
		game.markLocation(0,2);
		game.markLocation(2,1);
        game.checkForGameOver();
		assertEquals("X",game.getWinner());
	}
	
	@Test
	public void testColumnThreeWin(){
		setupTests();		
		game.markLocation(1,1);	
		game.markLocation(0,2);
		game.markLocation(0,0);		
		game.markLocation(1,2);
		game.markLocation(0,1);
		game.markLocation(2,2);
        game.checkForGameOver();
		assertEquals("O",game.getWinner());
	}
	
	@Test
	public void testNoPlacesOnceGameIsOver(){
		setupTests();		
		game.markLocation(0,1);
		game.markLocation(0,0);		
		game.markLocation(1,1);
		game.markLocation(0,2);
		game.markLocation(2,1);	
        game.checkForGameOver();
		game.markLocation(2,2);
		assertEquals(" ",game.getTileAt(2,2));
	}
	
	@Test
	public void testIsTheBoardFull(){		
		setupTests();		
		game.markLocation(0,0);			
		game.markLocation(0,1);	
		game.markLocation(0,2);	
		game.markLocation(2,0);			
		game.markLocation(2,1);	
		game.markLocation(2,2);
		game.markLocation(1,0);			
		game.markLocation(1,1);	
		game.markLocation(1,2);
        game.checkForGameOver();
		assertEquals(true,game.isTheGameOver());
	}
}