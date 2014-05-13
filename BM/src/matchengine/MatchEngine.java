package matchengine;

import java.util.Random;

import teams.Player;
import events.MatchEvent;

// due to incomplete tactics board class lots of magic number in match engine and state classes
public class MatchEngine {
	private State state;
	int ballHandler;
	int attackOrder;
	int matchClock = 2400; // 40 min = 2400 sec
	int shotClock = 24; // sec
	int[] moral = { 10, 10 };
	int positioning;
	int[] score = { 0, 0 };
	Player[] InGameHome = new Player[5];
	Player[] InGameAway = new Player[5];

	public MatchEngine(MatchEvent match) {
		state = new AdvancingBallState();
		InGameHome = match.getHomeTeam().getTacticBoard().getInGamePlayers();
		InGameAway = match.getAwayTeam().getTacticBoard().getInGamePlayers();
	}

	public void play() {
		while (true) {
			state.startAction(this);
			if (matchClock < 0) {
				break;
			}
			state.performAction(this);
			System.out.println(state);
			state.decideNextAction(this);
		}
	}

	public void faulCheck() {
		// TODO
	}

	public void shotClockCheck() {
		// TODO
	}

	public Player getBallHandlerPlayer() {
		if (attackOrder == 0)
			return InGameHome[ballHandler];
		else
			return InGameAway[ballHandler];
	}

	public Player getBallDefenderPlayer() {
		if (attackOrder == 1)
			return InGameHome[ballHandler];
		else
			return InGameAway[ballHandler];
	}

	public void setState(State state) {
		this.state = state;
	}

	public State getState() {
		return state;
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

	public void increaseScore(int score) {
		this.score[getAttackOrder()] += score;
	}

	public void increasePositioning(int i) {
		positioning += i;

	}

	public void changeAttackOrder() {
		if (attackOrder == 0)
			attackOrder = 1;
		else
			attackOrder = 0;
	}
}