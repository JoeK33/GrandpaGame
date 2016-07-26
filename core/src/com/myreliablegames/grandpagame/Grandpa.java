package com.myreliablegames.grandpagame;

import com.badlogic.gdx.Gdx;
import com.myreliablegames.grandpagame.Diseases.DiseaseManager;

/**
 * Created by Joe on 7/6/2016.
 */
public class Grandpa {

    private int health = Constants.GRANDPA_HEALTH;
    private DiseaseManager diseaseManager;
    private int correctPillsTaken = 0;
    private Level level;

    public Grandpa(Level level) {
        this.level = level;
    }

    public void setDiseaseManager(DiseaseManager diseaseManager) {
        this.diseaseManager = diseaseManager;
    }

    public void takePill(Pill pill) {
        if (diseaseManager.tryCureDisease(pill)) {
            // Correct pill
            health += pill.getHealthValue();
            correctPillsTaken++;
            Gdx.app.log("Health", " up");
        } else {
            // Wrong pill
            health -= pill.getHealthValue();
            Gdx.app.log("Health", "down");

        }

        if (health < 1) {
            level.lose();
        }

        constrainHealth();
        Gdx.app.log("Health", Integer.toString(health));
    }

    public void drink() {
        health += 10;
    }

    public void eat() {
        health += 10;
    }

    public void update(float delta) {
        constrainHealth();
    }

    public void damage(int damage) {
        this.health -= damage;
    }

    public int getHealth() {
        return this.health;
    }

    public DiseaseManager getDiseaseManager() {
        return this.diseaseManager;
    }

    private void constrainHealth() {
        if (health > Constants.GRANDPA_HEALTH) {
            health = Constants.GRANDPA_HEALTH;
        } else if (health < 0) {
            health = 0;
        }
    }
}
