package oop;

import java.util.List;
import java.util.Objects;

public class DepartmentEmployeeRecord {
    public static void main(String[] args) {
        List<Employees> employees = List.of(
                new Employees(01,"AA", 8000, 20, new Department(01, "Biology")),
                new Employees(02, "BB", 10000, 30,new Department(02, "Physics")),
                new Employees(03, "CC", 8000, 40,new Department(02, "Physics"))
        );
        employees.stream().forEach(System.out::println);
        Employees emp = new Employees(04,"AA", 20000, 18, new Department(04, "Computer Science"));
        System.out.println(emp);
    }
}

/**
 * Records introduce in java 14 and are immutable data classes that require only the type and name of fields.
 * The equals, hashCode, and toString methods, as well as the private, final fields and public constructor, are generated by the Java compiler.
 * Why record? since java is to verbos to remove lot of boilerplate code we use record.
 */
record Department(int depId, String name ) {
    //constructor - declaring a no-argument constructor and one with an argument list matching the generated constructor results in a compilation error.
    public Department{
        //ensure that the name and address provided to our Person record aren't null
        Objects.requireNonNull(depId);
        Objects.requireNonNull(name);
    }
    //we can also include static variables and methods in our records.
}
record Employees(int empId, String name, double salary, int age, Department dep) {}