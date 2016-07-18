package com.myreliablegames.grandpagame;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.myreliablegames.grandpagame.Diseases.DiseaseManager;
import com.myreliablegames.grandpagame.Diseases.DiseaseName;
import com.myreliablegames.grandpagame.Screens.GameScreen;

import java.util.ArrayList;

/**
 * Created by Joe on 7/11/2016.
 */
public class LevelSix extends Level {
    public LevelSix(GameScreen gameScreen, GrandpaGame game, BaseLevelAssets assets) {
        super(gameScreen, game, assets, GrandpaGame.LevelNumber.Six);
        pillManager.populate(60, 15, false);
        ArrayList<DiseaseName> levelDiseases =  new ArrayList<DiseaseName>();
        levelDiseases.add(DiseaseName.Colorblind);
        levelDiseases.add(DiseaseName.RingingInEars);
        levelDiseases.add(DiseaseName.DoubleVision);
        this.diseaseManager = new DiseaseManager(pillManager, levelDiseases, grandpa, assets);
        grandpa.setDiseaseManager(diseaseManager);
    }

    @Override
    public void render(SpriteBatch batch) {
        super.render(batch);
    }

    @Override
    public void update(float delta) {
        super.update(delta);
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
