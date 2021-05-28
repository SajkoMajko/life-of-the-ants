package com.codecool.ants.geometry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Direction {
        NORTH(0, -1),
        EAST(1, 0),
        SOUTH(0, 1),
        WEST(-1, 0);

        public final int X;
        public final int Y;

        Direction(int x, int y) {
            this.X = x;
            this.Y = y;
        }

        public static List<Direction> getNeighbours() {
            return new ArrayList<>(Arrays.asList(NORTH, EAST, SOUTH, WEST));
        }

        public static Direction getRandomDirection(){
            List<Direction> neighbours = Direction.getNeighbours();
            return neighbours.get((int) Math.floor(Math.random() * neighbours.size()));
        }

        public static Direction getNextDirection(Direction direction) {
            List<Direction> directions = getNeighbours();
            int index = directions.indexOf(direction);
            int nextIndex = index == directions.size() - 1 ? 0 : index+1;
            return directions.get(nextIndex);
        }
    };