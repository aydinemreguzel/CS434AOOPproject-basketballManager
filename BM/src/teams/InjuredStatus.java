package teams;

import gameengine.Time;

public class InjuredStatus implements Status{
	int injuryDayLeft;
	InjuredStatus(int n){
		injuryDayLeft = n;
	}
	@Override
	public void perform(Player player) {
		injuryDayLeft--;
		if(injuryDayLeft == 0){
			player.setStatus(new healtyStatus());
		}
		
	}

}
