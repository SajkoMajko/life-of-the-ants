package com.codecool.ants;

import com.codecool.ants.geometry.Position;

public abstract class Ant {
    protected Position position;  //plan was private
    protected Colony colony;    //plan was private

    protected Ant(Colony colony) {
        this.colony = colony;
        this.position = getStartPosition();
    }

    protected Position getStartPosition() {
        int x = (int) Math.floor(Math.random() * colony.getWIDTH());
        int y = (int) Math.floor(Math.random() * colony.getWIDTH());
        return new Position(x, y, colony);
    }

    protected abstract void move();

    public Position getPosition() {
        return position;
    }

    protected abstract Character getIcon();


}
