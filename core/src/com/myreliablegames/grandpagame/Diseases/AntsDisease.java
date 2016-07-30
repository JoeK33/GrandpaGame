package com.myreliablegames.grandpagame.Diseases;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.myreliablegames.grandpagame.BaseLevelAssets;
import com.myreliablegames.grandpagame.Constants;
import com.myreliablegames.grandpagame.DrugName;

import java.util.ArrayList;

/**
 * Created by Joe on 7/30/2016.
 */
public class AntsDisease extends Disease {

    private ArrayList<Ant> ants = new ArrayList<Ant>();
    private final int NUM_ANTS = 5;

    public AntsDisease(DrugName cure, BaseLevelAssets assets) {
        super(new DiseaseDescription(cure, Constants.SNAKE_DAMAGE), DiseaseName.SeeSnakes);
        for (int i = 0; i < NUM_ANTS; i++) {
            ants.add(new Ant(assets.diseaseAssets.ant));
        }
    }

    @Override
    public void draw(SpriteBatch batch) {

        for (Ant a : ants) {
            a.draw(batch);
        }
    }

    @Override
    public void update(float delta) {
        for (Ant a : ants) {
           a.update(delta);
        }
    }

    @Override
    public void cureDisease() {
        for (Ant a : ants) {
            a.setActive(false);
        }
        cured = true;
    }

    @Override
    public void beginDisease() {
        for (Ant a : ants) {
            a.setActive(true);
        }
    }

    @Override
    public boolean readyForRemoval() {


    // If any active ants are present, the disease is not ready to remove.
        for (Ant a : ants) {
           if (a.isActive()) {
               return false;
           }
        }

        // If all the ants are inactive, then the disease can be removed if it has been cured.
        if (cured) {
            cured = false;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String getPrescriptionDescription() {
        return this.getDescription().getCure().toString() + " is how I keep ants out of my own eyes.";
    }
}
