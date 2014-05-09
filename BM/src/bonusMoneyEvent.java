public class bonusMoneyEvent implements Event {
	Time eventTime;

	public bonusMoneyEvent(Time eventTime) {
		super();
		this.eventTime = eventTime;
	}

	@Override
	public void perform() {
		System.out.println("congrats you got a bonus from yor employers");

	}

	@Override
	public Time getEventTime() {

		return eventTime;
	}
}
