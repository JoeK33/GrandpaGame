package com.myreliablegames.grandpagame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.utils.NinePatchDrawable;

/**
 * Created by Joe on 7/6/2016.
 */
public class HealthBar extends Actor {

    private NinePatchDrawable loadingBarBackground;
    private NinePatchDrawable loadingBar;
    private float health;

    public HealthBar(BaseLevelAssets assets) {
        TextureAtlas skinAtlas = new TextureAtlas(Gdx.files.internal("uiskin.atlas"));
        NinePatch loadingBarBackgroundPatch = new NinePatch(skinAtlas.findRegion("default-round"), 5, 5, 4, 4);
        NinePatch loadingBarPatch = new NinePatch(skinAtlas.findRegion("default-round-down"), 5, 5, 4, 4);
        loadingBar = new NinePatchDrawable(loadingBarPatch);
        loadingBarBackground = new NinePatchDrawable(loadingBarBackgroundPatch);
        health = 1f;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        loadingBarBackground.draw(batch, getX(), getY(), getWidth() * getScaleX(), getHeight() * getScaleY());
        if (this.health > 0) {
            loadingBar.draw(batch, getX(), getY(), health * getWidth() * getScaleX(), getHeight() * getScaleY());
        }
    }

    public void setHealth(int health) {
        this.health = ((float)health / (float)Constants.GRANDPA_HEALTH);
        if (this.health < 0) {
            this.health = 0;
        }
    }
}
