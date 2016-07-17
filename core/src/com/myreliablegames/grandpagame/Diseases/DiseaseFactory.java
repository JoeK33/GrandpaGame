package com.myreliablegames.grandpagame.Diseases;

import com.myreliablegames.grandpagame.BaseLevelAssets;
import com.myreliablegames.grandpagame.DrugName;
import com.myreliablegames.grandpagame.PillManager;

import java.util.ArrayList;

/**
 * Created by Joe on 7/14/2016.
 */
public class DiseaseFactory {

    private ArrayList<DrugName> possibleCures;
    private BaseLevelAssets assets;
    private PillManager pillManager;

    public DiseaseFactory(ArrayList<DrugName> pillsInPlay, BaseLevelAssets assets, PillManager pillManager) {
        this.possibleCures = new ArrayList<DrugName>(pillsInPlay);
        this.assets = assets;
        this.pillManager = pillManager;
    }

    public Disease getDisease(DiseaseName name) {
        if (name == DiseaseName.Colorblind) {
            Colorblind colorblind = new Colorblind(possibleCures.get(0), pillManager);
            possibleCures.remove(0);
            return colorblind;
        } else if (name == DiseaseName.RingingInEars) {
            RingingInEars ringingInEars = new RingingInEars(possibleCures.get(0), assets);
            possibleCures.remove(0);
            return ringingInEars;
        } else if (name == DiseaseName.DoubleVision) {
            DoubleVision doubleVision = new DoubleVision(possibleCures.get(0), pillManager);
            possibleCures.remove(0);
            return doubleVision;
        } else {  return new Colorblind(DrugName.Anipine, pillManager);}
    }


    public ArrayList<Disease> getDiseaseList(ArrayList<DiseaseName> levelDiseases) {
        ArrayList<Disease> listOfDiseases = new ArrayList<Disease>();

        for (DiseaseName name : levelDiseases) {
            listOfDiseases.add(this.getDisease(name));
        }
        return listOfDiseases;
    }

}
