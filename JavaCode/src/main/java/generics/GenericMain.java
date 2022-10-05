package generics;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

/**
 *  Generic- enables types(class, interface) to be parameters when defining classes, interfaces, and methods.
 *  A generic type is a generic class or interface that are parameterized over types.
 *  Advantage
 *  1. Strong type check at compile time.
 *  2. Eliminating casting.
 *  3. Helps us to implement generic algorithms.
 *  Generic method - are methods that introduce their own type parameters.
 *  Row type- The name of generic class or interface without any type arguments.
 */
public class GenericMain {
    public static void main(String[] args) {
        Box<Integer> IB1 = new Box<>();
        Box<String> IB2 = new Box<>();
        Box b1 = IB1; // row type- in legacy code before java(JDK) 5.0 and Generic type to row type is ok
        b1.set(8);
        b1.set(IB2);
        OrderPair<String, Integer> p1 = new OrderPair<>("I", 1);
        OrderPair<String, Integer> p2 = new OrderPair<>("V", 5);
        OrderPair<String, Box<Integer>> p3 = new OrderPair<>("primes", new Box<>());
        OrderPair<Integer, Character> p4 = new OrderPair<>(8, 'a');//ok
        // OrderPair<int, char> p5 = new OrderPair<>(8, 'a');//compile error - can't instantiate generic type with primitive types.
    }
}
/** Generic Version of Box class- Single parameter type */
class Box<T> {
    private T t;
    public void set(T t){ this.t = t; }
    public T getT() { return t; }
}

/** Multiple parameter type */
interface Pair<K, V> {
    K getKey();
    V getValue();
}

class OrderPair<K,V> implements Pair<K,V>{
    private K key;
    private V value;

    public OrderPair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }
    public static <K, V> boolean compare(Pair<K,V> p1, Pair<K,V> p2) {
        return p1.getKey().equals(p2.getKey()) && p1.getValue().equals(p2.getValue());
    }
}

interface IArithmetic<T> {
    T sum(T x, T y);
    T product(T x, T y);
    T min(T x, T y);
    T max(T x, T y);
}

class Arithmetic<T extends Comparable<T>> implements IArithmetic<T>{
    private T first;
    private T second;
    @Override
    public T sum(T x, T y) {
        return null;
    }

    @Override
    public T product(T x, T y) {
        return null;
    }

    @Override
    public T min(T x, T y) {
       return  (x.compareTo(y) > 0) ? y : x;
    }

    @Override
    public T max(T x, T y) {
        return  (x.compareTo(y) > 0) ? x : y;
    }
}

/**
 * 1. Write a generic method to count the number of elements in the collection that have a specific
 *      property(ex, odd integer, prime numbers, palindromes)
 * 2. Write a generic method to exchange the position of two different elements in the array
 * 3. Write a generic method to find the maximum element in the range [begin, end] o fa list
 */

final class Algorithm {

    public static void main(String[] args) {
        Integer [] array = {3, 1, 5, 7, 2, 9};
        System.out.println(Algorithm.countGreaterThan(new Integer [] {3, 1, 5, 7, 2, 9}, 3));
        Arrays.stream(Algorithm.swap(array, 1, 3)).forEach(System.out::print);

    }
    /** 1. Write a generic method to count elements in array which is greater than the given element */
    public static<T extends Comparable<T>> int countGreaterThan(T [] array, T elem) {
        int count = 0;
        for(T e : array){
            if(e.compareTo(elem) > 0)
                ++count;
        }
        return count;
    }

    /** 2. Write a generic method to count number of occurrence of element in the array*/
    public static<T > int count(T [] array, T elem) {
        int count = 0;
        for(T e : array){
            if(e.equals(elem))
                ++count;
        }
        return count;
    }
    /** 3.Write a generic method to count the number of elements in a collection
     *  that have a specific property (for example, odd integers, prime numbers, palindromes)
     */
    public static <T> int countIf(Collection<T> c, Predicate<T> p) {
        int count = 0;
        for (T elem : c)
            if (p.test(elem))
                ++count;
        return count;
    }
    /** 4. Write a generic method to exchange the positions of two different elements in an array. */
    public static <T> T[] swap(T[] a, int i, int j) {
        T temp = a[i];
        a[i] = a[j];
        a[j] = temp;
        return a;
    }
    /** 5. Write a generic method to find the maximal element in the range [begin, end) of a list. */
    public static <T extends Object & Comparable<? super T>> T max(List<? extends T> list, int begin, int end) {
        T maxElem = list.get(begin);
        for (++begin; begin < end; ++begin)
            if (maxElem.compareTo(list.get(begin)) < 0)
                maxElem = list.get(begin);
        return maxElem;
    }
}

interface UnaryPredicate<T> {
    public boolean test(T obj);
}

class Node<T extends Comparable<T>> {
    private T data;
    private Node<T> next;

    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
}