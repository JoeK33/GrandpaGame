package com.myreliablegames.grandpagame.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Timer;
import com.myreliablegames.grandpagame.Constants;
import com.myreliablegames.grandpagame.GrandpaGame;

/**
 * Created by Joe on 7/5/2016.
 */
public class GameOverScreen extends BaseScreen implements InputProcessor {

    private Texture bg;
    private Sound gameOverSound;

    public GameOverScreen(GrandpaGame game) {
        super(game);

        bg = new Texture(Gdx.files.internal("gameover.png"));
        gameOverSound = Gdx.audio.newSound(Gdx.files.internal("sounds/gameoversound.ogg"));
        gameOverSound.play(.7f);

        Timer timer = new Timer();
        timer.scheduleTask(new Timer.Task() {
            @Override
            public void run() {
                Gdx.input.setInputProcessor(GameOverScreen.this);
            }
        }, 1f);

    }

    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(bg, 0, 0);
        batch.end();
    }

    public void dispose() {
        batch.dispose();
        gameOverSound.dispose();
        bg.dispose();
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
