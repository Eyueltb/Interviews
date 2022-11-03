package lnu.ds.stacks;

public interface IStack<T> {

    /** Adds a newEntry to the top of the stack */
    void push(T newEntry);

    /** Removes and return this top stack's entry otherwise return null  */
    T pop();

    /** Retrieves(without removing) and return this top stack's entry otherwise return null  */
    T peek();

    /** Detect if stack is empty or not */
    boolean isEmpty();

    /** Removes all entries from this stack */
    void clear();
}
