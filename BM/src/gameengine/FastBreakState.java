package gameengine;

import java.util.Random;

class FastBreakState implements State {
	private boolean success = false;
	Random randomGenerator = new Random();

	public void startAction(MatchEngine matchEngine) {
		int actionTime = 1 + randomGenerator.nextInt(4);
		matchEngine.decreaseShotClock(actionTime);
		matchEngine.decreaseMatchClock(actionTime);
	}

	public void performAction(MatchEngine matchEngine) {
		int defancePower = matchEngine.getBallDefenderPlayer().getAgility()
				+ randomGenerator.nextInt(25); // some magic constants here
		int offancePower = matchEngine.getBallHandlerPlayer().getAgility()
				+ randomGenerator.nextInt(100); // these are change in future
												// for game balance
		if (defancePower > offancePower) { // TODO eþitlik durumu için hava
											// atýþý eklenecek
			success = false;
			matchEngine.changeAttackOrder();
			matchEngine.resetShotClock();
			matchEngine.setPositioning(0); //
		} else {
			success = true;
			matchEngine.setPositioning(70 + randomGenerator.nextInt(30));
		}
	}

	public void decideNextAction(MatchEngine matchEngine) {
		if (success == false) {
			matchEngine.setState(new AdvancingBallState());
		} else {
			matchEngine.setState(new ShotState());
		}
	}

	public String toString(MatchEngine matchEngine) {
		return "Fast Break";
	}
}