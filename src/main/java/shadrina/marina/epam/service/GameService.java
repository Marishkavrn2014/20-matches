package main.java.shadrina.marina.epam.service;

import main.java.shadrina.marina.epam.Exeptions.IncorrectPlayerNameException;
import main.java.shadrina.marina.epam.entity.GameField;
import main.java.shadrina.marina.epam.entity.GameSettings;

public interface GameService {

    //The method should initialize the settings, create a new playing field,
    // and work with methods showing the game.
    void startNewGame(String[] playerNames, int matches);

    // create new playing field with the settings that are set before launch
    GameField createGameField(GameSettings gameSettings);

    //the method should parse the field (current hit count) to check if the game is over
    boolean checkGameOver(int currentMatches);

    // The method must change the current number of matches on the field
    // by subtracting the number selected by the player from the current
    void makeMove(GameField gameField, int matches);

    // The method must return current field
    GameField getGameField();

    // The method should change the current player on the field to another
    void changePlayer();

    // Method should setup the game settings(create players by name and set the number of matches)
    GameSettings initialiseNewGame(String[] playerName, int matches) throws IncorrectPlayerNameException;

}
