package lambda;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

import java.awt.*;
import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Factory- is an object able to create another objects
 *        - It can be modeled by Supplier
 * A singleton is a class that have one single instance.
 * Registory is doing the same thing as Factory - But adding elements dynamically to Registory is achieved using a Builder pattern.
 * 1. Add elements to registory
 * 2. Build the registory and seal it. See Stream. Builder API
 */
public class FunctionalInterfaceMain {

    public static void main(String[] args) {

        Stream.Builder<String> builder = Stream.builder();
        builder.add("One");
        builder.add("TWO");
        builder.add("THREE");
        Stream<String> stream = builder.build();
        stream.forEach(System.out::println);
        Consumer<String> c1 = s -> System.out.println("C1 = " + s);
        Consumer<String> c2 = s -> System.out.println("C2 = " + s);
        Consumer<String>c3 = c1.andThen(c2); //chaining consumer- possible by using default method
        c3.accept("Hello");
           /*Consumer<String> c3 = S -> {
          c1.accept(S);
          c2.accept(S);
        };
        c3.accept("Hello");*/
       /* Consumer<String> c4 = c1.andThen(null); //chaining consumer- passing null
        c4.accept("Hello");*/

        Predicate<String> s1 = s-> s != null;
        Predicate<String> s2 = s-> !s.isEmpty();
        Predicate<String> notP2 = s2.negate();
        Predicate<String> p3 = s1.and(s2);
        System.out.println("Test for non empty = " + p3.test("java"));
        System.out.println("Test for empty = " + p3.test(""));
        System.out.println("Test for null = " + p3.test(null));

        Temperature temp = new Temperature(10);
        Function<Temperature, Integer> readCelsius = t-> t.getTemperature();
        Function<Integer, Double> celsiusToFahrenheit = t-> t * 9d/5d + 32d;
        Function<Temperature, Double> readFahrenheit = readCelsius.andThen(celsiusToFahrenheit);


        //Function composition
        readFahrenheit = celsiusToFahrenheit.compose(readCelsius);
        System.out.println("Temperature is F " + readFahrenheit.apply(temp));
        //Identity function
        Function<String , String> identity = Function.identity();

        //Compare person with name then age by creating your own comparator interface
        Persons beti = new Persons("Beti", 27);
        Persons dani = new Persons("Dani", 30);
        Persons mel = new Persons("Melat", 32);
        Persons jef = new Persons("Jef", 35);
        Persons zed = new Persons("Zed", 35);

        Comparator<Persons> compName = (p1, p2) -> {
            final String name1 = p1.getName();
            final String name2 = p2.getName();
            return name1.compareTo(name2);
        };
        System.out.println("" + (compName.compare(beti, dani) > 0));
        System.out.println("" + (compName.compare(jef, mel) <= 0));
        System.out.println("" + (compName.compare(zed, mel) == 0));

        Function<Persons, String> getName = p -> p.getName();
        Function<Persons, Integer> getAge = p -> p.getAge();
        Comparator<Persons> compNameReversed = compName.reversed();
        System.out.println("" + (compNameReversed.compare(beti, dani) > 0));

        /*Comparator<Persons> cmpName = Comparator.comparing(Persons::getName);
        Comparator<Persons> cmpAge = Comparator.comparing(Persons::getAge);

        Comparator<Persons> cmp = Comparator.comparing(Persons::getName)
                                        .thenComparing(getAge);
        System.out.println("" + (cmp.compare(beti, dani) > 0));
        System.out.println("" + (cmp.compare(jef, mel) <= 0));*/

        Comparator<Persons> cmp1 = Comparator.comparing(Persons::getName)
                                        .thenComparing(Persons::getAge);
        System.out.println("" + (cmp1.compare(beti, dani) > 0));
        System.out.println("" + (cmp1.compare(jef, mel) <= 0));


        //Simulating Factory design pattern
        Factory<Circle> factory = ()-> new Circle();
        Circle circle = factory.newInstance();
        System.out.println("Circle []" + circle);
        List<Circle> list  = factory.creat5();
        System.out.println("List = "+ list);

        final Factory<Circle> factory1 = Factory.createFactory(Circle::new);
        final Factory<Circle> factory2 = Factory.createFactory(Color.RED);
        final Factory<Circle> factory3 = Factory.createFactory(Circle::new, Color.RED); //color -> new Circle(color)

        //Registory
        SwitchRegistry registry = new SwitchRegistry();
        Factory<Rectangle> rectangleFactory = (Factory<Rectangle>) registry.buildShapeFactory("rectangle");
        System.out.println("Rectangle : "+ rectangleFactory.newInstance());
    }

}

@FunctionalInterface
interface Consumer<T> {
    void accept(T t);
    //Default method is a concrete method for backward compatability and helped to chain lambdas
    default Consumer<T> andThen(@NonNull Consumer<T> other) {
        //return instance of a functional interface-because consumer is a functional interface
        Objects.requireNonNull(other); // To protect null pointer Exception
        return (T t) -> {
            this.accept(t);
            other.accept(t);
        };
    }
}

@FunctionalInterface
interface Predicate<T> {
    boolean test(T t);
    default Predicate<T> and(@NonNull Predicate<T> other){
        Objects.requireNonNull(other);
        return (T t)-> this.test(t) && other.test(t);
    }

    default  Predicate<T> negate() {
        return (T t) -> !this.test(t);
    }
}

@FunctionalInterface
interface Function<T, R>  {
    R apply(T t);

    default <V> Function<T, V> andThen(Function<R, V> other) {
        Objects.requireNonNull(other);
        return (T t) -> {
            R r = this.apply(t);
            return other.apply(r);
        };
    };

    default <V> Function<V, R> compose(@NonNull Function<V, T> other) {
        Objects.requireNonNull(other);
        return (V v) -> {
            T t = other.apply(v);
            return this.apply(t);
        };
    };

    static <T> Function<T, T> identity(){
        return t->t;
    };
}

@FunctionalInterface
interface Comparator<T> {
    int compare(T t1, T t2);

    default  Comparator<T> reversed() {
        return (t1,t2)-> this.compare(t2,t1);
    }

    default <U extends Comparable<U>> Comparator<T>  thenComparing(Function<T, U> keyExtractor) {
        Objects.requireNonNull(keyExtractor);
        return (c1, c2) -> keyExtractor.apply(c1).compareTo(keyExtractor.apply(c2));
    }

    default Comparator<T>  thenComparing(Comparator<T> other) {
        Objects.requireNonNull(other);
        return (T t1, T t2)-> {
            final int compare = this.compare(t1, t2);
            if(compare == 0) {
                return other.compare(t1,t2);
            } else {
                return compare;
            }
        };
    }

    static <T, U extends Comparable<U> > Comparator<T> comparing(Function<T, U> keyExtracted) {
        Objects.requireNonNull(keyExtracted);
        /*return (p1, p2) -> {
            final U s1 = keyExtracted.apply(p1);
            final U s2 = keyExtracted.apply(p2);
            return s1.compareTo(s2);

        };*/
        return (c1, c2) -> keyExtracted.apply(c1).compareTo(keyExtracted.apply(c2));
    }
}

@FunctionalInterface
interface Factory<T> extends Supplier<T> {

    default T newInstance() {
        return get(); // call the supper method
    }

    default List<T>  creat5(){
        return IntStream.range(0, 5).mapToObj(index->newInstance()).collect(Collectors.toList());
    }

    /*static Factory<Circle> createFactory(){
        return () -> new Circle();
    }*/
    /* To make the above generic */
    static <T> Factory<T> createFactory(Supplier<T> supplier) {
        /* to return singleton */
        T singleton = supplier.get();
        return (Factory<T>) singleton;
        //return () -> supplier.get(); // return different instance every time it's called
    }

    static Factory<Circle> createFactory(Color color) {
        Function<Color, Circle> constructor = c -> new Circle();
        return () -> constructor.apply(color);
        //return () -> new Circle(color);
    }
    static Factory<Circle> createFactory(Function<Color, Circle> constructor, Color color) {
         return () -> constructor.apply(color);
    }
    static <T, U> Factory<T> createFactory1(Function<U, T> constructor, U color) {
        return () -> constructor.apply(color);
    }
}

@Data @AllArgsConstructor
class Temperature {
    private int temperature;
}

@Data @AllArgsConstructor
class Persons {
    private String name;
    private int age;

}

@Data
class Circle {

    private Color color;

    public Circle(){
        this.color = color;
    }
    public Circle(Color color){
        this.color = color;
    }
    @Override
    public String toString() { return  "Circle []" ;}


}

enum Color {
    WHITE, RED, YELLOW;
}

interface Shape {

}

class Square implements Shape {
    @Override
    public String toString() { return  "Square []" ;}
}

class Triangle implements Shape {
    @Override
    public String toString() { return  "Triangle []" ;}
}

class Rectangle implements Shape {
    @Override
    public String toString() { return  "Rectangle []" ;}
}

class SwitchRegistry {

    Factory<? extends Shape> buildShapeFactory(String shape) {
        switch (shape) {
            case "square" : return () -> new Square();
            case "triangle" : return () -> new Triangle();
            case "rectangle" : return () -> new Rectangle();
            default:
                throw new IllegalArgumentException("Unknown shape "+ shape);
        }
    }
}
