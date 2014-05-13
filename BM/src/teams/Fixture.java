package teams;

import events.Event;
import events.MatchEvent;
import gameengine.Time;

public class Fixture {
	Time startDate;
	Time[][] matchDates;
	int numTeams;
	Team[] teams;
	MatchEvent[] matches;

	public Fixture(Team[] teams, Time startDate) {
		this.teams = new Team[numTeams];
		this.startDate = startDate;
		numTeams = teams.length;
		matchDates = new Time[2 * (numTeams - 1)][numTeams / 2];
		matches = new MatchEvent[(2 * (numTeams - 1)) * (numTeams / 2)];
		generateFixture();
	}

	public void generateFixture() {

		if (numTeams % 2 == 1) {
			numTeams++;
		}

		// Generate the fixtures using the cyclic algorithm.
		int totalRounds = numTeams - 1;
		int matchesPerRound = numTeams / 2;
		String[][] rounds = new String[totalRounds][matchesPerRound];

		for (int round = 0; round < totalRounds; round++) {
			for (int match = 0; match < matchesPerRound; match++) {
				int home = (round + match) % (numTeams - 1);
				int away = (numTeams - 1 - match + round) % (numTeams - 1);
				// Last team stays in the same place while the others
				// rotate around it.
				if (match == 0) {
					away = numTeams - 1;
				}
				// Add one so teams are number 1 to teams not 0 to teams - 1
				// upon display.
				rounds[round][match] = (home + 1) + " v " + (away + 1);
			}
		}

		// Interleave so that home and away games are fairly evenly dispersed.
		rounds = interleave(totalRounds, matchesPerRound, rounds);

		// Last team can't be away for every game so flip them
		// to home on odd rounds.
		for (int round = 0; round < rounds.length; round++) {
			if (round % 2 == 1) {
				rounds[round][0] = flip(rounds[round][0]);
			}
		}

		int[][][] matchOrder = createMatchOrder(rounds);
		System.out.println("numteam:"+numTeams);
		createMatchEvents(rounds,matchOrder);
	}

	private String[][] interleave(int totalRounds, int matchesPerRound,
			String[][] rounds) {
		String[][] interleaved = new String[totalRounds][matchesPerRound];

		int evn = 0;
		int odd = (numTeams / 2);
		for (int i = 0; i < rounds.length; i++) {
			if (i % 2 == 0) {
				interleaved[i] = rounds[evn++];
			} else {
				interleaved[i] = rounds[odd++];
			}
		}

		rounds = interleaved;
		return rounds;
	}
	
	private int[][][] createMatchOrder(String[][] rounds){
		int[][][] matchOrder = new int[2 * (numTeams - 1)][numTeams / 2][2];
		for (int ii = 0; ii < rounds.length * 2; ii++) {
			for (int jj = 0; jj < rounds[0].length; jj++) {
				String[] components = rounds[ii % rounds.length][jj]
						.split(" v ");
				if (ii < rounds.length) {
					matchOrder[ii][jj][0] = Integer.parseInt(components[0]) - 1;
					matchOrder[ii][jj][1] = Integer.parseInt(components[1]) - 1;
				} else {
					matchOrder[ii][jj][0] = Integer.parseInt(components[1]) - 1;
					matchOrder[ii][jj][1] = Integer.parseInt(components[0]) - 1;
				}
			}
		}
		return matchOrder;
	}

	private void createMatchEvents(String[][] rounds,int[][][] matchOrder ) {
		Time date;
		for (int ii = 0; ii < rounds.length * 2; ii++) {
			for (int jj = 0; jj < rounds[0].length; jj++) {
				date = new Time(startDate.getDay(), startDate.getMonth(),
						startDate.getYear());
				matches[ii * rounds[0].length + jj] = new MatchEvent(
						teams[matchOrder[ii][jj][0]],
						teams[matchOrder[ii][jj][0]], date);
				startDate.moveOnTime(2, 0, 0);
			}
		}
	}

	public String flip(String match) {
		String[] components = match.split(" v ");
		return components[1] + " v " + components[0];
	}

	public Time getNextMatchDateAfter(Time time) {
		MatchEvent match = matches[0];
		for (int i = 0; time.before(match.getEventTime()); i++) {
			match = matches[i];
		}
		return match.getEventTime();
	}

	public Event getMatchAt(Time time) {
		for (int i = 0; i < matches.length; i++) {
			if (matches[i].getEventTime().equals(time)) {
				return matches[i];
			}
		}
		System.out.println("match not found");
		return null;
	}
}
