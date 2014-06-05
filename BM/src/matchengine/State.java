package matchengine;


public abstract class State {
	
	public abstract void startAction(MatchEngine matchEngine);//TODO getAction time

	public abstract void performAction(MatchEngine matchEngine);
	
	public abstract void decideNextAction(MatchEngine matchEngine);
	
	public void updateScoreboard(){
		
	}
}