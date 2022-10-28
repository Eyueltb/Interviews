package lnu.ooad.dices.mv.view;

import lnu.ooad.dices.mv.model.DiceGame;

import java.io.IOException;

public class Console {

    public void playGame(DiceGame game) throws IOException {
        System.out.println("Any key to play 'q' to quit");
        while (getInputChar() != 'q') {
            if(game.play())
                System.out.println("Win " + game.getD1().getValue() + " " + game.getD2().getValue());
            else
               System.out.println("Lost " + game.getD1().getValue() + " " + game.getD2().getValue());
        }
    }

    private char getInputChar() throws IOException {
        int c= System.in.read();
        while (c == '\r' || c =='\n'){
            c = System.in.read();
        }
        return (char) c;
    }
}
