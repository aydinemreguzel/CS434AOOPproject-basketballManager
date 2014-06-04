package matchengine;

import java.util.Random;

import teams.Player;

abstract class ShotState extends State {
	private boolean BlockedShot = false;
	Random randomGenerator = new Random();

	abstract int calcDefencePower(Player defPlayer);

	abstract int calcOffancePower(Player offensPlayer, MatchEngine matchEngine);
	
	abstract void updateStats();

	public void startAction(MatchEngine matchEngine) {
		int actionTime = 1 + randomGenerator.nextInt(3);
		matchEngine.decreaseShotClock(actionTime);
		matchEngine.decreaseMatchClock(actionTime);
	}

	public void performAction(MatchEngine matchEngine) {
		Player defPlayer = matchEngine.getBallDefenderPlayer();
		int defancePower = calcDefencePower(defPlayer);
		Player offensPlayer = matchEngine.getBallHandlerPlayer();
		int offancePower = calcOffancePower(offensPlayer, matchEngine);
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
		updateStats();
	}

	public void decideNextAction(MatchEngine matchEngine) {
		matchEngine.setState(new AdvancingBallState());
	}

	public String toString() {
		return "shoot ATTEMPT";
	}
}

class Layup extends ShotState {
	int calcDefencePower(Player defPlayer) {
		return defPlayer.getIntelegence() + defPlayer.getAgility()
				+ defPlayer.getStrength() + randomGenerator.nextInt(25);
	}

	int calcOffancePower(Player offensPlayer, MatchEngine matchEngine) {
		return offensPlayer.getStrength() + offensPlayer.getAgility() + 2
				* matchEngine.getPositioning() + randomGenerator.nextInt(10);
	}

	void updateStats() {

	}
}

class SlamDunk extends ShotState {
	int calcDefencePower(Player defPlayer) {
		return defPlayer.getIntelegence() + defPlayer.getAgility()
				+ defPlayer.getStrength() + randomGenerator.nextInt(25);
	}

	int calcOffancePower(Player offensPlayer, MatchEngine matchEngine) {
		return 2 * offensPlayer.getStrength() + 2
				* matchEngine.getPositioning() + randomGenerator.nextInt(10);
	}

	void updateStats() {

	}
}

class TwoPointShot extends ShotState {
	public int calcDefencePower(Player defPlayer) {
		return defPlayer.getIntelegence() + defPlayer.getAgility()
				+ defPlayer.getStrength() + randomGenerator.nextInt(25);
	}

	int calcOffancePower(Player offensPlayer, MatchEngine matchEngine) {
		return 2 * offensPlayer.getCurrentAbilityPoint()
				+ matchEngine.getPositioning() + offensPlayer.getAgility()
				+ randomGenerator.nextInt(150);
	}

	void updateStats() {

	}
}

class ThreePointShot extends ShotState {
	public int calcDefencePower(Player defPlayer) {
		return defPlayer.getIntelegence() + defPlayer.getAgility()
				+ defPlayer.getStrength() + randomGenerator.nextInt(25);
	}

	int calcOffancePower(Player offensPlayer, MatchEngine matchEngine) {
		return offensPlayer.getCurrentAbilityPoint()
				+ offensPlayer.getStrength() + matchEngine.getPositioning()
				+ randomGenerator.nextInt(150);
	}

	void updateStats() {

	}
}