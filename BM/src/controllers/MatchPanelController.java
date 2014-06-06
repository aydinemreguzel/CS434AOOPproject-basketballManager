package controllers;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;

import javax.swing.JFrame;

import teams.ScoreBoard;
import events.MatchEvent;
import matchengine.MatchEngine;
import gui.CommentaryPanel;
import gui.MatchPanel;
import gui.PositionsPanel;
import gui.ScoreBoardPanel;
import gui.TacticBoardFrame;
import gui.TimeOutsPanel;

public class MatchPanelController {
	MatchEvent match;
	MatchPanel matchPanel;
	MatchEngine matchEng;
	ScoreBoardPanel homeScoreBoardPanel;
	ScoreBoardPanel awayScoreBoardPanel;
	CommentaryPanel commentaryPanel;
	PositionsPanel positionsPanel;
	TimeOutsPanel timeOutsPanel;

	public MatchPanelController(MatchEvent match) {
		super();
		// TODO-MatchPanelController constructor
		this.match = match;
		this.matchEng = new MatchEngine(match);
		this.homeScoreBoardPanel = new ScoreBoardPanel(
				match.getHomeScoreBoard());
		this.awayScoreBoardPanel = new ScoreBoardPanel(
				match.getAwayScoreBoard());
		this.positionsPanel = new PositionsPanel(match.getHomeTeam(),
				match.getAwayTeam());
		this.commentaryPanel = new CommentaryPanel();
		this.timeOutsPanel = new TimeOutsPanel();
		this.matchPanel = new MatchPanel(this);
	}

	public void play() {
		// TODO play()
		JFrame frame = new JFrame("SimpleDemo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		frame.setLocation(100, 100);
		// Create and set up the content pane.
		matchPanel.setOpaque(true); // content panes must be opaque
		frame.add(matchPanel);
		// Display the window.static
		frame.pack();
		frame.setVisible(true);
		frame.repaint();
		while(matchEng.getReamainPeriodTime() > 0){ 
			matchEng.play();
			homeScoreBoardPanel.update();
			awayScoreBoardPanel.update();
			commentaryPanel.update();
		}
	}

	public void timeOut() {
		// TODO timeout

		// stop the matchEngine here;

		new TacticBoardFrame();

	}

	/**
	 * @return the matchPanel
	 */
	public MatchPanel getMatchPanel() {
		return matchPanel;
	}

	/**
	 * @param matchPanel
	 *            the matchPanel to set
	 */
	public void setMatchPanel(MatchPanel matchPanel) {
		this.matchPanel = matchPanel;
	}

	/**
	 * @return the matchEng
	 */
	public MatchEngine getMatchEng() {
		return matchEng;
	}

	/**
	 * @param matchEng
	 *            the matchEng to set
	 */
	public void setMatchEng(MatchEngine matchEng) {
		this.matchEng = matchEng;
	}

	/**
	 * @return the homeScoreBoardPanel
	 */
	public ScoreBoardPanel getHomeScoreBoardPanel() {
		return homeScoreBoardPanel;
	}

	/**
	 * @param homeScoreBoardPanel
	 *            the homeScoreBoardPanel to set
	 */
	public void setHomeScoreBoardPanel(ScoreBoardPanel homeScoreBoardPanel) {
		this.homeScoreBoardPanel = homeScoreBoardPanel;
	}

	/**
	 * @return the awayScoreBoardPanel
	 */
	public ScoreBoardPanel getAwayScoreBoardPanel() {
		return awayScoreBoardPanel;
	}

	/**
	 * @param awayScoreBoardPanel
	 *            the awayScoreBoardPanel to set
	 */
	public void setAwayScoreBoardPanel(ScoreBoardPanel awayScoreBoardPanel) {
		this.awayScoreBoardPanel = awayScoreBoardPanel;
	}

	/**
	 * @return the commentaryPanel
	 */
	public CommentaryPanel getCommentaryPanel() {
		return commentaryPanel;
	}

	/**
	 * @param commentaryPanel
	 *            the commentaryPanel to set
	 */
	public void setCommentaryPanel(CommentaryPanel commentaryPanel) {
		this.commentaryPanel = commentaryPanel;
	}

	/**
	 * @return the positionsPanel
	 */
	public PositionsPanel getPositionsPanel() {
		return positionsPanel;
	}

	/**
	 * @param positionsPanel
	 *            the positionsPanel to set
	 */
	public void setPositionsPanel(PositionsPanel positionsPanel) {
		this.positionsPanel = positionsPanel;
	}

	/**
	 * @return the match
	 */
	public MatchEvent getMatch() {
		return match;
	}

	/**
	 * @param match
	 *            the match to set
	 */
	public void setMatch(MatchEvent match) {
		this.match = match;
	}

	/**
	 * @return the timeOutsPanel
	 */
	public TimeOutsPanel getTimeOutsPanel() {
		return timeOutsPanel;
	}

	/**
	 * @param timeOutsPanel
	 *            the timeOutsPanel to set
	 */
	public void setTimeOutsPanel(TimeOutsPanel timeOutsPanel) {
		this.timeOutsPanel = timeOutsPanel;
	}

}
