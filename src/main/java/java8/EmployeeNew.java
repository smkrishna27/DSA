package java8;

import lombok.Data;

@Data
public class EmployeeNew {
    String name, dept;


    public EmployeeNew(String name, String dept) {
        this.name = name;
        this.dept = dept;
    }
}
