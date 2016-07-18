package com.myreliablegames.grandpagame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.myreliablegames.grandpagame.Diseases.DiseaseManager;
import com.myreliablegames.grandpagame.Screens.GameScreen;
import com.myreliablegames.grandpagame.Screens.MedicineCabinetScreen;
import com.myreliablegames.grandpagame.Screens.PrescriptionScreen;

/**
 * Created by Joe on 7/5/2016.
 */
public abstract class Level {

    BaseLevelAssets baseLevelAssets;
    PillManager pillManager;
    Grandpa grandpa;
    boolean paused;
    GameHUD gameHUD;
    GameScreen gameScreen;
    MedicineCabinetScreen medicineCabinetScreen;
    PrescriptionScreen prescriptionScreen;
    GrandpaGame game;
    InputMultiplexer multiplexer;
    DiseaseManager diseaseManager;
    protected GrandpaGame.LevelNumber levelNumber;
    private BlurEffect blurEffect;
    private float blurryVisionIntensity;

    public Level(GameScreen gameScreen, GrandpaGame game, BaseLevelAssets assets, GrandpaGame.LevelNumber levelNumber) {
        this.game = game;
        this.gameScreen = gameScreen;
        this.medicineCabinetScreen = new MedicineCabinetScreen(game, gameScreen);
        this.prescriptionScreen = new PrescriptionScreen(game, gameScreen);

        baseLevelAssets = assets;
        pillManager = new PillManager(baseLevelAssets);
        paused = false;
        grandpa = new Grandpa(this);
        gameHUD = new GameHUD(baseLevelAssets, grandpa, gameScreen, this);

        // Remove input processor so players can not change levels while pills are falling.
        Gdx.input.setInputProcessor(null);

        // Combine the input from the UI and the game screen and process them together.
        multiplexer = new InputMultiplexer();
        multiplexer.addProcessor(gameHUD.getInputProcessor());
        multiplexer.addProcessor(gameScreen);
        Gdx.input.setInputProcessor(multiplexer);

        this.levelNumber = levelNumber;
        blurEffect = new BlurEffect();
    }

    public void show() {
        Gdx.input.setInputProcessor(multiplexer);
    }

    public void render(SpriteBatch batch) {

        // Begin the blur effect. Anything drawn from here to blurEffect.end() will be blurred.
        // This will be a no-op when blur is not enabled.
        blurEffect.begin();

        Gdx.gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Render background.
        BitmapFont font = gameScreen.getFont();
        batch.begin();
        font.draw(batch, "Game Screen", 0, Constants.WORLD_HEIGHT);
        font.draw(batch, "Level Number " + levelNumber.toString(), 0, Constants.WORLD_HEIGHT / 2);
        batch.end();
        batch.flush();

        // Render foreground.
        batch.begin();
        pillManager.draw(batch);
        diseaseManager.draw(batch);
        batch.end();
        batch.flush();

        // Apply the blur effect. Again, this is a no-op when blur is disabled.
        blurEffect.end(batch);

        // Draw HUD on top.
        gameHUD.draw(batch);
    }

    public void update(float delta) {
        diseaseManager.update(delta);
        gameHUD.update(delta);
        grandpa.update(delta);
        pillManager.update(delta);
    }

    public void openMedicineCabinet() {
        game.setScreen(medicineCabinetScreen);
    }

    public void showPrescriptionScreen() {game.setScreen(prescriptionScreen);}

    public void dispose() {
        baseLevelAssets.dispose();
    }

    public void touchDown(Vector2 touchPos) {
        if (!paused) {
            Pill pill = pillManager.getTouchedPill(touchPos);
            if (pill != null) {
                grandpa.takePill(pill);
                pill.setActive(false);
            }
        }
    }

    public void backPress() {
        baseLevelAssets.diseaseSounds.stopSounds();
    }

    public void pauseToggle() {
        paused = !paused;
    }

    public boolean isPaused() {
        return paused;
    }

    public void resize(int width, int height) {
        gameHUD.resize(width, height);
        blurEffect.resize(width, height);
    }

    public void lose() {
        Gdx.app.log("Loser", "Game over");
    }

    public void setBlurryVisionIntensity(float blurryVisionIntensity) {
        blurEffect.setBlurRadius(blurryVisionIntensity);
    }
}
