package OOSD2Coursework;

import java.util.ArrayList;
import java.util.List;

public class Team {

    private String teamName; //  string of team name
    private final List<Player> playerList = new ArrayList<>(); // puts the player list into an array
    private int matchesPlayed; // matches played
    private int matchesWon; // matches won
    private int setsWon; // Sets won


    public Team(String teamName) {
        this.matchesPlayed = 0; // this will initialise the matches played at 0
        this.matchesWon = 0; // this will initialise the matches won at 0
        this.setsWon = 0; // this will initialise the sets won at 0
        this.setName(teamName); // name of the team
    }

    @Override
    public String toString() {
        return this.getName(); // get the string of the name
    }

    public String getName() {
        return this.teamName; // get the string of the Team name
    }

    public void setName(String name) {
        this.teamName = name; //set the team name
    }

    public int getsetsWon() {
        return this.setsWon; // return the sets won
    }

    public void setsWon() {
        this.setsWon++; // increment the sets won by 1 every everytime
    }

    public List<Player> getPlayers() {
        return this.playerList; // returns the list of the players
    }

    public int getMatchesPlayed() {
        return this.matchesPlayed; // return and gets the matches been played
    }

    public int getMatchesWon() {
        return this.matchesWon; // returns and gets the matches won
    }

    public void addPlayerToTeam(String playerName) {
        Player temporaryPlayer = new Player(playerName); // this is creating a temporary player
        this.playerList.add(temporaryPlayer); //adds the temporary player to a list
        System.out.println(this.playerList); // prints out the player list
    }

    public void expandMatchesPlayed() {
        this.matchesPlayed++; // increment the number of matches played by 1 everytime
    }

    public void expandMatchesWon() {
        this.matchesWon++; // increment the number of matches won by 1 everytime
    }

    public void resetwonSets() {
        System.out.println("The scores has been reset");
        this.setsWon = 0; // initialises and resets the sets won
    }
}