package com.epam.jmp.staff;

import com.epam.jmp.department.PositionList;
import com.epam.jmp.entity.Employee;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Iterator;
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

    public void addToEmployees(Employee employee){
        this.employees.add(employee);
        this.positionList.removePosition(employee.getPosition());
        for (Employee e : employees) {
            System.out.println(e.getFirstName());
        }
    }

    public void removeFromEmployees(String firstName) {
        for (Employee e : this.employees) {
            if(e.getFirstName().equals(firstName)) {
                this.positionList.addPosition(e.getPosition());
            }
        }
        employees.removeIf(employee -> employee.getFirstName().equals(firstName));
    }
}
