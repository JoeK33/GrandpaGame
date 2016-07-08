package com.myreliablegames.grandpagame;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.myreliablegames.grandpagame.Screens.GameScreen;

/**
 * Created by Joe on 7/5/2016.
 */
public class LevelThree extends Level {
    public LevelThree(GameScreen gameScreen, GrandpaGame game) {
        super(gameScreen, game);
        pillHolder.populate(50);
    }

    @Override
    public void render(SpriteBatch batch) {
        super.render(batch);
    }

    @Override
    public void update(float delta) {
        super.update(delta);

    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
