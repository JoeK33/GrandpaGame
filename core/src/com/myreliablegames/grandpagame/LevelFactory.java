package com.myreliablegames.grandpagame;

import com.myreliablegames.grandpagame.GrandpaGame;
import com.myreliablegames.grandpagame.Level;
import com.myreliablegames.grandpagame.Screens.GameScreen;

/**
 * Created by Joe on 7/5/2016.
 */
public class LevelFactory {

    public static Level getLevel(GrandpaGame.LevelNumber levelNumber, GameScreen gameScreen, GrandpaGame game, BaseLevelAssets assets) {
        Level level;
        switch (levelNumber) {
            case One:
                level = new LevelOne(gameScreen, game, assets);
                break;
            case Two:
                level = new LevelTwo(gameScreen, game, assets);
                break;
            case Three:
                level = new LevelThree(gameScreen, game, assets);
                break;
            case Four:
                level = new LevelFour(gameScreen, game, assets);
                break;
            case Five:
                level = new LevelFive(gameScreen, game, assets);
                break;
            case Six:
                level = new LevelSix(gameScreen, game, assets);
                break;
            default:
                level = new LevelOne(gameScreen, game, assets);
                break;
        }

        return level;
    }
}
