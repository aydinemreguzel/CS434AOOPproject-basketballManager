package teams;

import java.util.List;


public class TacticBoard {
	Player[] inGamePlayers=new Player[5];

	public TacticBoard(List<Player> players) {
		super();
		for(int i=0;i<inGamePlayers.length;i++){
			inGamePlayers[i]= players.get(i);
		}
	}

	
	public Player[] getInGamePlayers() {
		return inGamePlayers;
	}


	public void setInGamePlayers(Player[] inGamePlayers) {
		this.inGamePlayers = inGamePlayers;
	}
	
	
}
