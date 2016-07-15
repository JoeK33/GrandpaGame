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
    private boolean floating = false;
    private final float BOB_SPEED = 3;
    private float floatOffset = 0;
    private float wiggleDegrees = 0;

    public Pill(PillDescription pillDescription, Random rand, boolean floating) {
        isActive = true;
        this.pillDescription = pillDescription;
        dropHeight = Constants.WORLD_HEIGHT + (rand.nextInt(Constants.WORLD_HEIGHT));
        this.floating = floating;
    }

    public PillDescription getPillDescription() {
        return pillDescription;
    }

    public void draw(SpriteBatch batch) {
        if (isActive) {
            batch.draw(pillDescription.getTextureRegion(), position.x, position.y + dropHeight + floatOffset);
            batch.draw(pillDescription.getAnimation().getKeyFrame(stateTime), position.x, position.y + dropHeight + floatOffset);
        }
    }

    public void drawDoubleVision(SpriteBatch batch, float doubleWiggle) {

        if (isActive) {
            batch.draw(pillDescription.getTextureRegion(), position.x - Constants.PILL_SIZE / 4 + doubleWiggle, position.y + dropHeight + floatOffset + Constants.PILL_SIZE / 2 + doubleWiggle);
            batch.draw(pillDescription.getAnimation().getKeyFrame(stateTime), position.x - Constants.PILL_SIZE / 4 + doubleWiggle, position.y + dropHeight + floatOffset + Constants.PILL_SIZE / 2 + doubleWiggle);
        }
    }

    public void setFloating(boolean floating) {
        this.floating = floating;
    }

    public boolean isFloating() {
        return floating;
    }

    public void update(float delta) {
        stateTime += delta;

        if (dropHeight > 0) {
            dropHeight -= (FALL_SPEED * delta);
        } else {
            dropHeight = 0;
        }

        if (floating && dropHeight == 0) {
            wiggleDegrees += (BOB_SPEED * delta);
            floatOffset = (float) (Math.cos(wiggleDegrees) * 2);
            if (wiggleDegrees > 360) {
                wiggleDegrees = 0;
            }

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

    public boolean isActive() {
        return isActive;
    }

    public int getHealthValue() {
        return this.pillDescription.getHealthValue();
    }

}
