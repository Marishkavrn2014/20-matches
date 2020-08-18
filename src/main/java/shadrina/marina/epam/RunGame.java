package main.java.shadrina.marina.epam;

import main.java.shadrina.marina.epam.service.TwoPlayersGameService;

public class RunGame {
    public static void main(String[] args) {
        TwoPlayersGameService twoPlayersGameService = new TwoPlayersGameService();
        final String[] playerName = {"Test"};
        final int MATCHES = 20;
        twoPlayersGameService.startNewGame(playerName, MATCHES);
    }
}
