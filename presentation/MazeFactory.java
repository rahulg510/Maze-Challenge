package presentation;

import business.*;
import framework.*;
import java.awt.event.ActionListener;
/**
 * Edit History
 * Code generated from class diagrams
 * 11/12: EA: Fixed makeEditCommands()
 */
public class MazeFactory implements AppFactory {

    /**
     * Default constructor
     */
    public MazeFactory() {	
    }

    /**
     * 
     */
    public Model makeModel() {
    	return new Maze();
    }
    
    /**
     * @param model 
     * @param listener
     */
    public	AppPanel makePanel(Model model, ActionListener listener) {
    	AppPanel panel = new MazePanel((Maze)model,listener);
    	return panel;
    }

    /**
     * 
     */
    public String[] getEditCommands() {
    	return new String[] {"North", "East", "West", "South", "Reset"}; 
    }
    
    public String[] getFileCommands()
    {
    	return new String[]{"New", "Open", "Save", "SaveAs", "Quit"};
    }

    /**
     * @param model 
     * @param type
     */
    public Command makeEditCommands(Model model, String type) {
    	Maze m = (Maze) model;
        if(type == "North") return new MoveNorth(m);
        else if(type == "South") return new MoveSouth(m);
        else if(type == "West") return new MoveWest(m);
        else if(type == "East") return new MoveEast(m);
        else if(type == "Reset") return new Reset(m);
        return null;
    }

    /**
     * 
     */
    public String getTitle() {
        return "Maze Challenge"; 
    }

    /**
     * 
     */
    public String[] getHelp() {
        return new String[]{"About" , "Contents"};
    }

    /**
     * 
     */
    public String about() {
        return "Maze Challenge version 1.0 by XXX Design @2019";
    }
    
    public String contents()
    {
    	return "Locate the escape room in the number of allotted moves.";
    }
    
}