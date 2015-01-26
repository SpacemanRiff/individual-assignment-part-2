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
		assertEquals("X",game.whoControlsTheTileAt(0,0));
	}
	
	@Test
	public void testTileWrittenWithO(){
		setupTests();
		game.markLocation(0,0);
		game.markLocation(1,0);
		assertEquals("O",game.whoControlsTheTileAt(1,0));
	}
	
	@Test
	public void testTileCannotBeOverWritten(){
		setupTests();
		game.markLocation(0,0);		
		game.markLocation(0,0);
		assertEquals("X",game.whoControlsTheTileAt(0,0));
	}
	
	@Test
	public void testTopLeftToBottomRightWin(){
		setupTests();		
		game.markLocation(0,0);
		game.markLocation(1,0);		
		game.markLocation(1,1);
		game.markLocation(2,0);
		game.markLocation(2,2);
		assertEquals(true,game.isThereADiagonalWinner());
		assertEquals("X",game.whoIsTheWinner());
	}
	
	@Test
	public void testTopRightToBottomLeftWin(){
		setupTests();		
		game.markLocation(0,2);
		game.markLocation(1,0);		
		game.markLocation(1,1);
		game.markLocation(0,1);
		game.markLocation(2,0);
		assertEquals(true,game.isThereADiagonalWinner());
		assertEquals("X",game.whoIsTheWinner());
	}
	
	@Test
	public void testRowOneWin(){
		setupTests();		
		game.markLocation(0,0);
		game.markLocation(1,0);		
		game.markLocation(0,1);
		game.markLocation(2,0);
		game.markLocation(0,2);
		assertEquals(true,game.isThereAHorizontalWinner());
		assertEquals("X",game.whoIsTheWinner());
	}
	
	@Test
	public void testRowTwoWin(){
		setupTests();		
		game.markLocation(1,0);
		game.markLocation(0,0);		
		game.markLocation(1,1);
		game.markLocation(0,1);
		game.markLocation(1,2);
		assertEquals(true,game.isThereAHorizontalWinner());
		assertEquals("X",game.whoIsTheWinner());
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
		assertEquals(true,game.isThereAHorizontalWinner());
		assertEquals("O",game.whoIsTheWinner());
	}
	
	@Test
	public void testColumnOneWin(){
		setupTests();		
		game.markLocation(0,0);
		game.markLocation(0,1);		
		game.markLocation(1,0);
		game.markLocation(0,2);
		game.markLocation(2,0);
		assertEquals(true,game.isThereAVerticalWinner());
		assertEquals("X",game.whoIsTheWinner());
	}
	
	@Test
	public void testColumnTwoWin(){
		setupTests();		
		game.markLocation(0,1);
		game.markLocation(0,0);		
		game.markLocation(1,1);
		game.markLocation(0,2);
		game.markLocation(2,1);
		assertEquals(true,game.isThereAVerticalWinner());
		assertEquals("X",game.whoIsTheWinner());
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
		assertEquals(true,game.isThereAVerticalWinner());
		assertEquals("O",game.whoIsTheWinner());
	}
	
	@Test
	public void testNoPlacesOnceGameIsOver(){
		setupTests();		
		game.markLocation(0,1);
		game.markLocation(0,0);		
		game.markLocation(1,1);
		game.markLocation(0,2);
		game.markLocation(2,1);	
		game.markLocation(2,2);
		assertEquals(" ",game.whoControlsTheTileAt(2,2));
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
		assertEquals(true,game.isTheGameOver());
	}
}