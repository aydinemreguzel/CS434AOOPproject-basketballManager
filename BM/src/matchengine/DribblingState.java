package matchengine;

import java.util.Random;

class DribblingState implements State {
	private boolean success = false;
	Random randomGenerator = new Random();

	public void startAction(MatchEngine matchEngine) {
		int actionTime = 2 + randomGenerator.nextInt(4);
		matchEngine.decreaseShotClock(actionTime);
		matchEngine.decreaseMatchClock(actionTime);
	}

	public void performAction(MatchEngine matchEngine) {
		int defancePower = matchEngine.getBallDefenderPlayer()
				.getCurrentAbilityPoint()
				+ matchEngine.getBallDefenderPlayer().getAgility()
				+ matchEngine.getBallDefenderPlayer().getStrength()
				+ randomGenerator.nextInt(50); // some magic constants here
		int offancePower = matchEngine.getBallHandlerPlayer()
				.getCurrentAbilityPoint()
				+ 2
				* matchEngine.getBallHandlerPlayer().getAgility()
				+ randomGenerator.nextInt(100); // these are change in future
												// for game balance
		if (defancePower > offancePower) { // TODO hava atýþý eklenecek
			success = false;
			matchEngine.changeAttackOrder();
			// ballHandler
			// still
			// same
			matchEngine.resetShotClock();
			matchEngine.setPositioning(0); // //TODO fast break
		} else {
			success = true;
			matchEngine.increasePositioning(5); // TODO
			matchEngine.increasePositioning(randomGenerator
					.nextInt(15 + matchEngine.getBallHandlerPlayer()
							.getIntelegence() / 4));
		}
	}

	public void decideNextAction(MatchEngine matchEngine) {
		if (success == false) {
			matchEngine.setState(new AdvancingBallState());
		} else {
			int decision = randomGenerator.nextInt(3); // some variables comes
														// here
			// from tactics board in
			// future
			if (decision == 2 || matchEngine.getShotClock() < 3
					|| matchEngine.getPositioning() > 90) {
				matchEngine.setState(new ShotState());
			}
			if (decision == 0) {
				matchEngine.setState(new DribblingState());
			}
			if (decision == 1) {
				matchEngine.setState(new PassState());
			}
		}
	}

	public String toString(MatchEngine matchEngine) {
		return "The " + matchEngine.getBallHandlerPlayer()
				+ "is driving to ball";
	}
}