package matchengine;

import java.util.Random;

import teams.Player;

class FreeThrow  extends State {
	Random randomGenerator = new Random();
	boolean success = false;
	public void startAction(MatchEngine matchEngine) {
	}

	public void performAction(MatchEngine matchEngine) {
		Player offensPlayer = matchEngine.getBallHandlerPlayer();
		int offancePower = offensPlayer.getCurrentAbilityPoint();
		if (offancePower < randomGenerator.nextInt(100)) {
				updateStats(matchEngine);
				matchEngine.addCommentLog("missed shot");
		} else {
			updateStats(matchEngine);
			matchEngine.addCommentLog("1 point made");	
		}	
		if (offancePower < randomGenerator.nextInt(100)) {
			updateStats(matchEngine);
			matchEngine.addCommentLog("missed shot and rebound brawl");
		} else {					
			success = true;
			updateStats(matchEngine);
			matchEngine.changeAttackOrder();
			matchEngine.resetShotClock();
			matchEngine.setPositioning(0);
			matchEngine.addCommentLog("1 point BASKET");
		}
	}

	public void decideNextAction(MatchEngine matchEngine) {
		if (success)
			matchEngine.setState(new ReboundState());
		else
			matchEngine.setState(new AdvancingBallState());
	}

	void updateStats(MatchEngine matchEngine) {
		matchEngine.getAtackSB().updateStats(
				matchEngine.getAtackTB().getPlayerNum(
						matchEngine.getBallHandler()), 5);
		if (success){
			matchEngine.getAtackSB().updateStats(
					matchEngine.getAtackTB().getPlayerNum(
							matchEngine.getBallHandler()), 6);
			matchEngine.getDefenceSB().concadeBasket(6);
		}
	}
}
