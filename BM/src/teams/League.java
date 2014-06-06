package teams;

import java.awt.Color;

import events.Event;
import events.RandomEventGenerator;
import gameengine.Time;

public class League {

	String name;
	Color colors[];
	Team[] teams;
	Fixture fixture;

	public League(String name, int numTeams,Time time) {
		this.name = name;
		teams = new Team[numTeams];
		TeamGenerator teamGen=new TeamGenerator();
		for (int i = 0; i < numTeams; i++) {
			teams[i] = teamGen.generate();
		}
		fixture = new Fixture(teams, time);
	}

	public League(String name, Color[] colors, Team[] teams,
			Fixture fixture) {
		super();
		this.name = name;
		this.colors = colors;
		this.teams = teams;
		this.fixture = fixture;
	}

	public Team[] getNextMatchTeams() {
		return null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Color[] getColors() {
		return colors;
	}

	public void setColors(Color[] colors) {
		this.colors = colors;
	}

	public Team[] getTeams() {
		return teams;
	}

	public void setTeams(Team[] teams) {
		this.teams = teams;
	}

	public Fixture getFixture() {
		return fixture;
	}

	public void setFixture(Fixture fixture) {
		this.fixture = fixture;
	}

	public Event getTodaysEvent(Time time, Team yourTeam) {
		Time nextMatchTime = fixture.getNextMatchDateAfter(time);
		System.out.println("current: "+time);
		System.out.println("match: "+nextMatchTime);
		if (nextMatchTime.equals(time)) {
			return fixture.getMatchAt(nextMatchTime);
		} else {
			RandomEventGenerator reg = new RandomEventGenerator(yourTeam);
			return reg.getEvent(time);
		}
	}
}
