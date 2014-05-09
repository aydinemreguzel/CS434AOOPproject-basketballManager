package events;
import gameengine.Time;


public class injuryEvent implements Event {
	Time eventTime;
	public injuryEvent(Time eventTime) {
		super();
		this.eventTime = eventTime;
	}

	@Override
	public void perform() {
		System.out.println("one of your players got injured");

	}

	@Override
	public Time getEventTime() {
	
		return eventTime;
	}

}
