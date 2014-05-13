package teams;
import gameengine.Manager;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class Team {
	String name;
	int budget;
	int salary;
	Color[] color = new Color[2];
	List<Player> players;
	TacticBoard tacticBoard;
	
	Manager manager;
	Team(String name){
		 this(name,new ArrayList<Player>(),2000000,200000);
	}
	Team(String name, List<Player> players,int budget, int salary) {
		this.name = name;
		this.budget=budget;
		this.salary = salary;
		this.players = players;
		this.tacticBoard = new TacticBoard(players);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int financePoint) {
		this.salary = financePoint;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public TacticBoard getTacticBoard() {
		return tacticBoard;
	}

	public void setTacticBoard(TacticBoard tacticBoard) {
		this.tacticBoard = tacticBoard;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}
	public void addPlayer(Player player){
		players.add(player);
	}

}
