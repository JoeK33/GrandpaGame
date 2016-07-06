package com.myreliablegames.grandpagame;

import com.myreliablegames.grandpagame.GrandpaGame;
import com.myreliablegames.grandpagame.Level;

/**
 * Created by Joe on 7/5/2016.
 */
public class LevelFactory {

    public static Level getLevel(GrandpaGame.LevelNumber levelNumber) {
        Level level;
        switch (levelNumber) {
            case One:
                level = new LevelOne();
                break;
            case Two:
                level = new LevelTwo();
                break;
            default:
                level = new LevelOne();
                break;
        }

        return level;
    }
}
