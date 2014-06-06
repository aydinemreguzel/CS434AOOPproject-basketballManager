package matchengine;

import java.util.Random;

class AdvancingBallState extends State {
	private boolean success = false;
	Random randomGenerator = new Random();

	public void startAction(MatchEngine matchEngine) {
		matchEngine.setBallHandler(0);
		int actionTime = 1 + randomGenerator.nextInt(4);
		matchEngine.decreaseShotClock(actionTime);
		matchEngine.decreaseReamainPeriodTime(actionTime);
		matchEngine.getAtackSB().updateMin(actionTime);
		matchEngine.getDefenceSB().updateMin(actionTime);
		if (matchEngine.getAttackOrder() == 0) {
			matchEngine.addCommentLog("home team carrying the ball to front court");
		} else {
			matchEngine.addCommentLog("away team carrying the ball to front court");
		}
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
				+ 70 + randomGenerator.nextInt(50); // these are change in future
												// for game balance
		if (defancePower > offancePower) {
			success = false;
			matchEngine.addCommentLog("turnover");
			updateStats(matchEngine);
			matchEngine.changeAttackOrder();
			matchEngine.resetShotClock();
			matchEngine.setPositioning(0); // //TODO fast break
		} else {
			if (matchEngine.getAttackOrder() == 0) {
				matchEngine.addCommentLog("home team getting position");
			} else {
				matchEngine.addCommentLog("away team located back court");
			}
			success = true;
			matchEngine.setPositioning(30 + randomGenerator.nextInt(10));
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
			int decision = randomGenerator.nextInt(5);
			if (decision == 0) {
				matchEngine.addCommentLog(matchEngine.getBallHandlerPlayer().getName()
						+ " continue to dribbling");
				matchEngine.setState(new DribblingState());
			}
			if (decision >= 1) {
				matchEngine.addCommentLog(matchEngine.getBallHandlerPlayer().getName()
						+ " is searching avaible player for passing");
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