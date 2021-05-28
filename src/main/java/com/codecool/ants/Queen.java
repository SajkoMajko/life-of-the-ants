package com.codecool.ants;

import com.codecool.ants.geometry.Position;

public class Queen extends Ant {
    private int matingMood;

    protected Queen(Colony colony) {
        super(colony);
        setRandomMatingMood();

    }

    @Override
    protected Position getStartPosition() {
        int center = colony.getWIDTH() / 2;
        return new Position(center, center, colony);
    }

    @Override
    protected void move(){
        if (matingMood > 0) matingMood--;
        colony.addLog("Queen's mating mood: " + getMatingMood());
    }

    @Override
    protected Character getIcon() {
        return 'Q';
    }

    public boolean canMating() {
        return matingMood == 0;
    }

   public void setRandomMatingMood() {
        this.matingMood = (int) Math.floor(Math.random() * 50) + 51;
   }

    public int getMatingMood() {
        return matingMood;
    }
}
