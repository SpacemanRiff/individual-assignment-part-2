package edu.jsu.mcis;

import org.junit.*;
import static org.junit.Assert.*;

public class TicTacToeTest{
	@Test
	public void testWinDiagonallyAsX(){
		TicTacToe game = new TicTacToe();
		
		game.markLocation(1,1);		
		assertEquals("X",game.whoControlsTheTileAt(1,1));
		
		game.markLocation(0,1);
		assertEquals("O",game.whoControlsTheTileAt(0,1));
		
		game.markLocation(0,0);
		assertEquals("X",game.whoControlsTheTileAt(0,0));
		
		game.markLocation(0,2);
		assertEquals("O",game.whoControlsTheTileAt(0,2));
		
		game.markLocation(2,2);
		assertEquals("X",game.whoControlsTheTileAt(2,2));
		
		assertEquals("X", game.whoHasWon());		
	}
	
	@Test
	public void testWinHorizontallyAsO(){
		TicTacToe game = new TicTacToe();
		
		game.markLocation(1,1);		
		assertEquals("X",game.whoControlsTheTileAt(1,1));
		
		game.markLocation(2,0);
		assertEquals("O",game.whoControlsTheTileAt(2,0));
		
		game.markLocation(0,0);
		assertEquals("X",game.whoControlsTheTileAt(0,0));
		
		game.markLocation(2,2);
		assertEquals("O",game.whoControlsTheTileAt(2,2));
		
		game.markLocation(0,2);
		assertEquals("X",game.whoControlsTheTileAt(0,2));
		
		game.markLocation(2,1);
		assertEquals("O",game.whoControlsTheTileAt(2,1));
		
		assertEquals("O", game.whoHasWon());		
	}
	
	@Test
	public void testTieGame(){
		TicTacToe game = new TicTacToe();
		
		game.markLocation(1,1);		
		assertEquals("X",game.whoControlsTheTileAt(1,1));
		
		game.markLocation(0,0);
		assertEquals("O",game.whoControlsTheTileAt(0,0));
		
		game.markLocation(2,0);		
		assertEquals("X",game.whoControlsTheTileAt(2,0));
		
		game.markLocation(0,2);
		assertEquals("O",game.whoControlsTheTileAt(0,2));
		
		game.markLocation(0,1);		
		assertEquals("X",game.whoControlsTheTileAt(0,1));
		
		game.markLocation(2,1);
		assertEquals("O",game.whoControlsTheTileAt(2,1));
		
		game.markLocation(1,2);		
		assertEquals("X",game.whoControlsTheTileAt(1,2));
		
		game.markLocation(1,0);
		assertEquals("O",game.whoControlsTheTileAt(1,0));
		
		game.markLocation(2,2);
		assertEquals("X",game.whoControlsTheTileAt(2,2));
		
		assertEquals("Tie", game.whoHasWon());		
	}
}