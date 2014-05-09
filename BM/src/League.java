import java.awt.Color;
import java.util.ArrayList;

public class League {
	
	String name;
	Color colors[];
	ArrayList< Team > teams = new ArrayList< Team >();
	Fixture fixture;
	public League(String name, Color[] colors, ArrayList<Team> teams,
			Fixture fixture) {
		super();
		this.name = name;
		this.colors = colors;
		this.teams = teams;
		this.fixture = fixture;
	}
	public Team[] getNextMatchTeams(){
		return null;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Color[] getColors() {
		return colors;
	}
	public void setColors(Color[] colors) {
		this.colors = colors;
	}
	public ArrayList<Team> getTeams() {
		return teams;
	}
	public void setTeams(ArrayList<Team> teams) {
		this.teams = teams;
	}
	public Fixture getFixture() {
		return fixture;
	}
	public void setFixture(Fixture fixture) {
		this.fixture = fixture;
	}
}
