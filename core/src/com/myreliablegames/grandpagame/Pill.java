package com.myreliablegames.grandpagame;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

/**
 * Created by Joe on 7/5/2016.
 */
public class Pill {

    private Vector2 position;
    private boolean isActive;
    private PillDescription pillDescription;
    private int dropHeight;
    private final int FALL_SPEED = 300;
    private float stateTime = 0;

    public Pill(PillDescription pillDescription, Random rand) {
        isActive = true;
        this.pillDescription = pillDescription;
        dropHeight = Constants.WORLD_HEIGHT + (rand.nextInt(Constants.WORLD_HEIGHT));
    }

    public PillDescription getPillDescription() {
        return pillDescription;
    }

    public void draw(SpriteBatch batch) {
        if (isActive) {
            batch.draw(pillDescription.getTextureRegion(), position.x, position.y + dropHeight);
            batch.draw(pillDescription.getAnimation().getKeyFrame(stateTime), position.x, position.y + dropHeight);
        }
    }

    public void update(float delta) {
        stateTime += delta;

        if (dropHeight > 0) {
            dropHeight -= (FALL_SPEED * delta);
        } else {
            dropHeight = 0;
        }
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public boolean touched(Vector2 touchPosition) {

        if (isActive) {
            return (touchPosition.x > position.x && touchPosition.x < (position.x + Constants.PILL_SIZE) &&
                    touchPosition.y > position.y + dropHeight && touchPosition.y < position.y + dropHeight + Constants.PILL_SIZE);
        } else {
            return false;
        }
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public int getHealthValue() {
        return this.pillDescription.getHealthValue();
    }

}
