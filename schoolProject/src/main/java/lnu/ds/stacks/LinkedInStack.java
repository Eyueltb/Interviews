package lnu.ds.stacks;

import lombok.AllArgsConstructor;
import lombok.Data;

final public class LinkedInStack<T>  implements IStack<T> {
    private Node<T> top;
    private int numberOFEntries;
    @Override
    public void push(Object newEntry) {

    }

    @Override
    public T pop() {
        return null;
    }

    @Override
    public T peek() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void clear() {

    }


    @Data @AllArgsConstructor
    private class Node<T> {
        private T data;
        private Node<T> next;

    }
}
