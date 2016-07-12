package com.myreliablegames.grandpagame;

import com.badlogic.gdx.graphics.Texture;

/**
 * Created by Joe on 7/11/2016.
 */
public class PillDescription {

    private Texture texture;
    private DrugName drugName;
    private String description;
    private int healthValue;

    public PillDescription (Texture texture, String description, int healthValue, DrugName drugName) {
        this.texture = texture;
        this.description = description;
        this.healthValue = healthValue;
        this.drugName = drugName;
    }

    public Texture getTexture() {
        return this.texture;
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
}
