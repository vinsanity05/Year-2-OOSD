package OOSD2Coursework;

public class Fixtures {

    protected Team homeTeam;
    protected Team awayTeam;

    private int homeSets; // home sets
    private int awaySets; // away sets

    //check if matches are played
    protected int homeTeamScore;
    protected int awayTeamScore;

    Fixtures(Team homeTeam, Team awayTeam) {
        this.homeTeam = homeTeam; // initialises the home team
        this.awayTeam = awayTeam; // initialises the away team
    }

    //A string to show what the fixtures of home team against away team
    @Override
    public String toString() {
        return "Fixture: " + this.homeTeam + " vs. " + this.awayTeam;
    }

    //This a string to get the Name of the teams
    public String getName() {
        return this.homeTeam + " vs. " + this.awayTeam;
    }

    public String getAwayTeam(){
        return this.awayTeam.toString(); //get away team
    }

    public String getHomeTeam(){
        return this.homeTeam.toString(); //get Home team
    }

    public int getHomeScore() {
        return this.homeTeamScore; //get Home team Score
    }

    public int getAwayScore() {
        return this.awayTeamScore; //get Away team Score
    }

    //This will expand/increase the score on both teams
    public void expandScore(String team) {
        if (team.equals("home")) {
            this.homeTeamScore++; //increment the home team score
        }
        if (team.equals("away")) {
            this.awayTeamScore++; //increment the away team score
        }
    }

    // this will calculate the winner of the match
    public String CalculateWhoWon() {
        if (this.getHomeScore() <= this.getAwayScore())  //if away team score is greater than away team score
        {
            if (this.getHomeScore() == 0 && this.getAwayScore() == 0) // if both teams are 0 then this match hasn't started
            {
                return "This match has not played yet";
            }
            else {
                return this.getAwayTeam(); //returns if away team is greater than home team score
            }
        } else {
            return this.getHomeTeam(); // get the the home team
        }
    }

    public void viewFixture() {
        System.out.println("Hometeam: " + this.homeTeam.toString() + " Awayteam: " + this.awayTeam.toString() + "   Homesets: " + this.homeSets + " " + "Awaysets:" + this.awaySets);
    }

}