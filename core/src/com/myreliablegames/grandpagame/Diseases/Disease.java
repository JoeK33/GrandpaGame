package com.myreliablegames.grandpagame.Diseases;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.myreliablegames.grandpagame.DrugName;
import com.myreliablegames.grandpagame.Grandpa;
import com.myreliablegames.grandpagame.Pill;

/**
 * Created by Joe on 7/14/2016.
 */
public abstract class Disease {

    private DiseaseDescription description;
    private DiseaseName diseaseName;
    boolean cured;

    public Disease(DiseaseDescription description, DiseaseName name) {
        this.description = description;
        diseaseName = name;
        cured = false;
    }

    public DiseaseName getDiseaseName() {
        return diseaseName;
    }

    public void setCured(boolean cured) {
        this.cured = cured;
    }

    public boolean isCureDrug(DrugName name) {
        return (this.description.getCure() == name);
    }

    public DiseaseDescription getDescription() {
        return description;
    }

    public int getDamage() {
        if (cured) {
            return 0;
        } else {
            return description.getDamage();
        }
    }

    public abstract void draw(SpriteBatch batch);
    public abstract void update(float delta);
    public abstract void cureDisease();
    public abstract void beginDisease();
    public abstract boolean readyForRemoval();
    public abstract String getPrescriptionDescription();

}
