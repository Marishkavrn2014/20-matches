// this class stores information about the current number of matches on the table,
// players and the player who is currently playing
package main.java.shadrina.marina.epam.entity;

public class GameField {
    private Player[] players;
    private Player currentPlayer;
    private int currentMatches;

    public GameField(Player[] players, int currentMatches) {
        this.players = players;
        this.currentMatches = currentMatches;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public int getCurrentMatches() {
        return currentMatches;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public void setCurrentMatches(int currentMatches) {
        this.currentMatches = currentMatches;
    }
}
