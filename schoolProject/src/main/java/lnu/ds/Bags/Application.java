package lnu.ds.Bags;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {



        Item[] items = {
                new Item("Bird feeder", 2050.69),
                new Item("Squirrel guard", 1547.12),
                new Item("Bird bath", 4499.10),
                new Item("Sunflower seeds", 1295)
        };
        IBag<Item> shoppingCart = new ArrayBag<>();
        double totalCost = 0;

        Arrays.stream(items).forEach( item-> shoppingCart.add(item));
        System.out.println(" Sum = " + Arrays.stream(items).map(Item::getPrice).reduce(0.0, Double::sum));

        while (!shoppingCart.isEmpty())
            System.out.println(shoppingCart.remove());

        System.out.println(shoppingCart.isEmpty());


    }
}

@Data
@AllArgsConstructor
final class Item {
    String name;
    double price;
}

final class PiggyBank {

    private IBag<Coin> coins;

    public PiggyBank() {
        coins = new ArrayBag<>();
    }

    public boolean add(Coin coin) {
        return coins.add(coin);
    }

    public Coin remove() {
        return coins.remove();
    }

    public boolean isEmpty() {
        return coins.isEmpty();
    }
}


@Data
final class Coin {

}
