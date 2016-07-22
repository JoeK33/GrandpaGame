package com.myreliablegames.grandpagame;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.myreliablegames.grandpagame.Screens.GameScreen;

/**
 * Created by Joe on 7/21/2016.
 */
public class BackButton extends Button {
    public BackButton(BaseLevelAssets assets, final GrandpaGame game, final GameScreen gameScreen) {
        super(new TextureRegionDrawable(new TextureRegion(assets.backButtonUp)),
                new TextureRegionDrawable(new TextureRegion(assets.backButtonDown)));

        this.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.setScreen(gameScreen);

            }
        });
    }
}
