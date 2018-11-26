package com.epam.jmp.service;

import com.epam.jmp.entity.Employee;
import com.epam.jmp.entity.Position;
import com.epam.jmp.entity.Salary;
import com.epam.jmp.dataCollections.SalarySheet;
import com.epam.jmp.dataCollections.Staff;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Calendar;

@Component
@Scope("singleton")
public class SalaryService {
    private static final Logger LOGGER = Logger.getLogger(SalaryService.class);
    private static final int percentOfSalaryIncreasing = 20;
    @Autowired
    private SalarySheet salarySheet;
    @Autowired
    private Staff staff;

    public SalarySheet getSalarySheet() {
        return salarySheet;
    }

    public void setSalarySheet(SalarySheet salarySheet) {
        this.salarySheet = salarySheet;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    /*
     * Checks if salary requested by employee matching with value in salary sheet
     * If it fits then requested salary can be assigned to employee
     */
    public boolean setAppropriateSalary(Position position, Salary salary) {
        boolean result = false;
        if (salary.getSize() <= salarySheet.getSalaryToPositionMap().get(position)) {
            result = true;
        }
        return result;
    }

    /*
     * Annual salary increasing for all employee
     */
    public void increaseSalaryEveryYear() {
        for (Employee employee : staff.getEmployees()) {
            int yearOfWorkExperience = Calendar.getInstance().get(Calendar.YEAR) - employee.getYearOfEmployment();
            int increasedSize = (employee.getSalary().getSize() / 100) * (percentOfSalaryIncreasing * yearOfWorkExperience);
            employee.getSalary().setSize(employee.getSalary().getSize() + increasedSize);
            LOGGER.info("Salary of " + employee.getPosition() + " " + employee.getFirstName() + " after "
                    + yearOfWorkExperience + " years of work is " + employee.getSalary().getSize() + "$");
        }
    }
}
