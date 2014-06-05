package matchengine;

import teams.Player;
import teams.ScoreBoard;
import teams.TacticBoard;
import teams.Team;
import events.MatchEvent;

// due to incomplete tactics board class lots of magic number in match engine and state classes
public class MatchEngine {
	private State state;
	int ballHandler;
	int attackOrder = 0;
	int matchClock = 2400; // 40 min = 2400 sec
	int shotClock = 24; // sec
	int positioning;
	Team homeTeam;
	Team awayTeam;
	ScoreBoard homeSB;
	ScoreBoard awaySB;
	TacticBoard homeTB;
	TacticBoard awayTB;

	public MatchEngine(MatchEvent match) {
		state = new JumpBallState();
		homeTB = match.getHomeTacticBoard();
		awayTB = match.getAwayTacticBoard();
		homeSB = match.getHomeScoreBoard();
		awaySB = match.getAwayScoreBoard();
		homeTeam = match.getHomeTeam();
		awayTeam = match.getAwayTeam();
	}

	public void play() {
		while (true) {
			state.startAction(this);
			if (matchClock < 0) {
				System.out.println("refeeree finishes the game");
				break;
			} else if (shotClock < 0){
				changeAttackOrder();
				resetShotClock();
				setPositioning(0);
				System.out.println("BUZZER");
			}
			state.performAction(this);
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
			return homeTB.getInGamePlayers()[ballHandler];
		else
			return awayTB.getInGamePlayers()[ballHandler];
	}

	public Player getBallDefenderPlayer() {
		if (attackOrder == 1)
			return homeTB.getInGamePlayers()[ballHandler];
		else
			return awayTB.getInGamePlayers()[ballHandler];
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

	public int getPositioning() {
		return positioning;
	}

	public void setPositioning(int positioning) {
		this.positioning = positioning;
	}

	public ScoreBoard getAtackSB(){
		if(getAttackOrder() == 0)
			return homeSB;
		else
			return awaySB;
		
	}
	
	public ScoreBoard getDefenceSB(){
		if(getAttackOrder() == 1)
			return homeSB;
		else
			return awaySB;
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

	public void setBallDefender(int i) {
		// TODO Auto-generated method stub
		
	}
}