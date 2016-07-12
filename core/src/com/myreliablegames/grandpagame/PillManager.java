package com.myreliablegames.grandpagame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;


/**
 * Created by Joe on 7/5/2016.
 */
public class PillManager {

    private Pill[][] pills = new Pill[Constants.PILLS_WIDE][Constants.PILLS_HIGH];
    private BaseLevelAssets assets;
    private float YDrawOffset = 100;
    private float XDrawOffset = 48;
    private float pillPadding = 3;
    private PillFactory pillFactory;

    public PillManager(BaseLevelAssets baseLevelAssets) {
        assets = baseLevelAssets;
    }

    public void draw(SpriteBatch batch) {
        for (int pillX = 0; pillX < Constants.PILLS_WIDE - 1; pillX++) {
            for (int pillY = 0; pillY < Constants.PILLS_HIGH - 1; pillY++) {
                if (pills[pillX][pillY] != null) {
                    pills[pillX][pillY].draw(batch);
                }
            }
        }
    }

    public void populate(int numberOfPills, int numberOfPillTypes) {

        pillFactory = new PillFactory(assets, numberOfPillTypes);

        if (numberOfPills > (Constants.PILLS_HIGH * Constants.PILLS_WIDE)){
            numberOfPills = (Constants.PILLS_HIGH * Constants.PILLS_WIDE);
        }
        Gdx.app.log("Pill Manager", "Populating!");
        int pillsAdded = 0;
        while (pillsAdded < numberOfPills && numberOfPills > 0){
            // Randomly try to add pills until you have added enough.
            if (addPillRandomly()) {
                pillsAdded++;
                Gdx.app.log("Pill Manager", "Pills added: " + Integer.toString(pillsAdded));
            } else {
                Gdx.app.log("Pill Manager", "Pill slot already filled!");
            }
        }
    }

    private boolean addPillRandomly(){
        int xChoice = (int) (Math.random() * Constants.PILLS_WIDE);
        int yChoice = (int) (Math.random() * Constants.PILLS_HIGH);

        if (pills[xChoice][yChoice] == null) {

            Pill pill = pillFactory.getPill();

            pill.setPosition(new Vector2(
                    (xChoice * Constants.PILL_SIZE) + XDrawOffset + (pillPadding * xChoice),
                    (yChoice * Constants.PILL_SIZE) + YDrawOffset + (pillPadding * yChoice)));

            pills[xChoice][yChoice] = pill;

            return true;
        } else {
            return false;

        }
    }

    // Returns null if no pill to touch.
    public Pill getTouchedPill(Vector2 touchPosition) {
        for (int pillX = 0; pillX < Constants.PILLS_WIDE - 1; pillX++) {
            for (int pillY = 0; pillY < Constants.PILLS_HIGH - 1; pillY++) {
                if (pills[pillX][pillY] != null) {
                    if(pills[pillX][pillY].touched(touchPosition)) {
                        return pills[pillX][pillY];
                    }

                }
            }
        }
        return null;
    }

    public void clear() {
       pills = new Pill[Constants.PILLS_WIDE][Constants.PILLS_HIGH];
    }
}
