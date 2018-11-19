package com.epam.jmp.department;

import com.epam.jmp.entity.Position;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PositionList {
    private List<Position> positions = new ArrayList<>();

    public PositionList() {
        fillPositions();
    }

    public List<Position> getPositions() {
        return positions;
    }

    public void setPositions(List<Position> positions) {
        this.positions = positions;
    }

    private void fillPositions() {
        this.positions.addAll(Arrays.asList(Position.values()));
    }

    public void removePosition(Position position) {
        this.positions.remove(position);
    }

    public void addPosition(Position position) {
        this.positions.add(position);
    }
}
