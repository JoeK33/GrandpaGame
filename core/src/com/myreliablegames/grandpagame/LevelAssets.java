package com.myreliablegames.grandpagame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by Joe on 7/27/2016.
 */
public class LevelAssets {

    private AssetManager assetManager = new AssetManager();
    private TextureRegion background;
    private Music music;

    public LevelAssets(GrandpaGame.LevelNumber levelNumber, BaseLevelAssets baseLevelAssets) {

        TextureAtlas atlas = baseLevelAssets.getAssetManager().get("gameassets/grandpagame.pack");

        if (levelNumber == GrandpaGame.LevelNumber.One) {
            background = atlas.findRegion("livingroombg");
            loadMusic("sounds/livingroom.mp3");
        } else if (levelNumber == GrandpaGame.LevelNumber.Two) {
            background = atlas.findRegion("bathroombg");
            loadMusic("sounds/bathroom.mp3");
        }else if (levelNumber == GrandpaGame.LevelNumber.Three) {
            background = atlas.findRegion("picnicbg");
            loadMusic("sounds/park.mp3");
        }else if (levelNumber == GrandpaGame.LevelNumber.Four) {
            background = atlas.findRegion("lawnbg");
            loadMusic("sounds/lawn.mp3");
        }else if (levelNumber == GrandpaGame.LevelNumber.Five) {
            background = atlas.findRegion("garagebg");
            loadMusic("sounds/garage.mp3");
        }else if (levelNumber == GrandpaGame.LevelNumber.Six) {
            background = atlas.findRegion("factorybg");
            loadMusic("sounds/pillfactory.mp3");
        }

        music.setLooping(true);
        music.setVolume(.8f);
    }

    private void loadMusic(String filePath) {
        assetManager.load(filePath, Music.class);
        assetManager.finishLoading();
        music = assetManager.get(filePath);
    }

    public TextureRegion getBackground() {
        return this.background;
    }

    public void playMusic() {
        music.play();
    }

    public void stopMusic() {
        music.stop();
    }

    public void dispose() {
       music.dispose();
    }
}
