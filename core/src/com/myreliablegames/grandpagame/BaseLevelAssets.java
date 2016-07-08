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

    public Texture drinkButtonUp = new Texture(Gdx.files.internal("drinkbuttonup.png"));
    public Texture drinkButtonDown = new Texture(Gdx.files.internal("drinkbuttondown.png"));

    public Texture eatButtonUp = new Texture(Gdx.files.internal("eatbuttonup.png"));
    public Texture eatButtonDown = new Texture(Gdx.files.internal("eatbuttondown.png"));

    public Texture pillBottleButtonUp = new Texture(Gdx.files.internal("pillbuttonup.png"));
    public Texture pillBottleButtonDown = new Texture(Gdx.files.internal("pillbuttondown.png"));



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

        drinkButtonUp.dispose();
        drinkButtonDown.dispose();

        eatButtonUp.dispose();
        eatButtonDown.dispose();

        pillBottleButtonUp.dispose();
        pillBottleButtonDown.dispose();
    }
}
