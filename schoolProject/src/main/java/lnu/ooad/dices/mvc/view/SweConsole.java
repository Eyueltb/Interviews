package lnu.ooad.dices.mvc.view;

import java.io.IOException;

public class SweConsole implements IView{

    private char getInputChar() throws IOException {
        int c= System.in.read();
        while (c == '\r' || c =='\n'){
            c = System.in.read();
        }
        return (char) c;
    }

    @Override
    public boolean wantsToPlay() throws IOException {
        return getInputChar() != 'q';
    }

    @Override
    public void displayResult(boolean win, int dice1Val, int dice2Val) {
        if(win)
            System.out.println("Vann " + dice1Val + " " + dice1Val);
        else
            System.out.println("Förlorat " + dice1Val + " " + dice1Val);
    }

    @Override
    public void displayInstructions() {
        System.out.println("Valfri tangent för att spela 'q' för att avsluta");
    }
}
