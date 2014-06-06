package matchengine;

import java.util.Random;

public class ReboundState extends State {
	Random randomGenerator = new Random();
	private boolean success = false;

	public void startAction(MatchEngine matchEngine) {
		int actionTime = 1 + randomGenerator.nextInt(3);
		matchEngine.decreaseShotClock(actionTime);
		matchEngine.decreaseReamainPeriodTime(actionTime);
		matchEngine.getAtackSB().updateMin(actionTime);
		matchEngine.getDefenceSB().updateMin(actionTime);
		matchEngine.addCommentLog("rebound fight!!!");

	}

	public void performAction(MatchEngine matchEngine) {
		int offencePts = (int) (0.2
				* matchEngine.homeTB.getOnFloorPlayers()[0].getHeight() + 0.2
				* matchEngine.homeTB.getOnFloorPlayers()[1].getHeight() + 0.4
				* matchEngine.homeTB.getOnFloorPlayers()[2].getHeight() + 0.55
				* matchEngine.homeTB.getOnFloorPlayers()[3].getHeight() + 0.65 * matchEngine.homeTB
				.getOnFloorPlayers()[4].getHeight())
				+ matchEngine.homeTB.getOnFloorPlayers()[4].getStrength()
				+ randomGenerator.nextInt(100);
		int deffencePts = (int) (0.2
				* matchEngine.awayTB.getOnFloorPlayers()[0].getHeight() + 0.2
				* matchEngine.awayTB.getOnFloorPlayers()[1].getHeight() + 0.4
				* matchEngine.awayTB.getOnFloorPlayers()[2].getHeight() + 0.55
				* matchEngine.awayTB.getOnFloorPlayers()[3].getHeight() + 0.65 * matchEngine.awayTB
				.getOnFloorPlayers()[4].getHeight())
				+ matchEngine.awayTB.getOnFloorPlayers()[4].getIntelegence()
				+ matchEngine.awayTB.getOnFloorPlayers()[4].getStrength();
		int nextPlayer = randomGenerator.nextInt(10);
		if (nextPlayer > 5) {
			matchEngine.setBallHandler(4);
		} else if (nextPlayer > 2) {
			matchEngine.setBallHandler(3);
		} else {
			matchEngine.setBallHandler(nextPlayer);
		}
		if (offencePts > deffencePts) {
			updateStats(matchEngine,nextPlayer);
			matchEngine.addCommentLog("offence rebound the ball");
			matchEngine.setPositioning(50 + randomGenerator.nextInt(30));
		} else {
			success = false;
			updateStats(matchEngine,nextPlayer);
			matchEngine.changeAttackOrder();
			matchEngine.setPositioning(0);
			matchEngine.addCommentLog("deffence rebound the ball");
		}
	}

	public void decideNextAction(MatchEngine matchEngine) {
		if (success) {
			if (matchEngine.getPositioning() > 75) {
				matchEngine.setState(new SlamDunk());
			} else {
				int next = randomGenerator.nextInt(2);
				if (next == 0) {
					matchEngine.setState(new DribblingState());
				} else {
					matchEngine.setState(new PassState());
				}
			}
		} else {
			matchEngine.setState(new AdvancingBallState());
		}
	}

	private void updateStats(MatchEngine matchEngine,int nextPlayer) {
		if (success) {
			matchEngine.getAtackSB().updateStats(
					matchEngine.getBallHandler(), 7);
		} else {
			matchEngine.getDefenceSB().updateStats(
					matchEngine.getBallHandler(), 7);
		}
	}

}
