package com.myreliablegames.grandpagame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.TimeUtils;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Joe on 7/11/2016.
 */
public class PillFactory {

    private BaseLevelAssets assets;
    private ArrayList<DrugName> unusedDrugNames;
    private ArrayList<Texture> unusedPillTextures;
    private ArrayList<Pill> pills;
    private final int PILL_HEALTH_VALUE = -15;

    public PillFactory(BaseLevelAssets assets, int numberOfPillTypes) {
        this.assets = assets;
        unusedDrugNames = DrugName.getDrugNameArrayList();
        unusedPillTextures = assets.pillAssets.getPillTextures();
        pills = new ArrayList<Pill>();

        for (int i = 0; i < numberOfPillTypes; i++) {
            pills.add(makePill(PILL_HEALTH_VALUE));
        }
    }

    private Pill makePill(int healthValue) {
        Texture pillTexture = getUnusedTexture();
        String pillDescriptionString = assets.pillAssets.getTextureDescription(pillTexture);
        PillDescription pillDescription = new PillDescription(pillTexture, pillDescriptionString, healthValue, getUnusedDrugName());
        return new Pill(pillDescription);
    }

    public Pill getPill() {
        int index = (pills.size() == 1 ? 0 : getRandIntInRange(0, pills.size() - 1));
        return copyPill(pills.get(index));
    }

    public Pill copyPill(Pill pill) {
        return new Pill(pill.getPillDescription());
    }

    private Texture getUnusedTexture() {
        int index = (unusedPillTextures.size() == 1 ? 0 : getRandIntInRange(0, unusedPillTextures.size() - 1));
        Texture tempTexture = unusedPillTextures.get(index);
        unusedPillTextures.remove(index);

        return tempTexture;
    }

    private DrugName getUnusedDrugName() {
        int index = (unusedDrugNames.size() == 1 ? 0 : getRandIntInRange(0, unusedDrugNames.size() - 1));
        DrugName tempName = unusedDrugNames.get(index);
        Gdx.app.log("Pill Factory", "Name : " + tempName.toString());
        unusedDrugNames.remove(index);

        return tempName;
    }

    public Pill getPlacebo() {
        return null;
    }

    Random rand = new Random(TimeUtils.nanoTime());

    public int getRandIntInRange(int min, int max) {
            return rand.nextInt((max - min) + 1) + min;
    }
}
