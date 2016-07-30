package com.myreliablegames.grandpagame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

/**
 * Created by Joe on 7/29/2016.
 */
public class SaveGameData {

    private Preferences prefs;

    public SaveGameData() {
        prefs = Gdx.app.getPreferences("preferences");
    }

    // First level is always unlocked
    public boolean isLevelUnlocked(GrandpaGame.LevelNumber levelNumber) {
        if (levelNumber == GrandpaGame.LevelNumber.One) {
           return true;
        } else {
            return prefs.getBoolean(levelNumber.toString(), false);
        }
    }

    public void unlockNextLevel(GrandpaGame.LevelNumber levelNumber) {
        if (levelNumber == GrandpaGame.LevelNumber.One) {
           unlockLevel(GrandpaGame.LevelNumber.Two);
        } else if (levelNumber == GrandpaGame.LevelNumber.Two) {
            unlockLevel(GrandpaGame.LevelNumber.Three);
        } else if (levelNumber == GrandpaGame.LevelNumber.Three) {
            unlockLevel(GrandpaGame.LevelNumber.Four);
        } else if (levelNumber == GrandpaGame.LevelNumber.Four) {
            unlockLevel(GrandpaGame.LevelNumber.Five);
        } else if (levelNumber == GrandpaGame.LevelNumber.Five) {
            unlockLevel(GrandpaGame.LevelNumber.Six);
        }
    }

    public void unlockLevel(GrandpaGame.LevelNumber levelNumber) {
        prefs.putBoolean(levelNumber.toString(), true);
        prefs.flush();
    }
}
