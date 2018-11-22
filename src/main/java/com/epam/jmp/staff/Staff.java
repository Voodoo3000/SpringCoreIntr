package com.epam.jmp.staff;

import com.epam.jmp.department.PositionList;
import com.epam.jmp.entity.Employee;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Staff {
    private static final Logger LOGGER = Logger.getLogger(Staff.class);
    private List<Employee> employees = new ArrayList<>();
    private PositionList positionList;

    public List<Employee> getEmployees() {
        return employees;
    }

    public PositionList getPositionList() {
        return positionList;
    }

    public void setPositionList(PositionList positionList) {
        this.positionList = positionList;
    }

    /*
    * Adds employee to the list of employees and
    * remove occupied position from list of available positions
    */
    public void addToEmployees(Employee employee){
        this.employees.add(employee);
        this.positionList.removePosition(employee.getPosition());
    }

    /*
    * Removes employee from list of employee and
    * gets back free position to list of available positions
    */
    public void removeFromStaff(String firstName) {
        for (Employee e : this.employees) {
            if(e.getFirstName().equals(firstName)) {
                this.positionList.addPosition(e.getPosition());
            }
        }
        employees.removeIf(employee -> employee.getFirstName().equals(firstName));
    }
}
