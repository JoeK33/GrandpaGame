package com.myreliablegames.grandpagame;

import com.badlogic.gdx.Gdx;

/**
 * Created by Joe on 7/6/2016.
 */
public class Grandpa {

    private int health;

    public Grandpa() {
        health = Constants.GRANDPA_HEALTH;
    }

    public void takePill(Pill pill) {
        health += pill.getHealthValue();
        Gdx.app.log("Health" , Integer.toString(health));

    }

    public int getHealth() {
        return this.health;
    }
}
