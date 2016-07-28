package com.myreliablegames.grandpagame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by Joe on 7/27/2016.
 */
public class LevelSelectBackground {

    private Texture bgTexture;

    private int tileWidth;
    private int tileHeight;
    private int tilesWide;
    private int tilesHigh;
    private float scrollingPoint = 0;
    private final float SCROLL_SPEED = 40;
    private float verticalSpacing = 20f;
    private float horizontalSpacing = 20f;
    private final float bufferTiles = 5;

    public LevelSelectBackground() {
        this.bgTexture = new Texture(Gdx.files.internal("pillorganizer.png"));
        tileHeight = bgTexture.getHeight();
        tileWidth = bgTexture.getWidth();

        tilesWide =  (int)((Constants.WORLD_WIDTH / tileWidth) * 2 + bufferTiles);
        tilesHigh = (int)((Constants.WORLD_HEIGHT / tileHeight) * 2 + bufferTiles);
    }

    public void draw(SpriteBatch batch) {
        // Draw a scrolling grid of background tiles.
        for (int heightIndex = 0; heightIndex < tilesHigh; heightIndex++) {
            for (int widthIndex = 0; widthIndex < tilesWide; widthIndex++) {
                // Only draw when index is an even and odd number together to get checkerboard-esque effect.
                if ((widthIndex % 2 == 0 && heightIndex % 2 == 1) || widthIndex % 2 == 1 && heightIndex % 2 == 0) {
                    batch.draw(
                            bgTexture,
                            scrollingPoint + (widthIndex * tileWidth) - tileWidth * 2 + (widthIndex * horizontalSpacing),
                            (heightIndex * tileHeight) + (heightIndex * verticalSpacing),
                            tileWidth,
                            tileHeight
                    );
                }
            }
        }
    }

    public void update(float delta) {
        scrollingPoint -= SCROLL_SPEED * delta;
        if (scrollingPoint < (-(tileWidth + horizontalSpacing) * 2)) {
            scrollingPoint = 0;
        }
    }

    public void dispose() {
        bgTexture.dispose();
    }
}
