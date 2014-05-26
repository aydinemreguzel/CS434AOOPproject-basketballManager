package events;
import matchengine.MatchEngine;
import gameengine.Time;
import teams.ScoreBoard;
import teams.TacticBoard;
import teams.Team;


public class MatchEvent implements Event {
	private Team homeTeam;
	private Team awayTeam;
	private boolean isPlayed=false;
	private ScoreBoard homeScoreBoard;
	private ScoreBoard awayScoreBoard;
	private Time matchTime;
	
	public MatchEvent(Team homeTeam, Team awayTeam, Time matchTime) {
		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;
		this.matchTime = matchTime;
		setHomeScoreBoard(new ScoreBoard(homeTeam.getTacticBoard()));
		setAwayScoreBoard(new ScoreBoard(awayTeam.getTacticBoard()));
	}
	@Override
	public void perform() {
		MatchEngine matchEngine=new MatchEngine(this);
		matchEngine.play();
	}
	public TacticBoard getHomeTacticBoard() {
		return homeTeam.getTacticBoard();
	}
	public TacticBoard getAwayTacticBoard() {
		return awayTeam.getTacticBoard();
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
	public ScoreBoard getHomeScoreBoard() {
		return homeScoreBoard;
	}
	public void setHomeScoreBoard(ScoreBoard homeScoreBoard) {
		this.homeScoreBoard = homeScoreBoard;
	}
	public ScoreBoard getAwayScoreBoard() {
		return awayScoreBoard;
	}
	public void setAwayScoreBoard(ScoreBoard awayScoreBoard) {
		this.awayScoreBoard = awayScoreBoard;
	}
	public boolean isPlayed() {
		return isPlayed;
	}
	public void setPlayed(boolean isPlayed) {
		this.isPlayed = isPlayed;
	}


}
