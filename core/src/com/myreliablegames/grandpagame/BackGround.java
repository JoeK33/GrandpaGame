package com.myreliablegames.grandpagame;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;

/**
 * Created by Joe on 7/25/2016.
 */
public class BackGround {

    private TextureRegion background;
    private final float MAXIMUM_WIGGLE = 15;
    private boolean shaking;

    private float shakeOffsetX;
    private float shakeOffsetY;

    public BackGround(LevelAssets assets) {
        this.background = assets.getBackground();

    }

    public void draw(SpriteBatch batch) {
        batch.draw(background, -25 + shakeOffsetX, -25 + shakeOffsetY);
    }

    public void update(float delta) {

        if (shaking) {
            shakeOffsetX = MathUtils.random(-MAXIMUM_WIGGLE, MAXIMUM_WIGGLE);
            shakeOffsetY = MathUtils.random(-MAXIMUM_WIGGLE, MAXIMUM_WIGGLE);
        }
    }

    public void shakeOn() {
        shaking = true;
    }

    public void shakeOff() {
        shaking = false;
        shakeOffsetX = 0;
        shakeOffsetY = 0;
    }
}
