package com.myreliablegames.grandpagame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

/**
 * Created by Joe on 7/7/2016.
 */
public class DrinkButton extends Button {

    public DrinkButton(BaseLevelAssets assets, final Grandpa grandpa, final Level level) {
        super(new TextureRegionDrawable(new TextureRegion(assets.drinkButtonUp)),
                new TextureRegionDrawable(new TextureRegion(assets.drinkButtonDown)));

        this.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                if (!level.isPaused()) {
                    grandpa.drink();
                }
            }
        });
    }
}
