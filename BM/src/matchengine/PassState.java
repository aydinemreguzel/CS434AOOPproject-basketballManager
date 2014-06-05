package matchengine;

import java.util.Random;

class PassState extends State {
	private boolean success = false;
	Random randomGenerator = new Random();

	public void startAction(MatchEngine matchEngine) {
		int actionTime = 1 + randomGenerator.nextInt(3);
		matchEngine.decreaseShotClock(actionTime);
		matchEngine.decreaseMatchClock(actionTime);
	}

	public void performAction(MatchEngine matchEngine) {
		int defancePower = matchEngine.getBallDefenderPlayer().getIntelegence()
				+ matchEngine.getBallDefenderPlayer().getAgility()
				+ matchEngine.getBallDefenderPlayer().getStrength()
				+ randomGenerator.nextInt(25); // some magic constants here
		int offancePower = matchEngine.getBallHandlerPlayer()
				.getCurrentAbilityPoint()
				+ matchEngine.getBallHandlerPlayer().getIntelegence()
				+ matchEngine.getBallHandlerPlayer().getAgility()
				+ randomGenerator.nextInt(100); // these are change in future
												// for game balance
		if (defancePower > offancePower) { // TODO hava atýþý eklenecek
			success = false;
			matchEngine.changeAttackOrder();
			matchEngine.resetShotClock();
			matchEngine.setPositioning(0); // //TODO fast break
		} else {
			success = true;
			matchEngine.increasePositioning(5); // TODO
			int incPos = randomGenerator.nextInt(15 + matchEngine
					.getBallHandlerPlayer().getIntelegence() / 3);
			matchEngine.increasePositioning(incPos);
			int nextPlayer = 1 + randomGenerator.nextInt(3);
			nextPlayer = (matchEngine.getBallHandler() + nextPlayer) % 5;
			System.out.print(matchEngine.getBallHandlerPlayer().getName()
					+ " passed to ");
			matchEngine.setBallDefender(nextPlayer);
			System.out.println(matchEngine.getBallHandlerPlayer().getName());
		}
	}

	public void decideNextAction(MatchEngine matchEngine) {
		if (success == false) {
			System.out.println("misplaced pass");
			matchEngine.setState(new AdvancingBallState());
		} else {
			int decision = randomGenerator.nextInt(3); 
			if (decision == 2 || matchEngine.getShotClock() < 3) {
				decision = randomGenerator.nextInt(2);
				if (matchEngine.getPositioning() > 90) {
					if (decision == 0) {
						System.out.println(matchEngine.getBallHandlerPlayer()
								.getName() + " got good pass under hoop");
						matchEngine.setState(new SlamDunk());
					} else {
						System.out.println(matchEngine.getBallHandlerPlayer()
								.getName()
								+ " saw the empty man behind 3 point line");
						matchEngine.setState(new ThreePointShot());
					}
				} else {
					if (decision == 0) {
						System.out.println("very hard shot over hand");
						matchEngine.setState(new TwoPointShot());
					} else {
						System.out.println("very hard 3p shot over hand");
						matchEngine.setState(new ThreePointShot());
					}
				}
			} else if (decision == 0) {
				matchEngine.setState(new DribblingState());
			} else if (decision == 1) {
				matchEngine.setState(new PassState());
			}
		}
	}

	public String toString(MatchEngine matchEngine) {
		return "long pass to " + matchEngine.getBallHandlerPlayer();
	}
}
