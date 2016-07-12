package com.myreliablegames.grandpagame;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

/**
 * Created by Joe on 7/7/2016.
 */
public class EatButton extends Button {
    public EatButton(BaseLevelAssets assets, final Grandpa grandpa, final Level level) {
        super(new TextureRegionDrawable(new TextureRegion(assets.eatButtonUp)),
                new TextureRegionDrawable(new TextureRegion(assets.eatButtonDown)));

        this.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                if (!level.isPaused()) {
                    grandpa.eat();
                }
            }
        });
    }
}
