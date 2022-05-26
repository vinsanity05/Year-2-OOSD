package OOSD2Coursework;

public class Player {
    private final String playerName; // This is setting the name of player as a private string, as well 'final' create this variable for every object.

    public Player(String name){
        this.playerName = name; // user will type the player name
    }

    @Override
    public String toString() {
        return this.getPlayerName(); // this will get the string of the player.
    }

    public String getPlayerName(){
        return this.playerName; // this will get the name of the player
    }

}