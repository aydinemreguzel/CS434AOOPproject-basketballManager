package teams;

import java.util.List;

public class TacticBoard {
	Player[] onFloorPlayers;
	Player[] inMatchPlayers;
	int[] defenceOrder;

	public TacticBoard(List<Player> players) {
		super();
		inMatchPlayers = new Player[12];
		onFloorPlayers = new Player[5];
		defenceOrder = new int[5];
		for (int i = 0; i < onFloorPlayers.length; i++) {
			onFloorPlayers[i] = players.get(i);
		}
		for (int i = 0; i < inMatchPlayers.length; i++) {
			inMatchPlayers[i] = players.get(i);
		}
		for (int i = 0; i < 5; i++) {
			defenceOrder[i] = i;
		}
	}

	public Player[] getOnFloorPlayers() {
		return onFloorPlayers;
	}
	
	public Player[] getInMatchPlayers() {
		return inMatchPlayers;
	}

	public void setInGamePlayers(Player[] inGamePlayers) {
		this.onFloorPlayers = inGamePlayers;
	}
	
	public Player[] getInGamePlayers() {
		return onFloorPlayers;
	}

	public int getPlayerNum(int j) {
		for(int i = 0;i<12;i++)
			if(inMatchPlayers[j].equals(inMatchPlayers[i]))
				return i;
		return -1;
	}

	public int getDefender(int i) {
		return defenceOrder[i];
	}	

}
