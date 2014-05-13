package teams;


public class Player {
	String name;
	String age;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
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
