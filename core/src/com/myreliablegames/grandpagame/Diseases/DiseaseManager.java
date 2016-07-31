package com.myreliablegames.grandpagame.Diseases;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.TimeUtils;
import com.myreliablegames.grandpagame.BaseLevelAssets;
import com.myreliablegames.grandpagame.Constants;
import com.myreliablegames.grandpagame.DrugName;
import com.myreliablegames.grandpagame.Grandpa;
import com.myreliablegames.grandpagame.Level;
import com.myreliablegames.grandpagame.Pill;
import com.myreliablegames.grandpagame.PillManager;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**
 * Created by Joe on 7/14/2016.
 */
public class DiseaseManager {

    private ArrayList<Disease> possibleDiseases = new ArrayList<Disease>();
    private ArrayList<Disease> allDiseases = new ArrayList<Disease>();
    private ArrayList<Disease> activeDiseases = new ArrayList<Disease>();
    private DiseaseFactory diseaseFactory;
    private PillManager pillManager;
    private Grandpa grandpa;
    private float grandpaDamageTimer;
    private float activateDiseaseTimer;
    private Level level;
    private boolean fasterDiseaseSpawn;

    public DiseaseManager(
            PillManager pillManager,
            ArrayList<DiseaseName> levelDiseases,
            Grandpa grandpa,
            BaseLevelAssets assets,
            Level level, boolean fasterDiseaseSpawn) {
        this.fasterDiseaseSpawn = fasterDiseaseSpawn;
        this.level = level;
        this.grandpa = grandpa;
        this.pillManager = pillManager;
        diseaseFactory = new DiseaseFactory(pillManager.getPillsInPlay(), assets, pillManager, level);
        possibleDiseases.addAll(diseaseFactory.getDiseaseList(levelDiseases));
        allDiseases.addAll(possibleDiseases);
        grandpaDamageTimer = 0;
        activateDiseaseTimer = 0;
    }

    public void update(float delta) {

        Iterator<Disease> iterator = activeDiseases.iterator();
        while (iterator.hasNext()) {
            Disease disease = iterator.next();

            disease.update(delta);

            if (disease.readyForRemoval()) {
                possibleDiseases.add(disease);
                iterator.remove();
            }
        }

        if (grandpaDamageTimer > Constants.DISEASE_DAMAGE_INTERVAL) {
            grandpa.damage(getActiveDiseaseDamage());
            grandpaDamageTimer = 0;
        }

        if (fasterDiseaseSpawn) {
            if (activateDiseaseTimer > Constants.DISEASE_SPAWN_INTERVAL_FASTER) {
                activateADisease();
                activateDiseaseTimer = 0;
            }
        } else {
            if (activateDiseaseTimer > Constants.DISEASE_SPAWN_INTERVAL) {
                activateADisease();
                activateDiseaseTimer = 0;
            }
        }

        if (checkWinState()) {
            level.win();
        }

        Gdx.app.log("Active Diseases: ", activeDiseases.toString());
        Gdx.app.log("Possible Diseases: ", possibleDiseases.toString());

        grandpaDamageTimer += delta;
        activateDiseaseTimer += delta;
    }

    public void draw(SpriteBatch batch) {
        for (Disease disease : activeDiseases) {
            disease.draw(batch);
        }
    }

    public ArrayList<Disease> getAllDiseases() {
        return allDiseases;
    }

    public boolean tryCureDisease(Pill pill) {
        for (Disease disease : activeDiseases) {

            if (disease.isCureDrug(pill.getPillDescription().getDrugName()) && !disease.cured) {
                disease.cureDisease();
                return true;
            }
        }
        return false;
    }

    private int getActiveDiseaseDamage() {
        int damageSum = 0;
        for (Disease disease : activeDiseases) {
            damageSum += disease.getDamage();
        }
        return damageSum;
    }

    private void activateADisease() {
        ArrayList<DrugName> drugsRemaining = pillManager.getActiveDrugs();

        // Try to start a random disease.  If it doesn't work, start the first one that does.
        if (possibleDiseases.size() > 0) {
            int index = (possibleDiseases.size() == 1 ? 0 : getRandIntInRange(0, possibleDiseases.size() - 1));

            if (drugsRemaining.contains(possibleDiseases.get(index).getDescription().getCure()) &&
                    !activeDiseases.contains(possibleDiseases.get(index))) {

                Disease tempDisease = possibleDiseases.get(index);
                tempDisease.beginDisease();
                activeDiseases.add(tempDisease);
                possibleDiseases.remove(index);
            } else {

                Iterator<Disease> iterator = possibleDiseases.iterator();

                while (iterator.hasNext()) {
                    Disease disease = iterator.next();
                    if (drugsRemaining.contains(disease.getDescription().getCure())) {
                        disease.beginDisease();
                        activeDiseases.add(disease);
                        iterator.remove();
                        // return to only add a single disease
                        return;
                    }
                }
            }
        }
    }

    private boolean checkWinState() {
        ArrayList<DrugName> drugsRemaining = pillManager.getActiveDrugs();

        if (activeDiseases.isEmpty()) {
            for (Disease d : possibleDiseases) {
                if (drugsRemaining.contains(d.getDescription().getCure())) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    Random rand = new Random(TimeUtils.nanoTime());

    public int getRandIntInRange(int min, int max) {
        return rand.nextInt((max - min) + 1) + min;
    }
}
