package lnu.ds.Bags;

import lombok.AllArgsConstructor;
import lombok.Data;

public final class LinkedListBag<T>  implements IBag<T> {
    private Node<T> first;
    private int numberOFEntries;

    public LinkedListBag() {
        this.first = null;
        this.numberOFEntries = 0;
    }
    @Override
    public int getCurrentSize() {
        return numberOFEntries;
    }

    @Override
    public boolean isEmpty() {
        return numberOFEntries == 0;
    }

    @Override
    public boolean add(T newEntry) {
        Node<T> newNode  = new Node<T>(newEntry);
        newNode.setNext(first);
        newNode.next = first;
        first = newNode; //
        numberOFEntries++;
        return true;
    }
    /** Rwemove the first node from chain */
    @Override
    public T remove() {
        T result = null;
        if(first != null) {
            result = first.data;
            first = first.next; // remove first node from chain
            numberOFEntries--;
        }
        return result;
    }

    @Override
    public boolean remove(T anEntry) {
        return false;
    }

    @Override
    public void clear() {
        while(!isEmpty())
                remove();
    }

    @Override
    public int getFrequencyOf(T anEntry) {
        int count = 0;
        Node<T> newNode = first;
        boolean notFound = true;
        while(newNode.next != null && notFound) {
            if(anEntry.equals(newNode.data)){
                notFound = false;
            }
            newNode = newNode.next;
            count++;
        }
        return count;
    }

    @Override
    public boolean contains(T anEntry) {
        return false;
    }

    @Override
    public T[] toArray() {
        return null;
    }


    @Data
    private class Node<T> {
        private T data;
        private Node<T> next;

        private Node(T data) {
           this(data, null);
        }
        private Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;

        }
    }
}
