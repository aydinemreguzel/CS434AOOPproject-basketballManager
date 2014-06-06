package matchengine;

public class faulState extends State {
	boolean freeThrow = false;

	public void startAction(MatchEngine matchEngine) {

	}

	public void performAction(MatchEngine matchEngine) {
		if (++matchEngine.getNumOfFoulds()[(matchEngine.getAttackOrder() + 1) % 2][matchEngine.currentPeriod-1] > 4)
			freeThrow = true;
		else
			matchEngine.setPositioning(60);
	}

	public void decideNextAction(MatchEngine matchEngine) {
		if (freeThrow) {
			matchEngine.setState(new FreeThrow());
		} else {
			matchEngine.setState(new PassState());
		}
	}
}
