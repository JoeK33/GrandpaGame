package com.myreliablegames.grandpagame.Diseases;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.myreliablegames.grandpagame.Constants;
import com.myreliablegames.grandpagame.DrugName;
import com.myreliablegames.grandpagame.Grandpa;
import com.myreliablegames.grandpagame.GreyscaleShader;
import com.myreliablegames.grandpagame.PillManager;

/**
 * Created by Joe on 7/14/2016.
 */
public class Colorblind extends  Disease {

    private float grayness = 0;
    private float blindingSpeed = .5f;
    private boolean isColorblind;
    private PillManager pillManager;

    public Colorblind(DrugName cure, PillManager pillManager) {
        super(new DiseaseDescription(cure, Constants.COLORBLIND_DAMAGE), DiseaseName.Colorblind);
        this.pillManager = pillManager;
    }

    @Override
    public void draw(SpriteBatch batch) {
        pillManager.setGreyscale(grayness);
    }

    @Override
    public void update(float delta) {

        if (isColorblind) {
            grayness += blindingSpeed * delta;
        } else {
            grayness -= blindingSpeed * delta;
        }

        if (grayness > 1) {
            grayness = 1;
        } else if (grayness < 0) {
            grayness = 0;
        }

    }

    @Override
    public void cureDisease() {
        isColorblind = false;
        cured = true;
        Gdx.app.log("ColorBlind" , getPrescriptionDescription());
    }

    @Override
    public void beginDisease() {
        isColorblind = true;
    }

    @Override
    public boolean readyForRemoval() {
        if (!(grayness > 0) && cured){
            cured = false;
            return true;
        }

        return false;
    }

    @Override
    public String getPrescriptionDescription() {
        return this.getDescription().getCure().toString() + " should bring the color back to your life.";
    }

}
