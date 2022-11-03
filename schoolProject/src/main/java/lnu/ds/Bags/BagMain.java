package lnu.ds.Bags;

public class BagMain {
    public static void main(String[] args) {



        IBag<String> aBag = new ArrayBag<>();
        String[] contentsOfBag1 = {"A", "A", "B", "A", "C", "A"};
        testAdd(aBag, contentsOfBag1);
        System.out.println("\nTesting an initially empty bag that " + " will be filled to capacity:");
        aBag = new ArrayBag<>(7);
        String[] contentsOfBag2 = {"A", "B", "A", "C", "B", "C", "D", "another string"};
        testAdd(aBag, contentsOfBag2);

       /* PiggyBank myBank = new PiggyBank();
        addCoin(new Coin(1, 2010), myBank);
        addCoin(new Coin(5, 2011), myBank);
        addCoin(new Coin(10, 2000), myBank);
        addCoin(new Coin(25, 2012), myBank);
        System.out.println("Removing all the coins:");
        int amountRemoved = 0;
        while (!myBank.isEmpty()) {
            Coin removedCoin = myBank.remove();
            System.out.println("Removed a " + removedCoin.getCoinName() + ".");
            amountRemoved = amountRemoved + removedCoin.getValue();
        } // end while
        System.out.println("All done. Removed " + amountRemoved + " cents.");*/

    }


    /*private static void addCoin(Coin aCoin, PiggyBank aBank) {
        if (aBank.add(aCoin))
            System.out.println("Added a " + aCoin.getCoinName() + ".");
        else
            System.out.println("Tried to add a " + aCoin.getCoinName() + ", but couldn't");
    }*/

    private static void testAdd(IBag<String> aBag, String[] content) {
        System.out.print("Adding the following strings to the bag:");
        for (int index = 0; index < content.length; index++) {
            if (aBag.add(content[index]))
                System.out.print(content[index] + " ");
            else
                System.out.print("\nUnable to add " + content[index] + " to the bag.");
        }
        System.out.println();
        displayBag(aBag);
    }

    private static void displayBag(IBag<String> aBag) {
        System.out.println("The bag contains the following string(s):");
        Object[] bagArray = aBag.toArray();
        for (int index = 0; index < bagArray.length; index++) {
            System.out.print(bagArray[index] + " ");
        }
        System.out.println();
    }
}













