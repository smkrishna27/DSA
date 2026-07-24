package java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class GroupByDept {

    public static void main(String[] args) {
        List<EmployeeNew> employees = Arrays.asList(
                new EmployeeNew("Ravi", "IT"),
                new EmployeeNew("Anu", "HR"),
                new EmployeeNew("Sam", "IT")
        );

        System.out.println(employees.stream().collect(groupingBy(EmployeeNew::getDept)));

    }
}
