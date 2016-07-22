package com.myreliablegames.grandpagame;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.myreliablegames.grandpagame.Screens.GameScreen;

/**
 * Created by Joe on 7/21/2016.
 */
public class PaperHUD {

    private Stage stage;
    private Table table;
    private HealthBar healthBar;
    private BackButton backButton;
    private Grandpa grandpa;

    public PaperHUD(GrandpaGame game, GameScreen gameScreen, BaseLevelAssets assets, Grandpa grandpa) {
        this.grandpa = grandpa;
        stage = new Stage(gameScreen.getViewport());
        table = new Table();
        table.setFillParent(true);
        table.defaults().expandY().pad(10);

        backButton = new BackButton(assets, game, gameScreen);

        healthBar = new HealthBar(assets);
        healthBar.setWidth(200);
        healthBar.setHeight(30);
        table.add(healthBar).expandX().top().right().colspan(4).pad(10);
        table.row();
        table.add(backButton).size(70, 70).bottom().right().width(75).colspan(4);
        stage.addActor(table);
        table.pack();

    }

    public void draw(SpriteBatch batch) {
        stage.draw();
    }

    public InputProcessor getInputProcessor() {
        return this.stage;
    }

    public void update(float delta) {
        stage.act(delta);
        healthBar.setHealth(grandpa.getHealth());
    }

    public void dispose() {
        stage.dispose();
    }

    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }
}
