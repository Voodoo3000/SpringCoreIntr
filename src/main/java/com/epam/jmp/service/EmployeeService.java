package com.epam.jmp.service;

import com.epam.jmp.entity.Employee;
import com.epam.jmp.entity.Position;
import com.epam.jmp.entity.Salary;
import com.epam.jmp.dataCollections.Staff;
import com.epam.jmp.util.RandomYear;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class EmployeeService {
    private static final Logger LOGGER = Logger.getLogger(EmployeeService.class);
    @Autowired
    private PositionService positionService;
    @Autowired
    private SalaryService salaryService;
    @Autowired
    private Staff staff;
    @Autowired
    private RandomYear year;

    /*
     * Creating new employee and setting first name. Employee will be added to staff if:
     * requested position will be available and requested salary will be suitable.
     */
    public void hireEmployee(String firstName, Position position, int salarySize) {
        Employee employee = new Employee();
        Salary salary = new Salary();
        employee.setFirstName(firstName);
        salary.setSize(salarySize);
        if (positionService.setAvailablePosition(position)) {
            employee.setPosition(position);
            LOGGER.info("Position " + position + " was assigned to employee " + firstName);
        } else LOGGER.info("Position " + position + " which was requested by" + firstName + "is occupied");
        if (salaryService.setAppropriateSalary(position, salary)) {
            employee.setSalary(salary);
            LOGGER.info("Salary amount of: " + salarySize + " was assigned to employee " + firstName);
        } else LOGGER.info("Employee " + firstName + " requested inappropriate salary amount");
        if (employee.getPosition() != null && employee.getSalary() != null) {
            employee.setYearOfEmployment(year.getYear());
            staff.addToEmployees(employee);
        } else LOGGER.info("\n" + "The employee " + employee.getFirstName() + " was not admitted to the staff");
    }

    /*
     * Fires employee
     */
    public void fireEmployee(String firstName) {
        this.staff.removeFromStaff(firstName);
    }
}
