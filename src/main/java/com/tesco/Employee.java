package com.tesco;

import lombok.Data;
import tesco.Shift;

import java.util.List;

@Data
public class Employee {
private String employeeId;
private List<Shift> shifts;
private ContactType contactType;


}
