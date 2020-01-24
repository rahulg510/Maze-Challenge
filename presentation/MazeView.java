package presentation;

import java.awt.Color;
import java.awt.Graphics;
import java.util.*;

import javax.swing.*;

import business.*;
import framework.*;

public class MazeView extends View{

	/**
	 * 11/12: JL: Created all of MazeView
	 * 11/13: RK: Replaced reshow() with an update()
	 */
private static final long serialVersionUID = 6L;
	
	public MazeView(Model maze) { 
		super(maze);
	}
	
	private ArrayList<JLabel> labels = new ArrayList<>();
    private int last;
	
	
	@Override
	protected void paintComponent(Graphics g) {
		if(model != null && model instanceof Maze) {
			Maze maze = (Maze) model;
			int x = maze.getPlayer().getCurrentX();
	    	int y = maze.getPlayer().getCurrentY();
	    	int grids = 20;
	        int size = 20;
	        for (int i = 0; i < grids; i++) {
	            for (int j = 0; j < grids; j++) {
	                JLabel jLabel = new JLabel();
	                jLabel.setSize(size, size);
	                jLabel.setLocation(i * size, j * size);
	                jLabel.setBackground(Color.darkGray);
	                jLabel.setOpaque(true);
	                jLabel.setBorder(BorderFactory.createLineBorder(Color.black));
	                if(x == i && j == y) {
	                	Icon icon = new LabelIcon(15,15);
	                	jLabel.setIcon(icon);
	                	last = i*20+j;
	                }
	                add(jLabel);
	                labels.add(jLabel);
	            }
	        }
			
		}
	}

	public void update(Observable subject, Object msg) {
		Icon icon = new LabelIcon(15,15);
		Maze maze = (Maze)model;
    	int x = maze.getPlayer().getCurrentX();
    	int y = maze.getPlayer().getCurrentY();
    	labels.get(last).setIcon(null);
    	labels.get(x*20 +y).setIcon(icon);
    	last = x*20 +y;
		repaint();}

	}

