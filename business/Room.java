package business;

import java.io.Serializable;

/**
 * Edit History
 * 11/6 EA: implemented isExitRoom(), setExit()
 */
public class Room implements Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Boolean exitRoom;
    private int xCoordinate;
    private int yCoordinate;
    
    /**
     * Default constructor
     */
    public Room(int x,int y) {
    	xCoordinate = x;
    	yCoordinate = y;
    	exitRoom = false;
    }
    public int getxCoordinate() {return xCoordinate;}

    public int getyCoordinate() {return yCoordinate;}
    
    public void setxCoordinate(int x) {xCoordinate = x;}

    public void setyCoordinate(int y) {yCoordinate = y;}
    
    public void setExit() {exitRoom = true;}

    public boolean isExitRoom() {return exitRoom;}

}   
