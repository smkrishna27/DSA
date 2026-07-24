package com.tesco;

import tesco.Shift;

import java.util.ArrayList;
import java.util.List;

public class EmployeePayee {

    /*the following information:
·       com.com.tesco.Employee id
·       List of shifts worked.
·       Contract Type
Each shift will have the following information:
·       com.tesco.Shift id
·       com.com.tesco.Skill
·       Total Duration

com.com.tesco.Skill Pay
com.com.tesco.Skill	Pay Rate
Bakery	£2/hour
Checkout Cashier	£1.2/hour
Customer Service	£1.3/hour
com.tesco.Shift Leader	£3/hour
Security	£1/hour
Cleaning	£1/hour
Delivery Driver	£2/hour

Contract Pay
Contract type	Pay Rate
Permanent	£12.5/hour
Agency	£14/hour
*/

    public static void main(String[] args) {
        EmployeePayee employeePayee = new EmployeePayee();
        Employee employee = new Employee();
        employee.setEmployeeId("1");
        List<Shift> shifts = new ArrayList<>();
        Shift shift = new Shift();
        shift.setSkill(Skill.BAKERY);
        shift.setShiftId(2);
        shift.setTotalDuration(4);
        Shift shift2 = new Shift();
        shift2.setSkill(Skill.BAKERY);
        shift2.setShiftId(2);
        shift2.setTotalDuration(4);
        shifts.add(shift);
        shifts.add(shift2);
        employee.setShifts(shifts);
        employee.setContactType(ContactType.PERMENANT);

        System.out.println(employeePayee.payeeEmployee(employee));

    }

    public double payeeEmployee(Employee employee) {
        if (employee == null) {
            return 0;
        }
        List<Shift> shifts = employee.getShifts();
        if (shifts == null) {
            return 0;
        }
        double totalPayee = 0;
        ContactType contactType = employee.getContactType();
        int duration = 0;

        for (Shift shift : shifts) {
            totalPayee += (shift.getTotalDuration() * shift.getSkill().getAmount());
            duration += shift.getTotalDuration();

        }
        totalPayee += contactType.getAmount() * duration;


        return totalPayee;
    }
}
