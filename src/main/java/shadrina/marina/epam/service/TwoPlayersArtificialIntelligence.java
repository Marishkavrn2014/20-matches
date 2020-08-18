package main.java.shadrina.marina.epam.service;

public class TwoPlayersArtificialIntelligence implements ArtificialIntelligence {

    // the algorithm always wins if the AI moves first
    @Override
    public int chooseMove(int currentMatches) {
        int count = currentMatches % 4;
        if (count == 0) {
            return 3;
        } else if (currentMatches - count > 1) {
            if (count > 1) {
                return count - 1;
            } else {
                return 1;
            }
        } else {
            return count - 1;
        }
    }
}
