package lambda;

import lombok.Data;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class AnimalMain {
    public static void main(String[] args) {

        List<Animal> animals = new ArrayList<>();

        animals.add(new Animal("fish", false, true));
        animals.add(new Animal("kangaroo", true, false));
        //forEach, removeIf, sort for list
        //animals.stream().forEach(System.out::println);
        animals.removeIf(animal -> animal.getSpecies().charAt(0)!='f'); // remove every thing that is not started with 'f'
        animals.stream().forEach(System.out::println);
        animals.sort(Comparator.comparing(Animal::getSpecies));
        System.out.println(animals.stream().anyMatch(a->a.isCanHop()));
        System.out.println(print(animals, a->a.isCanHop()));
        Person p = new Person("AA", 10);
        Person p1 = new Person("BB", 20);
        System.out.println(validate(p, person -> person.getAge() < 15));
        System.out.println(validate(p1, person -> person.getAge() < 15));
        //forEach for map
        Map<Integer, Category> categories = new HashMap<>();
        categories.put(01, new Category("Computer"));
        categories.put(02, new Category("Mobile"));
        categories.keySet().forEach(System.out::println);
        categories.values().forEach(System.out::println);


    }
    private static boolean print( List<Animal> animals, Predicate<Animal> checker) {
       for ( Animal animal: animals) {
           if (checker.test(animal))
               return true;
        }
        return false;
    }
    private static boolean check(Climb climb, int height) {
        if (climb.isTooHigh(height, 10))
            return true;
        return false;
    }
    private static boolean validate(Person person, Predicate<Person> checker) {
        if (checker.test(person))
            return true;
        return false;
    }
}

@Data
class Category {
    String name;
    public Category(String name) {
        this.name = name;
    }
}
@Data
class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

@Data
class Animal {
    private String species;
    private boolean canHop;
    private boolean canSwim;

    public Animal(String species, boolean canHop, boolean canSwim) {
        this.species = species;
        this.canHop = canHop;
        this.canSwim = canSwim;
    }
}

interface Climb {
    boolean isTooHigh(int height, int limit);
}