package lnu.ooad.dices.mvc.view;

import java.io.IOException;

public interface IView {
    public boolean wantsToPlay() throws IOException;
    public void displayResult(boolean win, int dice1Val, int dice2Val);
    public void displayInstructions();
}
