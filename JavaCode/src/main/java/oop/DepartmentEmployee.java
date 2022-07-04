package oop;


import lombok.Data;

import java.util.List;
public class DepartmentEmployee {
    public static void main(String[] args) {
       List<Employee> employees = List.of(
                new Employee(01,"AA", 8000, 20),
                new Employee(02, "BB", 10000, 30),
                new Employee(03, "CC", 8000, 40)
                );
       employees.stream().forEach(i->{
                 if(i.getAge() >= 30){
                    i.setSalary(i.getSalary() + i.getSalary()* 0.1);
                 }
        });
       employees.stream().forEach(System.out::println);
    }
}
@Data
class Employee {
    private int empId;
    private String name;
    private double salary;
    private int age;
    public Employee(int empId, String name,double salary,int age){
        this.empId = empId;
        this.name = name;
        this.salary = salary;
        this.age = age;
    }
}

