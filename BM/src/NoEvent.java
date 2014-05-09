
public class NoEvent implements Event {
	Time eventTime;

	public NoEvent(Time eventTime) {
		super();
		this.eventTime = eventTime;
	}

	@Override
	public void perform() {
		System.out.println("no event today");

	}

	@Override
	public Time getEventTime() {

		return eventTime;
	}

}
