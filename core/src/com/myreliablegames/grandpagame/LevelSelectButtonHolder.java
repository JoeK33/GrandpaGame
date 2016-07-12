package com.myreliablegames.grandpagame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.myreliablegames.grandpagame.Screens.LevelSelectScreen;

/**
 * Created by Joe on 7/5/2016.
 */
public class LevelSelectButtonHolder {

    private Stage stage;
    private Table table;
    private BitmapFont font;

    public LevelSelectButtonHolder(BitmapFont font, GrandpaGame game, LevelSelectScreen levelSelectScreen) {
        this.font = font;
        this.font.getData().setScale(.5f);
        this.font.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        stage = new Stage(levelSelectScreen.getViewport());
        Gdx.input.setInputProcessor(stage);
        Skin skin = new Skin();
        skin.add("default", this.font);
        table = new Table(skin);
        table.defaults().pad(25);

        Pixmap pixmap = new Pixmap(155, 100, Pixmap.Format.RGB888);
        skin.add("default", new Texture(pixmap));

        TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.up = skin.newDrawable("default", Color.DARK_GRAY);
        textButtonStyle.down = skin.newDrawable("default", Color.WHITE);
        textButtonStyle.checked = skin.newDrawable("default", Color.DARK_GRAY);
        textButtonStyle.over = skin.newDrawable("default", Color.LIGHT_GRAY);

        textButtonStyle.font = skin.getFont("default");

        skin.add("default", textButtonStyle);

        Label label = new Label("Level Select", new Label.LabelStyle(font, Color.WHITE));
        table.add(label).colspan(3).expandX().expandY().center();
        table.row();

        LevelSelectButton button1 = new LevelSelectButton("Lv 1", skin, game, GrandpaGame.LevelNumber.One);
        LevelSelectButton button2 = new LevelSelectButton("Lv 2", skin, game, GrandpaGame.LevelNumber.Two);
        LevelSelectButton button3 = new LevelSelectButton("Lv 3", skin, game, GrandpaGame.LevelNumber.Three);
        table.add(button1).expandX().expandY().padLeft(10);
        table.add(button2).expandX().expandY();
        table.add(button3).expandX().expandY().padRight(10);
        table.row();

        LevelSelectButton button4 = new LevelSelectButton("Lv 4", skin, game, GrandpaGame.LevelNumber.Four);
        LevelSelectButton button5 = new LevelSelectButton("Lv 5", skin, game, GrandpaGame.LevelNumber.Five);
        LevelSelectButton button6 = new LevelSelectButton("Lv 6", skin, game, GrandpaGame.LevelNumber.Six);
        table.add(button4).expandX().expandY().fill().padLeft(10);
        table.add(button5).expandX().expandY().fill();
        table.add(button6).expandX().expandY().fill().padRight(10);

        table.setFillParent(true);
        stage.addActor(table);
        table.pack();
    }

    public void render(float delta) {
        stage.act(delta);
        stage.draw();
    }

    public void dispose() {
        stage.dispose();
    }

    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

}
