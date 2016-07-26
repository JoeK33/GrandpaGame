package com.myreliablegames.grandpagame.Diseases;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.myreliablegames.grandpagame.BaseLevelAssets;
import com.myreliablegames.grandpagame.Constants;
import com.myreliablegames.grandpagame.DrugName;

import java.util.ArrayList;

/**
 * Created by Joe on 7/20/2016.
 */
public class MigraineSparkles extends Disease {

    private ArrayList<Sparkle> sparkles = new ArrayList<Sparkle>();
    private final int numOfSparkles = 5;

    public MigraineSparkles(DrugName cure, BaseLevelAssets assets) {
        super(new DiseaseDescription(cure, Constants.SPARKLE_DAMAGE), DiseaseName.Sparkles);

        for (int i = 0; i < numOfSparkles; i++) {
            sparkles.add(new Sparkle(assets));
        }
    }

    @Override
    public void draw(SpriteBatch batch) {
        for (Sparkle sparkle : sparkles) {
            sparkle.draw(batch);
        }
    }

    @Override
    public void update(float delta) {
        for (Sparkle sparkle : sparkles) {
            sparkle.update(delta);
        }
    }

    @Override
    public void cureDisease() {
        for (Sparkle sparkle : sparkles) {
            sparkle.setActive(false);
        }
        cured = true;
    }

    @Override
    public void beginDisease() {
        for (Sparkle sparkle : sparkles) {
            sparkle.setActive(true);
        }
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
        return this.getDescription().getCure().toString() + " should help clear up those stars you're seeing.";
    }
}
