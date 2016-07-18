package com.myreliablegames.grandpagame.Diseases;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.myreliablegames.grandpagame.Constants;
import com.myreliablegames.grandpagame.DrugName;
import com.myreliablegames.grandpagame.Level;
import com.myreliablegames.grandpagame.math.ImprovedNoise;

public class BlurryVision extends Disease {
    private Level level;
    private float currentMaxBlurriness = 0.0f;
    private float totalTime = 0.0f;
    private boolean isEnabled;

    public BlurryVision(DrugName cure, Level level) {
        super(new DiseaseDescription(cure, Constants.BLURRY_VISION_DAMAGE), DiseaseName.BlurryVision);
        this.level = level;
    }

    @Override
    public void draw(SpriteBatch batch) {
    }

    @Override
    public void update(float delta) {
        // Animate the maximum blurriness we can apply, i.e. if we just enabled blurry vision,
        // lerp to the maximum blurriness.
        final float blurrinessAnimationVelocity = Constants.MAX_BLURRY_VISION_INTENSITY;
        currentMaxBlurriness += delta * blurrinessAnimationVelocity * (isEnabled ? 1 : -1);
        currentMaxBlurriness =
                MathUtils.clamp(currentMaxBlurriness, 0.0f, Constants.MAX_BLURRY_VISION_INTENSITY);

        totalTime += delta;
        float blurryVisionIntensity =
                currentMaxBlurriness * ((float)ImprovedNoise.noise(0.69f * totalTime, 0, 0) + 0.5f);

        level.setBlurryVisionIntensity(blurryVisionIntensity);
    }

    @Override
    public void cureDisease() {
        isEnabled = false;
    }

    @Override
    public void beginDisease() {
        isEnabled = true;
    }

    @Override
    public boolean readyForRemoval() {
        return currentMaxBlurriness <= 0.0f;
    }

    @Override
    public String getPrescriptionDescription() {
        return this.getDescription().getCure().toString();
    }
}
