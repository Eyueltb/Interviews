package lambda;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

import java.util.Comparator;
import java.util.Objects;

public class FunctionalInterfaceMain {

    public static void main(String[] args) {
        java.util.Comparator<String> f ;
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

        IComparator<Persons> compName = (p1, p2) -> {
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

        Comparator<Persons> cmpName = Comparator.comparing(Persons::getName);
        Comparator<Persons> cmpAge = Comparator.comparing(Persons::getAge);

        Comparator<Persons> cmp = cmpName.thenComparing(cmpAge);

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
interface IComparator<T> {
    int compare(T t1, T t2);

    default  Comparator<T> reversed() {
        return (t1,t2)-> this.compare(t2,t1);
    }

    static <T, U extends Comparable<U> > Comparator<T> comparing(Function<T, U> keyExtracted) {
        Objects.requireNonNull(keyExtracted);
        return (p1, p2) -> {
            final U s1 = keyExtracted.apply(p1);
            final U s2 = keyExtracted.apply(p2);
            return s1.compareTo(s2);

        };
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
