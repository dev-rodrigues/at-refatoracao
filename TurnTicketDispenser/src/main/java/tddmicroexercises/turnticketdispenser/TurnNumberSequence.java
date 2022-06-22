package tddmicroexercises.turnticketdispenser;

public class TurnNumberSequence {

    private TurnNumberSequence() {
    }

    private static int turnNumber = 0;

    public static int getNextTurnNumber() {
        return turnNumber++;
    }
}
