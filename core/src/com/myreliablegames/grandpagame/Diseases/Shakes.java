package com.myreliablegames.grandpagame.Diseases;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.myreliablegames.grandpagame.Constants;
import com.myreliablegames.grandpagame.DrugName;
import com.myreliablegames.grandpagame.Level;
import com.myreliablegames.grandpagame.PillManager;

/**
 * Created by Joe on 7/20/2016.
 */
public class Shakes extends Disease {

    private PillManager pillManager;
    private Level level;

    public Shakes(DrugName cure, PillManager manager, Level level) {
        super(new DiseaseDescription(cure, Constants.SHAKES_DAMAGE), DiseaseName.Shakes);
        this.pillManager = manager;
        this.level = level;
    }

    @Override
    public void draw(SpriteBatch batch) {

    }

    @Override
    public void update(float delta) {

    }

    @Override
    public void cureDisease() {
        pillManager.setShakes(false);
        level.shakeOff();
        cured = true;
    }

    @Override
    public void beginDisease() {
        pillManager.setShakes(true);
        level.shakeOn();
    }

    @Override
    public boolean readyForRemoval() {
        if (cured) {
            cured = false;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String getPrescriptionDescription() {
        return this.getDescription().getCure().toString() + " will steady your nerves and stop the shakes.";
    }
}
