package presentation;

import java.awt.*;
import java.util.*;
import javax.swing.*;

import business.*;
import framework.*;
/**
 * Edit History
 * 11/7 : JL: Implemented methods: MazeFrame const, createMenuBar(), main(),
 * createMenuBar(), FileMenuController class, HelpMenuController class
 *   
 *  11/12: RK: Removed actionPerformed(), made changes to ctor
 */
public class MazeFrame extends AppFrame implements Observer{

	private static final long serialVersionUID = 1L;
	private Maze model;
	private MazeView mView;
	private AppPanel panel;

	public MazeFrame(AppFactory factory) {
		super(factory);
    	setBackground(Color.DARK_GRAY);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	model = (Maze) factory.makeModel();
    	panel = factory.makePanel(model, this);
    	add(panel);
    	JMenuBar menuBar = createMenuBar();
    	setJMenuBar(menuBar);
    	setSize(800,445);
    	model.addObserver(this);
		GridLayout layout = new GridLayout(1, 2); 
   	 	layout.preferredLayoutSize(this);
    	setLayout(layout);  
    	mView = new MazeView(model);
    	add(mView);
 	
	}

	protected JMenuBar createMenuBar() 
	{
    	FileMenuController fileMenuController = new FileMenuController(model);
    	JMenuBar result = new JMenuBar();
    	result.add(Utilities.makeMenu("File", new String[]{"New", "Open", "Save", "SaveAs", "Quit"}, fileMenuController));
    	result.add(Utilities.makeMenu("Edit", factory.getEditCommands(), new MazeController(model)));
    	result.add(Utilities.makeMenu("Help", factory.getHelp() , new HelpMenuController(this)));
    	return result;
    }
	
	@Override
	public void update(Observable o, Object arg)
	{
		repaint();
	}
	
	public static void main(String[] args) {
			AppFrame app = new MazeFrame(new MazeFactory());
			app.display();
    }
	
}
