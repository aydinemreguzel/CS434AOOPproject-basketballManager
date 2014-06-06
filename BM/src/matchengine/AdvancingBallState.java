package matchengine;

import java.util.Random;

import teams.Player;

class AdvancingBallState extends State {
	private boolean success = false;
	Random randomGenerator = new Random();
	int timeRangeMin = 2;
	int timeRangeMax = 8;
	int defChanceFac = 100;
	int attChanceFac = 500;
	int positioningValue = 40;

	public void startAction(MatchEngine matchEngine) {
		int actionTime = timeRangeMin
				+ randomGenerator.nextInt(timeRangeMax - timeRangeMin + 1);
		updateTime(matchEngine, actionTime);
		matchEngine.setBallHandler(0);
		if (matchEngine.getAttackOrder() == 0) {
			if (randomGenerator.nextBoolean())
				matchEngine
						.addCommentLog("home team carrying the ball to front court \n");
			else
				matchEngine
						.addCommentLog("home team placeing the other court \n");
		} else {
			if (randomGenerator.nextBoolean())
				matchEngine
						.addCommentLog("away team carrying the ball to front court \n");
			else
				matchEngine
						.addCommentLog("away team placeing the other court \n");
		}
	}

	public void performAction(MatchEngine matchEngine) {
		Player defPlayer = matchEngine.getBallDefenderPlayer();
		Player offensPlayer = matchEngine.getBallHandlerPlayer();
		int defancePower = defPlayer.getCurrentAbilityPoint()
				+ defPlayer.getAgility() + defPlayer.getStrength()
				+ randomGenerator.nextInt(defChanceFac);
		int offancePower = offensPlayer.getCurrentAbilityPoint() + 2
				* offensPlayer.getAgility()
				+ randomGenerator.nextInt(attChanceFac);
		if (defancePower > offancePower) {
			success = false;
			matchEngine.addCommentLog(defPlayer.getName()
					+ " is defencesing soo tough " + offensPlayer.getName()
					+ "\n");
			matchEngine.addCommentLog("TURNOVER \n");
			matchEngine.addCommentLog(defPlayer.getName()
					+ "has got the ball \n");
			updateStats(matchEngine);
			matchEngine.changeAttackOrder();
			matchEngine.resetShotClock();
			matchEngine.setPositioning(0);
		} else {
			if (matchEngine.getAttackOrder() == 0) {
				matchEngine.addCommentLog(matchEngine.getHomeTeam().getName()
						+ " getting position \n");
			} else {
				matchEngine.addCommentLog(matchEngine.getAwayTeam().getName()
						+ "away team located back court \n");
			}
			success = true;
			matchEngine.setPositioning(positioningValue);
		}
	}

	public void decideNextAction(MatchEngine matchEngine) {
		if (success == false) {
			if (randomGenerator.nextInt(100) < 50)
				matchEngine.setState(new FastBreakState());
			else
				matchEngine.setState(new AdvancingBallState());
		} else {
			int decision = randomGenerator.nextInt(5);
			if (decision == 0) {
				matchEngine.addCommentLog(matchEngine.getBallHandlerPlayer()
						.getName() + " continue to dribbling \n");
				matchEngine.setState(new DribblingState());
			}
			if (decision >= 1) {
				matchEngine
						.addCommentLog(matchEngine.getBallHandlerPlayer()
								.getName()
								+ " is searching avaible player for passing \n");
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