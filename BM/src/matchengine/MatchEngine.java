package matchengine;

import java.util.Random;

import teams.Player;
import teams.ScoreBoard;
import teams.TacticBoard;
import teams.Team;
import events.MatchEvent;

public class MatchEngine {
	private State state;
	final int periodDuration = 600; // 40 min = 2400 sec
	final int numOfPeriod = 4;
	int ballHandler;
	int ballDefender;
	int attackOrder = 0;
	int reamainPeriodTime = periodDuration;
	int currentPeriod = 1;
	int shotClock = 24; // sec
	int positioning;
	int[][] numOfFoulds = new int[2][4];
	Team homeTeam;
	Team awayTeam;
	ScoreBoard homeSB;
	ScoreBoard awaySB;
	TacticBoard homeTB;
	TacticBoard awayTB;
	String commentLog;
	Random randomGenerator = new Random();

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
		state.startAction(this);
//		System.out.println(String.valueOf(reamainPeriodTime() / 60) + ":"
//				+ String.valueOf(reamainPeriodTime() % 60));
		addCommentLog(String.valueOf(reamainPeriodTime() / 60) + ":"
				+ String.valueOf(reamainPeriodTime() % 60));
		if (reamainPeriodTime <= 0) {
			if (currentPeriod < 4) {
				currentPeriod++;
				reamainPeriodTime = 600;
				addCommentLog("refeeree finishes the period");
			} else
				addCommentLog("refeeree finishes the game");
		} else {
			shotClockCheck();
			state.performAction(this);
			detectFaul();
			state.decideNextAction(this);
			// System.out.println("remain time: " + reamainPeriodTime
			// +" period: "+ currentPeriod);
		}
	}

	public void detectFaul() {
		int homeAgg = 0, awayAgg = 0;
		for (int i = 0; i < 5; i++) {
			homeAgg += homeTB.getOnFloorPlayers()[i].getAgression();
			awayAgg += awayTB.getOnFloorPlayers()[i].getAgression();
		}
		if (attackOrder == 0) {
			if (randomGenerator.nextInt(2000) < awayAgg) {
				addCommentLog("FOUL");
				setState(new faulState());
				state.performAction(this);
			}
		} else {
			if (randomGenerator.nextInt(2000) < homeAgg) {
				addCommentLog("FOUL");
				setState(new faulState());
				state.performAction(this);
			}
		}
	}

	public void fiveFaulCheck() {
		// TODO
	}

	public void shotClockCheck() {
		if (shotClock < 0) {
			changeAttackOrder();
			resetShotClock();
			setPositioning(0);
			addCommentLog("BUZZER");
		}
	}

	public Player getBallHandlerPlayer() {
		if (attackOrder == 0)
			return homeTB.getOnFloorPlayers()[ballHandler];
		else
			return awayTB.getOnFloorPlayers()[ballHandler];
	}

	public Player getBallDefenderPlayer() {
		if (attackOrder == 1)
			return homeTB.getOnFloorPlayers()[ballHandler];
		else
			return awayTB.getOnFloorPlayers()[ballHandler];
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

	public int getBallDefender() {
		return getDefenceTB().getDefender(ballHandler);
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

	public int reamainPeriodTime() {
		return reamainPeriodTime;
	}

	public void decreaseReamainPeriodTime(int time) {
		this.reamainPeriodTime -= time;
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

	public TacticBoard getAtackTB() {
		if (getAttackOrder() == 0)
			return homeTB;
		else
			return awayTB;

	}

	public TacticBoard getDefenceTB() {
		if (getAttackOrder() == 1)
			return homeTB;
		else
			return awayTB;
	}

	public ScoreBoard getAtackSB() {
		if (getAttackOrder() == 0)
			return homeSB;
		else
			return awaySB;

	}

	public ScoreBoard getDefenceSB() {
		if (getAttackOrder() == 1)
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

	public int[][] getNumOfFoulds() {
		return numOfFoulds;
	}

	public void setNumOfFoulds(int[][] numOfFoulds) {
		this.numOfFoulds = numOfFoulds;
	}

	public int getReamainPeriodTime() {
		return reamainPeriodTime;
	}

	public void addCommentLog(String str) {
		commentLog += str + "\n";
	}
	
	public void resetCommentLog() {
		commentLog = "";
	}
	
	public String getCommentLog(){
		return commentLog;
	}
}