package com.myreliablegames.grandpagame.Diseases;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.myreliablegames.grandpagame.BaseLevelAssets;
import com.myreliablegames.grandpagame.Constants;

/**
 * Created by Joe on 7/20/2016.
 */
public class Sparkle {

    private TextureRegion sparkle;
    private Vector2 position = new Vector2();
    private float stateTime = MathUtils.random(100);
    private boolean isActive = false;

    public Sparkle(BaseLevelAssets assets) {
        sparkle = assets.diseaseAssets.sparkle;
        reposition();
    }

    public void draw(SpriteBatch batch) {
        if (isActive) {
            batch.draw(sparkle, position.x, position.y);
        }
    }

    public void update(float delta) {
        if (isActive) {
            stateTime += delta;
        }
    }

    public void reposition() {
        position.x = MathUtils.random(0, Constants.WORLD_WIDTH - sparkle.getRegionWidth());
        position.y = MathUtils.random(0, Constants.WORLD_HEIGHT - sparkle.getRegionHeight());
    }


    public void setActive(boolean active) {
        if (!active) {
            reposition();
        }
        isActive = active;
    }


}
