package com.myreliablegames.grandpagame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.myreliablegames.grandpagame.Screens.LevelSelectScreen;

import java.util.ArrayList;

/**
 * Created by Joe on 7/5/2016.
 */
public class LevelSelectButtonHolder {

    private Stage stage;
    private Table table;
    private LockTable lockTable;
    private BitmapFont font;
    private ArrayList<Texture> buttonsTextures = new ArrayList();
    private ArrayList<LevelSelectButton> buttons = new ArrayList();
    private SaveGameData saveGameData = new SaveGameData();

    public LevelSelectButtonHolder(BitmapFont font, GrandpaGame game, LevelSelectScreen levelSelectScreen) {
        this.font = font;
        this.font.getData().setScale(.5f);
        this.font.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        stage = new Stage(levelSelectScreen.getViewport());
        Skin skin = new Skin();
        skin.add("default", this.font);
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

        Label label = new Label("Level Select", new Label.LabelStyle(font, Color.WHITE));
        table.add(label).colspan(3).expandX().expandY().center();
        table.row();

        LevelSelectButton button1 = makeButton(game, GrandpaGame.LevelNumber.One);
        LevelSelectButton button2 = makeButton(game, GrandpaGame.LevelNumber.Two);
        LevelSelectButton button3 = makeButton(game, GrandpaGame.LevelNumber.Three);
        table.add(button1).expandX().expandY().padLeft(10);
        table.add(button2).expandX().expandY();
        table.add(button3).expandX().expandY().padRight(10);
        table.row();

        LevelSelectButton button4 = makeButton(game, GrandpaGame.LevelNumber.Four);
        LevelSelectButton button5 = makeButton(game, GrandpaGame.LevelNumber.Five);
        LevelSelectButton button6 = makeButton(game, GrandpaGame.LevelNumber.Six);
        table.add(button4).expandX().expandY().fill().padLeft(10);
        table.add(button5).expandX().expandY().fill();
        table.add(button6).expandX().expandY().fill().padRight(10);
        table.setFillParent(true);
        stage.addActor(table);
        table.pack();
        table.validate();

        lockTable = new LockTable(font, levelSelectScreen, saveGameData);

    }

    public InputProcessor getInputProcessor() {
        return this.stage;
    }

    public void render(float delta) {
        stage.act(delta);
        stage.draw();
        lockTable.render(delta);
    }

    private LevelSelectButton makeButton(GrandpaGame game, GrandpaGame.LevelNumber levelNumber) {
        LevelSelectButton tempButton = new LevelSelectButton(game, levelNumber, getButtonUpTexture(levelNumber), getButtonDownTexture(levelNumber), saveGameData);
        buttons.add(tempButton);
        return tempButton;
    }

    private Drawable getButtonUpTexture(GrandpaGame.LevelNumber levelNumber) {

        Texture tempTex;

        if (levelNumber == GrandpaGame.LevelNumber.One) {
            tempTex = new Texture(Gdx.files.internal("levelbuttons/chairbuttonup.png"));
        } else if (levelNumber == GrandpaGame.LevelNumber.Two) {
            tempTex = new Texture(Gdx.files.internal("levelbuttons/bathroombuttonup.png"));
        } else if (levelNumber == GrandpaGame.LevelNumber.Three) {
            tempTex = new Texture(Gdx.files.internal("levelbuttons/picnicbuttonup.png"));
        } else if (levelNumber == GrandpaGame.LevelNumber.Four) {
            tempTex = new Texture(Gdx.files.internal("levelbuttons/lawnbuttonup.png"));
        } else if (levelNumber == GrandpaGame.LevelNumber.Five) {
            tempTex = new Texture(Gdx.files.internal("levelbuttons/garagebuttonup.png"));
        } else {
            tempTex = new Texture(Gdx.files.internal("levelbuttons/factorybuttonup.png"));
        }

        buttonsTextures.add(tempTex);

        return new SpriteDrawable(new Sprite(tempTex));
    }

    private Drawable getButtonDownTexture(GrandpaGame.LevelNumber levelNumber) {
        Texture tempTex;

        if (levelNumber == GrandpaGame.LevelNumber.One) {
            tempTex = new Texture(Gdx.files.internal("levelbuttons/chairbuttondown.png"));
        } else if (levelNumber == GrandpaGame.LevelNumber.Two) {
            tempTex = new Texture(Gdx.files.internal("levelbuttons/bathroombuttondown.png"));
        } else if (levelNumber == GrandpaGame.LevelNumber.Three) {
            tempTex = new Texture(Gdx.files.internal("levelbuttons/picnicbuttondown.png"));
        } else if (levelNumber == GrandpaGame.LevelNumber.Four) {
            tempTex = new Texture(Gdx.files.internal("levelbuttons/lawnbuttondown.png"));
        } else if (levelNumber == GrandpaGame.LevelNumber.Five) {
            tempTex = new Texture(Gdx.files.internal("levelbuttons/garagebuttondown.png"));
        } else {
            tempTex = new Texture(Gdx.files.internal("levelbuttons/factorybuttondown.png"));
        }

        return new SpriteDrawable(new Sprite(tempTex));
    }

    public void dispose() {
        stage.dispose();

        for (Texture t : buttonsTextures) {
            t.dispose();
        }

    }

    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
        table.validate();
    }

}
