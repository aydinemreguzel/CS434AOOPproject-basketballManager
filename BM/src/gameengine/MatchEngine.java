package gameengine;
import java.util.Random;

import events.Match;


public class MatchEngine {
	private State state;
	int ballHandler;
	int attackOrder;
	int matchClock = 2400; // 40 min = 240 sec
	int shotClock = 24;    // sec
	int[] moral = {10,10};
	int positioning;
	int[] score = {0,0};

	public MatchEngine(Match match) {
		state = new BeginingState();
		match.getHomeTeam().getTacticBoard().getInGamePlayers();
	}

	public void play() {
		while(true){
			state.performState(this);
			if(matchClock>0){
				break;
			}
			System.out.println(state);
			state.next(this);
		}
	}

	public void setState(State state) {
		this.state = state;
	}

	public State getState() {
		return state;
	}
	
	public void touch() {
		state.next(this);
	}
	
	public void complete() {
		state.complete(this);
	}

	public int getBallHandler() {
		return ballHandler;
	}

	public void setBallHandler(int ballHandler) {
		this.ballHandler = ballHandler;
	}

	public int getAttackOrder() {
		return attackOrder;
	}

	public void setAttackOrder(int attackOrder) {
		this.attackOrder = attackOrder;
	}

	public int getMatchClock() {
		return matchClock;
	}

	public void decreaseMatchClock(int time) {
		this.matchClock -= time;
	}

	public int getShotClock() {
		return shotClock;
	}

	public void decreaseShotClock(int time) {
		this.shotClock -= time;
	}
	
	public void resetShotClock() {
		this.shotClock = 24;
	}

	public int[] getMoral() {
		return moral;
	}

	public void setMoral(int[] moral) {
		this.moral = moral;
	}

	public int getPositioning() {
		return positioning;
	}

	public void setPositioning(int positioning) {
		this.positioning = positioning;
	}

	public int[] getScore() {
		return score;
	}

	public void increaseScore(int team,int score) {
		this.score[team] += score;
	}
}

interface State {
	public void next(MatchEngine matchEngine);
	public void performState(MatchEngine matchEngine);
	public void complete(MatchEngine matchEngine);
}

class BeginingState implements State {
	
	private State nextState;
	public void performState(MatchEngine matchEngine){
		Random randomGenerator = new Random();
		matchEngine.setBallHandler(1);
		//matchEngine.setAttackOrder((matchEngine.setPositioning(0);+1)%2);
		matchEngine.resetShotClock();
		matchEngine.setPositioning(0);
		matchEngine.decreaseMatchClock(randomGenerator.nextInt(3));
		
	}

	public void next(MatchEngine matchEngine) {		
		matchEngine.setState(nextState);
	}
	
	public void complete(MatchEngine matchEngine){
	}

	public String toString(MatchEngine matchEngine) {
		String team;
		if(matchEngine.getAttackOrder()==1){
			team = "home";
		}else{
			team = "away";
		}
		return "The no:1 is starting to " + team + " team offance";
	}
}

class DribblingState implements State {
	
	private State nextState;
	public void performState(MatchEngine matchEngine){
		Random randomGenerator = new Random();
		int positioning = matchEngine.getPositioning()+randomGenerator.nextInt(10);
		matchEngine.setPositioning(positioning);
		
		int actionTime = randomGenerator.nextInt(5);
		matchEngine.decreaseShotClock(actionTime);
		matchEngine.decreaseMatchClock(actionTime);
	}

	public void next(MatchEngine matchEngine) {
		matchEngine.setState(nextState);
	}

	public String toString() {
		return "Open";
	}

	public void complete(MatchEngine matchEngine) {
	}
}

class PassState implements State {
	private State nextState;
	public void performState(MatchEngine matchEngine){
		Random randomGenerator = new Random();
		
		matchEngine.setBallHandler(1+randomGenerator.nextInt(4));
		
		int positioning = matchEngine.getPositioning()+3+randomGenerator.nextInt(5);
		matchEngine.setPositioning(positioning);
		
		int actionTime = randomGenerator.nextInt(2);
		matchEngine.decreaseShotClock(actionTime);
		matchEngine.decreaseMatchClock(actionTime);
	}

	public void next(MatchEngine matchEngine) {
		matchEngine.setState(nextState);
	}

	public String toString() {
		return "Closed";
	}

	public void complete(MatchEngine matchEngine) {
	}
}

class ShotState implements State {
	private State nextState;
	public void performState(MatchEngine matchEngine){
		matchEngine.increaseScore(matchEngine.getAttackOrder(),2);
	}

	public void next(MatchEngine matchEngine) {
		matchEngine.setState(nextState);
	}
	
	public void complete(MatchEngine matchEngine){
	}

	public String toString() {
		return "Closing";
	}
}

class TurnoverState implements State {
	private State nextState;
	public void performState(MatchEngine matchEngine){
		
	}

	public void next(MatchEngine matchEngine) {
		matchEngine.setState(nextState);
	}

	public String toString() {
		return "StayOpen";
	}

	public void complete(MatchEngine matchEngine) {
	}
}

class FaulState implements State {
	private State nextState;
	public void performState(MatchEngine matchEngine){
		
	}

	public void next(MatchEngine matchEngine) {
		matchEngine.setState(new BeginingState());
	}

	public String toString() {
		return "StayOpen";
	}

	public void complete(MatchEngine matchEngine) {
	}
}
