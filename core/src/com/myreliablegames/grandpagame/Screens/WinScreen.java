package com.myreliablegames.grandpagame.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.utils.Timer;
import com.myreliablegames.grandpagame.Constants;
import com.myreliablegames.grandpagame.GrandpaGame;

/**
 * Created by Joe on 7/5/2016.
 */
public class WinScreen extends BaseScreen implements InputProcessor {

    private Texture bg;
    private Sound winSound;
    private String winString = "You Win!";
    private String complianceString1 = "Patient compliance";
    private String complianceString2 = "is a real issue.";
    private int winLength;
    private int compliance1Length;
    private int compliance2Length;
    private int lineHeight;
    private long startTime;


    public WinScreen(GrandpaGame game) {
        super(game);
        bg = new Texture(Gdx.files.internal("winbg.png"));
        winSound = Gdx.audio.newSound(Gdx.files.internal("sounds/clapping.wav"));
        winSound.play();

        // Don't set input processor until all the strings have been displayed.
        Timer timer = new Timer();
        timer.scheduleTask(new Timer.Task() {
            @Override
            public void run() {
                Gdx.input.setInputProcessor(WinScreen.this);
            }
        }, 2.5f);


        winLength = getStringLength(winString);
        compliance1Length = getStringLength(complianceString1);
        compliance2Length = getStringLength(complianceString2);
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
        batch.draw(bg, 0, 0);
        font.draw(batch, winString , Constants.WORLD_WIDTH / 2 - winLength / 2  ,Constants.WORLD_HEIGHT /2);

        if (TimeUtils.nanoTime() > startTime + (TimeUtils.millisToNanos(1500))) {
            font.draw(batch, complianceString1, Constants.WORLD_WIDTH / 2 - compliance1Length / 2, Constants.WORLD_HEIGHT / 2 - lineHeight);
        }

        if (TimeUtils.nanoTime() > startTime + (TimeUtils.millisToNanos(2500))) {
            font.draw(batch, complianceString2, Constants.WORLD_WIDTH / 2 - compliance2Length / 2, Constants.WORLD_HEIGHT / 2 - (2 * lineHeight));
        }

        batch.end();
    }

    public void dispose() {
        batch.dispose();
        bg.dispose();
        winSound.dispose();
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        game.openCreditsScreen();
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
