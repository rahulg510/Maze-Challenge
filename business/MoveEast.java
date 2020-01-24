package business;

import framework.Command;

/**
 * Edit History
 * 11/6 EA: implemented execute()
 * 
 * 11/11 EA: changed MoveEast ctor
 */
public class MoveEast extends Command {

    /**
     * Default constructor
     */
    public MoveEast(Maze m) {
    	super();
    	model = m;
    }
 
    public void execute() 
    {
    	if(model != null && model instanceof Maze)
    	{
	    	Maze m = (Maze) model;
	        Player p = m.getPlayer();
	        if(p.getCurrentX() == 19) return;
	        p.changePosition(p.getCurrentX()+1, p.getCurrentY());
	        m.decMoves();
    	}
    }
}