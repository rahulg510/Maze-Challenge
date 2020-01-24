package business;

import framework.*;

/**
 * Edit History
 * 11/12: RK: Implemented execute() 
 */
public class Reset extends Command {

    /**
     * Default constructor
     */
    public Reset(Model m) {
    	super();
    	model = (Maze)m;
    }

    /**
     * 
     */
    public void execute() {
    	int size = 20;
    	int x1 = (int) (Math.random()*(size));
    	int y1 = (int) (Math.random()*(size));
    	int x2 = (int) (Math.random()*(size));
    	int y2 = (int) (Math.random()*(size));
    	Room initRoom = new Room(x1,y1);
    	
    	Player player = new Player(initRoom);
    	Room exitRoom = new Room(x2,y2);
    	int exitDistance = Math.abs(x1-x2)+Math.abs(y1-y2);
    	int movesLeft = exitDistance+5;
    	((Maze)model).setExitRoom(exitRoom);
    	((Maze)model).setNumberOfMovesLeft(movesLeft);
    	((Maze)model).setPlayer(player);
    	((Maze)model).setDistanceToExit(exitDistance);
    	
    }

}