package com.myreliablegames.grandpagame;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Joe on 7/5/2016.
 */
public abstract class Level {

    BaseLevelAssets baseLevelAssets;
    PillHolder pillHolder;
    Grandpa grandpa;
    boolean paused;
    GameHUD gameHUD;

    public Level() {
        baseLevelAssets = new BaseLevelAssets();
        pillHolder = new PillHolder(baseLevelAssets);
        paused = false;
        grandpa = new Grandpa();
        gameHUD = new GameHUD(baseLevelAssets, grandpa);
    }

    public void render(SpriteBatch batch) {
        pillHolder.draw(batch);
        gameHUD.draw(batch);
    }

    public void update(float delta) {
        gameHUD.update(delta);
    };

    public void dispose() {
        baseLevelAssets.dispose();
    }

    public void touchDown(Vector2 touchPos) {
        if (!paused) {
            Pill pill = pillHolder.getTouchedPill(touchPos);
            if (pill != null) {
                grandpa.takePill(pill);
                pill.setActive(false);
            }
        }
    }

    public void pauseToggle() {
        if (paused) {
            paused = false;
        } else {
            paused = true;
        }
    }

    public boolean isPaused() {
        return paused;
    }

    public void resize(int width, int height) {
        gameHUD.resize(width, height);
    }

}
