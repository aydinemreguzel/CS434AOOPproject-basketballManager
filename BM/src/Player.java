

public class Player {
	String name;
	String surName;
	String age;
	String nationality;
	short currentAbilityPoint;
	short potentialAbilityPoint;
	short height;
	short strength;
	short agility;
	short intelegence;
	short naturalFitness;
	short agression;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurName() {
		return surName;
	}
	public void setSurName(String surName) {
		this.surName = surName;
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
	public short getCurrentAbilityPoint() {
		return currentAbilityPoint;
	}
	public void setCurrentAbilityPoint(short currentAbilityPoint) {
		this.currentAbilityPoint = currentAbilityPoint;
	}
	public short getPotentialAbilityPoint() {
		return potentialAbilityPoint;
	}
	public void setPotentialAbilityPoint(short potentialAbilityPoint) {
		this.potentialAbilityPoint = potentialAbilityPoint;
	}
	public short getHeight() {
		return height;
	}
	public void setHeight(short height) {
		this.height = height;
	}
	public short getStrength() {
		return strength;
	}
	public void setStrength(short strength) {
		this.strength = strength;
	}
	public short getAgility() {
		return agility;
	}
	public void setAgility(short agility) {
		this.agility = agility;
	}
	public short getIntelegence() {
		return intelegence;
	}
	public void setIntelegence(short intelegence) {
		this.intelegence = intelegence;
	}
	public short getNaturalFitness() {
		return naturalFitness;
	}
	public void setNaturalFitness(short naturalFitness) {
		this.naturalFitness = naturalFitness;
	}
	public short getAgression() {
		return agression;
	}
	public void setAgression(short agression) {
		this.agression = agression;
	}
	@Override
	public String toString() {
		return "Player [name=" + name + ", surName=" + surName + ", age=" + age
				+ ", nationality=" + nationality + ", currentAbilityPoint="
				+ currentAbilityPoint + ", potentialAbilityPoint="
				+ potentialAbilityPoint + ", height=" + height + ", strength="
				+ strength + ", agility=" + agility + ", intelegence="
				+ intelegence + ", naturalFitness=" + naturalFitness
				+ ", agression=" + agression + "]";
	}
}
