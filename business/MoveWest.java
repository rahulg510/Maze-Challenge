package business;

import framework.*;

/**
 * Edit History
 * 11/6 EA: implemented execute()
 * 
 * 11/11 EA: changed MoveWest ctor
 */
public class MoveWest extends Command {

    /**
     * Default constructor
     */
    public MoveWest(Maze m) {
    	super();
    	model = m;
    }
    public void execute() {
    	if(model != null && model instanceof Maze)
    	{
	    	Maze m = (Maze) model;
	        Player p = m.getPlayer();
	        if(p.getCurrentX() == 0) return;
	        p.changePosition(p.getCurrentX()-1, p.getCurrentY());
	        m.decMoves();
    	}
    }

}