package com.myreliablegames.grandpagame.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.utils.Timer;
import com.myreliablegames.grandpagame.Constants;
import com.myreliablegames.grandpagame.GrandpaGame;

/**
 * Created by Joe on 7/29/2016.
 */
public class CreditsScreen extends BaseScreen implements InputProcessor {

    private String thanksString = "Thank you for playing!";
    private String programmingCreditString = "Programming and art by";
    private String programmingCreditString2 = "MyReliableGames";
    private String musicCreditString = "Music by";
    private String musicCreditString2 = "Nornec";
    private String musicCreditString3 = "soundcloud.com/nornec";
    private int thanksLength;
    private int programmingLength;
    private int programmingLength2;
    private int musicLength;
    private int musicLength2;
    private int musicLength3;
    private int lineHeight;
    private long startTime;


    public CreditsScreen(GrandpaGame game) {
        super(game);
        // Don't set input processor until all the strings have been displayed.
        Timer timer = new Timer();
        timer.scheduleTask(new Timer.Task() {
            @Override
            public void run() {
                Gdx.input.setInputProcessor(CreditsScreen.this);
            }
        }, 5.5f);

        font.getData().setScale(.3f);
        thanksLength = getStringLength(thanksString);
        programmingLength = getStringLength(programmingCreditString);
        programmingLength2 = getStringLength(programmingCreditString2);
        musicLength = getStringLength(musicCreditString);
        musicLength2 = getStringLength(musicCreditString2);
        musicLength3 = getStringLength(musicCreditString3);
        lineHeight = (int) font.getLineHeight();
        startTime = TimeUtils.nanoTime();


    }

    GlyphLayout layout = new GlyphLayout();

    private int getStringLength(String s) {
        layout.setText(font, s);
        return (int) layout.width;
    }

    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glClearColor(0.686f, 0.933f, 0.933f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        font.draw(batch, thanksString, (Constants.WORLD_WIDTH / 2) - (thanksLength / 2), 5 * (Constants.WORLD_HEIGHT / 6));

        if (TimeUtils.nanoTime() > startTime + (TimeUtils.millisToNanos(1000))) {
            font.draw(batch, programmingCreditString, (Constants.WORLD_WIDTH / 2) - (programmingLength / 2), (2 * (Constants.WORLD_HEIGHT / 3)) - lineHeight);
        }

        if (TimeUtils.nanoTime() > startTime + (TimeUtils.millisToNanos(2000))) {
            font.draw(batch, programmingCreditString2, (Constants.WORLD_WIDTH / 2) - (programmingLength2 / 2), (2 * (Constants.WORLD_HEIGHT / 3)) - (2 * lineHeight));
        }

        if (TimeUtils.nanoTime() > startTime + (TimeUtils.millisToNanos(3000))) {
            font.draw(batch, musicCreditString, (Constants.WORLD_WIDTH / 2) - (musicLength / 2), (2 * (Constants.WORLD_HEIGHT / 3)) - (4 * lineHeight));
        }

        if (TimeUtils.nanoTime() > startTime + (TimeUtils.millisToNanos(4000))) {
            font.draw(batch, musicCreditString2, (Constants.WORLD_WIDTH / 2) - (musicLength2 / 2), (2 * (Constants.WORLD_HEIGHT / 3)) - (5 * lineHeight));
        }

        if (TimeUtils.nanoTime() > startTime + (TimeUtils.millisToNanos(5000))) {
            font.draw(batch, musicCreditString3, (Constants.WORLD_WIDTH / 2) - (musicLength3 / 2), (2 * (Constants.WORLD_HEIGHT / 3)) - (6 * lineHeight));
        }

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
        game.openTitleScreen();
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

