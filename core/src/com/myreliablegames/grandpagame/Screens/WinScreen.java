package com.myreliablegames.grandpagame.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.myreliablegames.grandpagame.Constants;
import com.myreliablegames.grandpagame.GrandpaGame;

/**
 * Created by Joe on 7/5/2016.
 */
public class WinScreen extends BaseScreen implements InputProcessor {

    public WinScreen(GrandpaGame game) {
        super(game);
        Gdx.input.setInputProcessor(this);
    }

    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glClearColor(1, 0, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        font.draw(batch, "Win Screen", 0, Constants.WORLD_HEIGHT);
        font.draw(batch, "Click to Continue", 0, Constants.WORLD_HEIGHT - 50);
        batch.end();
    }

    public void dispose() {
        batch.dispose();
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        game.openLevelSelectScreen();
        return false;
    }

    // Unused input methods
    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
