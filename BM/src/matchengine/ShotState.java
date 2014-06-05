package matchengine;

import java.util.Random;

import teams.Player;

abstract class ShotState extends State {
	protected boolean success = false;
	protected boolean block = false;
	private boolean rebound = false;
	Random randomGenerator = new Random();

	abstract int calcDefencePower(Player defPlayer);

	abstract int calcOffancePower(Player offensPlayer, MatchEngine matchEngine);

	public void startAction(MatchEngine matchEngine) {
		int actionTime = 1 + randomGenerator.nextInt(3);
		matchEngine.decreaseShotClock(actionTime);
		matchEngine.decreaseReamainPeriodTime(actionTime);
		matchEngine.getAtackSB().updateMin(actionTime);
		matchEngine.getDefenceSB().updateMin(actionTime);
	}

	public void performAction(MatchEngine matchEngine) {
		Player defPlayer = matchEngine.getBallDefenderPlayer();
		int defancePower = calcDefencePower(defPlayer);
		Player offensPlayer = matchEngine.getBallHandlerPlayer();
		int offancePower = calcOffancePower(offensPlayer, matchEngine);
		if (defancePower > offancePower) {
			success = false;
			matchEngine.resetShotClock();
			block = randomGenerator.nextBoolean(); 
			if (block) {
				updateStats(matchEngine);
				matchEngine.changeAttackOrder();
				matchEngine.setPositioning(0);
				System.out.println("incredible BLOCK");
			} else {
				updateStats(matchEngine);
				matchEngine.changeAttackOrder();
				matchEngine.setPositioning(0);
				System.out.println("missed shot");
				rebound = true;
			}
		} else {
			success = true;
			updateStats(matchEngine);
			matchEngine.changeAttackOrder();
			matchEngine.resetShotClock();
			matchEngine.setPositioning(0);
			System.out.println("BASKET");
		}
	}

	public void decideNextAction(MatchEngine matchEngine) {
		if (rebound == true && success == false)
			matchEngine.setState(new ReboundState());
		else
			matchEngine.setState(new AdvancingBallState());
	}

	void updateStats(MatchEngine matchEngine) {
		matchEngine.getAtackSB().updateStats(
				matchEngine.getAtackTB().getPlayerNum(
						matchEngine.getBallHandler()), 1);
		if (success){
			matchEngine.getAtackSB().updateStats(
					matchEngine.getAtackTB().getPlayerNum(
							matchEngine.getBallHandler()), 2);
			matchEngine.getDefenceSB().concadeBasket(2);
		}
		if(block){
			matchEngine.getDefenceSB().updateStats(
					matchEngine.getDefenceTB().getPlayerNum(
							matchEngine.getBallDefender()), 11);
			matchEngine.getAtackSB().updateStats(
					matchEngine.getAtackTB().getPlayerNum(
							matchEngine.getBallDefender()), 12);
		}
	}
}
