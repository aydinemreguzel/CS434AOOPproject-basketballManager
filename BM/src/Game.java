
public class Game {
Time currentTime;
League league;
public Game(Time currentTime, League league) {
	this.currentTime = currentTime;
	this.league = league;
}
public void advanceInTime(){
	time++;
	event=league.getTodaysEvent();
	event.perform();
}

}
