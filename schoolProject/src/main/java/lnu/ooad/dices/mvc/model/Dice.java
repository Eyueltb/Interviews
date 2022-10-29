package lnu.ooad.dices.mvc.model;

import lombok.Data;

@Data
public class Dice {
    private int value;

     public void roll() {
        value = (int)(Math.random() * 171717.0) % 6 + 1;
    }
}
