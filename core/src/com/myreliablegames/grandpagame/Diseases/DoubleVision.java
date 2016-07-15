package com.myreliablegames.grandpagame.Diseases;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.myreliablegames.grandpagame.Constants;
import com.myreliablegames.grandpagame.DrugName;
import com.myreliablegames.grandpagame.PillManager;

/**
 * Created by Joe on 7/14/2016.
 */
public class DoubleVision extends Disease {

    private PillManager pillManager;


    public DoubleVision(DrugName cure, PillManager pillManager) {
        super(new DiseaseDescription(cure, Constants.DOUBLE_VISION_DAMAGE), DiseaseName.RingingInEars);
        this.pillManager = pillManager;
    }

    @Override
    public void draw(SpriteBatch batch) {

    }

    @Override
    public void update(float delta) {

    }

    @Override
    public void cureDisease() {
        pillManager.setDoubleVision(false);
        cured = true;
    }

    @Override
    public void beginDisease() {
        pillManager.setDoubleVision(true);
    }

    @Override
    public boolean readyForRemoval() {
        if (cured) {
            cured = false;
            return true;
        }
        return false;
    }

    @Override
    public String getPrescriptionDescription() {
        return this.getDescription().getCure().toString() + " is very effective against double vision";
    }
}
