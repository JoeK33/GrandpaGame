package com.myreliablegames.grandpagame.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Timer;
import com.myreliablegames.grandpagame.Constants;
import com.myreliablegames.grandpagame.GrandpaGame;

/**
 * Created by Joe on 7/30/2016.
 */
public class IntroScreen extends BaseScreen {


    private Texture img;

    public IntroScreen(final GrandpaGame game) {
        super(game);
        img = new Texture("instructions.png");
        Gdx.input.setInputProcessor(null);

        Timer timer = new Timer();
        timer.scheduleTask(new Timer.Task() {
            @Override
            public void run() {
                game.openLevelSelectScreen();
            }
        }, 5f);
    }

    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glClearColor(1, 1, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(img, 0, 0);
        batch.end();
    }

    public void dispose() {
        batch.dispose();
        img.dispose();
    }

    @Override
    public void show() {}

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
    }
}

