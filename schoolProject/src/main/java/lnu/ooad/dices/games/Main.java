package lnu.ooad.dices.games;

/**
 * Requirement- Play a Dice-Game
 * The dice(has value from 1 to 6) are rolled and the result is presented.
 * If the sum is 7 then the player wins.
 *  => Two dices are rolled and if the sum is 7 then the player wins
 */
public class Main {
    public static void main(String[] args) {

        DiceGame g = new DiceGame();

        if(g.play())
            System.out.println("Winner...");
        else
            System.out.println("Sorry...");

    }
}
