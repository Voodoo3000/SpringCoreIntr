package com.epam.jmp.service;

import com.epam.jmp.entity.Employee;
import com.epam.jmp.entity.Salary;
import com.epam.jmp.salarySheet.SalarySheet;
import org.apache.log4j.Logger;

public class SalaryService {

    private static final Logger LOGGER = Logger.getLogger(SalaryService.class);

    private SalarySheet salarySheet;

    public SalarySheet getSalarySheet() {
        return salarySheet;
    }

    public void setSalarySheet(SalarySheet salarySheet) {
        this.salarySheet = salarySheet;
    }

    public Employee setAppropriateSalary(Employee employee, Salary salary) {
        if (salary.getSize() <= salarySheet.getSalaryToPositionMap().get(employee.getPosition())) {
            employee.setSalary(salary);
        } else LOGGER.info("Employee " + employee.getFirstName() + " requested inappropriate salary");
        return employee;
    }

}
