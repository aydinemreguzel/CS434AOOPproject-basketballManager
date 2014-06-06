package teams;

import gameengine.Time;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class TeamGenerator {
	private Scanner nameScanner;
	private int numPlayers = 12;
	private Scanner teamNameScanner;

	public TeamGenerator() {
		super();
		try {
			nameScanner = new Scanner(new File("newRandPeople.txt"));
			teamNameScanner=new Scanner(new File("teamData.txt"));
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
	}

	public Team generate() {
		return generate(readNameFromFile());
	}

	public Team generate(String teamName) {
		Team team = new Team(teamName);
		for (int i = 0; i < numPlayers; i++) {
			team.addPlayer(getNextPlayer());
		}
		return team;
	}

	private String readNameFromFile() {

		String teamName = teamNameScanner.nextLine();	
		return teamName;

	}

	private Player getNextPlayer() {
		String playerString = nameScanner.nextLine();// GivenName,Surname,Birthday,CountryFull,currentAbility,poteAbility,height,strength,agility,intelligence,naturalFitness,agression,condition
		String[] data = playerString.split(","); // 0 1 2 3 4 5 6 7 8 9 10 11 12
		return new Player(data);

	}
	// public static void main(String args[]){
	// TeamGenerator tg=new TeamGenerator();
	// System.out.println(tg.generateName());
	// }
}
