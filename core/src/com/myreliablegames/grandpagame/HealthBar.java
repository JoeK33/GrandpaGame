package com.myreliablegames.grandpagame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.utils.NinePatchDrawable;
import com.badlogic.gdx.utils.Timer;

/**
 * Created by Joe on 7/6/2016.
 */
public class HealthBar extends Actor {

    private NinePatchDrawable healthBarBackground;
    private NinePatchDrawable healthBar;
    private float health;
    private boolean jiggling;

    public HealthBar(BaseLevelAssets assets) {
        TextureAtlas skinAtlas = new TextureAtlas(Gdx.files.internal("uiskin.atlas"));
        NinePatch loadingBarBackgroundPatch = new NinePatch(skinAtlas.findRegion("default-round"), 5, 5, 4, 4);
        NinePatch loadingBarPatch = new NinePatch(skinAtlas.findRegion("default-round-down"), 5, 5, 4, 4);
        healthBar = new NinePatchDrawable(loadingBarPatch);
        healthBarBackground = new NinePatchDrawable(loadingBarBackgroundPatch);
        health = 1f;
        jiggling = false;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {

        if (jiggling) {
            healthBarBackground.draw(batch, getX() + getJiggle(), getY() + getJiggle(), getWidth() * getScaleX(), getHeight() * getScaleY());
            if (this.health > 0) {
                healthBar.draw(batch, getX() + getJiggle(), getY() + getJiggle(), health * getWidth() * getScaleX(), getHeight() * getScaleY());
            }
        } else {
            healthBarBackground.draw(batch, getX(), getY(), getWidth() * getScaleX(), getHeight() * getScaleY());
            if (this.health > 0) {
                healthBar.draw(batch, getX(), getY(), health * getWidth() * getScaleX(), getHeight() * getScaleY());
            }
        }
    }

    public void setHealth(int health) {
        if (((float)health / (float)Constants.GRANDPA_HEALTH) < this.health) {
            jiggle();
        }
        this.health = ((float)health / (float)Constants.GRANDPA_HEALTH);
        if (this.health < 0) {
            this.health = 0;
        }
    }

    public void jiggle() {
        jiggling = true;
        Timer timer = new Timer();
        timer.scheduleTask(new Timer.Task() {
            @Override
            public void run() {
                jiggling = false;
            }
        }, .125f);
    }

    private final int minimumJiggle = -10;
    private final int maxJiggle = 10;
    // Returns a number between min and max jiggle.
    private float getJiggle() {
        return minimumJiggle + (int)(Math.random() * (maxJiggle - minimumJiggle) + 1);
    }
}
