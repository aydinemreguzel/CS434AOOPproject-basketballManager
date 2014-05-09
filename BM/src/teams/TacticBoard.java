package teams;


public class TacticBoard {
	Player[] inGamePlayers=new Player[5];

	public TacticBoard(Player[] inGamePlayers) {
		super();
		this.inGamePlayers = inGamePlayers;
	}

	
	public Player[] getInGamePlayers() {
		return inGamePlayers;
	}


	public void setInGamePlayers(Player[] inGamePlayers) {
		this.inGamePlayers = inGamePlayers;
	}
	
	
}
