package gameengine;

import java.util.Random;

class AdvancingBallState implements State {
	private boolean success = false;
	Random randomGenerator = new Random();

	public void startAction(MatchEngine matchEngine) {
		matchEngine.setBallHandler(0);
		int actionTime = 1 + randomGenerator.nextInt(4);
		matchEngine.decreaseShotClock(actionTime);
		matchEngine.decreaseMatchClock(actionTime);
	}

	public void performAction(MatchEngine matchEngine) {
		int defancePower = matchEngine.getBallDefenderPlayer()
				.getCurrentAbilityPoint()
				+ matchEngine.getBallDefenderPlayer().getAgility()
				+ matchEngine.getBallDefenderPlayer().getStrength()
				+ randomGenerator.nextInt(50); // some magic constants here
		int poffancePower = matchEngine.getBallHandlerPlayer()
				.getCurrentAbilityPoint()
				+ 2
				* matchEngine.getBallHandlerPlayer().getAgility()
				+ randomGenerator.nextInt(100); // these are change in future
												// for game balance
		if (defancePower > poffancePower) { // TODO hava atýþý eklenecek
			success = false;
			matchEngine.changeAttackOrder(); // new
												// ballHandler
												// still
												// same
			matchEngine.resetShotClock();
			matchEngine.setPositioning(0); // //TODO fast break
		} else {
			success = true;
			matchEngine.setPositioning(30 + randomGenerator.nextInt(10)); // TODO
																			// point
																			// guard
																			// intelegence
																			// will
																			// affect
																			// here
		}
	}

	public void decideNextAction(MatchEngine matchEngine) {
		if (success == false) {
			if (randomGenerator.nextInt(100) < 50) // TODO magic number should
													// come from tactics board
				matchEngine.setState(new FastBreakState());
			else
				matchEngine.setState(new AdvancingBallState());
		} else {
			int decision = randomGenerator.nextInt(2); // some variables comes
														// here
			// from tacticboard in
			// future
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
				+ " is advancing the ball.";
	}
}