package capgemini;

import com.sun.source.doctree.SeeTree;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringInterview {

    /**
     * Find duplicate numbers in the list/array
     */
     private static void findDuplicateNumbers(int [] nums) {
         //Java 7
         Set<Integer> uniqueNumbers = new HashSet<>();
         for (int num : nums) {
             if (!uniqueNumbers.add(num)); //if not added to set => not unique
                System.out.println(num);
         }
         //Java 8 - filter using a condition if not then display the number
         Arrays.stream(nums).filter(n -> !uniqueNumbers.add(n)).forEach(System.out::println);
     }
    /**
     * Find all the words that start and end with the same character(Use java 8)
     * Input:- "ab", "aba", "xyx", "mno", "xyz", "pop"
     * OutPut:- "aba", "xyx","pop"
     *
     */
    private static List<String> findAllWordsWithStartAndEndSameCharacters(List<String> input) {
        //get the first and last ch
        List<String> result = new ArrayList<>(); // to store the result
        input.forEach(s -> {
            if(s.charAt(0) == s.charAt(s.length() - 1)){
                result.add(s);
            }
        });
        return result;
    }
    private static void findAllWordsWithStartAndEndSameCharacters1(List<String> inputs) {
       inputs.stream()
               .filter(s->s.length() > 0 && s.endsWith(String.valueOf(s.charAt(0))))
               .forEach(System.out::println);
    }

    /**
     * Count number of 1s and number of 0s from the list
     * Input - 0, 1, 1, 0, 1, 0, 1, 1, 1, 0, 0
     * Output- 1s are 6 and 0s are 5.
     *
     */
    private static void displayNumberOfZerosAndOnes(List<Integer> numbers) {
        final Integer sum = numbers.stream().reduce(0, Integer::sum);// reduce helps to find the sum
        System.out.println("Number of 1s are "+ sum);
        System.out.println("Number of 0s are "+ (numbers.size() - sum));
    }

    /**
     *  Array of n natural numbers find the missing numbers from that array and make sure that array doesn't contain duplicate number
     */
    private static int findMissingNumber(int [] arr, int n) {
        int sum = (n * (n + 1))/2;
        int actualSum = 0;
        for(int i = 0; i < arr.length; i++) {
            actualSum = actualSum + arr[i];
        }
        return  (sum - actualSum);
    }

    private static int findMissingNumberUsingStream(int [] arr, int n) {
     return  0;
    }

    /**
     * Given a sentence and divided the sentence into two parts:-
     * The first half part should be in lower case
     * whereas the second half part should be in the lower case
     *
     */


    /**
     *  Q1- List of Employees with attributes name,age, salary
     *  Want to increase the salary of each employee by 10% with the condition where age of employee should greater than 25
     *  Solution
     *  Step 1- Create Employee class and update salary if age < 25 using stream (Use map)
     *  Q2- Group employees by city
     *  Solution- GroupBy method is available in Collectors
     *  i.e employees.stream().collect(Collectors.groupingBy(Employee::getCity));
     *  Q3- Find Highest Paid Employee From Department
     */

    private static List<Employee> incrementSalary(List<Employee> employees) {
        //stream is sequence of object, map is to modify attributes
        /* TODO- Increment the salary based on some condition */
        final List<Employee> result = employees.stream().map(e -> {
            if (e.getAge() < 25) {
                e.setSalary(e.getSalary() * 1.10); //modify the salary 10% => salary * 1.10 ?
            }
            return e;
        }).collect(Collectors.toList());
        /* TODO -Group employee by city */
        final Map<String, List<Employee>> groupEmployeeByCity = employees.stream().collect(Collectors.groupingBy(Employee::getCity));
        System.out.println(groupEmployeeByCity);
        /* TODO - Find Highest Paid Employee From Department
        *  Solution - first group by then find the highest salary
        */
        final Map<String, List<Employee>> groupEmployeeByDepartment = employees.stream().collect(Collectors.groupingBy(e -> e.getDepartment())); //Group employee by departement
        final Map<String, Employee> groupEmployeeByDepartmentAndMaxSalary = employees.stream()
                            .collect(Collectors.groupingBy(e -> e.getDepartment(), Collectors.collectingAndThen(
                                    Collectors.maxBy(Comparator.comparingDouble(e->e.getSalary())), Optional::get)));

        System.out.println(groupEmployeeByDepartmentAndMaxSalary);

        return result;
    }

    /**
     * Q-Difference between sequential and parallel stream
     * Sequential streams - 1. Generally runs in one core and one thread  2. The result is predictable
     * Parallel Streams 1. Runs in multiple core and multiple thread  2. The result is not predictable
     */
    private static void sequentialANDParallelStream(List<Integer> numbers) {
        //Sequential
        numbers.stream().forEach(n-> System.out.println("Sequential " + n + " "+ Thread.currentThread().getName()));
        //Parallel
        numbers.parallelStream().forEach(n-> System.out.println("Parallel " + n + " "+ Thread.currentThread().getName()));

    }
    /**
     *  Q- What is the difference between String Literal and String object
     *
     *  equals() method check the content whereas  == check both the content and the reference.
     */
    private static void stringLiteralsAndStringObject() {
        String str1 = "Hello"; // String literal
        String str2 = "Hello";
        String str3 = new String("Hello"); //This object is created in the heap
        String str4 = new String("hello");

        //comparing two string literal
        System.out.println(str1.equals(str2));// content comparison which is True
        System.out.println(str1 == str2);// reference comparison ->True

        //comparing string literal with string object
        System.out.println(str1.equals(str3));// content comparison which is True
        System.out.println(str1 == str3);// reference comparison -> False
        System.out.println(str1 .equals(str4));// reference comparison -> False
        System.out.println(str1 .equalsIgnoreCase(str4));// reference comparison -> True

    }

    /**
     * Add sum of array to each element in the array
     * Input-10, 20, 30, 40, 50
     * Sum = 150
     * OutPut- 160, 170, 180, 190, 200
     *
     */
    private static List<Integer> sumArrayElement(List<Integer> nums ) {
        final int sum = nums.stream().reduce(0, Integer::sum); //find sum
        return nums.stream().map(n -> n + sum).collect(Collectors.toList()); // transform array into new array
    }

    /**
     * Convert all names to upper case and separate them by ,
     * Input- "Beza", "Henok","Dawit", "Selam"
     * OutPut- BEZA, Henok,DAWIT, SELAM
     * Solution - Transform using map
     */
    private static String convertNameToUpperCase(List<String> names) {
        //convert using mao then put ", "
       return names.stream().map(n -> n.toUpperCase()).collect(Collectors.joining(", "));
    }

    /**
     * In the hospital there are different patients
     * Given Patient p1 = new Patient ("p1", 20, "Corona", 18000); Patient p2 = new Patient ("p2", 26, "Fever", 10000);
     * Patient p3 = new Patient ("p3", 35, "Corona", 20000); Patient p4 = new Patient ("p4", 24, "Fever", 17000);
     * Q1- Find list of patients that suffer corona
     * Answer = patients.stream().filter(ByCorona)
     * Q2- Find list of patients whose age is less than 25 and had corona
     * Answer = patients.stream().filter(ByCorona && ByAge)
     * Q2- Find Average Bill paid by each corona patient
     */
    private static void getInfoPatient(List<Patient> patients ){
        final Stream<Patient> coronaPatients = patients.stream().filter(p -> p.getDisease().equals("Corona"));//List of Patient suffered from Corona
        final Stream<Patient> coronaPatientsAgeLessThan25 = patients.stream().filter(p -> p.getDisease().equals("Corona") && p.getAge() < 25);// age < 25 and has corona

        //Find sum of bill, find the number of patients
        final long numberOfPatients = patients.stream().filter(p -> p.getDisease().equals("Corona")).count(); //number of patients
        final Integer totalBill = patients.stream().filter(p -> p.getDisease().equals("Corona")).map(p -> p.getAmount()).reduce(0, Integer::sum);
        System.out.println(numberOfPatients);
        System.out.println(totalBill);
        System.out.println(totalBill/numberOfPatients);

        // Find the average Bill of corona patients . The sum of the bill of each corona patient and divided by the number of corona patient
        final Double averageBillPaid = patients.stream()
                .filter(p -> p.getDisease().equals("Corona"))
                .collect(Collectors.averagingDouble(Patient::getAmount));
    }
    public static void main(String[] args) {

        List<String> strings = Arrays.asList("ab", "aba", "xyx", "mno", "xyz", "pop");
        StringInterview.findAllWordsWithStartAndEndSameCharacters(strings).stream().forEach(System.out::println);
        StringInterview.findAllWordsWithStartAndEndSameCharacters1(strings);

        List<Integer> numbers = Arrays.asList(0, 1, 1, 0, 1, 0, 1, 1, 1, 0, 0);
        displayNumberOfZerosAndOnes(numbers);
        int [] arr = new int [] {1, 2, 3, 4, 6, 7, 8, 9, 10}; // 5 is missing
        // find the sum of natural number:- example int sum = (10 + 11)/2;
        System.out.println("Missing number is " + (StringInterview.findMissingNumber(arr, 10)));

        String str = "Hello this is me This is me Hello";
        int mid = str.length()/2;
        String lowerCase = "";
        String upperCase = "";
        for (int i = 0; i < str.length() ; i++ ) {
           if( i < mid){
                lowerCase += Character.toLowerCase(str.charAt(i));
            }else {
               upperCase += Character.toUpperCase(str.charAt(i));
           }
        }
        System.out.println(lowerCase);
        System.out.println(upperCase);

        List<Employee> employees = List.of( new Employee("AA", 20, 100, "Hawasa", "CS"), new Employee("BB", 28, 200, "Addis", "CS"), new Employee("CC", 18, 800, "Hawasa", "IT"), new Employee("DD", 30, 1000, "Addis", "IT"));
        incrementSalary(employees).stream().forEach(System.out::println);
        stringLiteralsAndStringObject();

        int [] nums = {10, 20, 30, 30, 40, 50, 50 };
        findDuplicateNumbers(nums);
        sequentialANDParallelStream(Arrays.asList(1, 2, 3, 4));

        //
        List<String> names = Arrays.asList("Beza", "Henok","Dawit", "Selam");
        convertNameToUpperCase(names);

        List<Patient> patients = Arrays.asList(new Patient ("p1", 20, "Corona", 18000), new Patient ("p2", 26, "Fever", 10000), new Patient ("p3", 35, "Corona", 20000), new Patient ("p4", 24, "Fever", 17000));
        getInfoPatient(patients);
    }
}

@Data @AllArgsConstructor
class Employee {
    private String name;
    private int age;
    private double salary;
    private String city;
    private String department;
}

/**
 * Given Patient p1 = new Patient ("p1", 20, "Corona", 18000);
 */
@Data @AllArgsConstructor
class Patient {
    private String name;
    private int age;
    private String disease;
    private int amount;

}
