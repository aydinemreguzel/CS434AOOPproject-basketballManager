package matchengine;

import teams.Player;

class Layup extends ShotState {
	int calcDefencePower(Player defPlayer) {
		return defPlayer.getIntelegence() + defPlayer.getAgility()
				+ defPlayer.getStrength() + randomGenerator.nextInt(25);
	}

	int calcOffancePower(Player offensPlayer, MatchEngine matchEngine) {
		return offensPlayer.getStrength() + offensPlayer.getAgility() + 2
				* matchEngine.getPositioning() + randomGenerator.nextInt(10);
	}
}