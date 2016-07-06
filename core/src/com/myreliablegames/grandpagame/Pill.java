package com.myreliablegames.grandpagame;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Joe on 7/5/2016.
 */
public class Pill {

    private Texture pillTexture;

    public Pill(BaseLevelAssets assets) {
        pillTexture = assets.getRandomPillTexture();
    }

    public void draw(SpriteBatch batch, float x, float y) {
        batch.draw(pillTexture, x, y);

    }
}
