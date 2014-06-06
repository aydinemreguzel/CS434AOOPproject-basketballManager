package matchengine;

import teams.Player;

class ThreePointShot extends ShotState {
	public int calcDefencePower(Player defPlayer) {
		return defPlayer.getIntelegence() + defPlayer.getAgility()
				+ defPlayer.getStrength() + 30 + randomGenerator.nextInt(100);
	}

	int calcOffancePower(Player offensPlayer, MatchEngine matchEngine) {
		return offensPlayer.getCurrentAbilityPoint()
				+ offensPlayer.getStrength() + matchEngine.getPositioning()
				+ randomGenerator.nextInt(150);
	}

	void updateStats(MatchEngine matchEngine) {
		matchEngine.getAtackSB().updateStats(
				matchEngine.getAtackTB().getPlayerNum(
						matchEngine.getBallHandler()), 3);
		if (success){
			matchEngine.getAtackSB().updateStats(
					matchEngine.getAtackTB().getPlayerNum(
							matchEngine.getBallHandler()), 4);
			matchEngine.getDefenceSB().concadeBasket(4);
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