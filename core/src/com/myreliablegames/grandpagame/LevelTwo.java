package com.myreliablegames.grandpagame;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.myreliablegames.grandpagame.Screens.GameScreen;

/**
 * Created by Joe on 7/5/2016.
 */
public class LevelTwo extends Level {

    public LevelTwo(GameScreen gameScreen, GrandpaGame game) {
        super(gameScreen, game);
        pillManager.populate(25, 8);
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

