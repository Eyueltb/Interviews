package oop;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OnlineShopper {
    public static void main(String[] args) {
        Item [] items = {
                new Item ("Item 1", 1340),
                new Item ("Item 2", 1000),
                new Item ("Item 3", 1110),
                new Item ("Item 4", 14540),
        };
        Bag<Item> shoppingCart = new Bag<>();
        final int[] totalCost = {0};

        Arrays.stream(items).forEach(item -> {
            shoppingCart.add(item);
            totalCost[0] += item.getPrice();
        });
        System.out.println("total cost " + totalCost[0]);
        shoppingCart.getItems().stream().forEach(System.out::println);
    }
}

@Data
class Item {
    private String name;
    private double price;

    public Item(String name, double price){
        this.name = name;
        this.price = price;
    }
}
class Bag<Item> implements IBag<Item> {
    private List<Item> items;
    public Bag() {
        items = new ArrayList<>();
    }
    @Override
    public int getCurrentSize() {
        return items.size();
    }
    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return items.isEmpty();
    }

    @Override
    public boolean add(Item newItem) {
        return items.add(newItem);
    }

    @Override
    public Item remove() {
        return null;
    }

    @Override
    public boolean remove(Item anEntry) {
        return items.remove(anEntry);
    }

    @Override
    public void clear(Item anEntry) {

    }

    @Override
    public int getFrequencyOf(Item anEntry) {
        return (int)items.stream().filter(item -> item.equals(anEntry)).count();
    }

    @Override
    public boolean contains(Item anEntry) {
        return items.stream().anyMatch(item -> items.contains(anEntry));
    }

    @Override
    public Item[] toArray() {
        return null;
    }
    public  List<Item> getItems(){
        return new ArrayList<>(items);
    }
}
interface IBag<T> {
    /** Get the current number of entries */
    int getCurrentSize();

    /** Validate if the bag is full */
    boolean isFull();

    /** Validate if the bag is empty */
    boolean isEmpty();

    /** Add new entry to this bag */
    boolean add(T newItem);

    /** Remove one unspecified entry from this bag */
    T remove();

    /** Remove one occurrence entry from this bag */
    boolean remove(T  anEntry);

    /** Remove all entries from this bag */
    void clear(T  anEntry);

    /** Count the number of times a given entry appears in the bag */
    int getFrequencyOf(T  anEntry);

    /** Validate if this bag contains a given entry */
    boolean contains(T  anEntry);

    /** Convert to an array*/
    T[] toArray();
}