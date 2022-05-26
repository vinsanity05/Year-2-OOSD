package OOSD2Coursework;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Match {

    //the Away/Home team
    private Team homeTeam;
    private Team awayTeam;

    //The players, home/away player 1 and 2
    protected Player HPlayer1;
    protected Player HPlayer2;
    protected Player APlayer1;
    protected Player APlayer2;

    private String name;
    private Fixtures fixture;

    // Number of the sets
    private int set1;
    private int set2;
    private int set3;
    private int set4;
    private int set5;

    // gets the Home team
    public Team getTeamHome() {
        return this.homeTeam;
    }

    // gets the Away team
    public Team getTeamAway() {
        return this.awayTeam;
    }

    //gets the home team player 1
    public Player getHPlayer1() {
        return this.HPlayer1;
    }

    //gets the home team player 2
    public Player getHPlayer2() {
        return this.HPlayer2;
    }

    //gets the Away team player 1
    public Player getAPlayer1() {
        return this.APlayer1;
    }

    //gets the Away team player 2
    public Player getAPlayer2() {
        return this.APlayer2;
    }

    //sets the home team name
    public void setTeamHome(Team name) {
        this.homeTeam = name;
    }

    //sets the away team name
    public void setTeamAway(Team name) {
        this.awayTeam = name;
    }


    //gets the fixtures and returns
    public Fixtures getFixtures() {return this.fixture;}

    @Override
    //this will get the string of the team names.
    public String toString() {
        this.name = this.getTeamHome() + " vs. " + this.getTeamAway();
        return this.name;
    }

    //this will join/link the fixtures to a fixtures list and will increment the size
    public void joinFixtures(){
        this.toString();
        int LF = 0;
        while (LF < Main.fixtureList.size()) {
            System.out.println(this.name);
            System.out.println(Main.fixtureList.get(LF).toString());
            if (this.name.equals(Main.fixtureList.get(LF).getName())) {
                this.fixture = Main.fixtureList.get(LF);
                System.out.println("fixture joined/linked to match");
            }
            else {System.out.println("cannot find matching fixture.");}
            LF++;
        }
    }

    // this will set the players and saves the the player
    // Using an AND operator for it to see if the Home/Away team is equal to the home/away player
    public void setPlayers(String team, int playerNo, Player player) {
        if (team.equals("home") && playerNo == 1) {
            this.HPlayer1 = player;
            System.out.println("Home Player 1 saved");
        }
        if (team.equals("home") && playerNo == 2) {
            this.HPlayer2 = player;
            System.out.println("Home Player 2 saved");
        }
        if (team.equals("away") && playerNo == 1) {
            this.APlayer1 = player;
            System.out.println("Away Player 1 saved");
        }
        if (team.equals("away") && playerNo == 2) {
            this.APlayer2 = player;
            System.out.println("Away Player 2 saved");
        }
    }

    //This is the Home player 1 against Away player 1 and player 2

    private int HP1vsAP1_set1Home; //this is set 1 Home of Home1vsAway1set1 as its called on Scenebuilder/fx:id
    private int HP1vsAp1_set1Away; //this is set 1 Away of Home1vsAway1set1 as its called on Scenebuilder/fx:id

    private int HP1vsAP1_set2Home; //this is set 2 Home of Home1vsAway1set2 as its called on Scenebuilder/fx:id
    private int Hp1vsAP1_set2Away; //this is set 2 Away of Home1vsAway1set2 as its called on Scenebuilder/fx:id

    private int HP1vsAP1_set3Home; //this is set 3 Home of Home1vsAway1set3 as its called on Scenebuilder/fx:id
    private int HP1vsAP1_set3Away; //this is set 3 Away of Home1vsAway1set3 as its called on Scenebuilder/fx:id

    private int HP1vsAP2_set1Home; //this is set 1 Home of Home1vsAway2set1 as its called on Scenebuilder/fx:id
    private int HP1vsAP2_set1Away; //this is set 1 Away of Home1vsAway2set1 as its called on Scenebuilder/fx:id

    private int HP1vsAP2_set2Home; //this is set 2 Home of Home1vsAway2set2 as its called on Scenebuilder/fx:id
    private int HP1vsAP2_set2Away; //this is set 2 Away of Home1vsAway2set2 as its called on Scenebuilder/fx:id

    private int HP1vsAP2_set3Home; //this is set 3 Home of Home1vsAway2set3 as its called on Scenebuilder/fx:id
    private int HP1vsAP2_set3Away; //this is set 3 Away of Home1vsAway2set3 as its called on Scenebuilder/fx:id

    //This is Home player 2 against Away player 1 and player 2

    private int HP2vsAP1_set1Home; //this is set 1 Home of Home2vsAway1set1 as its called on Scenebuilder/fx:id
    private int HP2vsAP1_set1Away; //this is set 1 Away of Home2vsAway1set1 as its called on Scenebuilder/fx:id

    private int HP2vsAP1_set2Home; //this is set 2 Home of Home2vsAway1set2 as its called on Scenebuilder/fx:id
    private int HP2vsAP1_set2Away; //this is set 2 Away of Home2vsAway1set2 as its called on Scenebuilder/fx:id

    private int HP2vsAP1_set3Home; //this is set 3 Home of Home2vsAway1set3 as its called on Scenebuilder/fx:id
    private int HP2vsAP1_set3Away; //this is set 3 Away of Home2vsAway1set3 as its called on Scenebuilder/fx:id

    private int HP2vsAP2_set1Home; //this is set 1 Home of Home2vsAway2set1 as its called on Scenebuilder/fx:id
    private int HP2vsAP2_set1Away; //this is set 1 Away of Home2vsAway2set1 as its called on Scenebuilder/fx:id

    private int HP2vsAP2_set2Home; //this is set 2 Home of Home2vsAway2set2 as its called on Scenebuilder/fx:id
    private int HP2vsAP2_set2Away; //this is set 2 Away of Home2vsAway2set2 as its called on Scenebuilder/fx:id

    private int HP2vsAP2_set3Home; //this is set 3 Home of Home2vsAway2set3 as its called on Scenebuilder/fx:id
    private int HP2vsAP2_set3Away;//this is set 3 Away of Home2vsAway2set3 as its called on Scenebuilder/fx:id

    // -------------------------Double set-----------------------------------

    private int DoubleSet1Home; //this is set 1 home of the double set
    private int DoubleSet1Away; //this is set 1 away of the double set

    private int DoubleSet2Home; //this is set 2 home of the double set
    private int DoubleSet2Away; //this is set 2 away of the double set

    private int DoubleSet3Home; //this is set 3 home of the double set
    private int DoubleSet3Away; //this is set 3 away of the double set



    //this will set the points and score values on each team per set.
    public void setPoints(List<String> scoreValues) {
        int score = 0;
        while (score < scoreValues.size()) {
            String temp = scoreValues.get(score);
            String[] splitTemp = temp.split(":"); // this will split it temporarily
            // This method is used to get the primitive data type of a certain String which is the Home points
            int HomePoints = Integer.parseInt(splitTemp[0]);
            // This method is used to get the primitive data type of a certain String which is the Away points
            int AwayPoints = Integer.parseInt(splitTemp[1]);

            //Here will be a list of switch statements, If there is a match, the associated block of the code is executed.
            // This will be used on the Controller for it to get its values.
            switch (score) {
                case 0:
                    this.HP1vsAP1_set1Home = HomePoints;
                    this.HP1vsAp1_set1Away = AwayPoints;
                    break;
            }
            switch (score) {
                case 1:
                    this.HP1vsAP1_set2Home = HomePoints;
                    this.Hp1vsAP1_set2Away = AwayPoints;
                    break;
            }
            switch (score) {
                case 2:
                    this.HP1vsAP1_set3Home = HomePoints;
                    this.HP1vsAP1_set3Away = AwayPoints;
                    break;
            }
            switch (score) {
                case 3:
                    this.HP1vsAP2_set1Home = HomePoints;
                    this.HP1vsAP2_set1Away = AwayPoints;
                    break;
            }
            switch (score) {
                case 4:
                    this.HP1vsAP2_set2Home = HomePoints;
                    this.HP1vsAP2_set2Away = AwayPoints;
                    break;
            }
            switch (score) {
                case 5:
                    this.HP1vsAP2_set3Home = HomePoints;
                    this.HP1vsAP2_set3Away = AwayPoints;
                    break;
            }
            switch (score) {
                case 6:
                    this.HP2vsAP1_set1Home = HomePoints;
                    this.HP2vsAP1_set1Away = AwayPoints;
                    break;
            }
            switch (score) {
                case 7:
                    this.HP2vsAP1_set2Home = HomePoints;
                    this.HP2vsAP1_set2Away = AwayPoints;
                    break;
            }
            switch (score) {
                case 8:
                    this.HP2vsAP1_set3Home = HomePoints;
                    this.HP2vsAP1_set3Away = AwayPoints;
                    break;
            }
            switch (score) {
                case 9:
                    this.HP2vsAP2_set1Home = HomePoints;
                    this.HP2vsAP2_set1Away = AwayPoints;
                    break;
            }
            switch (score) {
                case 10:
                    this.HP2vsAP2_set2Home = HomePoints;
                    this.HP2vsAP2_set2Away = AwayPoints;
                    break;
            }
            switch (score) {
                case 11:
                    this.HP2vsAP2_set3Home = HomePoints;
                    this.HP2vsAP2_set3Away = AwayPoints;
                    break;
            }
            switch (score) {
                case 12:
                    this.DoubleSet1Home = HomePoints;
                    this.DoubleSet1Away = AwayPoints;
                    break;
            }
            switch (score) {
                case 13:
                    this.DoubleSet2Home = HomePoints;
                    this.DoubleSet2Away = AwayPoints;
                    break;
            }
            switch (score) {
                case 14:
                    this.DoubleSet3Home = HomePoints;
                    this.DoubleSet3Away = AwayPoints;
                    break;
            }

            score++;
        }
    }
    //This will get all the sets by using a concat() method which concatenates one string to the end of another string.
    // This method returns a string with the value of the string passed into the method, add/appended to the end of the string.
    // This method is to combine two strings which is better option than using a '+' operator because it takes more memory
    //This will get all the boxes on each set and double set
    public List<String> getSet(int setNumber){
        String concat;
        List<String> sets = new ArrayList<>();
        switch (setNumber) {
            case 1:
                concat = this.HP1vsAP1_set1Home + ":" + this.HP1vsAp1_set1Away;
                sets.add(concat);
                concat = this.HP1vsAP1_set2Home + ":" + this.Hp1vsAP1_set2Away;
                sets.add(concat);
                concat = this.HP1vsAP1_set3Home + ":" + this.HP1vsAP1_set3Away;
                sets.add(concat);
                break;
        }
        switch (setNumber) {
            case 2:
                concat = this.HP1vsAP2_set1Home + ":" + this.HP1vsAP2_set1Away;
                sets.add(concat);
                concat = this.HP1vsAP2_set2Home + ":" + this.HP1vsAP2_set2Away;
                sets.add(concat);
                concat = this.HP1vsAP2_set3Home + ":" + this.HP1vsAP2_set3Away;
                sets.add(concat);
                break;
        }
        switch (setNumber) {
            case 3:
                concat = this.HP2vsAP1_set1Home + ":" + this.HP2vsAP1_set1Away;
                sets.add(concat);
                concat = this.HP2vsAP1_set2Home + ":" + this.HP2vsAP1_set2Away;
                sets.add(concat);
                concat = this.HP2vsAP1_set3Home + ":" + this.HP2vsAP1_set3Away;
                sets.add(concat);
                break;
        }
        switch (setNumber) {
            case 4:
                concat = this.HP2vsAP2_set1Home + ":" + this.HP2vsAP2_set1Away;
                sets.add(concat);
                concat = this.HP2vsAP2_set2Home + ":" + this.HP2vsAP2_set2Away;
                sets.add(concat);
                concat = this.HP2vsAP2_set3Home + ":" + this.HP2vsAP2_set3Away;
                sets.add(concat);
                break;
        }
        switch (setNumber) {
            case 5:
                concat = this.DoubleSet1Home + ":" + this.DoubleSet1Away;
                sets.add(concat);
                concat = this.DoubleSet2Home + ":" + this.DoubleSet2Away;
                sets.add(concat);
                concat = this.DoubleSet3Home + ":" + this.DoubleSet3Away;
                sets.add(concat);
                break;
        }
        return sets;
    }


    //StringJoiner is used in this sequence to separate by a delimiter which will be added to get the value of each box
    //So for instance each box will get the score/points and get the value of DoubleSet box of home and away team and the other box/text fields

    public List<String> getpointsfromeachteam() {
        List<String> valueofPoints = new ArrayList<>();
        StringJoiner getPoints = new StringJoiner(":");
        valueofPoints.add(getPoints.add(String.valueOf(this.HP1vsAP1_set1Home)).add(String.valueOf(this.HP1vsAp1_set1Away)).toString());
        getPoints = new StringJoiner(":");
        valueofPoints.add(getPoints.add(String.valueOf(this.HP1vsAP1_set2Home)).add(String.valueOf(this.Hp1vsAP1_set2Away)).toString());
        getPoints = new StringJoiner(":");
        valueofPoints.add(getPoints.add(String.valueOf(this.HP1vsAP1_set3Home)).add(String.valueOf(this.HP1vsAP1_set3Away)).toString());
        getPoints = new StringJoiner(":");
        valueofPoints.add(getPoints.add(String.valueOf(this.HP1vsAP2_set1Home)).add(String.valueOf(this.HP1vsAP2_set1Away)).toString());
        getPoints = new StringJoiner(":");
        valueofPoints.add(getPoints.add(String.valueOf(this.HP1vsAP2_set2Home)).add(String.valueOf(this.HP1vsAP2_set2Away)).toString());
        getPoints = new StringJoiner(":");
        valueofPoints.add(getPoints.add(String.valueOf(this.HP1vsAP2_set3Home)).add(String.valueOf(this.HP1vsAP2_set3Away)).toString());
        getPoints = new StringJoiner(":");
        valueofPoints.add(getPoints.add(String.valueOf(this.HP2vsAP1_set1Home)).add(String.valueOf(this.HP2vsAP1_set1Away)).toString());
        getPoints = new StringJoiner(":");
        valueofPoints.add(getPoints.add(String.valueOf(this.HP2vsAP1_set2Home)).add(String.valueOf(this.HP2vsAP1_set2Away)).toString());
        getPoints = new StringJoiner(":");
        valueofPoints.add(getPoints.add(String.valueOf(this.HP2vsAP1_set3Home)).add(String.valueOf(this.HP2vsAP1_set3Away)).toString());
        getPoints = new StringJoiner(":");
        valueofPoints.add(getPoints.add(String.valueOf(this.HP2vsAP2_set1Home)).add(String.valueOf(this.HP2vsAP2_set1Away)).toString());
        getPoints = new StringJoiner(":");
        valueofPoints.add(getPoints.add(String.valueOf(this.HP2vsAP2_set2Home)).add(String.valueOf(this.HP2vsAP2_set2Away)).toString());
        getPoints = new StringJoiner(":");
        valueofPoints.add(getPoints.add(String.valueOf(this.HP2vsAP2_set3Home)).add(String.valueOf(this.HP2vsAP2_set3Away)).toString());
        getPoints = new StringJoiner(":");
        valueofPoints.add(getPoints.add(String.valueOf(this.DoubleSet1Home)).add(String.valueOf(this.DoubleSet1Away)).toString());
        getPoints = new StringJoiner(":");
        valueofPoints.add(getPoints.add(String.valueOf(this.DoubleSet2Home)).add(String.valueOf(this.DoubleSet2Away)).toString());
        getPoints = new StringJoiner(":");
        valueofPoints.add(getPoints.add(String.valueOf(this.DoubleSet3Home)).add(String.valueOf(this.DoubleSet3Away)).toString());

        return valueofPoints;

    }

    //This will calculate the total whether Home is greater/less than to Away team
    public void calculateTotal() {
        int homeScore = 0, awayScore = 0;
        if (HP1vsAP1_set1Home <= HP1vsAp1_set1Away) {
            awayScore++; //increments the awayScore
        } else {
            homeScore++; //increments the homeScore
        }
        if (HP1vsAP1_set2Home <= Hp1vsAP1_set2Away) {
            awayScore++; //increments the awayScore
        } else {
            homeScore++; //increments the homeScore
        }
        if (HP1vsAP1_set3Home <= HP1vsAP1_set3Away) {
            awayScore++; //increments the awayScore
        } else {
            homeScore++; //increments the homeScore
        }
        if (homeScore <= awayScore) {
            fixture.expandScore("away");
            this.awayTeam.setsWon(); //away team won the set
        } else {
            fixture.expandScore("home");
            this.homeTeam.setsWon(); //home team won the set
        }

        homeScore = 0;
        awayScore = 0;
        if (HP1vsAP2_set1Home <= HP1vsAP2_set1Away) {
            awayScore++; //increments the awayScore
        } else {
            homeScore++; //increments the homeScore
        }
        if (HP1vsAP2_set2Home <= HP1vsAP2_set2Away) {
            awayScore++; //increments the awayScore
        } else {
            homeScore++; //increments the homeScore
        }
        if (HP1vsAP2_set3Home <= HP1vsAP2_set3Away) {
            awayScore++; //increments the awayScore
        } else {
            homeScore++; //increments the homeScore
        }
        if (homeScore <= awayScore) {
            fixture.expandScore("away");
            this.awayTeam.setsWon(); //away team won the set
        } else {
            fixture.expandScore("home");
            this.homeTeam.setsWon(); //home team won the set
        }

        homeScore = 0;
        awayScore = 0;
        if (HP2vsAP1_set1Home <= HP2vsAP1_set1Away) {
            awayScore++; //increments the awayScore
        } else {
            homeScore++; //increments the homeScore
        }
        if (HP2vsAP1_set2Home <= HP2vsAP1_set2Away) {
            awayScore++; //increments the awayScore
        } else {
            homeScore++; //increments the homeScore
        }
        if (HP2vsAP1_set3Home <= HP2vsAP1_set3Away) {
            awayScore++; //increments the awayScore
        } else {
            homeScore++; //increments the homeScore
        }
        if (homeScore <= awayScore) {
            fixture.expandScore("away");
            this.awayTeam.setsWon(); //away team won the set

        } else {
            fixture.expandScore("home");
            this.homeTeam.setsWon(); //home team won the set
        }

        homeScore = 0;
        awayScore = 0;
        if (HP2vsAP2_set1Home <= HP2vsAP2_set1Away) {
            awayScore++; //increments the awayScore
        } else {
            homeScore++; //increments the homeScore
        }
        if (HP2vsAP2_set2Home <= HP2vsAP2_set2Away) {
            awayScore++; //increments the awayScore
        } else {
            homeScore++; //increments the homeScore
        }
        if (HP2vsAP2_set3Home <= HP2vsAP2_set3Away) {
            awayScore++;  //increments the awayScore
        } else {
            homeScore++; //increments the homeScore
        }
        if (homeScore <= awayScore) {
            fixture.expandScore("away");
            this.awayTeam.setsWon(); //away team won the set
        } else {
            fixture.expandScore("home");
            this.homeTeam.setsWon(); //home team won the set
        }

        homeScore = 0;
        awayScore = 0;
        if (DoubleSet1Home <= DoubleSet1Away) {
            awayScore++; //increments the awayScore
        } else {
            homeScore++; //increments the homeScore
        }
        if (DoubleSet2Home <= DoubleSet2Away) {
            awayScore++; //increments the awayScore
        } else {
            homeScore++; //increments the homeScore
        }
        if (DoubleSet3Home <= DoubleSet3Away) {
            awayScore++; //increments the awayScore
        } else {
            homeScore++; //increments the homeScore
        }
        if (homeScore <= awayScore) {
            fixture.expandScore("away");
            this.awayTeam.setsWon();  //away team won the set
        } else {
            fixture.expandScore("home");
            this.homeTeam.setsWon(); //home team won the set
        }
    }



}