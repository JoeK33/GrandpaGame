package com.myreliablegames.grandpagame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Joe on 7/5/2016.
 */
public class Pill {

    private Vector2 position;
    private boolean isActive;
    private PillDescription pillDescription;

    public Pill(Vector2 position, PillDescription pillDescription) {
        this.position = position;
        isActive = true;
        this.pillDescription = pillDescription;
    }

    public Pill(PillDescription pillDescription) {
        isActive = true;
        this.pillDescription = pillDescription;
    }

    public PillDescription getPillDescription() {
        return pillDescription;
    }

    public void draw(SpriteBatch batch) {
        if (isActive) {
            batch.draw(pillDescription.getTexture(), position.x, position.y);
        }
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public boolean touched(Vector2 touchPosition) {

        if (isActive) {
            return (touchPosition.x > position.x && touchPosition.x < (position.x + Constants.PILL_SIZE) &&
                    touchPosition.y > position.y && touchPosition.y < position.y + Constants.PILL_SIZE);
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
