package com.myreliablegames.grandpagame.Diseases;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.myreliablegames.grandpagame.BaseLevelAssets;
import com.myreliablegames.grandpagame.Constants;
import com.myreliablegames.grandpagame.DrugName;

/**
 * Created by Joe on 7/14/2016.
 */
public class RingingInEars extends Disease {

    private float volume = 0;
    private final float volumeFadeSpeed = .3f;
    private boolean isRinging;
    private Music ringing;
    private long soundID;


    public RingingInEars(DrugName cure, BaseLevelAssets assets) {
        super(new DiseaseDescription(cure, Constants.RINGING_DAMAGE), DiseaseName.RingingInEars);
        ringing = assets.diseaseAssets.ringingInEars;
    }


    @Override
    public void draw(SpriteBatch batch) {

    }

    @Override
    public void update(float delta) {

        if (isRinging) {
            volume += volumeFadeSpeed * delta;

        } else {
            volume -= volumeFadeSpeed * delta;
        }

        if (volume > 1) {
            volume = 1;
        } else if (volume < 0) {
            volume = 0;
        }

        ringing.setVolume(volume);
    }

    @Override
    public void cureDisease() {
        cured = true;
        isRinging = false;
    }

    @Override
    public void beginDisease() {
        isRinging = true;
        ringing.play();
        ringing.setVolume(volume);
        ringing.setLooping(true);
    }

    @Override
    public boolean readyForRemoval() {
        if (cured && volume == 0) {
            ringing.stop();
            cured = false;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String getPrescriptionDescription() {
        return this.getDescription().getCure().toString() + " will stop that ringing in your ears.";
    }
}
