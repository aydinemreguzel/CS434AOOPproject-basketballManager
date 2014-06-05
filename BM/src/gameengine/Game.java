package gameengine;

import teams.League;
import teams.Team;
import events.Event;

public class Game {
	Time currentTime;
	League league;
	Team yourTeam;

	public Game(Time currentTime) {
		this.currentTime = currentTime;
		generateLeague("League1", 4);
	}

	public Game(Time currentTime, League league) {
		this.currentTime = currentTime;
		this.league = league;
	}

	public void advanceInTime() {
		currentTime.nextDay();
		Event event = league.getTodaysEvent(currentTime,getYourTeam());
		event.perform();
	}

	public void generateLeague(String leagueName, int numTeams) {
		Time leagueTime = new Time(currentTime.getDay(),
				currentTime.getMonth(), currentTime.getYear());
		leagueTime.moveOnTime(3, 0, 0);
		league = new League(leagueName, numTeams, leagueTime);
	}

	public Team getYourTeam() {
		return yourTeam;
	}

	public void setYourTeam(Team yourTeam) {
		this.yourTeam = yourTeam;
	}

}
