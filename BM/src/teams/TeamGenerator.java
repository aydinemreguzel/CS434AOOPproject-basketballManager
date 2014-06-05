package teams;

import gameengine.Time;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class TeamGenerator {
	private Scanner scanner;
	private int numPlayers=12;
	
	public TeamGenerator() {
		super();
		try {
			scanner=new Scanner(new File("Random people.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Team generate(){
		return generate(generateName());
	}
	public Team generate(String teamName){
		Team team= new Team(teamName);
		for(int i=0;i<numPlayers;i++){
			team.addPlayer(getNextPlayer());
		}
		return team;
	}
	private String generateName(){
		Random rand= new Random();
		String name="";
		
		for(int i=0;i<3;i++){
			name+=(char)('A'+rand.nextInt('Z'-'A'));
		}
		return name;
	}
	private Player getNextPlayer(){
		String playerString = scanner.nextLine();// GivenName,Surname,Birthday,CountryFull,Kilograms,Centimeters,BloodType
		String[] data = playerString.split(","); //    0         1        2          3        4          5           6    
		return new Player(data[0]+data[1],new Time(data[2]),data[3],data[5],)
		
	}
//	public static void main(String args[]){
//		TeamGenerator tg=new TeamGenerator();
//		System.out.println(tg.generateName());
//	}
}
