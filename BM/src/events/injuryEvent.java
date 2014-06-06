package events;

import java.util.Random;

import teams.Team;
import gameengine.Time;

public class injuryEvent implements Event {
	Time eventTime;
	Team yourTeam;
	String log;

	public injuryEvent(Time eventTime, Team yourTeam) {
		super();
		this.eventTime = eventTime;
		this.yourTeam = yourTeam;
	}

	@Override
	public void perform() {
		Random random = new Random();
		int randomPlayer = random.nextInt(yourTeam.getPlayers().size());
		int randomDay = random.nextInt(10);
		yourTeam.getPlayers().get(randomPlayer).setInjury(randomDay);
		log = yourTeam.getPlayers().get(randomPlayer).getName()
				+ " got injured";
		System.out.println(yourTeam.getPlayers().get(randomPlayer).getName()
				+ " got injured");
	}

	@Override
	public Time getEventTime() {
		return eventTime;
	}

	@Override
	public String getLog() {
		return log;
	}

}
