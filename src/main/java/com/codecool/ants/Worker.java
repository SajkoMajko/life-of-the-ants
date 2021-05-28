package com.codecool.ants;

import com.codecool.ants.geometry.Direction;
import com.codecool.ants.geometry.Position;

import java.util.List;

public class Worker extends Ant {
    protected Worker(Colony colony) {
        super(colony);
    }

    @Override
    protected void move() {
        position.setPosition(Direction.getRandomDirection());
    }

    @Override
    protected Character getIcon() {
        return 'W';
    }
}
