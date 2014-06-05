package teams;

import gameengine.Time;

import java.util.Random;

public class Player {
	String name;
	Time birthDate;
	String nationality;
	int currentAbilityPoint;
	int potentialAbilityPoint;
	int height;
	int strength;
	int agility;
	int intelegence;
	int naturalFitness;
	int agression;
	int condition;

	public Player(String name, Time birthDate, String nationality,
			int currentAbilityPoint, int potentialAbilityPoint, int height,
			int strength, int agility, int intelegence, int naturalFitness,
			int agression, int condition) {
		super();
		this.name = name;
		this.birthDate = birthDate;
		this.nationality = nationality;
		this.currentAbilityPoint = currentAbilityPoint;
		this.potentialAbilityPoint = potentialAbilityPoint;
		this.height = height;
		this.strength = strength;
		this.agility = agility;
		this.intelegence = intelegence;
		this.naturalFitness = naturalFitness;
		this.agression = agression;
		this.condition = condition;
	}

public Player(String[] data){
	this(data[0] + data[1], new Time(data[2]), data[3],
			Integer.parseInt(data[4]), Integer.parseInt(data[5]),
			Integer.parseInt(data[6]), Integer.parseInt(data[7]),
			Integer.parseInt(data[8]), Integer.parseInt(data[9]),
			Integer.parseInt(data[10]), Integer.parseInt(data[11]),
			Integer.parseInt(data[12]));
}
	public static Player generateRandomPlayer(){
		return new Player(generateRandomName(), new Time(generateRandomInt(1, 30),
				generateRandomInt(1, 12), generateRandomInt(1975, 1995)),
				"Ilimonio", generateRandomInt(0, 100), generateRandomInt(0, 100),
				generateRandomInt(150, 230), generateRandomInt(0, 100),
				generateRandomInt(0, 100), generateRandomInt(0, 100),
				generateRandomInt(0, 100), generateRandomInt(0, 100),
				generateRandomInt(0, 100));
	}
	public static String generateRandomName() {
		Random rand = new Random();
		String name = "";
		for (int i = 0; i < 5; i++) {
			name += (char) ('A' + rand.nextInt('Z' - 'A'));
		}
		name += " ";
		for (int i = 0; i < 5; i++) {
			name += (char) ('A' + rand.nextInt('Z' - 'A'));
		}
		return name;
	}

	public static int generateRandomInt(int min, int max) {
		Random rand = new Random();
		return min + rand.nextInt(max - min);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge(Time currentTime) {
		return currentTime.subtraction(birthDate) / 365;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public int getCurrentAbilityPoint() {
		return currentAbilityPoint;
	}

	public void setCurrentAbilityPoint(int currentAbilityPoint) {
		this.currentAbilityPoint = currentAbilityPoint;
	}

	public int getPotentialAbilityPoint() {
		return potentialAbilityPoint;
	}

	public void setPotentialAbilityPoint(int potentialAbilityPoint) {
		this.potentialAbilityPoint = potentialAbilityPoint;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public int getAgility() {
		return agility;
	}

	public void setAgility(int agility) {
		this.agility = agility;
	}

	public int getIntelegence() {
		return intelegence;
	}

	public void setIntelegence(int intelegence) {
		this.intelegence = intelegence;
	}

	public int getNaturalFitness() {
		return naturalFitness;
	}

	public void setNaturalFitness(int naturalFitness) {
		this.naturalFitness = naturalFitness;
	}

	public int getAgression() {
		return agression;
	}

	public void setAgression(int agression) {
		this.agression = agression;
	}

	public int getCondition() {
		return condition;
	}

	public void setCondition(int condition) {
		this.condition = condition;
	}

	@Override
	public String toString() {
		return name;
	}
}
