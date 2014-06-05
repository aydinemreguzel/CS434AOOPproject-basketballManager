package events;
import gameengine.Time;

import java.util.Random;

import teams.Team;


public class RandomEventGenerator {
	
	Team yourTeam;
	
	public RandomEventGenerator(Team yourTeam) {
		this.yourTeam = yourTeam;
	}

	public Event getEvent(Time time) {
		Random random= new Random();
		int randomNum=random.nextInt(101);
		if(randomNum<2){
			return new injuryEvent(time,yourTeam);
		}else if(randomNum<4){
			return new bonusMoneyEvent(time,yourTeam);
		}
		else{
			return new NoEvent(time);
		}
	}

}
