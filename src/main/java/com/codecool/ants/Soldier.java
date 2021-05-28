package com.codecool.ants;

import com.codecool.ants.geometry.Direction;

public class Soldier extends Ant {
    private Direction actualDirection;

    protected Soldier(Colony colony) {
        super(colony);
        this.actualDirection = Direction.getRandomDirection();
    }

    @Override
    protected void move() {
        position.setPosition(actualDirection);
        Direction nextDirection = Direction.getNextDirection(actualDirection);

        actualDirection = nextDirection;
    }

    @Override
    protected Character getIcon() {
        return 'S';
    }
}
