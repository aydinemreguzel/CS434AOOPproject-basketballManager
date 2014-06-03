package teams;
import java.util.Arrays;

public class ScoreBoard {
	// STATS
	private static final int MIN   = 0;   //minute in game
	private static final int PM2_A = 1;   //2point attempt
	private static final int PM2_M = 2;   //2point made
	private static final int PM3_A = 3;   //3point attempt
	private static final int PM3_M = 4;	  //3point made
	private static final int FTM_A = 5;   //free throw attempt
	private static final int FTM_M = 6;   //free throw made
	private static final int RB    = 7;   //rebounds
	private static final int PF    = 8;   //fouls
	private static final int ST    = 9;   //steals
	private static final int TO    = 10;  //turnover
	private static final int BS    = 11;  //blocked shot
	private static final int BA    = 12;  //block against
	private static final int PTS   = 13;  //points
	private static final int DIFF  = 14;  // difference
	
	private static final int matchPlayerNum  = 12;  // difference
	private static final int numOfAtt  = 15;  // difference
	
	String[] names = new String[matchPlayerNum];
	int[][] stats = new int[matchPlayerNum][numOfAtt];
	
	public ScoreBoard(TacticBoard tacticBoard){
		for(int ii = 0;ii<matchPlayerNum;ii++){
			names[ii] = tacticBoard.getInMatchPlayers()[ii].getName();
			for(int jj = 0;jj<numOfAtt;jj++){
				stats[ii][jj] = 0;
			}
		}
	}
	
	public void updateStats(int player, int att){
		stats[player][att]++;
	}

	@Override
	public String toString() {//TODO
		return "scoreBoard [names=" + Arrays.toString(names) + ", stats="
				+ Arrays.toString(stats) + "]";
	}

//	public static void main(String args[]) {
//		scoreBoard sb=new scoreBoard();
//		System.out.println(sb.toString());
//	}
}
