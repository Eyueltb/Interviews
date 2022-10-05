package collections;

import java.util.*;

/**
 * ArrayList is an object that contain other object.
 * Array- is built-in data structure that contains primitives or other objects.
 */
public class ArrayListMain {

    public static void main(String[] args) {
        /**arrayListToArrayAndViseVersa();
        * searchAndSortArrayOchArrayList();
        * autoBoxingAndUnboxing();
        * diamondOperator();
        */
        ArrayListMain main = new ArrayListMain();
        main.genericClassDemoWithOneParameter();
        main.genericClassDemoWithTwoParameter();
    }

    private static void arrayListToArrayAndViseVersa() {
        /**
         *  Case1 - from ArrayList to Array
         */
        List<String> list = new ArrayList<>();
        list.add("One");
        list.add("Two");
        String [] array = new String[list.size()];
        System.out.println(array.length);
        System.out.println(list.size());
        array[1] = list.get(0);
        array[0] = list.get(1);
        Arrays.asList(array).stream().forEach(System.out::println);
        list.stream().forEach(System.out::println);
        list.add("Three");
        list.add("Four");
        System.out.println("...");
        Arrays.asList(array).stream().forEach(System.out::println);
        list.stream().forEach(System.out::println);
        //array[2] = list.get(2); // Error since array has fixed length
        //Arrays.asList(array).stream().forEach(System.out::println);
        /**
         *  Case2 - from Array to ArrayList
         *  They refer the same memory
         */
        String[] array1 = {"Ett","Två"};
        List<String> list1 = Arrays.asList(array1); // asList(array1) has features not being resizable
        System.out.println("...");
        list1.stream().forEach(System.out::println);
        list1.set(1, "fyra"); //changes are reflected in both.
        list1.stream().forEach(System.out::println); //Ett, fyra
        Arrays.stream(array1).forEach(System.out::println); // Ett, fyra
        array1[0]= "Nytt-Ett";
        list1.stream().forEach(System.out::println); //Nytt-Ett, fyra
        Arrays.stream(array1).forEach(System.out::println); // Nytt-Ett, fyra
        list1.add("New-Data"); // UnsupportedOperationException- Not possible to add more data to the list.
        list1.add("Other-new");
        System.out.println("List1 output");
        list1.stream().forEach(System.out::println);
        String[] array2 = array1; //ok

        System.out.println("...");
        Arrays.stream(array2).forEach(System.out::println); // Nytt-Ett, fyra
        System.out.println("...");
        list1.remove(0); // Throws UnsupportedOperationException
        Arrays.stream(array1).forEach(System.out::println); //
        list1.stream().forEach(System.out::println); //
        System.out.println("...");
        list1.remove(1); // Throws UnsupportedOperationException
        Arrays.stream(array1).forEach(System.out::println); //
        list1.stream().forEach(System.out::println); //
        System.out.println("...");
        String [] array3 = (String[]) list1.toArray(); //
        Arrays.stream(array3).forEach(System.out::println); //
    }

    private static void searchAndSortArrayOchArrayList(){
        int [] numbers = {6,9,1,8};
        Arrays.sort(numbers); //[1,6,8,9]
        System.out.println(Arrays.binarySearch(numbers, 1));//0 - return the position
        System.out.println(Arrays.binarySearch(numbers, 7));//-2 because -position(index position of number) -1 = -2-(1)=-3
        List<Integer> list = Arrays.asList(9,7,5,3);
        Collections.sort(list); //[3,5,7,9]
        System.out.println(Collections.binarySearch(list, 5)); //1
        System.out.println(Collections.binarySearch(list, 8)); // -4 because (-)position -1 = -3 -1 =-4
    }

    /**
     * Wrapper class- The object representation of primitive type
     * Autoboxing- automatically converts primitive to the corresponding wrapper class
     * Unboxing - automatically converts wrapper class back to primitive
     */
    private static void autoBoxingAndUnboxing(){
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);// Autoboxing- primitive to Wrapper class.
        numbers.add(2);
        numbers.add(6);
        numbers.add(5);
        int num = numbers.get(3); // unboxing - Wrapper to primitive
        //numbers.add(new Integer(3)); // @Deprecated(since="9", forRemoval = true)
        /**
         * Remark- remove(index) or remove(object) but priority is given to the index
         * No need to do autoboxing to remove object instead of index
         * If we want to remove object we need to apply autoboxing.
         */
        numbers.remove(1); // [1,6,5] which is after removed index 1 which is 2.
        numbers.stream().forEach(System.out::println);
        numbers.remove(new Integer(6)); // 1 which is after removed index 1 which is 2.
        numbers.stream().forEach(System.out::println); // [1,5]

    }

    private static void diamondOperator(){
        List names = new ArrayList(); // Before Java 5
        List<String> names1 = new ArrayList<String>(); // Java 5
        List<String> names2 = new ArrayList<>(); // After Java 7
        HashMap<String, HashMap<String,String>> map1 = new HashMap<String, HashMap<String,String>>(); //Java 5
        HashMap<String, HashMap<String,String>> map2 = new HashMap<>(); // After Java 7

        names.add(new StringBuilder("Hello")); // ok- to put stringBuilder to list
        names.stream().forEach(System.out::println);
        System.out.println(names.get(0));
        System.out.println((String) names.get(0)); // ClassCastException- from StringBuilder to String because names.get(0) is StringBuilder
        //names2.add(new StringBuilder("Hello")); // Does not compile because- StringBuilder can't be added to String because both are different object


    }

    private void genericClassDemoWithOneParameter(){
        CreateWithOneParameter<Dog> dog = new CreateWithOneParameter<>();
        dog.setContent(new Dog("Dog"));
        System.out.println(dog.getContent().getName());
        CreateWithOneParameter<Cat> cat = new CreateWithOneParameter<>();
        cat.setContent(new Cat("cat"));
        System.out.println(cat.getContent().getName() );
    }
    private void genericClassDemoWithTwoParameter(){
        CreateWithTwoParameter<Dog, Integer> dog = new CreateWithTwoParameter<>();
        dog.setContent(new Dog("Dog"), 100);
        System.out.println(dog.getContent().getName() + "," + dog.getSize().toString());
        Cat cat1 = new Cat("MyCat");
        Integer size1 = 200;
        CreateWithTwoParameter<Cat, Integer> cat = new CreateWithTwoParameter<>(cat1,size1);
        System.out.println(cat.content.name + "," + cat.size);
    }

    /**
     *  E for element
     *  K for a map key
     *  V for a map value
     *  N for a number
     *  T for generic data type
     *  S,U,V and so forth for multiple generic type.
     */
    public class CreateWithOneParameter<T> {
        private T content;
        private T getContent(){ return content ;}
        private void setContent(T content) {
            this.content = content;
        }
    }
    public class CreateWithTwoParameter<T, U> {
        private T content;
        private U size;
        public CreateWithTwoParameter(){}
        public CreateWithTwoParameter(T content , U size){
            this.content = content;
            this.size = size;
        }
        private T getContent(){ return content; }
        private U getSize(){ return size; }
        private void setContent(T content, U size) {
            this.content = content;
            this.size = size;
        }
    }
    abstract class Animal {
        String name;
        public Animal(String name){this.name = name;}
        public String getName(){ return  name; }

    }
    class Dog extends Animal{
        public Dog(String name){super(name);}
    }
    class Cat extends Animal{
        public Cat(String name){super(name);}
    }
}

