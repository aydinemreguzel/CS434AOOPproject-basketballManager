package teams;

import java.util.ArrayList;

import java.util.Random;

public class TeamGenerator {
	private int numPlayers=12;
	public Team generate(){
		return generate(generateName());
	}
	public Team generate(String teamName){
		Team team= new Team(teamName);
		for(int i=0;i<numPlayers;i++){
			team.addPlayer(new Player());
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
//	public static void main(String args[]){
//		TeamGenerator tg=new TeamGenerator();
//		System.out.println(tg.generateName());
//	}
}
