package com.myreliablegames.grandpagame.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.myreliablegames.grandpagame.Constants;
import com.myreliablegames.grandpagame.GrandpaGame;
import com.myreliablegames.grandpagame.Level;
import com.myreliablegames.grandpagame.LevelFactory;

/**
 * Created by Joe on 7/5/2016.
 */
public class GameScreen extends BaseScreen implements InputProcessor {

    private GrandpaGame.LevelNumber levelNumber;
    private Level level;

    public GameScreen(GrandpaGame game, GrandpaGame.LevelNumber levelNumber) {
        super(game);
        this.levelNumber = levelNumber;
        Gdx.input.setInputProcessor(this);
        level = LevelFactory.getLevel(levelNumber);
    }

    public void render(float delta) {
        batch.setProjectionMatrix(camera.combined);
        super.render(delta);
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        font.draw(batch, "Game Screen", 0, Constants.WORLD_HEIGHT);
        font.draw(batch, "Level Number " + levelNumber.toString(), 0, Constants.WORLD_HEIGHT / 2);
        level.render(batch);
        batch.end();

        level.update(delta);
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
        game.openWinLevelScreen();
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
