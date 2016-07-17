package com.myreliablegames.grandpagame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
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

    public Level(GameScreen gameScreen, GrandpaGame game, BaseLevelAssets assets) {
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

    }

    public void show() {
        Gdx.input.setInputProcessor(multiplexer);
    }

    public void render(SpriteBatch batch) {
        diseaseManager.draw(batch);
        pillManager.draw(batch);
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

    public void pauseToggle() {
        paused = !paused;
    }

    public boolean isPaused() {
        return paused;
    }

    public void resize(int width, int height) {
        gameHUD.resize(width, height);
    }

    public void lose() {
        Gdx.app.log("Loser", "Game over");
    }

}
