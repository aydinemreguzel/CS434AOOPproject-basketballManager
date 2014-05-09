package teams;
import gameengine.Manager;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class Team {
	String name;
	short financePoint;
	short fanSupportPoint;
	short fanAgressionPoint;
	Color colors[];
	String stadiumName;
	int stadiumCapacity;
	List<Player> players = new ArrayList<Player>();
	TacticBoard tacticBoard;
	
	Manager manager;

	Team(String name, short financePoint, short fanSupportPoint,
			short fanAgressionPoint, Color colors[], String stadiumName,
			int stadiumCapacity, List<Player> players, TacticBoard tacticBoard) {
		this.name = name;
		this.financePoint = financePoint;
		this.fanSupportPoint = fanSupportPoint;
		this.fanAgressionPoint = fanAgressionPoint;
		this.colors = colors;
		this.stadiumName = stadiumName;
		this.stadiumCapacity = stadiumCapacity;
		this.players = players;
		this.tacticBoard = tacticBoard;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public short getFinancePoint() {
		return financePoint;
	}

	public void setFinancePoint(short financePoint) {
		this.financePoint = financePoint;
	}

	public short getFanSupportPoint() {
		return fanSupportPoint;
	}

	public void setFanSupportPoint(short fanSupportPoint) {
		this.fanSupportPoint = fanSupportPoint;
	}

	public short getFanAgressionPoint() {
		return fanAgressionPoint;
	}

	public void setFanAgressionPoint(short fanAgressionPoint) {
		this.fanAgressionPoint = fanAgressionPoint;
	}

	public Color[] getColors() {
		return colors;
	}

	public void setColors(Color[] colors) {
		this.colors = colors;
	}

	public String getStadiumName() {
		return stadiumName;
	}

	public void setStadiumName(String stadiumName) {
		this.stadiumName = stadiumName;
	}

	public int getStadiumCapacity() {
		return stadiumCapacity;
	}

	public void setStadiumCapacity(int stadiumCapacity) {
		this.stadiumCapacity = stadiumCapacity;
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

}
