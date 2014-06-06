package matchengine;

import java.util.Random;

class FastBreakState extends State {
	private boolean success = false;
	Random randomGenerator = new Random();

	public void startAction(MatchEngine matchEngine) {
		int actionTime = 1 + randomGenerator.nextInt(4);
		matchEngine.decreaseShotClock(actionTime);
		matchEngine.decreaseReamainPeriodTime(actionTime);
		matchEngine.getAtackSB().updateMin(actionTime);
		matchEngine.getDefenceSB().updateMin(actionTime);
	}

	public void performAction(MatchEngine matchEngine) {
		int defancePower = matchEngine.getBallDefenderPlayer().getAgility()
				+ randomGenerator.nextInt(25); // some magic constants here
		int offancePower = matchEngine.getBallHandlerPlayer().getAgility()
				+ randomGenerator.nextInt(100); // these are change in future
												// for game balance
		if (defancePower > offancePower) {
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
			matchEngine.addCommentLog(matchEngine.getBallHandlerPlayer().getName()
					+ " cannot make use this fastbreak oppurtunity");
			matchEngine.setState(new AdvancingBallState());
		} else {
			matchEngine.addCommentLog(matchEngine.getBallHandlerPlayer().getName()
					+ " is ending fastbreak with good layup");
			matchEngine.setState(new Layup());
		}
	}
}