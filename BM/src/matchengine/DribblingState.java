package matchengine;

import java.util.Random;

import teams.Player;

class DribblingState extends State {
	private boolean success = false;
	Random randomGenerator = new Random();
	int timeRangeMin = 2;
	int timeRangeMax = 7;
	int defChanceFac = 100;
	int attChanceFac = 400;
	int positioningValue = 40;

	public void startAction(MatchEngine matchEngine) {
		int actionTime = timeRangeMin
				+ randomGenerator.nextInt(timeRangeMax - timeRangeMin + 1);
		matchEngine.decreaseShotClock(actionTime);
		matchEngine.decreaseReamainPeriodTime(actionTime);
		matchEngine.getAtackSB().updateMin(actionTime);
		matchEngine.getDefenceSB().updateMin(actionTime);
	}

	public void performAction(MatchEngine matchEngine) {
		Player defPlayer = matchEngine.getBallDefenderPlayer();
		int defancePower = defPlayer.getCurrentAbilityPoint()
				+ defPlayer.getAgility() + defPlayer.getStrength()
				+ randomGenerator.nextInt(defChanceFac);
		Player offensPlayer = matchEngine.getBallHandlerPlayer();
		int offencePower = offensPlayer.getCurrentAbilityPoint() + 2
				* offensPlayer.getAgility() + randomGenerator.nextInt(attChanceFac);
		if (defancePower > offencePower) {
			success = false;
			updateStats(matchEngine);
			matchEngine.changeAttackOrder();
			matchEngine.resetShotClock();
			matchEngine.setPositioning(0);
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
			int decision = randomGenerator.nextInt(3);
			if (decision == 2 || matchEngine.getShotClock() < 3
					|| matchEngine.getPositioning() > 90) {
				matchEngine.addCommentLog(matchEngine.getBallHandlerPlayer()
						.getName() + " saw the empty corridor");
				matchEngine.setState(new Layup());
			}
			if (decision == 0) {
				matchEngine.addCommentLog(matchEngine.getBallHandlerPlayer()
						.getName() + " continue dribbling");
				matchEngine.setState(new DribblingState());
			}
			if (decision == 1) {
				matchEngine.addCommentLog(matchEngine.getBallHandlerPlayer()
						.getName() + " looking his friedns for passing");
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