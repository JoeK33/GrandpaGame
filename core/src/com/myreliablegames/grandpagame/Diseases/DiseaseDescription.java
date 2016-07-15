package com.myreliablegames.grandpagame.Diseases;

import com.myreliablegames.grandpagame.DrugName;
import com.myreliablegames.grandpagame.Pill;

/**
 * Created by Joe on 7/14/2016.
 */
public class DiseaseDescription {

    private DrugName cure;
    private int damage;

    public DiseaseDescription(DrugName cure, int damage) {
        this.cure = cure;
        this.damage = damage;
    }


    public DrugName getCure() {
        return this.cure;
    }

    public int getDamage() {
        return this.damage;
    }
}
