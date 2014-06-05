package matchengine;

import java.util.Random;

public class JumpBallState extends State{
	Random randomGenerator = new Random();

	public void startAction(MatchEngine matchEngine) {
		matchEngine.setBallHandler(4);
		matchEngine.setBallDefender(4);
		int actionTime = 2;
		matchEngine.decreaseMatchClock(actionTime);
	}

	public void performAction(MatchEngine matchEngine) {
		System.out.println("Match is starting with Jump Ball, good luck for both team");
		int awayPower = matchEngine.getBallDefenderPlayer().getHeight()
				+ randomGenerator.nextInt(20); // some magic constants here
		int homePower = matchEngine.getBallHandlerPlayer().getHeight()
				+ randomGenerator.nextInt(20); // these are change in future
		if (awayPower > homePower) {
			matchEngine.changeAttackOrder();
		}
	}

	public void decideNextAction(MatchEngine matchEngine) {
		matchEngine.setState(new AdvancingBallState());
	}

	public String toString(MatchEngine matchEngine) {
		return "The " + matchEngine.getBallHandlerPlayer()
				+ " is advancing the ball.";
	}
}
