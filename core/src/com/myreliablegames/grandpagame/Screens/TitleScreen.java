package com.myreliablegames.grandpagame.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.utils.TimeUtils;
import com.myreliablegames.grandpagame.Constants;
import com.myreliablegames.grandpagame.GrandpaGame;

/**
 * Created by Joe on 7/5/2016.
 */
public class TitleScreen extends BaseScreen implements InputProcessor {

    private Texture img;
    private String startString = "Click To Start";
    private long blinkStart;

    public TitleScreen(GrandpaGame game) {
        super(game);
        img = new Texture("title.png");

        Gdx.input.setInputProcessor(this);
        blinkStart = TimeUtils.nanoTime();
    }

    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(img, 0, 0);
        if (blinkStart < TimeUtils.nanoTime() - TimeUtils.millisToNanos(500)) {
            font.draw(batch, startString, (Constants.WORLD_WIDTH / 2) - (getStringLength(startString) / 2), font.getLineHeight());
        }
        if (blinkStart < TimeUtils.nanoTime() - TimeUtils.millisToNanos(1500)) {
            blinkStart = TimeUtils.nanoTime();
        }
        batch.end();
    }

    public void dispose() {
        batch.dispose();
        img.dispose();
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        game.openIntroScreen();
        return false;
    }

    GlyphLayout layout = new GlyphLayout();
    private int getStringLength(String s) {
        layout.setText(font, s);
        return (int) layout.width;
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
