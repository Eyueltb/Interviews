package lnu.ooad.dices.mv;

import lnu.ooad.dices.mv.model.DiceGame;
import lnu.ooad.dices.mv.view.Console;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        DiceGame g = new DiceGame();
        Console v = new Console();

        v.playGame(g);
    }
}
