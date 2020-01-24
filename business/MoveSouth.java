package business;

import framework.*;

/**
 * Edit History
 * 11/6 EA: implemented execute()
 * 
 * 11/11 EA: changed MoveSouth ctor
 */
public class MoveSouth extends Command {

    /**
     * Default constructor
     */
    public MoveSouth(Maze m) {
    	super();
    	model = m;
    }
   
    public void execute() {
    	if(model != null && model instanceof Maze)
    	{
    		Maze m = (Maze) model;
	        Player p = m.getPlayer();
	        if(p.getCurrentY() == 19) return;
	        p.changePosition(p.getCurrentX(), p.getCurrentY()+1);	
	        m.decMoves();
    	}
    }

}