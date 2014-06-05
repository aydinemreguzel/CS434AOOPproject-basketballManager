package gui;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controllers.MatchPanelController;
import events.MatchEvent;
import teams.ScoreBoard;

public class MatchPanel extends JPanel{
	MatchEvent match;
	ScoreBoardPanel homeScoreBoardPanel;
	ScoreBoardPanel awayScoreBoardPanel;
	CommentaryPanel commentaryPanel;
	PositionsPanel positionsPanel;
	TimeOutsPanel timeOutsPanel;
	JButton timeOutButton;
	MatchPanelController matchPanelController;
	public MatchPanel(MatchEvent match) {
		super();
		this.matchPanelController=new MatchPanelController(this);
		this.match = match;
		this.homeScoreBoardPanel = new ScoreBoardPanel(match.getHomeScoreBoard());
		this.awayScoreBoardPanel = new ScoreBoardPanel(match.getAwayScoreBoard());
		this.commentaryPanel = new CommentaryPanel();
		this.positionsPanel = new PositionsPanel(match.getHomeTeam(),match.getAwayTeam());
		this.timeOutsPanel = new TimeOutsPanel();
		
		this.timeOutButton=new JButton(new AbstractAction("") {
			public void actionPerformed(ActionEvent e) {
				matchPanelController.timeOut();
			}
		});
			
			
	
		this.add(homeScoreBoardPanel);
		this.add(awayScoreBoardPanel);
		this.add(commentaryPanel);
		this.add(positionsPanel);
		this.add(timeOutsPanel);
		this.add(timeOutButton);
	}
	

}
