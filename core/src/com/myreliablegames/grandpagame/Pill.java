package com.myreliablegames.grandpagame;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Joe on 7/5/2016.
 */
public class Pill {

    private Texture pillTexture;
    private Vector2 position;
    private boolean isActive;
    private int healthValue;

    public Pill(BaseLevelAssets assets, Vector2 position, int healthValue) {
        pillTexture = assets.getRandomPillTexture();
        this.position = position;
        isActive = true;
        this.healthValue = healthValue;
    }

    public void draw(SpriteBatch batch) {
        if (isActive) {
            batch.draw(pillTexture, position.x, position.y);
        }

    }

    public boolean touched(Vector2 touchPosition) {

        if (isActive) {
            if (touchPosition.x > position.x && touchPosition.x < (position.x + Constants.PILL_SIZE) &&
                    touchPosition.y > position.y && touchPosition.y < position.y + Constants.PILL_SIZE) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public int getHealthValue() {
        return this.healthValue;
    }
}
