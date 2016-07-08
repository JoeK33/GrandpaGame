package com.myreliablegames.grandpagame.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.myreliablegames.grandpagame.GrandpaGame;
import com.myreliablegames.grandpagame.LevelSelectButtonHolder;

/**
 * Created by Joe on 7/5/2016.
 */
public class LevelSelectScreen extends BaseScreen {

    private LevelSelectButtonHolder buttons;

    public LevelSelectScreen(GrandpaGame game) {
        super(game);
        buttons = new LevelSelectButtonHolder(font, game, this);
    }

    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glClearColor(1, 1, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        buttons.render(delta);
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
        buttons.resize(width, height);
    }

}
