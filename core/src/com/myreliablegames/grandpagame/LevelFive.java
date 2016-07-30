package com.myreliablegames.grandpagame;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.myreliablegames.grandpagame.Diseases.DiseaseManager;
import com.myreliablegames.grandpagame.Diseases.DiseaseName;
import com.myreliablegames.grandpagame.Screens.GameScreen;

import java.util.ArrayList;

/**
 * Created by Joe on 7/11/2016.
 */
public class LevelFive extends Level {
    public LevelFive(GameScreen gameScreen, GrandpaGame game, BaseLevelAssets assets) {
        super(gameScreen, game, assets, GrandpaGame.LevelNumber.Five);
        pillManager.populate(45, 11, true);
        ArrayList<DiseaseName> levelDiseases =  new ArrayList<DiseaseName>();
          levelDiseases.add(DiseaseName.Shakes);
           levelDiseases.add(DiseaseName.SeeSnakes);
           levelDiseases.add(DiseaseName.Sparkles);
           levelDiseases.add(DiseaseName.DoubleVision);
           levelDiseases.add(DiseaseName.Colorblind);
        //   levelDiseases.add(DiseaseName.BlurryVision);
       //    levelDiseases.add(DiseaseName.RingingInEars);
        this.diseaseManager = new DiseaseManager(pillManager, levelDiseases, grandpa, assets, this);
        grandpa.setDiseaseManager(diseaseManager);
        prescriptionScreen.initWriter();
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
