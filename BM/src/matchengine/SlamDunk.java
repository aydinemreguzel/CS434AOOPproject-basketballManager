package matchengine;

import teams.Player;

class SlamDunk extends ShotState {
	int calcDefencePower(Player defPlayer) {
		return defPlayer.getIntelegence() + defPlayer.getAgility()
				+ defPlayer.getStrength() + randomGenerator.nextInt(25);
	}

	int calcOffancePower(Player offensPlayer, MatchEngine matchEngine) {
		return 2 * offensPlayer.getStrength() + 2
				* matchEngine.getPositioning() + randomGenerator.nextInt(10);
	}
}
