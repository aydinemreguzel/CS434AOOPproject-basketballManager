package gameengine;

import teams.League;
import events.Event;

public class Game {
	Time currentTime;
	League league;

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
		Event event = league.getTodaysEvent(currentTime);
		event.perform();
	}

	public void generateLeague(String leagueName, int numTeams) {
		Time leagueTime = new Time(currentTime.getDay(),
				currentTime.getMonth(), currentTime.getYear());
		leagueTime.moveOnTime(3, 0, 0);
		league = new League(leagueName, numTeams, leagueTime);
	}

}
