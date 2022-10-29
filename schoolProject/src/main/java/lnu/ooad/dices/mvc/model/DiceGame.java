package lnu.ooad.dices.mvc.model;

import lombok.Data;

@Data
public class DiceGame {
    private Dice d1;
    private Dice d2;

    public DiceGame() {
        d1 = new Dice();
        d2 = new Dice();
    }
    public boolean play() {
        //role each dice and get the value and check if sum is 7
        d1.roll();
        d2.roll();

        return d1.getValue() + d2.getValue() == 7;
    }

}
