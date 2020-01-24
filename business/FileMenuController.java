package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import framework.Model;
import framework.Utilities;
/**
 *11/12: RK: Implemented FileMenuController as its own class instead of an inner class
 */
public class FileMenuController implements ActionListener {

	private Model model;
	
	public FileMenuController(Model m)
	{
		model = m;
	}
	
    @Override
    public void actionPerformed(ActionEvent e) {
        String cmmd = e.getActionCommand(); 
     
        if (cmmd.equals("Save")) {
            Utilities.save(model, false);
            model.setUnsavedChanges(false);
        } else if (cmmd == "SaveAs") {
            Utilities.save(model, true);
            model.setUnsavedChanges(false);
        } else if (cmmd == "Open") {
            Maze model2 = (Maze) Utilities.open(model);
            model.copy(model2);
        } else if (cmmd == "New") {
            Maze m2 = (Maze) Utilities.newMaze(model);
            model.copy(m2);
        } else if (cmmd == "Quit") {
            if(Utilities.isExit(model))
            	System.exit(1);
            
        } else {
            Utilities.error("Unrecognized command: " + cmmd);
        }
    }
}