package com.myreliablegames.grandpagame.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.utils.NinePatchDrawable;
import com.myreliablegames.grandpagame.BackGround;
import com.myreliablegames.grandpagame.BaseLevelAssets;
import com.myreliablegames.grandpagame.Constants;
import com.myreliablegames.grandpagame.Grandpa;
import com.myreliablegames.grandpagame.GrandpaGame;
import com.myreliablegames.grandpagame.Level;
import com.myreliablegames.grandpagame.LevelAssets;
import com.myreliablegames.grandpagame.PaperHUD;
import com.myreliablegames.grandpagame.PrescriptionWriter;

/**
 * Created by Joe on 7/8/2016.
 */
public class PrescriptionScreen extends BaseScreen {

    private GameScreen gameScreen;
    private NinePatchDrawable paperBG;
    private PaperHUD hud;
    private PrescriptionWriter writer;
    private Grandpa grandpa;
    private BackGround backGround;

    public PrescriptionScreen(GrandpaGame game, GameScreen gameScreen, BaseLevelAssets assets, Grandpa grandpa, LevelAssets levelAssets) {
        super(game);
        this.gameScreen = gameScreen;
        paperBG = new NinePatchDrawable(assets.paperPatch);
        hud = new PaperHUD(game, gameScreen, assets, grandpa);
        this.grandpa = grandpa;
        backGround = new BackGround(levelAssets);

    }

    public void initWriter() {
        writer = new PrescriptionWriter(grandpa.getDiseaseManager().getAllDiseases(), font);
    }

    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glClearColor(1, .5f, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        backGround.draw(batch);
        paperBG.draw(batch,
                Constants.PAPER_NINEPATCH_BUFFER,
                Constants.PAPER_NINEPATCH_BUFFER,
                Constants.WORLD_WIDTH - Constants.PAPER_NINEPATCH_BUFFER * 2,
                Constants.WORLD_HEIGHT - Constants.PAPER_NINEPATCH_BUFFER * 3);
        writer.draw(batch);
       // font.draw(batch, "Prescription", 0, Constants.WORLD_HEIGHT);
     //   font.draw(batch, "Click to go back", 0, Constants.WORLD_HEIGHT - 50);
        batch.end();

        hud.draw(batch);
        update(delta);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(hud.getInputProcessor());
    }

    public void update(float delta) {
        hud.update(delta);
        gameScreen.update(delta);

    }

    public void dispose() {
        batch.dispose();
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
        hud.resize(width, height);
    }

}
