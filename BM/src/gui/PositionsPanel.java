package gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import teams.Player;
import teams.TacticBoard;
import teams.Team;

public class PositionsPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BufferedImage background;
	JLabel[] overlay = new JLabel[10]; 
	Team homeTeam;
	Team awayTeam;

	public PositionsPanel(Team homeTeam, Team awayTeam) {
		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;
		setFocusable(true);
		setSize(100,100);
		for(int i=0;i<overlay.length;i++){
			overlay[i]=new JLabel();
		}
		
		try {
			background = ImageIO.read(new File("basketball-court.jpg"));
		} catch (IOException ex) {
			// handle exception...
		}
	
		Dimension dim=new Dimension(background.getWidth(), background.getHeight());
		setPreferredSize(dim);
		
	}
	
	public void setTextPositions(){
		for(int i=0;i<5;i++){
		TacticBoard tb= homeTeam.getTacticBoard();
		Player[] players=tb.getOnFloorPlayers();
		String name=players[i].getName();
		overlay[i].setText(name);
		}
		for(int i=5;i<10;i++){
		TacticBoard tb= awayTeam.getTacticBoard();
		Player[] players=tb.getOnFloorPlayers();
		String name=players[i-5].getName();
		overlay[i].setText(name);
		}
		overlay[4].setLocation(background.getWidth()/5-10, 2*background.getHeight()/5+5);
		overlay[9].setLocation(2*background.getWidth()/3,  2*background.getHeight()/5+5);
		overlay[0].setLocation(background.getWidth()/20-5, 3*background.getHeight()/5-10);
		overlay[5].setLocation(2*background.getWidth()/4+10, 3*background.getHeight()/5-10);
		overlay[1].setLocation(2*background.getWidth()/7, 3*background.getHeight()/5);
		overlay[6].setLocation(4*background.getWidth()/5, 3*background.getHeight()/5);
		overlay[2].setLocation(background.getWidth()/20-5, background.getHeight()/5-10);
		overlay[7].setLocation(2*background.getWidth()/4+10, background.getHeight()/5-10);
		overlay[3].setLocation(2*background.getWidth()/7, background.getHeight()/5);
		overlay[8].setLocation(4*background.getWidth()/5, background.getHeight()/5);	
		for(JLabel player : overlay){
			add(player);
		}
		repaint();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(background, 0, 0, null);
		setTextPositions();
		
	}

}
