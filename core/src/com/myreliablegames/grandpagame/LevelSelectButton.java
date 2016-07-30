package com.myreliablegames.grandpagame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

/**
 * Created by Joe on 7/5/2016.
 */
public class LevelSelectButton extends Button {

    public LevelSelectButton(final GrandpaGame game, final GrandpaGame.LevelNumber level, Drawable buttonUp, Drawable buttonDown, final SaveGameData saveGameData) {
        super(buttonUp, buttonDown);
               this.addListener(new com.badlogic.gdx.scenes.scene2d.utils.ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                if (saveGameData.isLevelUnlocked(level)) {
                    game.startLevel(level);
                }
            }
        });
    }
}
