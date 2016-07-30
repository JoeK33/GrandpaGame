package com.myreliablegames.grandpagame.Diseases;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.TimeUtils;
import com.myreliablegames.grandpagame.Constants;

/**
 * Created by Joe on 7/30/2016.
 */
public class Ant {
    private TextureRegion ant;
    private Vector2 position = new Vector2();
    private final float antSpeed = 100f;
    private Vector2 velocity = new Vector2(0, antSpeed);
    private boolean active = false;
    private long startTime = 0;
    private long walkTime;

    public Ant(TextureRegion antTex) {
        ant = antTex;
        reset();

        // Randomly choose within a millisecond range for an ant to walk before pausing.
        walkTime = (MathUtils.random(1500 ,3000));
    }

    public void draw(SpriteBatch batch) {
        if (active) {
            batch.draw(ant, position.x, position.y);
        }
    }

    // Ant moves up across the screen.
    public void update(float delta) {

        // If active, walk the ant for 3 seconds. Pause for a second. Repeat.
        if (active) {
            if (TimeUtils.nanoTime() > startTime + TimeUtils.millisToNanos(walkTime)) {
                if (TimeUtils.nanoTime() > startTime + TimeUtils.millisToNanos(walkTime + 1000)) {
                    startTime = TimeUtils.nanoTime();
                }
            } else {
                position.mulAdd(velocity, delta);
            }

            // Reset ant when it goes off screen.
            if (this.position.y > Constants.WORLD_HEIGHT + (ant.getRegionWidth())) {
                reset();
            }
        }
    }

    public void reset() {
        this.position.x = MathUtils.random(0, Constants.WORLD_WIDTH - ant.getRegionWidth());
        this.position.y = 0 - ant.getRegionHeight() - (MathUtils.random(0, Constants.WORLD_HEIGHT));
        startTime = TimeUtils.nanoTime();
    }

    public void setActive(boolean isActive) {
        if (!isActive) {
            reset();
        }

        active = isActive;
    }

    public boolean isActive() {
        return active;
    }
}
