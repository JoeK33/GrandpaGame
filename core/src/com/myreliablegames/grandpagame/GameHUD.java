package com.myreliablegames.grandpagame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.myreliablegames.grandpagame.Screens.GameScreen;

/**
 * Created by Joe on 7/6/2016.
 */
public class GameHUD {

    private Stage stage;
    private Table table;
    private HealthBar healthBar;
    private DrinkButton drinkButton;
    private EatButton eatButton;
    private MedicineBottleButton medicineBottleButton;
    private PrescriptionButton prescriptionButton;
    private Grandpa grandpa;

    public GameHUD(BaseLevelAssets assets, Grandpa grandpa, GameScreen gameScreen, Level level) {
        this.grandpa = grandpa;
        stage = new Stage(gameScreen.getViewport());
        table = new Table();
        table.setFillParent(true);
        table.defaults().expandY().pad(10);

        drinkButton = new DrinkButton(assets, grandpa);
        eatButton = new EatButton(assets, grandpa);
        medicineBottleButton = new MedicineBottleButton(assets, level);
        prescriptionButton = new PrescriptionButton(assets, level);

        healthBar = new HealthBar(assets);
        healthBar.setWidth(200);
        healthBar.setHeight(30);
        table.add(healthBar).expandX().top().right().colspan(4).pad(10);
        table.row();
        table.add(drinkButton).size(90, 90).bottom().width(100);
        table.add(eatButton).size(90, 90).bottom().left().padLeft(-5).width(100).expandX();
        table.add(prescriptionButton).size(90, 90).bottom().right().padRight(-5).width(100).expandX();
        table.add(medicineBottleButton).size(90, 90).bottom().right().width(100);
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
