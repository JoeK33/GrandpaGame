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

    public void drink() {
        health += 10;
    }

    public void eat() {
        health += 10;
    }

    public void update(float delta) {
        if (health > Constants.GRANDPA_HEALTH) {
            health = Constants.GRANDPA_HEALTH;
        } else if (health < 0) {
            health = 0;
        }
    }

    public int getHealth() {
        return this.health;
    }
}
