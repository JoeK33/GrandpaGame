package com.myreliablegames.grandpagame;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by Joe on 7/11/2016.
 */
public class PillDescription {

    private TextureRegion textureRegion;
    private DrugName drugName;
    private String description;
    private int healthValue;
    private Animation animation;


    public PillDescription(TextureRegion textureRegion, String description, int healthValue, DrugName drugName, Animation animation) {
        this.textureRegion = textureRegion;
        this.description = description;
        this.healthValue = healthValue;
        this.drugName = drugName;
        this.animation = animation;

    }

    public Animation getAnimation() {
        return animation;
    }

    public TextureRegion getTextureRegion() {
        return this.textureRegion;
    }

    public String getDescription() {
        return this.description;
    }

    public int getHealthValue() {
        return this.healthValue;
    }

    public DrugName getDrugName() {
        return this.drugName;
    }

    enum PillShape {
        Triangle, Circle, Square, Pentagon, Oval;
    }

}
