package com.codecool.ants.geometry;

import com.codecool.ants.Colony;

public class Position {

//    public final int x;
//    public final int y;

    //Our planned version:
    private int x;
    private int y;
    private Colony colony;

    public Position(int x, int y, Colony colony) {
        this.x = x;
        this.y = y;
        this.colony = colony;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setPosition(Direction direction) {
        if (colony.isOnMap(this.x + direction.X, this.y + direction.Y)) {
            this.x += direction.X;
            this.y += direction.Y;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this.getClass() != obj.getClass()) return false;
        Position position = (Position) obj;
        if (this.x == position.x && this.y == position.y) return true;
        return super.equals(obj);
    }
}