package matchengine;

import java.util.Random;

class ShotState extends State {
	private boolean BlockedShot = false;
	Random randomGenerator = new Random();

	public void startAction(MatchEngine matchEngine) {
		int actionTime = 1 + randomGenerator.nextInt(3);
		matchEngine.decreaseShotClock(actionTime);
		matchEngine.decreaseMatchClock(actionTime);

	}

	public void performAction(MatchEngine matchEngine) {
		// temporary solution,
		// Here will change
		int shotDecision = randomGenerator.nextInt(3);
		int defancePower = matchEngine.getBallDefenderPlayer().getIntelegence()
				+ matchEngine.getBallDefenderPlayer().getAgility()
				+ matchEngine.getBallDefenderPlayer().getStrength()
				+ randomGenerator.nextInt(25); // some magic constants here
		int offancePower = 0;
		if (shotDecision == 0) { // DUNK
			offancePower = 2 * matchEngine.getBallHandlerPlayer().getStrength()
					+ 2 * matchEngine.getPositioning()
					+ randomGenerator.nextInt(0); // these are change in
													// future
													// for game balance
		}
		if (shotDecision == 1) { // LAYUP
			offancePower = matchEngine.getBallHandlerPlayer().getStrength()
					+ matchEngine.getBallHandlerPlayer().getAgility() + 2
					* matchEngine.getPositioning() + randomGenerator.nextInt(0); // these
																					// are
																					// change
																					// in
																					// future
																					// for
																					// game
																					// balance
		}
		if (shotDecision == 2) { // Shot3P
			offancePower = matchEngine.getBallHandlerPlayer()
					.getCurrentAbilityPoint()
					+ matchEngine.getBallHandlerPlayer().getStrength()
					+ matchEngine.getPositioning()
					+ randomGenerator.nextInt(150); // these are change in
													// future
													// for game balance
		}
		if (shotDecision == 3) { // Shot2P
			offancePower = 2
					* matchEngine.getBallHandlerPlayer()
							.getCurrentAbilityPoint()
					+ matchEngine.getPositioning()
					+ matchEngine.getBallHandlerPlayer().getAgility()
					+ randomGenerator.nextInt(150); // these lines are change in
													// future
													// for game balance
		}
		if (defancePower > offancePower) {
			BlockedShot = true;
			matchEngine.changeAttackOrder();
			matchEngine.resetShotClock();
			matchEngine.setPositioning(0);
			System.out.println("incredible BLOCK");
		} else {
			BlockedShot = false;
			// TODO missing shots will be added, rebounds will be added
			matchEngine.changeAttackOrder();
			matchEngine.resetShotClock();
			matchEngine.setPositioning(0);
			System.out.println("BASKET");
		}
		if (shotDecision == 2)
			updateStats();// TODO
		else
			updateStats();// TODO
	}

	public void decideNextAction(MatchEngine matchEngine) {
		matchEngine.setState(new AdvancingBallState());
	}

	public String toString() {
		return "shoot ATTEMPT";
	}
}

