package gameengine;


public class Manager {
	String name;
	String surName;
	String age;
	String nationality;
	short currentAbilityPoint;
	public Manager(String userName) {
		setName(userName);
		
	}
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
}
