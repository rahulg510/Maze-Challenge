package business;

import java.util.Random;

import framework.*;

/**
 * Edit History
 * 11/6: EA: Implemented Maze(),createRooms(),getExitDistance(),
 * getMovesLeft(),move(Heading h),getPlayer(),decMoves() 
 * 
 * 11/11: EA: Small change in move()
 * 
 * 11/12: RK: removed move(), implemented setters for numberOfMovesLeft, exitDistance, and player
 * 
 */public class Maze extends Model{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Room[][] rooms;
	private int numberOfMovesLeft;
    private int distanceToExit;
    private Room exitRoom;
    
    private Player player;
    
    
    public Maze() {
    	createRooms();
    	player = new Player();
    	distanceToExit = getExitDistance();
    	numberOfMovesLeft = distanceToExit + random();
    }

	public void createRooms() {
    	rooms = new Room[20][20];
    	int x = Utilities.gen.nextInt(20);
		int y = Utilities.gen.nextInt(20);
		for(int i=0; i<20;i++)
		{
			for(int j=0;j<20;j++)
			{
				rooms[i][j] = new Room(i,j);
				if(i == x && j == y) 
				{
					exitRoom = rooms[i][j];
					exitRoom.setExit();
				}
			}
		}
	}

	public void copy(Model other)
    {
    	super.copy(other);
    	if(other != null && other instanceof Maze)
    	{
	    	Maze m = (Maze) other;
	    	//update instance variables here
	    	player = m.player;
	    	numberOfMovesLeft = m.numberOfMovesLeft;
	    	distanceToExit = 0;//m.distanceToExit;
	    	rooms = m.rooms;
	    	exitRoom = m.exitRoom;
	    	changed();
    	}
    }
	
	public Room getExitRoom() {
		return exitRoom;
		}
    
	public int random()
	{
		Random r = new Random(System.currentTimeMillis());
		int m = r.nextInt(4);
		return 5+m;
		
	}
	
	public void setExitRoom(Room exit)
	{
		exitRoom = exit;
		changed();
		
	}
    public int getExitDistance()
    {
    	return (Math.abs(player.getCurrentX()-exitRoom.getxCoordinate())
    			+ Math.abs(player.getCurrentY()-exitRoom.getyCoordinate()));
    }

	public void setNumberOfMovesLeft(int numberOfMovesLeft) {
		this.numberOfMovesLeft = numberOfMovesLeft;
		changed();
	}

	public void setDistanceToExit(int distanceToExit) {
		this.distanceToExit = distanceToExit;
		changed();
	}

	public void setPlayer(Player player) {
		this.player = player;
		changed();
	}

	public int getMovesLeft() {
		return numberOfMovesLeft;
	}

	public boolean isPlayerAtExit() {
		return exitRoom.getxCoordinate() == player.getCurrentX() 
				&& exitRoom.getyCoordinate() == player.getCurrentY();
	}
	
	public Player getPlayer() { return player;}
	
	public void decMoves() {numberOfMovesLeft--;}

	public int getYExitCoordinate() {return exitRoom.getyCoordinate();}
	
	public int getXExitCoordinate() {return exitRoom.getxCoordinate();}
	
	public void setYExitCoordinate(int yExitCoordinate)
	{
		exitRoom.setyCoordinate(yExitCoordinate);
		changed();
	}
	public void setXExitCoordinate(int xExitCoordinate)
	{
		exitRoom.setxCoordinate(xExitCoordinate);
		changed();
	}

}