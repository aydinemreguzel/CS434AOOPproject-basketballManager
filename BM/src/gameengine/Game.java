package gameengine;

import javax.swing.JOptionPane;

import teams.League;
import teams.Team;
import events.Event;

public class Game {
	Time currentTime;
	League league;
	Team yourTeam;
	StringBuilder commentLogger=new StringBuilder();

	public Game(Time currentTime) {
		this.currentTime = currentTime;
		generateLeague("League1", 4);
		String userName = JOptionPane.showInputDialog(null, "What is your name?",
				"Enter your name", JOptionPane.QUESTION_MESSAGE);
		String[] choices = new String[league.getTeams().length];
		for (int i = 0; i < league.getTeams().length; i++) {
			choices[i] = league.getTeams()[i].getName();
		}
		String picked = (String) JOptionPane.showInputDialog(null,
				"Pick a Team:", "ComboBox Dialog", JOptionPane.QUESTION_MESSAGE,
				null, choices, choices[0]);

		for (int i = 0; i < league.getTeams().length; i++) {
			if(picked==league.getTeams()[i].getName()){
				yourTeam=league.getTeams()[i];
				yourTeam.setManager(new Manager(userName));
			}
		}		
	}

	public Game(Time currentTime, League league) {
		this.currentTime = currentTime;
		this.league = league;
	}

	public void advanceInTime() {
		currentTime.nextDay();
		Event event = league.getTodaysEvent(currentTime, getYourTeam());
		event.perform();
		addCommentLog(event.getLog());
	}

	public void generateLeague(String leagueName, int numTeams) {
		Time leagueTime = new Time(currentTime.getDay(), currentTime.getMonth(),
				currentTime.getYear());
		leagueTime.moveOnTime(3, 0, 0);
		league = new League(leagueName, numTeams, leagueTime);
	}

	public Team getYourTeam() {
		return yourTeam;
	}
	
	public League getLeague(){
		return league;
	}
	
	public Time getCurrentTime(){
		return currentTime;
	}

	public void setYourTeam(Team yourTeam) {
		this.yourTeam = yourTeam;
	}
	
	public void addCommentLog(String str) {
		commentLogger.append(str+"\n");
	}
	
	public StringBuilder getCommentLogger(){
		return commentLogger;
	}

}
