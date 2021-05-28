package com.codecool.ants;

import com.codecool.ants.geometry.Position;

import java.util.Random;

public class Drone extends Ant {
    private int matingCounter = -1;

    protected Drone(Colony colony) {
        super(colony);
    }

    @Override
    protected void move() {
        if (this.matingCounter > 0) {
            this.matingCounter--;
        } else if (this.matingCounter == 0) {
            kickOffDrone();
            this.matingCounter--;
        } else {
            int droneX = getPosition().getX();
            int droneY = getPosition().getY();
            int queenX = colony.getQueen().getPosition().getX();
            int queenY = colony.getQueen().getPosition().getY();

            int newX = getAxleDirection(droneX, queenX);
            int newY = getAxleDirection(droneY, queenY);

            this.getPosition().setPosition(newX, newY);

            if (this.position.equals(colony.getQueen().getPosition())) {
                if (colony.getQueen().canMating()) {
                    mating();
                    colony.getQueen().setRandomMatingMood();
                } else {
                    kickOffDrone();
                    colony.addLog(":(");
                }
            }
        }
    }

    private void kickOffDrone() {
        Random random = new Random();
        int first = random.nextBoolean() ? 0 : colony.getWIDTH() -1;
        int second = random.nextInt(colony.getWIDTH());
        this.position = random.nextBoolean() ? new Position(first, second, colony) : new Position(second, first, colony);
    }

    public int getAxleDirection(int droneAxle, int queenAxle) {
        if (droneAxle < queenAxle) {
            return droneAxle + 1;
        } else if (droneAxle > queenAxle) {
            return droneAxle - 1;
        } else {
            return droneAxle;
        }
    }

    @Override
    protected Character getIcon() {
        return 'D';
    }

    private boolean isNextToQueen() {
        //TODO: write the method here

        return false;
    }

    private void mating() {
        this.matingCounter = 10;
        colony.addLog("HALLELUJAH");
    }
}
