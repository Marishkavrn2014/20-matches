package main.java.shadrina.marina.epam.service;

import main.java.shadrina.marina.epam.Exeptions.IncorrectPlayerNameException;
import main.java.shadrina.marina.epam.entity.GameField;
import main.java.shadrina.marina.epam.entity.GameSettings;
import main.java.shadrina.marina.epam.entity.Player;
import main.java.shadrina.marina.epam.view.ShowTwoPlayersGame;

public class TwoPlayersGameService implements GameService {
    GameField gameField;
    Player[] players = new Player[2];

    // The first player creates by name from the arguments, the second player - AI
    @Override
    public GameSettings initialiseNewGame(String[] playerNames, int matches) throws IncorrectPlayerNameException {
        if (playerNames[0].isEmpty()) {
            throw new IncorrectPlayerNameException("Player name is empty!");
        }
        players[0] = new Player(playerNames[0]);
        players[1] = new Player("AI");
        return new GameSettings(players, matches);
    }

    // The method initializes the game, creates a playing field, AI, controls
    // the methods of displaying information about the progress of the game and winning
    @Override
    public void startNewGame(String[] playerNames, int matches) {
        GameSettings gameSettings = null;
        try {
            gameSettings = initialiseNewGame(playerNames, matches);
        } catch (IncorrectPlayerNameException e) {
            System.out.println("Game settings not initialized! " + e.getMessage());
            System.exit(0);
        }

        gameField = createGameField(gameSettings);
        gameField.setCurrentPlayer(players[0]);
        ShowTwoPlayersGame showTwoPlayersGame = new ShowTwoPlayersGame();
        TwoPlayersArtificialIntelligence twoPlayersArtificialIntelligence =
                new TwoPlayersArtificialIntelligence();

        do {
            changePlayer();
            if (gameField.getCurrentPlayer().getName().equals(playerNames[0])) {
                showTwoPlayersGame.printMatchesOnField(gameField.getCurrentMatches());
                makeMove(gameField, showTwoPlayersGame.askMatchesCount(gameField.getCurrentMatches()));
            } else {
                showTwoPlayersGame.printMatchesOnField(gameField.getCurrentMatches());
                int move = twoPlayersArtificialIntelligence.chooseMove(
                        gameField.getCurrentMatches());
                showTwoPlayersGame.printArtificialIntelligenceMove(move);
                makeMove(gameField, move);
            }
        } while (!checkGameOver(gameField.getCurrentMatches()));

        showTwoPlayersGame.printWinner(gameField.getCurrentPlayer().getName());

    }

    @Override
    public GameField createGameField(GameSettings gameSettings) {
        return new GameField(players, gameSettings.getMatches());
    }

    @Override
    public boolean checkGameOver(int currentMatches) {
        return gameField.getCurrentMatches() == 1;
    }

    @Override
    public void makeMove(GameField gameField, int matches) {
        gameField.setCurrentMatches(gameField.getCurrentMatches() - matches);
    }

    @Override
    public GameField getGameField() {
        return gameField;
    }

    @Override
    public void changePlayer() {
        if (gameField.getCurrentPlayer() == players[0]) {
            gameField.setCurrentPlayer(players[1]);
        } else {
            gameField.setCurrentPlayer(players[0]);
        }
    }

}
