package matchengine;


public abstract class State {
	public abstract void decideNextAction(MatchEngine matchEngine);

	public abstract void startAction(MatchEngine matchEngine);

	public abstract void performAction(MatchEngine matchEngine);
	
	public void updateScoreboard(){
		
	}
}