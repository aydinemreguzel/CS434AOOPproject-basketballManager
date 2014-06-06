package teams;

import java.util.Arrays;

public class ScoreBoard {
	// STATS
	private static final int SEC = 0; // time in game
	private static final int PM2_A = 1; // 2point attempt
	private static final int PM2_M = 2; // 2point made
	private static final int PM3_A = 3; // 3point attempt
	private static final int PM3_M = 4; // 3point made
	private static final int FTM_A = 5; // free throw attempt
	private static final int FTM_M = 6; // free throw made
	private static final int RB = 7; // rebounds
	private static final int PF = 8; // fouls
	private static final int ST = 9; // steals
	private static final int TO = 10; // turnover
	private static final int BS = 11; // blocked shot
	private static final int BA = 12; // block against
	private static final int PTS = 13; // points
	private static final int DIFF = 14; // difference

	private static final int matchPlayerNum = 12;
	private static final int numOfAtt = 15;
	private static final int onFloorPlayerNum = 5;

	String[] names = new String[matchPlayerNum];
	int[][] stats = new int[matchPlayerNum][numOfAtt];
	String[] statNames = {"name","SEC","PM2_A","PM2_M ","PM3_A","PM3_M","FTM_A","FTM_M","RB","PF","ST","TO","BS","BA","PTS","DIFF"};
	int score = 0;
	TacticBoard tacticBoard;

	public ScoreBoard(TacticBoard tacticBoard) {
		this.tacticBoard = tacticBoard;
		for (int ii = 0; ii < matchPlayerNum; ii++) {
			names[ii] = tacticBoard.getInMatchPlayers()[ii].getName();
			for (int jj = 0; jj < numOfAtt; jj++) {
				stats[ii][jj] = 0;
			}
		}
	}

	public void updateStats(int player, int att) {
		stats[player][att]++;
		for (int i = 0; i < onFloorPlayerNum; i++) {
			if (att == PM2_M) {
				stats[tacticBoard.getPlayerNum(i)][DIFF] += 2;
			}
			if (att == PM3_M) {
				stats[tacticBoard.getPlayerNum(i)][DIFF] += 3;
			}
			if (att == FTM_M) {
				stats[tacticBoard.getPlayerNum(i)][DIFF]++;
			}
		}
		updateScoreBoard();
	}

	public void concadeBasket(int j) {
		for (int i = 0; i < onFloorPlayerNum; i++) {
			if (j == PM2_M) {
				stats[tacticBoard.getPlayerNum(i)][DIFF] -= 2;
			}
			if (j == PM3_M) {
				stats[tacticBoard.getPlayerNum(i)][DIFF] -= 3;
			}
			if (j == FTM_M) {
				stats[tacticBoard.getPlayerNum(i)][DIFF]--;
			}
		}
	}

	public void updateScoreBoard() {
		score = 0;
		for (int i = 0; i < matchPlayerNum; i++) {
			stats[i][PTS] = 2 * stats[i][PM2_M] + 3 * stats[i][PM3_M]
					+ stats[i][FTM_M];
			score += stats[i][PTS];
		}
	}

	public void updateMin(int actionTime) {
		for (int i = 0; i < onFloorPlayerNum; i++) {
			stats[tacticBoard.getPlayerNum(i)][SEC] = actionTime;
		}
	}

	@Override
	public String toString() {// TODO
		return "scoreBoard [names=" + Arrays.toString(names) + ", stats="
				+ Arrays.toString(stats) + "]";
	}

	/**
	 * @return the names
	 */
	public String[] getNames() {
		return names;
	}

	/**
	 * @param names
	 *            the names to set
	 */
	public void setNames(String[] names) {
		this.names = names;
	}

	public int[][] getStats() {
		return stats;
	}

	public String[][] getStatsAsString() {
		String[][] statsString = new String[matchPlayerNum][numOfAtt+1];
		for (int i = 0; i < statsString.length; i++) {
			for (int j = 1; j < statsString[0].length; j++) {
				statsString[i][j]=String.valueOf(stats[i][j-1]);
			}
		}
		for (int i = 0; i < statsString.length; i++) {
			statsString[i][0]=getNames()[i];
		}
		return statsString;
	}

	public void setStats(int[][] stats) {
		this.stats = stats;
	}

	/**
	 * @return the statNames
	 */
	public String[] getStatNames() {
		return statNames;
	}

	/**
	 * @param statNames the statNames to set
	 */
	public void setStatNames(String[] statNames) {
		this.statNames = statNames;
	}

	/**
	 * @return the score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * @param score the score to set
	 */
	public void setScore(int score) {
		this.score = score;
	}
	
}
