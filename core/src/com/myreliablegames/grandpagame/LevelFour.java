package com.myreliablegames.grandpagame;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.myreliablegames.grandpagame.Screens.GameScreen;

import java.util.ArrayList;

/**
 * Created by Joe on 7/11/2016.
 */
public class LevelFour extends Level {

    public LevelFour(GameScreen gameScreen, GrandpaGame game, BaseLevelAssets assets) {
        super(gameScreen, game, assets, GrandpaGame.LevelNumber.Four);
        pillManager.populate(40, 12, false);

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
