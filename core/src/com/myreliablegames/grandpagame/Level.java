package com.myreliablegames.grandpagame;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Joe on 7/5/2016.
 */
public abstract class Level {

    BaseLevelAssets baseLevelAssets;
    PillHolder pillHolder;

    public Level() {
        baseLevelAssets = new BaseLevelAssets();
        pillHolder = new PillHolder(baseLevelAssets);
    }

    public void render(SpriteBatch batch){
        pillHolder.draw(batch);
    }

    public abstract void update(float delta);

    public void dispose(){
        baseLevelAssets.dispose();
    }


}
