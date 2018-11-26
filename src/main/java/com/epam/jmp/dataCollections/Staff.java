package com.epam.jmp.dataCollections;

import com.epam.jmp.entity.Employee;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope("singleton")
public class Staff {
    private static final Logger LOGGER = Logger.getLogger(Staff.class);
    private List<Employee> employees = new ArrayList<>();
    @Autowired
    private PositionList positionList;

    public List<Employee> getEmployees() {
        return employees;
    }

    /*
    * Adds employee to the list of employees and
    * remove occupied position from list of available positions
    */
    public void addToEmployees(Employee employee){
        this.employees.add(employee);
        this.positionList.removePosition(employee.getPosition());
        LOGGER.info("\n" + "The employee " + employee.getFirstName() + " was admitted in " + employee.getYearOfEmployment() + " year");
    }

    /*
    * Removes employee from list of employee and
    * gets back free position to list of available positions
    */
    public void removeFromStaff(String firstName) {
        for (Employee e : this.employees) {
            if(e.getFirstName().equals(firstName)) {
                this.positionList.addPosition(e.getPosition());
                LOGGER.info("Employee " + firstName + " was fired");
            }
        }
        employees.removeIf(employee -> employee.getFirstName().equals(firstName));
    }
}
