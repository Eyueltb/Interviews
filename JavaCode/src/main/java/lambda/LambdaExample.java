package lambda;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class LambdaExample {
    public static void main(String[] args) {
        Supplier<String> supplier = ()-> "Hello";
        System.out.println(supplier.get());
        Consumer<String> c = (String s)-> System.out.println(s);
        c.accept("Hej");
    }
}
