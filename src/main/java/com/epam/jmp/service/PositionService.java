package com.epam.jmp.service;

import com.epam.jmp.department.PositionList;
import com.epam.jmp.entity.Employee;
import com.epam.jmp.entity.Position;
import org.apache.log4j.Logger;

public class PositionService {

    private static final Logger LOGGER = Logger.getLogger(PositionService.class);

    private PositionList positionList;

    public PositionService(PositionList positionList) {
        this.positionList = positionList;
    }

    public Employee setAvailablePosition(Employee employee, Position position) {
        System.out.println(positionList.getPositions().size());
        if (positionList.getPositions().contains(position)) {
            employee.setPosition(position);
            LOGGER.info(position.toString() + " was assigned to new employee " + employee.getFirstName());
        } else LOGGER.info(position + " is occupied");
        return employee;
    }
}
