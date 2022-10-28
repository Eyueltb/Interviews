package lnu.ooad.dices.games;

import lombok.Data;

@Data
public class Dice {
    private int value;

    public void roll() {
        this.value = (int)(Math.random() * 171717.0) % 6 + 1;
    }
}
