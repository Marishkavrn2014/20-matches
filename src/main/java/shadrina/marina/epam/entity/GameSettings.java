// This class is responsible for the initial configuration of
// the game - the initial data of players and matches
package main.java.shadrina.marina.epam.entity;

public class GameSettings {
    private final Player[] players;
    private final int MATCHES;

    public GameSettings(Player[] players, int START_MATCHES) {
        this.players = players;
        this.MATCHES = START_MATCHES;
    }

    public Player[] getPlayers() {
        return players;
    }

    public int getMatches() {
        return MATCHES;
    }
}
