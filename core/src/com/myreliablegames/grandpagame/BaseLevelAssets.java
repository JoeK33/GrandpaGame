package com.myreliablegames.grandpagame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

/**
 * Created by Joe on 7/5/2016.
 */
public class BaseLevelAssets {

    public Texture Pill1Texture = new Texture(Gdx.files.internal("pill1.png"));
    public Texture Pill2Texture = new Texture(Gdx.files.internal("pill2.png"));
    public Texture Pill3Texture = new Texture(Gdx.files.internal("pill3.png"));

    public BaseLevelAssets() {

    }

    public Texture getRandomPillTexture() {
        int choice = (int)(Math.random() * 3);

        switch(choice) {
            case 0:
                return Pill1Texture;
            case 1:
                return Pill2Texture;
            case 2:
                return Pill3Texture;
            default:
                return Pill1Texture;
        }
    }

    public void dispose() {
        Pill1Texture.dispose();
        Pill2Texture.dispose();
        Pill3Texture.dispose();
    }
}
