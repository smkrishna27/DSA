package java8;

import lombok.Data;

import java.util.*;
import java.util.stream.*;

@Data
class Employee {
    int empId;
    String name;
    int salary;
    String department;

    Employee(int empId, String name, int salary) {
        this.empId = empId;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{id=" + empId + ", name='" + name + "', salary=" + salary + "}";
    }
}

@Data
class Employee1 {

    String name;
    int salary;
    String department;


    public Employee1(String alice, String hr, int i) {
        this.name = alice;
        this.salary = i;
        this.department = hr;
    }
}

public class EleventhHighestSalary {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Alice", 5000),
                new Employee(2, "Bob", 7100),
                new Employee(3, "Charlie", 9000),
                new Employee(4, "David", 12000),
                new Employee(5, "Eve", 7000),
                new Employee(6, "Frank", 15000),
                new Employee(7, "Grace", 20000),
                new Employee(8, "Hank", 18000),
                new Employee(9, "Ivy", 22000),
                new Employee(10, "Jack", 25000),
                new Employee(11, "Kate", 27000),
                new Employee(12, "Leo", 30000),
                new Employee(13, "Mia", 35000)
        );

        // Find 11th highest salary
        Optional<Integer> eleventhSalary = employees.stream()
                .map(e -> e.salary)
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(10) // skip first 10
                .findFirst();

        if (eleventhSalary.isPresent()) {
            int targetSalary = eleventhSalary.get();
            List<Employee> result = employees.stream()
                    .filter(e -> e.salary == targetSalary)
                    .collect(Collectors.toList());

            System.out.println("11th Highest Salary: " + targetSalary);
            System.out.println("Employees with that salary: " + result);
        } else {
            System.out.println("Less than 11 distinct salaries available.");
        }
        System.out.println("Employees with that salary");
        employees.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).skip(10).findFirst().ifPresent(System.out::println);
        System.out.println("end");


       /* Collections.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                return Integer.compare(e2.salary, e1.salary); // descending
            }
        });*/

        employees.sort((e1, e2) -> {
            return Integer.compare(e2.salary, e1.salary); // descending
        });


       System.out.println("Employees with that salary: " + employees.get(10).salary);
       employees.stream().filter(e-> e.salary==employees.get(10).salary).forEach(System.out::println);
    }
}
