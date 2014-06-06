package gui;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import events.MatchEvent;
import teams.Team;

public class ScorePanel extends JPanel {
	JLabel homeLabel;
	JLabel awayLabel;
	Team homeTeam;
	Team awayTeam;
	MatchEvent match;
	public ScorePanel(MatchEvent match) {
		super();
		this.match=match;
		this.homeTeam = match.getHomeTeam();
		this.awayTeam = match.getAwayTeam();
		this.homeLabel=new JLabel(homeTeam.getName()+"-"+match.getHomeScoreBoard().getScore());
		this.awayLabel=new JLabel(awayTeam.getName()+"-"+match.getAwayScoreBoard().getScore());
		homeLabel.setFont(new Font("Ariel",1,16));
		awayLabel.setFont(new Font("Ariel",1,16));
		this.add(homeLabel);
		this.add(awayLabel);
		
	}
	public void update() {
		homeLabel.setText(homeTeam.getName()+"-"+match.getHomeScoreBoard().getScore());
		awayLabel.setText(awayTeam.getName()+"-"+match.getAwayScoreBoard().getScore());
	}
	

}
