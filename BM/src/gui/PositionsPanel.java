package gui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

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
		try {
			background = ImageIO.read(new File("basketball-court.jpg"));
		} catch (IOException ex) {
			// handle exception...
		}
	}
	
	public void setTextPositions(){
		overlay[0].setText(homeTeam.getTacticBoard().getOnFloorPlayers()[0].getName());
		overlay[1].setText(homeTeam.getTacticBoard().getOnFloorPlayers()[1].getName());
		overlay[2].setText(homeTeam.getTacticBoard().getOnFloorPlayers()[2].getName());
		overlay[3].setText(homeTeam.getTacticBoard().getOnFloorPlayers()[3].getName());
		overlay[4].setText(homeTeam.getTacticBoard().getOnFloorPlayers()[4].getName());
		overlay[5].setText(awayTeam.getTacticBoard().getOnFloorPlayers()[0].getName());
		overlay[6].setText(awayTeam.getTacticBoard().getOnFloorPlayers()[1].getName());
		overlay[7].setText(awayTeam.getTacticBoard().getOnFloorPlayers()[2].getName());
		overlay[8].setText(awayTeam.getTacticBoard().getOnFloorPlayers()[3].getName());
		overlay[9].setText(awayTeam.getTacticBoard().getOnFloorPlayers()[4].getName());
		overlay[4].setLocation(background.getWidth()/3, background.getHeight()/2);
		overlay[9].setLocation(2*background.getWidth()/3, background.getHeight()/2);
		overlay[0].setLocation(background.getWidth()/5, 3*background.getHeight()/5);
		overlay[5].setLocation(3*background.getWidth()/5, 3*background.getHeight()/5);
		overlay[1].setLocation(2*background.getWidth()/5, 3*background.getHeight()/5);
		overlay[6].setLocation(4*background.getWidth()/5, 3*background.getHeight()/5);
		overlay[2].setLocation(background.getWidth()/5, background.getHeight()/5);
		overlay[7].setLocation(3*background.getWidth()/5, background.getHeight()/5);
		overlay[3].setLocation(2*background.getWidth()/5, background.getHeight()/5);
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
	}

}
