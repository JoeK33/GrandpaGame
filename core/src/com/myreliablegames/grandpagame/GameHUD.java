package com.myreliablegames.grandpagame;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

/**
 * Created by Joe on 7/6/2016.
 */
public class GameHUD {

    private Stage stage;
    private Table table;
    private HealthBar healthBar;
    private Grandpa grandpa;

    public GameHUD(BaseLevelAssets assets, Grandpa grandpa) {
        this.grandpa = grandpa;
        stage = new Stage();
        table = new Table();
        table.setFillParent(true);
        table.defaults().center().expandX().expandY().pad(25);

        healthBar = new HealthBar(assets);
        healthBar.setWidth(400);
        healthBar.setHeight(75);
        table.add(healthBar).expandX().top().right();
        stage.addActor(table);
        table.pack();
    }

    public void draw(SpriteBatch batch) {
        stage.draw();
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
