package com.myreliablegames.grandpagame;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

/**
 * Created by Joe on 7/5/2016.
 */
public class LevelSelectButton extends TextButton {

    public LevelSelectButton(String text, Skin skin, final GrandpaGame game, final GrandpaGame.LevelNumber level) {
        super(text, skin);
        this.addListener(new com.badlogic.gdx.scenes.scene2d.utils.ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.startLevel(level);
            }
        });
    }
}
