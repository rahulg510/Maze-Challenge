package business;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


/**
 * 11/13: RK: Create MazeChallenge Tests
 */
class MazeChallengeTests {

		@Test
		void moveNorthTest() 
		{
			Maze maze = new Maze();
			int currentY = maze.getPlayer().getCurrentY();
			int currentX = maze.getPlayer().getCurrentX();
			int currentMoves = maze.getMovesLeft();
			new MoveNorth(maze).execute();
			int expectedY = maze.getPlayer().getCurrentY();
			int expectedX = maze.getPlayer().getCurrentX();
			int expMoves = maze.getMovesLeft();
			if(currentY>0) 
			{
				assertEquals(expectedY, currentY-1);
				assertEquals(expectedX, currentX);
				assertEquals(expMoves,currentMoves-1);
			}
			else
			{
				assertEquals(expectedY, currentY);
				assertEquals(expectedX, currentX);
				assertEquals(expMoves,currentMoves);
			}
		}
		
		@Test
		void moveSouthTest() 
		{
			Maze maze = new Maze();
			int currentY = maze.getPlayer().getCurrentY();
			int currentX = maze.getPlayer().getCurrentX();
			int currentMoves = maze.getMovesLeft();
			new MoveSouth(maze).execute();
			int expectedY = maze.getPlayer().getCurrentY();
			int expectedX = maze.getPlayer().getCurrentX();
			int expMoves = maze.getMovesLeft();
			if(currentY<19) 
			{
				assertEquals(expectedY, currentY+1);
				assertEquals(expectedX, currentX);
				assertEquals(expMoves,currentMoves-1);
			}
			else
			{
				assertEquals(expectedY, currentY);
				assertEquals(expectedX, currentX);
				assertEquals(expMoves,currentMoves);
			}
		}
		
		@Test
		void moveWestTest() 
		{
			Maze maze = new Maze();
			int currentY = maze.getPlayer().getCurrentY();
			int currentX = maze.getPlayer().getCurrentX();
			int currentMoves = maze.getMovesLeft();
			new MoveWest(maze).execute();
			int expectedY = maze.getPlayer().getCurrentY();
			int expectedX = maze.getPlayer().getCurrentX();
			int expMoves = maze.getMovesLeft();
			if(currentX>0) 
			{
				assertEquals(expectedY, currentY);
				assertEquals(expectedX, currentX-1);
				assertEquals(expMoves,currentMoves-1);
			}
			else
			{
				assertEquals(expectedY, currentY);
				assertEquals(expectedX, currentX);
				assertEquals(expMoves,currentMoves);
			}
		}
		
		@Test
		void moveEastTest() 
		{
			Maze maze = new Maze();
			int currentY = maze.getPlayer().getCurrentY();
			int currentX = maze.getPlayer().getCurrentX();
			int currentMoves = maze.getMovesLeft();
			new MoveEast(maze).execute();
			int expectedY = maze.getPlayer().getCurrentY();
			int expectedX = maze.getPlayer().getCurrentX();
			int expMoves = maze.getMovesLeft();
			if(currentX<19) 
			{
				assertEquals(expectedY, currentY);
				assertEquals(expectedX, currentX+1);
				assertEquals(expMoves,currentMoves-1);
			}
			else
			{
				assertEquals(expectedY, currentY);
				assertEquals(expectedX, currentX);
				assertEquals(expMoves,currentMoves);
			}
		}
		
		
		
}
