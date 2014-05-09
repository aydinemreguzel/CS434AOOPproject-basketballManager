package teams;
import java.util.Arrays;

public class ScoreBoard {
	// STATS
	private static final int MIN   = 0;
	private static final int PM2_A = 1;
	private static final int PM3_A = 2;
	private static final int FTM_A = 3;
	private static final int RB    = 4;
	private static final int PF    = 5;
	private static final int ST    = 6;
	private static final int TO    = 7;
	private static final int BS    = 8;
	private static final int BA    = 9;
	private static final int PTS   = 10;

	String[] names = new String[12];
	int[][] stats = new int[12][12];

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
