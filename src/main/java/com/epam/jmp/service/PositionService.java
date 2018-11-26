package com.epam.jmp.service;

import com.epam.jmp.dataCollections.PositionList;

import com.epam.jmp.entity.Position;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class PositionService {
    private static final Logger LOGGER = Logger.getLogger(PositionService.class);

    @Autowired
    private PositionList positionList;

    public PositionService(PositionList positionList) {
        this.positionList = positionList;
    }

    /*
     * Checks if requested position is available, if yes then set it to employee
     */
    public boolean setAvailablePosition(Position position) {
        boolean result = false;
        if (positionList.getPositions().contains(position)) {
            result = true;
        }
        return result;
    }
}
