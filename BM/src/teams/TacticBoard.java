package teams;

import java.util.Collections;
import java.util.List;

public class TacticBoard {

	int[] defenceOrder;
	List<Player> players;

	public TacticBoard(List<Player> players) {
		super();
		this.players = players;

		defenceOrder = new int[5];
		for (int i = 0; i < 5; i++) {
			defenceOrder[i] = i;
		}
	}

	public Player[] getOnFloorPlayers() {

		Player[] onFloorPlayers = new Player[5];

		for (int i = 0; i < onFloorPlayers.length; i++) {
			onFloorPlayers[i] = players.get(i);
		}
		return onFloorPlayers;
	}

	public Player[] getInMatchPlayers() {
		Player[] inMatchPlayers = new Player[12];
		;
		for (int i = 0; i < inMatchPlayers.length; i++) {
			inMatchPlayers[i] = players.get(i);
		}
		return inMatchPlayers;
	}

	public void swapPlayers(int i, int j) {
		Collections.swap(players, i, j);
	}

	public int getPlayerNum(int j) {
		for (int i = 0; i < 12; i++)
			if (getOnFloorPlayers()[j].equals(getInMatchPlayers()[i]))
				return i;
		return -1;
	}

	public int getDefender(int i) {
		return defenceOrder[i];
	}

}
