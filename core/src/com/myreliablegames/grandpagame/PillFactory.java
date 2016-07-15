package com.myreliablegames.grandpagame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.TimeUtils;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Joe on 7/11/2016.
 */
public class PillFactory {

    private BaseLevelAssets assets;
    private ArrayList<DrugName> unusedDrugNames;
    private ArrayList<TextureRegion> unusedPillTextures;
    private ArrayList<Pill> pills;
    private final int PILL_HEALTH_VALUE = 25;
    private Random rand = new Random(TimeUtils.nanoTime());

    public PillFactory(BaseLevelAssets assets, int numberOfPillTypes, boolean floating) {
        this.assets = assets;
        unusedDrugNames = DrugName.getDrugNameArrayList();
        unusedPillTextures = assets.pillAssets.getPillTextures();
        pills = new ArrayList<Pill>();

        for (int i = 0; i < numberOfPillTypes; i++) {
            pills.add(makePill(PILL_HEALTH_VALUE, floating));
        }
    }

    private Pill makePill(int healthValue, boolean floating) {
        TextureRegion pillTexture = getUnusedTexture();
        String pillDescriptionString = assets.pillAssets.getTextureDescription(pillTexture);

        PillDescription pillDescription = new PillDescription(
                pillTexture,
                pillDescriptionString,
                healthValue,
                getUnusedDrugName(),
                assets.pillAssets.getPillHighlight(assets.pillAssets.getPillShape(pillTexture))
        );

        return new Pill(pillDescription, rand, floating);
    }

    public Pill getPill() {
        int index = (pills.size() == 1 ? 0 : getRandIntInRange(0, pills.size() - 1));
        return copyPill(pills.get(index));
    }

    public Pill copyPill(Pill pill) {
        return new Pill(pill.getPillDescription(), rand, pill.isFloating());
    }

    private TextureRegion getUnusedTexture() {
        int index = (unusedPillTextures.size() == 1 ? 0 : getRandIntInRange(0, unusedPillTextures.size() - 1));
        TextureRegion tempTexture = unusedPillTextures.get(index);
        unusedPillTextures.remove(index);

        return tempTexture;
    }

    private DrugName getUnusedDrugName() {
        int index = (unusedDrugNames.size() == 1 ? 0 : getRandIntInRange(0, unusedDrugNames.size() - 1));
        DrugName tempName = unusedDrugNames.get(index);
        unusedDrugNames.remove(index);

        return tempName;
    }

    public Pill getPlacebo() {
        return null;
    }

    public int getRandIntInRange(int min, int max) {
            return rand.nextInt((max - min) + 1) + min;
    }
}
