package com.myreliablegames.grandpagame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.myreliablegames.grandpagame.Screens.LevelSelectScreen;

/**
 * Created by Joe on 7/29/2016.
 */
public class LockTable {

    private Stage stage;
    private Table table;
    private Texture lockTex;

    private Image button1;
    private Image button2;
    private Image button3;
    private Image button4;
    private Image button5;
    private Image button6;

    private SaveGameData saveGameData;

    public LockTable(BitmapFont font, LevelSelectScreen levelSelectScreen, SaveGameData saveGameData) {
        this.saveGameData = saveGameData;
        lockTex = new Texture(Gdx.files.internal("levelbuttons/locked.png"));
        stage = new Stage(levelSelectScreen.getViewport());
        Skin skin = new Skin();
        skin.add("default", font);
        table = new Table(skin);
        table.defaults().pad(25);
        Pixmap pixmap = new Pixmap(155, 100, Pixmap.Format.RGB888);
        skin.add("default", new Texture(pixmap));

        TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.up = skin.newDrawable("default", Color.LIGHT_GRAY);
        textButtonStyle.down = skin.newDrawable("default", Color.WHITE);
        textButtonStyle.checked = skin.newDrawable("default", Color.LIGHT_GRAY);
        textButtonStyle.over = skin.newDrawable("default", Color.LIGHT_GRAY);

        textButtonStyle.font = skin.getFont("default");

        skin.add("default", textButtonStyle);

        Label label = new Label("", new Label.LabelStyle(font, Color.WHITE));
        table.add(label).colspan(3).expandX().expandY().center();
        table.row();

        button1 = new Image(lockTex);
        button2 = new Image(lockTex);
        button3 = new Image(lockTex);
        table.add(button1).expandX().expandY().padLeft(10);
        table.add(button2).expandX().expandY();
        table.add(button3).expandX().expandY().padRight(10);
        table.row();

        button4 = new Image(lockTex);
        button5 = new Image(lockTex);
        button6 = new Image(lockTex);
        table.add(button4).expandX().expandY().fill().padLeft(10);
        table.add(button5).expandX().expandY().fill();
        table.add(button6).expandX().expandY().fill().padRight(10);
        table.setFillParent(true);
        stage.addActor(table);
        table.pack();
        table.validate();
        checkVisibility();
    }

    public void render(float delta) {
        checkVisibility();
        stage.act(delta);
        stage.draw();
    }

    public void dispose() {
        lockTex.dispose();
        stage.dispose();
    }

    private void checkVisibility() {
        if (saveGameData.isLevelUnlocked(GrandpaGame.LevelNumber.One)) {
            button1.setVisible(false);
        }
        if (saveGameData.isLevelUnlocked(GrandpaGame.LevelNumber.Two)) {
            button2.setVisible(false);
        }
        if (saveGameData.isLevelUnlocked(GrandpaGame.LevelNumber.Three)) {
            button3.setVisible(false);
        }
        if (saveGameData.isLevelUnlocked(GrandpaGame.LevelNumber.Four)) {
            button4.setVisible(false);
        }
        if (saveGameData.isLevelUnlocked(GrandpaGame.LevelNumber.Five)) {
            button5.setVisible(false);
        }
        if (saveGameData.isLevelUnlocked(GrandpaGame.LevelNumber.Six)) {
            button6.setVisible(false);
        }
    }
}
