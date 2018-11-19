package com.epam.jmp.service;

import com.epam.jmp.entity.Employee;
import com.epam.jmp.entity.Position;
import com.epam.jmp.entity.Salary;
import com.epam.jmp.staff.Staff;
import org.apache.log4j.Logger;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmployeeService {
    private static final Logger LOGGER = Logger.getLogger(EmployeeService.class);
    private PositionService positionService;
    private SalaryService salaryService;
    private Staff staff;

    public EmployeeService(PositionService positionService, SalaryService salaryService, Staff staff) {
        this.positionService = positionService;
        this.salaryService = salaryService;
        this.staff = staff;
    }

    public void hireEmployee(String firstName, Position position, int salarySize) {
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        Employee employee = ctx.getBean(Employee.class);
        Salary salary = ctx.getBean(Salary.class);
        employee.setFirstName(firstName);
        salary.setSize(salarySize);
        employee = positionService.setAvailablePosition(employee, position);
        if (employee.getPosition() != null) employee = salaryService.setAppropriateSalary(employee, salary);
        if (employee.getPosition() != null && employee.getSalary() != null) {
            staff.addToEmployees(employee);
            LOGGER.info("The employee " + employee.getFirstName() + " was admitted");
        } else LOGGER.info("The employee " + employee.getFirstName() + " was not admitted to the staff");
    }

    public void fireEmployee(String firstName) {
        this.staff.removeFromEmployees(firstName);
    }
}
