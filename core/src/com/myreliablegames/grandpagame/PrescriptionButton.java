package com.myreliablegames.grandpagame;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

/**
 * Created by Joe on 7/8/2016.
 */
public class PrescriptionButton extends Button {
    public PrescriptionButton(BaseLevelAssets assets, final Level level) {
        super(new TextureRegionDrawable(new TextureRegion(assets.prescriptionButtonUp)),
                new TextureRegionDrawable(new TextureRegion(assets.prescriptionButtonDown)));

        this.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                level.showPrescriptionScreen();
            }
        });
    }
}
