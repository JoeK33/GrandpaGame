package com.myreliablegames.grandpagame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Joe on 7/5/2016.
 */
public class PillHolder {

    private Pill[][] pills = new Pill[Constants.PILLS_WIDE][Constants.PILLS_HIGH];
    private BaseLevelAssets assets;
    private float YDrawOffset = 60;
    private float XDrawOffset = 60;
    private float pillPadding = 3;

    public PillHolder(BaseLevelAssets baseLevelAssets) {
        assets = baseLevelAssets;

    }

    public void draw(SpriteBatch batch) {
        for (int pillX = 0; pillX < Constants.PILLS_WIDE - 1; pillX++) {
            for (int pillY = 0; pillY < Constants.PILLS_HIGH - 1; pillY++) {
                if (pills[pillX][pillY] != null) {
                    pills[pillX][pillY].draw(batch,
                            (pillX * Constants.PILL_SIZE) + XDrawOffset + (pillPadding * pillX),
                            (pillY * Constants.PILL_SIZE) + YDrawOffset + (pillPadding * pillY));
                }
            }
        }
    }

    public void populate(int numberOfPills) {
        if (numberOfPills > (Constants.PILLS_HIGH * Constants.PILLS_WIDE)){
            numberOfPills = (Constants.PILLS_HIGH * Constants.PILLS_WIDE);
        }
        Gdx.app.log("Pill Holder", "Populating!");
        int pillsAdded = 0;
        while (pillsAdded < numberOfPills && numberOfPills > 0){
            // Randomly try to add pills until you have added enough.
            if (addPillRandomly()) {
                pillsAdded++;
                Gdx.app.log("Pill Holder", "Pills added: " + Integer.toString(pillsAdded));
            } else {
                Gdx.app.log("Pill Holder", "Pill slot already filled!");
            }
        }
    }

    private boolean addPillRandomly(){
        int xChoice = (int) (Math.random() * Constants.PILLS_WIDE);
        int yChoice = (int) (Math.random() * Constants.PILLS_HIGH);

        if (pills[xChoice][yChoice] == null) {
            pills[xChoice][yChoice] = new Pill(assets);
            return true;
        } else {
            return false;

        }
    }

    public void clear() {
       pills = new Pill[Constants.PILLS_WIDE][Constants.PILLS_HIGH];
    }
}
