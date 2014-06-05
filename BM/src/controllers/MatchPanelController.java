package controllers;

import matchengine.MatchEngine;
import gui.CommentaryPanel;
import gui.MatchPanel;
import gui.PositionsPanel;
import gui.ScoreBoardPanel;
import gui.TacticBoardFrame;

public class MatchPanelController {
	MatchPanel matchPanel;
	MatchEngine matchEng;
	ScoreBoardPanel homeScoreBoardPanel;
	ScoreBoardPanel awayScoreBoardPanel;
	CommentaryPanel commentaryPanel;
	PositionsPanel positionsPanel;
	public MatchPanelController(MatchPanel matchPanel) {
		super();
		//TODO-MatchPanelController constructor
//		this.matchPanel = new MatchPanel(matchPanel);
//		this.homeScoreBoardPanel = new ScoreBoardPanel(matchPanel.getHomeScoreBoard());
//		this.awayScoreBoardPanel = new ScoreBoardPanel(matchPanel.getAwayScoreBoard());
	}
	public void timeOut() {
		// TODO timeout
		
		//stop the matchEngine here;
		
		new TacticBoardFrame();
		
	}
	
	
}
