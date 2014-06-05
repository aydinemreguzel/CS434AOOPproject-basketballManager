package teams;

import gameengine.Time;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class TeamGenerator {
	private Scanner scanner;
	private int numPlayers = 12;

	public TeamGenerator() {
		super();
		try {
			scanner = new Scanner(new File("newRandPeople.txt"));
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
	}

	public Team generate() {
		return generate(generateName());
	}

	public Team generate(String teamName) {
		Team team = new Team(teamName);
		for (int i = 0; i < numPlayers; i++) {
			team.addPlayer(getNextPlayer());
		}
		return team;
	}

	private String generateName() {
		Random rand = new Random();
		String name = "";

		for (int i = 0; i < 3; i++) {
			name += (char) ('A' + rand.nextInt('Z' - 'A'));
		}
		return name;
	}

	private Player getNextPlayer() {
		String playerString = scanner.nextLine();// GivenName,Surname,Birthday,CountryFull,currentAbility,poteAbility,height,strength,agility,intelligence,naturalFitness,agression,condition
		String[] data = playerString.split(","); // 0 1 2 3 4 5 6 7 8 9 10 11 12
		return new Player(data);

	}
	// public static void main(String args[]){
	// TeamGenerator tg=new TeamGenerator();
	// System.out.println(tg.generateName());
	// }
}
