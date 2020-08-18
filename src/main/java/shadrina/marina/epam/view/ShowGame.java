package main.java.shadrina.marina.epam.view;

public interface ShowGame {
    void printMatchesOnField(int currentMatches);

    void printArtificialIntelligenceMove(int matches);

    void printWinner(String playerName);

    // user input, must check valid number
    int askMatchesCount(int currentMatches);
}
