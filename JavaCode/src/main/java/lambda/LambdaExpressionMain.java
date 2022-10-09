package lambda;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * A lambda Expression is an implementation for a functional Interface
 * Lambda Expression implements a Functional Interface.
 * A Functional Interface-> are interface that has only one abstract method(Default & static methods don't count)
 *
 */

/**
 * interface Supplier {  T get(); } -> doesn't accept any argument but produce any kind of object that match
 * Steps to implement functional Interface
 *  1. Copy/past block of parameter i.e ()
 *  2. Add arrow i.e () ->
 *  3. Provide the implementation i.e () -> "Hello";
 *
 *  interface Consumer{ void accept(T t); } -> consumes any kind of object.
 *  interface Predicate<T> { boolean test(T t); } -> Take any kind of object and do testing on it and return boolean
 *  Predicate is used in the filtering operation of stream API -> predicate is for filtering
 *  interface Function<T, R> { R apply(T t); } -> Function takes an object and returns another object
 *  Function -> It's important since it's used in the map operator
 *  Predicate is for filtering and Function is for mapping.
 *  Q- Why @FunctionalInterface is not mandatory -> Had it been mandatory the Runnable interface wouldn't be a functional Interface
 *
 *  Summery
 *  Supplier<T>         T get()                  ()-> "Hello";
 *  Consumer<T>         void accept(T t)         ()->System.out.println(s)'
 *  Predicate<T>        boolean test(T t)        s-> s.isEmpty();
 *  Function<T, R>      R apply(T t)             u-> u.getName();
 */
public class LambdaExpressionMain {

    public static void main(String[] args) {


        Supplier<String> supplier = () -> "Hello";
        System.out.println(supplier.get());
        Consumer<String> consumer = t -> System.out.println(t);
        consumer.accept("hello 1");

        /** When we have a block of code */
        Consumer<String> consumer1 = (String s) -> {
            System.out.println("I'm inside the consumer");
            System.out.println(s);
        };
        consumer1.accept("New Hello");

        Supplier<String> supplier1 = () -> {
            System.out.println("Inside supplier");
            return "Hello";
        };
        System.out.println(supplier1.get());

        Predicate<String> isEmpty = s-> s.isEmpty();

        List<String>  strings = new ArrayList<>(List.of("One", "Two", "Three"));

      /*  Predicate<String> filter = s -> s.startsWith("t");
        strings.removeIf(filter);
        Consumer<String> action = s -> System.out.println(s);
        strings.forEach(action);*/
        strings.removeIf(s -> !s.startsWith("t"));
        strings.forEach(System.out::println); //s-> System.out.println(s)

        User jeff = new User ("Jeff");
        User beti = new User ("Beti");
        User dani = new User ("Dani");
        User liya = new User ("Liya");

        List<User> users = List.of(jeff, beti, dani, liya);
        //Mapping   a class to the list of names -> To model mapping we need Functional
        List<String> names = new ArrayList<>();

        Function<User, String> toName = user -> user.getName();
        for (User user: users) {
            String name = toName.apply(user);
            names.add(name);
        }
        users.forEach(System.out::println);
        names.forEach(System.out::println);

        IntSupplier supplier2 = () -> 10;
        System.out.println("i ="+ supplier2.getAsInt());
        DoubleToIntFunction func1 = value -> (int) Math.floor(value);
        System.out.println(func1.applyAsInt(Math.PI));

        
    }

}

@Data
@AllArgsConstructor
class User {
    private String name;
}
