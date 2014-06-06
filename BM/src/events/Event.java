package events;
import gameengine.Time;


public interface Event {
	public void perform();
	public Time getEventTime();
	public String getLog();
}
