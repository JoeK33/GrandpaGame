package com.myreliablegames.grandpagame;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.myreliablegames.grandpagame.shaders.GreyscaleShader;

import java.util.ArrayList;


/**
 * Created by Joe on 7/5/2016.
 */
public class PillManager {

    private Pill[][] pills = new Pill[Constants.PILLS_WIDE][Constants.PILLS_HIGH];
    private ArrayList<Pill> listOfPills = new ArrayList<Pill>();
    private ArrayList<DrugName> uniquePillDrugNames = new ArrayList<DrugName>();
    private ArrayList<Pill> uniquePills = new ArrayList<Pill>();
    private BaseLevelAssets assets;
    private float YDrawOffset = 100;
    private float XDrawOffset = 76;
    private float pillPadding = 3;
    private PillFactory pillFactory;
    private boolean doubleVision = false;
    private boolean hasShakes = false;
    private float doubleWiggle;
    private float greyscale = 0.0f;

    public PillManager(BaseLevelAssets baseLevelAssets) {
        assets = baseLevelAssets;
    }

    public void draw(SpriteBatch batch) {

        if (greyscale > 0.0f) {
            batch.setShader(GreyscaleShader.grayscaleShader);
            GreyscaleShader.grayscaleShader.setUniformf("u_grayness", greyscale);
        } else {
            // Use the default shader.
            batch.setShader(null);
        }

        for (Pill p : listOfPills) {
            if (!hasShakes) {
                p.draw(batch);
            } else {
                p.drawShakes(batch);
            }

        }

        if (doubleVision) {
            for (Pill p : listOfPills) {
                p.drawDoubleVision(batch, doubleWiggle);
            }
        }

        // Hack: Drawing this makes all the pills draw properly.  Why?  I have no idea.
        //batch.draw(assets.drinkButtonUp, -Constants.WORLD_WIDTH, -Constants.WORLD_HEIGHT);
    }

    public void populate(int numberOfPills, int numberOfPillTypes, boolean floatingPills) {

        pillFactory = new PillFactory(assets, numberOfPillTypes, floatingPills);

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

    public void setDoubleVision(boolean doubleVision) {
        this.doubleVision = doubleVision;
    }

    /**
     * Sets the grayness used to render the pills. A greyscale value that is 1.0 is full grey.
     * A grey scale value that is <= 0.0 is full color.
     */
    public void setGreyscale(float greyscale) {
        this.greyscale = greyscale;
    }

    public void setShakes(boolean hasShakes) {
        this.hasShakes = hasShakes;
    }

    public void update(float delta) {
        for (Pill p : listOfPills) {
            p.update(delta);
        }

        // Jiggle the double vision pills around a little.
        doubleWiggle = (float) ((Math.random() * 4) - 2);
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
            if (!uniquePillDrugNames.contains(pill.getPillDescription().getDrugName())) {
                uniquePillDrugNames.add(pill.getPillDescription().getDrugName());
                uniquePills.add(pill);
            }

            return true;
        } else {
            return false;

        }
    }

    public ArrayList<DrugName> getPillsInPlay() {
        return uniquePillDrugNames;
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

    public ArrayList<Pill> getUniquePills() {
        return uniquePills;
    }

    public void clear() {
        pills = new Pill[Constants.PILLS_WIDE][Constants.PILLS_HIGH];
        listOfPills.clear();
        uniquePillDrugNames.clear();
    }

    public ArrayList<DrugName> getActiveDrugs() {
        ArrayList<DrugName> remainingDrugs = new ArrayList<DrugName>();

        for (Pill p : listOfPills) {

            if (p.isActive() && !remainingDrugs.contains(p.getPillDescription().getDrugName())) {
                remainingDrugs.add(p.getPillDescription().getDrugName());
            }
        }
        return remainingDrugs;
    }
}
