package oop;

import lombok.Data;

import java.util.Arrays;
import java.util.stream.Stream;

public class OnlineShopper {
    public static final void main(String ... args) {
        Item [] items = {
                new Item ("Item 1", 1340),
                new Item ("Item 2", 1000),
                new Item ("Item 3", 1110),
                new Item ("Item 4", 14540),
        };
        IBag<Item> shoppingCart = new ArrayBag<>();
        final int[] totalCost = {0};

        Arrays.stream(items).forEach(item -> {
            shoppingCart.add(item);
            totalCost[0] += item.getPrice();
        });
        System.out.println("total cost " + totalCost[0]);
        shoppingCart.toStream().forEach(System.out::println);
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

/** Array implementation */
class ArrayBag<T> implements  IBag<T>{
    private T[] bag;
    private static final int DEFAULT_CAPACITY = 20;
    private int count ;

    public ArrayBag(){
        this(DEFAULT_CAPACITY);
    }
    public ArrayBag(int capacity){
        count = 0;
        this.bag = (T[]) new Object[capacity];
    }
    @Override
    public int getCurrentSize() {
        return count;
    }

    @Override
    public boolean isFull() {
        return count == bag.length;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public boolean add(T newItem) {
       ensureCapacity();
       bag[count++] = newItem;
       return true;
    }

    @Override
    public T remove() {
        T result = null;
        if(count > 0)
        {
            result = bag[count -1];
            bag[count -1] = null;
            count --;
        }
        return result;
    }

    @Override
    public boolean remove(T anEntry) {
        int index = getIndexOf(anEntry);
        T result = removeEntry(index);
       return anEntry.equals(result);
    }

    @Override
    public void clear() {
        count = 0;
    }


    @Override
    public int getFrequencyOf(T anEntry) {
        return (int)Arrays.stream(bag).filter(item -> item.equals(anEntry)).count();
    }

    @Override
    public boolean contains(T anEntry) {
        return getFrequencyOf(anEntry) > 0; //getIndexOf(anEntry) > -1;
    }

    @Override
    public T[] toArray() {
        return bag;
    }
    public Stream<T> toStream(){
        //ToDo- Need to be modified- loop until count IntStream.range(0, count)
      return Arrays.stream(bag);
    }
    private void ensureCapacity(){
        if(count == bag.length)
            bag = Arrays.copyOf(bag, 2* bag.length);
    }
    private int getIndexOf(T anEntry){
      boolean stillLooking = true;
      int index = -1;
      for(int i = 0; stillLooking && (i < count); i++){
          if(anEntry.equals(bag[i])){
              stillLooking = false;
              index = i;
          }
      }
      return index;
    }
    private T removeEntry(int givenIndex){
        T result = null;
        if(!isEmpty() && (givenIndex >= 0)){
            result = bag[givenIndex];
            count --;
            bag[givenIndex] = bag[count]; //replace with last entry
            bag[count] = null; //remove last entry
        }
        return result;
    }
}

/** Array implementation */

class LinkedBag<T> implements IBag<T>{

    @Override
    public int getCurrentSize() {
        return 0;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean add(T newItem) {
        return false;
    }

    @Override
    public T remove() {
        return null;
    }

    @Override
    public boolean remove(T anEntry) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public int getFrequencyOf(T anEntry) {
        return 0;
    }

    @Override
    public boolean contains(T anEntry) {
        return false;
    }

    @Override
    public T[] toArray() {
        return null;
    }

    @Override
    public Stream<T> toStream() {
        return null;
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
    void clear();

    /** Count the number of times a given entry appears in the bag */
    int getFrequencyOf(T  anEntry);

    /** Validate if this bag contains a given entry */
    boolean contains(T  anEntry);

    /** Convert to an array*/
    T[] toArray();
    /** Convert to stream*/
    Stream<T> toStream();

}