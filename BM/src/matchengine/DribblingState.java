package matchengine;

import java.util.Random;

import teams.Player;

class DribblingState extends State {
	private boolean success = false;
	Random randomGenerator = new Random();

	public void startAction(MatchEngine matchEngine) {
		int actionTime = 2 + randomGenerator.nextInt(4);
		matchEngine.decreaseShotClock(actionTime);
		matchEngine.decreaseMatchClock(actionTime);
	}

	public void performAction(MatchEngine matchEngine) {
		Player defPlayer = matchEngine.getBallDefenderPlayer();
		int defancePower = defPlayer.getCurrentAbilityPoint()
				+ defPlayer.getAgility() + defPlayer.getStrength()
				+ randomGenerator.nextInt(50); // some magic constants here
		Player offensPlayer = matchEngine.getBallHandlerPlayer();
		int offencePower = offensPlayer.getCurrentAbilityPoint() + 2
				* offensPlayer.getAgility() + randomGenerator.nextInt(100); // these
																			// are
																			// change
																			// in
																			// future
																			// for
																			// game
																			// balance
		if (defancePower > offencePower) {
			success = false;
			updateStats(matchEngine);
			matchEngine.changeAttackOrder();
			matchEngine.resetShotClock();
			matchEngine.setPositioning(0);  //TODO fast break
		} else {
			success = true;
			matchEngine.increasePositioning(5);
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
				System.out.println(matchEngine.getBallHandlerPlayer().getName() + " saw the empty corridor");
				matchEngine.setState(new Layup());
			}
			if (decision == 0) {
				System.out.println(matchEngine.getBallHandlerPlayer().getName() + " continue dribbling");
				matchEngine.setState(new DribblingState());
			}
			if (decision == 1) {
				System.out.println(matchEngine.getBallHandlerPlayer().getName() + " looking his friedns for passing");
				matchEngine.setState(new PassState());
			}
		}
	}

	private void updateStats(MatchEngine matchEngine) {
		matchEngine.getAtackSB().updateStats(
				matchEngine.getAtackTB().getPlayerNum(
						matchEngine.getBallHandler()), 10);
		matchEngine.getDefenceSB().updateStats(
				matchEngine.getDefenceTB().getPlayerNum(
						matchEngine.getBallDefender()), 9);
	}
}