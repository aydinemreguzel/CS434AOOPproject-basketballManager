import java.util.Random;


public class RandomEventGenerator {
	
	public Event getEvent(Time time) {
		Random random= new Random();
		int randomNum=random.nextInt(101);
		if(randomNum<2){
			return new injuryEvent(time);
		}else if(randomNum<4){
			return new bonusMoneyEvent(time);
		}
		else{
			return new NoEvent(time);
		}
	}

}
