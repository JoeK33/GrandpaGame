package com.myreliablegames.grandpagame;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.myreliablegames.grandpagame.Screens.GameScreen;

/**
 * Created by Joe on 7/11/2016.
 */
public class LevelFive extends Level {
    public LevelFive(GameScreen gameScreen, GrandpaGame game, BaseLevelAssets assets) {
        super(gameScreen, game, assets);
        pillManager.populate(50, 13, true);
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