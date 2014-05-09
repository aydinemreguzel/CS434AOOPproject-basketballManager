public class Time {
	private int year;
	private int month;
	private int day;
	int[] daysOfMonths = { -1, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public static void main(String[] args) {
		Time time = new Time(15, 02, 1991);
		Time time2 = new Time(22, 03, 1994);
		System.out.println(time2.subtraction(time));
	}

	public void nextYear() {
		year++;
	}

	public void nextMonth() {
		if (month == 12) {
			month = 1;
			nextYear();
		} else
			month++;
	}

	public void nextDay() {
		if (daysOfMonths[month] <= day) {
			if (month == 2 && year % 4 == 0)
				day++;
			else {
				day = 1;
				nextMonth();
			}
		} else
			day++;
	}

	public void moveOnTime(int day, int month, int year) {
		for (int ii = 0; ii < year; ii++) {
			nextYear();
		}
		for (int ii = 0; ii < month; ii++) {
			nextMonth();
		}
		for (int ii = 0; ii < day; ii++) {
			nextDay();
		}
	}

	Time(String t) {
		String[] result;
		try {
			if (t.contains("/"))
				result = t.split("/");
			else if (t.contains(":"))
				result = t.split(":");
			else {
				String ti = t.replace(".", "/");
				result = ti.split("/");
			}
			day = Integer.parseInt(result[0]);
			month = Integer.parseInt(result[1]);
			year = Integer.parseInt(result[2]);
		} catch (Exception e) {
			System.out.println("time format error");
			day = 1;
			month = 1;
			year = 0;
		}
	}

	Time(int d, int m, int y) {
		year = y;
		month = m;
		day = d;
	}

	Time(int t) {
		int temp = t % 10;
		t = t / 10;
		int d = (t % 10) * 10 + temp;
		t = t / 10;
		temp = t % 10;
		t = t / 10;
		int m = (t % 10) * 10 + temp;
		int y = t / 10;
		year = y;
		month = m;
		day = d;
	}

	public String toString() {
		return day + "/" + month + "/" + year;
	}

	public int subtraction(Time t) {
		int result = 0;
		if (this.getYear() < t.getYear())
			for (int i = this.getYear(); i < t.getYear(); i++)
				result -= (i % 4 == 0) ? 366 : 365;
		else
			for (int i = this.getYear(); i > t.getYear(); i--)
				result += (i % 4 == 0) ? 366 : 365;
		for (int i = 1; i < this.getMonth(); i++)
			result += (this.getYear() % 4 == 0 && i == 2) ? 29
					: daysOfMonths[i];
		for (int i = 1; i < t.getMonth(); i++)
			result -= (this.getYear() % 4 == 0 && i == 2) ? 29
					: daysOfMonths[i];
		return result + this.getDay() - t.getDay();
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + day;
		result = prime * result + month;
		result = prime * result + year;
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Time other = (Time) obj;
		if (day != other.day)
			return false;
		if (month != other.month)
			return false;
		if (year != other.year)
			return false;
		return true;
	}
	
}
