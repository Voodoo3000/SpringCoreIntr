package com.epam.jmp.dataCollections;

import com.epam.jmp.entity.Position;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

@Component
@Scope("singleton")
public class SalarySheet {
    private Map<Position, Integer> salaryToPositionMap = new HashMap<>();

    public SalarySheet() {
        fillSalaryAndPositionSheet();
    }

    public Map<Position, Integer> getSalaryToPositionMap() {
        return salaryToPositionMap;
    }

    public void setSalaryToPositionMap(Map<Position, Integer> salaryToPositionMap) {
        this.salaryToPositionMap = salaryToPositionMap;
    }

    private void fillSalaryAndPositionSheet() {
        BiConsumer<Position, Integer> con = salaryToPositionMap::put;
        con.accept(Position.TESTING_ENGINEER, 900);
        con.accept(Position.SOFTWARE_ENGINEER, 1500);
        con.accept(Position.SYSTEMS_ENGINEER, 1400);
        con.accept(Position.BUSINESS_ANALYST, 1100);
        con.accept(Position.TESTING_MANAGER, 1800);
        con.accept(Position.SOFTWARE_MANAGER, 2500);
        con.accept(Position.SYSTEMS_MANAGER, 2300);
    }
}
