package business;

import java.io.Serializable;
import java.util.Observable;

import framework.Utilities;

/**
 * 11/6 EA: implemented ctor, changePosition
 * 11/12 RK: created a Room variable to hold location of a player
 *
 */
public class Player implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Room room;
    
    
    public Player() {
		int xPos = Utilities.gen.nextInt(20);
		int yPos = Utilities.gen.nextInt(20);
		room = new Room(xPos,yPos);
	
	}
    
    public Player(Room r)
    {
    	room = r;
    }
	
	public int getCurrentX() {
    	return room.getxCoordinate();
    }
    
    public int getCurrentY() {
    	return room.getyCoordinate();
    }
    
    public void changePosition(int x, int y)
    {
    	room.setxCoordinate(x);
    	room.setyCoordinate(y);
    }
    
}
