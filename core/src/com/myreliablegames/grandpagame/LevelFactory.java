package com.myreliablegames.grandpagame;

import com.myreliablegames.grandpagame.GrandpaGame;
import com.myreliablegames.grandpagame.Level;
import com.myreliablegames.grandpagame.Screens.GameScreen;

/**
 * Created by Joe on 7/5/2016.
 */
public class LevelFactory {

    public static Level getLevel(GrandpaGame.LevelNumber levelNumber, GameScreen gameScreen, GrandpaGame game) {
        Level level;
        switch (levelNumber) {
            case One:
                level = new LevelOne(gameScreen, game);
                break;
            case Two:
                level = new LevelTwo(gameScreen, game);
                break;
            case Three:
                level = new LevelThree(gameScreen, game);
                break;
            default:
                level = new LevelOne(gameScreen, game);
                break;
        }

        return level;
    }
}
