


public class Fixture {
	Time startDate;
	int[][][] matchOrder;
	Time[][] matchDates;
	int numTeams;
	Team[] teams;
	public int[][][] getMatchOrder() {
		return matchOrder;
	}

	public Fixture(Team[] teams){
		teams=new Team[numTeams];
		numTeams = teams.length;
		matchOrder = new int[2*(numTeams-1)][numTeams / 2][2];
		matchDates = new Time[2*(numTeams-1)][numTeams / 2];
	}
	
	public void generateFixture(){
        
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

        // Last team can't be away for every game so flip them
        // to home on odd rounds.
        for (int round = 0; round < rounds.length; round++) {
            if (round % 2 == 1) {
                rounds[round][0] = flip(rounds[round][0]);
            }
        }
        
        for (int ii = 0; ii < rounds.length*2; ii++) {
        	for (int jj = 0; jj < rounds[0].length; jj++) {
        		String[] components = rounds[ii%rounds.length][jj].split(" v ");
        		if(ii<rounds.length){
        			matchOrder[ii][jj][0] = Integer.parseInt(components[0])-1;
            		matchOrder[ii][jj][1] = Integer.parseInt(components[1])-1;	
        		}else{
        			matchOrder[ii][jj][0] = Integer.parseInt(components[1])-1;
            		matchOrder[ii][jj][1] = Integer.parseInt(components[0])-1;
        		}
        	}
        }
	}
	
	public String flip(String match) {
        String[] components = match.split(" v ");
        return components[1] + " v " + components[0];
    }
	
	public Time getNextMatchDate(){
		return null;
	}
}
