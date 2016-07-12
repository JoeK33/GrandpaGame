package com.myreliablegames.grandpagame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

/**
 * Created by Joe on 7/5/2016.
 */
public class BaseLevelAssets {

    public PillAssets pillAssets;

    public Texture drinkButtonUp = new Texture(Gdx.files.internal("drinkbuttonup.png"));
    public Texture drinkButtonDown = new Texture(Gdx.files.internal("drinkbuttondown.png"));

    public Texture eatButtonUp = new Texture(Gdx.files.internal("eatbuttonup.png"));
    public Texture eatButtonDown = new Texture(Gdx.files.internal("eatbuttondown.png"));

    public Texture pillBottleButtonUp = new Texture(Gdx.files.internal("pillbuttonup.png"));
    public Texture pillBottleButtonDown = new Texture(Gdx.files.internal("pillbuttondown.png"));

    public Texture prescriptionButtonUp = new Texture(Gdx.files.internal("prescriptionbuttonup.png"));
    public Texture prescriptionButtonDown = new Texture(Gdx.files.internal("prescriptionbuttondown.png"));

    public BaseLevelAssets() {
        pillAssets = new PillAssets();
    }

    public void dispose() {
        pillAssets.dispose();

        drinkButtonUp.dispose();
        drinkButtonDown.dispose();

        eatButtonUp.dispose();
        eatButtonDown.dispose();

        pillBottleButtonUp.dispose();
        pillBottleButtonDown.dispose();
    }
}
