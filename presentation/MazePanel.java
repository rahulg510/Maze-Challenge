package presentation;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;

import framework.*;
import business.*;

public class MazePanel extends AppPanel{

	public JTextField exitDistanceField;
	public JTextField movesLeftField;
    public MazeController controller;
    private ArrayList<JPanel> jPanels = new ArrayList<>();
    private Maze maze;
    private static final long serialVersionUID = 1L;
	
	
	public MazePanel(Maze maze, ActionListener listener) {
        super(maze, listener);
        setSize(400, 400);
        this.maze = (Maze)super.model;
        exitDistanceField = new JTextField(String.valueOf(maze.getExitDistance()));
        movesLeftField = new JTextField(String.valueOf(maze.getMovesLeft()));
        addInfo(new JLabel("Exist Distance:"), exitDistanceField);
        addInfo(new JLabel("Moves Left:"), movesLeftField);
        controller = new MazeController(maze);
        
        AppFactory factory = new MazeFactory();
        for (String str : factory.getEditCommands())
        {
            JButton button = new JButton(str);
            button.addActionListener(controller);
            addButton(button);
        }

        GridLayout layout = new GridLayout(jPanels.size(), 1);
        layout.preferredLayoutSize(this);
        layout.minimumLayoutSize(this);
        setLayout(layout);
        for (JPanel panel : jPanels) {
            panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
            add(panel);
        }
        
     }
	
    private void addInfo(JLabel label, JTextField field)
    {
        JPanel panel = new JPanel();
        panel.add(label);
        panel.add(field);
        jPanels.add(panel);
    }

    private void addButton(JButton button) {
        JPanel panel = new JPanel();
        panel.add(button);
        jPanels.add(panel);
    }
    
    @Override
    public void update(Observable o, Object arg) {
    	exitDistanceField.setText(String.valueOf(maze.getExitDistance()));
    	movesLeftField.setText(String.valueOf(maze.getMovesLeft()));
    	
    	repaint();

    }
  
}
