package com.myreliablegames.grandpagame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;


/**
 * Created by Joe on 7/5/2016.
 */
public class PillManager {

    private Pill[][] pills = new Pill[Constants.PILLS_WIDE][Constants.PILLS_HIGH];
    private ArrayList<Pill> listOfPills = new ArrayList<Pill>();
    private BaseLevelAssets assets;
    private float YDrawOffset = 100;
    private float XDrawOffset = 28;
    private float pillPadding = 3;
    private PillFactory pillFactory;

    public PillManager(BaseLevelAssets baseLevelAssets) {
        assets = baseLevelAssets;
    }

    public void draw(SpriteBatch batch) {
        for (Pill p : listOfPills) {
            p.draw(batch);
        }

        // Drawing this makes all the pills draw properly.  Why?  I have no idea.
        batch.draw(assets.drinkButtonUp, -Constants.WORLD_WIDTH, -Constants.WORLD_HEIGHT);
    }

    public void populate(int numberOfPills, int numberOfPillTypes) {

        pillFactory = new PillFactory(assets, numberOfPillTypes);

        if (numberOfPills > (Constants.PILLS_HIGH * Constants.PILLS_WIDE)) {
            numberOfPills = (Constants.PILLS_HIGH * Constants.PILLS_WIDE);
        }
       // Gdx.app.log("Pill Manager", "Populating!");
        int pillsAdded = 0;
        while (pillsAdded < numberOfPills && numberOfPills > 0) {
            // Randomly try to add pills until you have added enough.
            if (addPillRandomly()) {
                pillsAdded++;
            //    Gdx.app.log("Pill Manager", "Pills added: " + Integer.toString(pillsAdded));
            } else {
            //    Gdx.app.log("Pill Manager", "Pill slot already filled!");
            }
        }
    }

    public void update(float delta) {
        for (Pill p : listOfPills) {
            p.update(delta);
        }
    }

    private boolean addPillRandomly() {
        int xChoice = (int) (Math.random() * Constants.PILLS_WIDE);
        int yChoice = (int) (Math.random() * Constants.PILLS_HIGH);

        if (pills[xChoice][yChoice] == null) {

            Pill pill = pillFactory.getPill();

            pill.setPosition(new Vector2(
                    (xChoice * Constants.PILL_SIZE) + XDrawOffset + (pillPadding * xChoice),
                    (yChoice * Constants.PILL_SIZE) + YDrawOffset + (pillPadding * yChoice)));

            pills[xChoice][yChoice] = pill;
            listOfPills.add(pill);

            return true;
        } else {
            return false;

        }
    }

    // Returns null if no pill to touch.
    public Pill getTouchedPill(Vector2 touchPosition) {
        for (Pill p : listOfPills) {
            if (p.touched(touchPosition)) {
                return p;
            }
        }
        return null;
    }

    public void clear() {
        pills = new Pill[Constants.PILLS_WIDE][Constants.PILLS_HIGH];
        listOfPills.clear();
    }
}
