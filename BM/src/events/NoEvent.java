package events;
import gameengine.Time;


public class NoEvent implements Event {
	Time eventTime;
	String log;

	public NoEvent(Time eventTime) {
		super();
		this.eventTime = eventTime;
	}

	@Override
	public void perform() {
		log = "no event for today";
	}

	@Override
	public Time getEventTime() {

		return eventTime;
	}

	@Override
	public String getLog() {
		return log;
	}

}
