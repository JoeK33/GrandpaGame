package com.myreliablegames.grandpagame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Joe on 7/11/2016.
 */
public enum DrugName {

        Colfloxifat,
        Anipine,
        Quicom,
        Dadroquent,
        Quanto,
        Dasthuash,
        Fyquoril,
        Flybixot,
        Aquote,
        Octololon,
        Getflo,
        Valelix,
        Conmad,
        Dusquode,
        Vardint,
        Logtir,
        Grast,
        Omniom,
        Flusu,
        Conyay,
        Gequoce,
        Betso,
        Tyraka,
        Deska,
        Hotnfat;


    public static ArrayList<DrugName> getDrugNameArrayList() {
        return new ArrayList<DrugName>(Arrays.asList(DrugName.values()));
    }

}
