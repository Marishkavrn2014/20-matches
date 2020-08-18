package main.java.shadrina.marina.epam.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ShowTwoPlayersGame implements ShowGame {


    @Override
    public void printMatchesOnField(int currentMatches) {
        System.out.printf("%d matches on the table\n", currentMatches);
    }

    @Override
    public void printArtificialIntelligenceMove(int matches) {
        System.out.printf("Number of selected computers matches: %d\n", matches);
    }

    @Override
    public void printWinner(String playerName) {
        ;
        System.out.printf("Only one match on the table. The winner is %s", playerName);
    }

    // checks the validity of the move and the number
    @Override
    public int askMatchesCount(int currentMatches) {
        System.out.print("Player move. ");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the number of matches: ");
        int matches = 0;
        try {
            matches = scanner.nextInt();
            while (matches < 1 || matches > 3 || (currentMatches - matches) < 1) {
                System.out.print("The number of matches is incorrect. Please enter the number of matches: ");
                matches = scanner.nextInt();
            }
            return matches;
        } catch (InputMismatchException e) {
            System.out.println("The number is incorrect");
            matches = askMatchesCount(currentMatches);
        }
        return matches;
    }

}
