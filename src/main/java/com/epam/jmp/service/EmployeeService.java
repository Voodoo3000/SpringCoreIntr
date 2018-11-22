package com.epam.jmp.service;

import com.epam.jmp.entity.Employee;
import com.epam.jmp.entity.Position;
import com.epam.jmp.entity.Salary;
import com.epam.jmp.staff.Staff;
import com.epam.jmp.util.RandomYear;
import org.apache.log4j.Logger;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmployeeService {
    private static final Logger LOGGER = Logger.getLogger(EmployeeService.class);
    private PositionService positionService;
    private SalaryService salaryService;
    private Staff staff;
    private RandomYear year;

    public EmployeeService(PositionService positionService, SalaryService salaryService, Staff staff, RandomYear year) {
        this.positionService = positionService;
        this.salaryService = salaryService;
        this.staff = staff;
        this.year = year;
    }

    /*
    * Creating new employee and setting first name. Employee will be added to staff if:
    * requested position will be available and requested salary will be suitable.
    */
    public void hireEmployee(String firstName, Position position, int salarySize) {
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        Employee employee = ctx.getBean(Employee.class);
        Salary salary = ctx.getBean(Salary.class);
        employee.setFirstName(firstName);
        salary.setSize(salarySize);
        employee = positionService.setAvailablePosition(employee, position);
        if (employee.getPosition() != null) employee = salaryService.setAppropriateSalary(employee, salary);
        if (employee.getPosition() != null && employee.getSalary() != null) {
            employee.setYearOfEmployment(year.getYear());
            staff.addToEmployees(employee);
            LOGGER.info("\n" + "The employee " + employee.getFirstName() + " was admitted in " + employee.getYearOfEmployment() + " year");
        } else LOGGER.info("\n" + "The employee " + employee.getFirstName() + " was not admitted to the staff");
    }

    /*
    * Fires employee
    */
    public void fireEmployee(String firstName) {
        this.staff.removeFromStaff(firstName);
        LOGGER.info("Employee " + firstName + " was fired");
    }
}
