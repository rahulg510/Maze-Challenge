package business;

import framework.*;

/**
 * Edit History
 * 11/6 EA: implemented execute()
 * 
 * 11/11 EA: changed MoveNorth 
 */
public class MoveNorth extends Command {
	
    /**
     * Default constructor
     */
    public MoveNorth(Maze m) {
    	super();
    	model = m;
    }

    public void execute()
    {
    	if(model != null && model instanceof Maze)
    	{
	       Maze m = (Maze) model;
	       Player p = m.getPlayer();
	       if(p.getCurrentY()==0) return;
	       p.changePosition(p.getCurrentX(), p.getCurrentY()-1);
	       m.decMoves();
    	}
    }

}