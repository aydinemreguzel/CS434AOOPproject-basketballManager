package events;

import teams.Team;
import gameengine.Time;

public class bonusMoneyEvent implements Event {
	Time eventTime;
	Team yourTeam;
	String log;

	public bonusMoneyEvent(Time eventTime, Team yourTeam) {
		super();
		this.eventTime = eventTime;
		this.yourTeam = yourTeam;
	}

	@Override
	public void perform() {
		yourTeam.setBudget(yourTeam.getBudget()+1000000);
		log = "congrats you got a 1000000$ bonus from your sugar daddy";
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
