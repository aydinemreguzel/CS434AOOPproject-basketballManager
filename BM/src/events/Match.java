package events;
import gameengine.MatchEngine;
import gameengine.Time;
import teams.ScoreBoard;
import teams.Team;


public class Match implements Event {
	private Team homeTeam;
	private Team awayTeam;
	private boolean isPlayed=false;
	private ScoreBoard scoreBoard;
	private Time matchTime;
	
	public Match(Team homeTeam, Team awayTeam, Time matchTime) {
		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;
		this.matchTime = matchTime;
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

}
