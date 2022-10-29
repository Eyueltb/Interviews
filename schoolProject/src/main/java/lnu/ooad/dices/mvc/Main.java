package lnu.ooad.dices.mvc;

import lnu.ooad.dices.mvc.controller.Player;
import lnu.ooad.dices.mvc.model.DiceGame;
import lnu.ooad.dices.mvc.view.Console;
import lnu.ooad.dices.mvc.view.IView;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        DiceGame g = new DiceGame();
        IView v = new Console();
        Player p = new Player();

        p.playGame(g, v);
    }
}
