package matchengine;

import teams.Player;

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
}