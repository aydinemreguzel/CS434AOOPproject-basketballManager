package controllers;

import java.awt.Dimension;
import java.util.Scanner;

import javax.swing.JFrame;

import gameengine.Game;
import gui.MainPanel;

public class MainController {

	Game game;
	MainPanel mainPanel;

	public MainController(Game game) {
		super();
		this.game = game;
		
		this.mainPanel = new MainPanel(this);
	}

	public void start() {
		JFrame frame = new JFrame("SimpleMain");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		frame.setPreferredSize(new Dimension(250,250));
		frame.setLocation(100, 100);
		frame.pack();
		frame.setVisible(true);
		frame.add(mainPanel);
		frame.repaint();
	}
	public void nextDay(){
		game.advanceInTime();
	}

}
