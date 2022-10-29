package lnu.ooad.dices.mvc.controller;

import lnu.ooad.dices.mvc.model.DiceGame;
import lnu.ooad.dices.mvc.view.IView;

import java.io.IOException;

public class Player {

    public void playGame(DiceGame g, IView v) throws IOException {
        v.displayInstructions();

        while (v.wantsToPlay()) {

            v.displayResult(g.play(), g.getD1().getValue(), g.getD2().getValue());
            v.displayInstructions();

        }
    }
}
