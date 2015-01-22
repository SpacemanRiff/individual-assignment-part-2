package edu.jsu.mcis;

import org.junit.*;
import static org.junit.Assert.*;

public class TicTacToeTest{
	@Test
	public void testTileWrittenWithX(){
		TicTacToe game = new TicTacToe();
		game.markLocation(0,0);
		assertEquals("X",game.whoControlsTheTileAt(0,0));
	}
	
	@Test
	public void testTileWrittenWithO(){
		TicTacToe game = new TicTacToe();
		game.markLocation(0,0);
		game.markLocation(1,0);
		assertEquals("O",game.whoControlsTheTileAt(1,0));
	}
	
	@Test
	public void testTileCannotBeOverWritten(){
		TicTacToe game = new TicTacToe();
		game.markLocation(0,0);		
		game.markLocation(0,0);
		assertEquals("X",game.whoControlsTheTileAt(0,0));
	}
	
	@Test
	public void testTopLeftToBottomRightWin(){
		TicTacToe game = new TicTacToe();		
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
		TicTacToe game = new TicTacToe();		
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
		TicTacToe game = new TicTacToe();		
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
		TicTacToe game = new TicTacToe();		
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
		TicTacToe game = new TicTacToe();		
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
		TicTacToe game = new TicTacToe();		
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
		TicTacToe game = new TicTacToe();		
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
		TicTacToe game = new TicTacToe();		
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
		TicTacToe game = new TicTacToe();		
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
		TicTacToe game = new TicTacToe();		
		game.markLocation(0,0);			
		game.markLocation(0,1);	
		game.markLocation(0,2);	
		game.markLocation(2,0);			
		game.markLocation(2,1);	
		game.markLocation(2,2);
		game.markLocation(1,0);			
		game.markLocation(1,1);	
		game.markLocation(1,2);
	}
}