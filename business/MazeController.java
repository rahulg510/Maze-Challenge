package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

import framework.AppFactory;
import framework.Command;
import presentation.MazeFactory;

/**
 * 11/12 RK: Implemented MazeController as its own class
 */
public class MazeController implements ActionListener
{
	private Maze maze;
	
	public MazeController(Maze model) 
	{
		maze = model;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String cmnd = e.getActionCommand();
		
		MazeFactory factory = new MazeFactory();
		Command c = factory.makeEditCommands(maze, cmnd);
			try 
			{
				if(c instanceof Reset || maze.getMovesLeft()>=1)
				{
					c.execute();
					if(maze.getExitDistance() == 0) {
						JOptionPane.showMessageDialog(null, "You escaped!", "Information", JOptionPane.INFORMATION_MESSAGE);
						return;
					}
					if(maze.getMovesLeft() == 0) {
						throw new Exception();
					}
				} 
			}
			catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "No moves left", "Information", JOptionPane.INFORMATION_MESSAGE);
			}
		
		maze.changed();
	}


	
}