package gui;

import java.awt.GridBagLayout;
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
	public MatchPanel(MatchPanelController controller) {
		super();
		this.matchPanelController=controller;
		this.match = controller.getMatch();
		this.homeScoreBoardPanel = controller.getHomeScoreBoardPanel();
		this.awayScoreBoardPanel = controller.getAwayScoreBoardPanel();
		this.commentaryPanel = controller.getCommentaryPanel();
		this.positionsPanel = controller.getPositionsPanel();
		this.timeOutsPanel = controller.getTimeOutsPanel();
		
		this.timeOutButton=new JButton(new AbstractAction("timeout") {
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
		this.setSize(500, 500);//TODO ayarla
		this.setLayout(new GridBagLayout());
	}
	public ScoreBoard getHomeScoreBoard() {
		
		return match.getHomeScoreBoard();
	}
	public ScoreBoard getAwayScoreBoard() {
		
		return match.getAwayScoreBoard();
	}
	/**
	 * @return the match
	 */
	public MatchEvent getMatch() {
		return match;
	}
	/**
	 * @param match the match to set
	 */
	public void setMatch(MatchEvent match) {
		this.match = match;
	}
	/**
	 * @return the homeScoreBoardPanel
	 */
	public ScoreBoardPanel getHomeScoreBoardPanel() {
		return homeScoreBoardPanel;
	}
	/**
	 * @param homeScoreBoardPanel the homeScoreBoardPanel to set
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
	 * @param awayScoreBoardPanel the awayScoreBoardPanel to set
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
	 * @param commentaryPanel the commentaryPanel to set
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
	 * @param positionsPanel the positionsPanel to set
	 */
	public void setPositionsPanel(PositionsPanel positionsPanel) {
		this.positionsPanel = positionsPanel;
	}
	/**
	 * @return the timeOutsPanel
	 */
	public TimeOutsPanel getTimeOutsPanel() {
		return timeOutsPanel;
	}
	/**
	 * @param timeOutsPanel the timeOutsPanel to set
	 */
	public void setTimeOutsPanel(TimeOutsPanel timeOutsPanel) {
		this.timeOutsPanel = timeOutsPanel;
	}
	/**
	 * @return the timeOutButton
	 */
	public JButton getTimeOutButton() {
		return timeOutButton;
	}
	/**
	 * @param timeOutButton the timeOutButton to set
	 */
	public void setTimeOutButton(JButton timeOutButton) {
		this.timeOutButton = timeOutButton;
	}
	/**
	 * @return the matchPanelController
	 */
	public MatchPanelController getMatchPanelController() {
		return matchPanelController;
	}
	/**
	 * @param matchPanelController the matchPanelController to set
	 */
	public void setMatchPanelController(MatchPanelController matchPanelController) {
		this.matchPanelController = matchPanelController;
	}
	

}
