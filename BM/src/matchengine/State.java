package matchengine;


interface State {
	public void decideNextAction(MatchEngine matchEngine);

	public void startAction(MatchEngine matchEngine);

	public void performAction(MatchEngine matchEngine);
}