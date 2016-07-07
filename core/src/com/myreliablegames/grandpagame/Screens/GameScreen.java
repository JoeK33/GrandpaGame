package com.myreliablegames.grandpagame.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
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
        if (level.isPaused()) {
            batch.begin();
            font.draw(batch, "     PAUSED \n TOUCH TO CONTINUE", 0, (Constants.WORLD_HEIGHT / 3) * 2);
            batch.end();
        }

        level.update(delta);
    }

    public void dispose() {
        batch.dispose();
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
        level.resize(width, height);
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {

        if (level.isPaused()) {
            level.pauseToggle();
        } else {
            Vector3 gameTouchPos = camera.unproject(new Vector3(screenX, screenY, 0));
            level.touchDown(new Vector2(gameTouchPos.x, gameTouchPos.y));
        }

        return false;
    }

    // Handle back button in game here.
    @Override
    public boolean keyDown(int keycode) {
        if(keycode == Input.Keys.BACK || keycode == Input.Keys.P){
            if (level.isPaused()) {
                game.openLevelSelectScreen();
            } else {
                level.pauseToggle();
            }
        }
        return false;
    }

    // Unused input methods
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
