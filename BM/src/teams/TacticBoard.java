package teams;

import java.util.List;

public class TacticBoard {
	Player[] onFloorPlayers;
	Player[] inMatchPlayers;

	public TacticBoard(List<Player> players) {
		super();
		inMatchPlayers = new Player[12];
		onFloorPlayers = new Player[5];
		for (int i = 0; i < onFloorPlayers.length; i++) {
			onFloorPlayers[i] = players.get(i);
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

}
