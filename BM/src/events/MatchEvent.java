package events;
import matchengine.MatchEngine;
import gameengine.Time;
import teams.ScoreBoard;
import teams.Team;


public class MatchEvent implements Event {
	private Team homeTeam;
	private Team awayTeam;
	private boolean isPlayed=false;
	private ScoreBoard scoreBoard;
	private Time matchTime;
	
	public MatchEvent(Team homeTeam, Team awayTeam, Time matchTime) {
		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;
		this.matchTime = matchTime;
		scoreBoard = new ScoreBoard();
	}
	@Override
	public void perform() {
		MatchEngine matchEngine=new MatchEngine(this);
		matchEngine.play();
	}
	@Override
	public Time getEventTime() {	
		return matchTime;
	}
	public Team getHomeTeam() {
		return homeTeam;
	}
	public void setHomeTeam(Team homeTeam) {
		this.homeTeam = homeTeam;
	}
	public Team getAwayTeam() {
		return awayTeam;
	}
	public void setAwayTeam(Team awayTeam) {
		this.awayTeam = awayTeam;
	}
	public ScoreBoard getScoreBoard() {
		return scoreBoard;
	}
	public void setScoreBoard(ScoreBoard scoreBoard) {
		this.scoreBoard = scoreBoard;
	}

}
