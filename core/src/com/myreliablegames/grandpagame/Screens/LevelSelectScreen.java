package com.myreliablegames.grandpagame.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.myreliablegames.grandpagame.GrandpaGame;
import com.myreliablegames.grandpagame.LevelSelectBackground;
import com.myreliablegames.grandpagame.LevelSelectButtonHolder;

/**
 * Created by Joe on 7/5/2016.
 */
public class LevelSelectScreen extends BaseScreen implements InputProcessor {

    private LevelSelectButtonHolder buttons;
    private LevelSelectBackground background;
    private SpriteBatch batch;

    public LevelSelectScreen(GrandpaGame game) {
        super(game);
        buttons = new LevelSelectButtonHolder(font, game, this);
        batch = new SpriteBatch();
        background = new LevelSelectBackground();
        InputMultiplexer multiplexer = new InputMultiplexer();
        multiplexer.addProcessor(buttons.getInputProcessor());
        multiplexer.addProcessor(this);
        Gdx.input.setInputProcessor(multiplexer);
    }

    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glClearColor(.69f, .88f, .9f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        background.draw(batch);
        batch.end();
        buttons.render(delta);
        background.update(delta);
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
        buttons.resize(width, height);
    }

    @Override
    public boolean keyDown(int keycode) {
        if (keycode == Input.Keys.P || keycode == Input.Keys.BACK) {
            game.openTitleScreen();
        }
        return false;
    }

    @Override
    public void dispose() {
        super.dispose();
        background.dispose();
    }

    // Unused input methods
    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) { return false; }

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
