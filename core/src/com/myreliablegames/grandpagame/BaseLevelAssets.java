package com.myreliablegames.grandpagame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.ArrayList;

/**
 * Created by Joe on 7/5/2016.
 */
public class BaseLevelAssets {

    public PillAssets pillAssets;
    public DiseaseSounds diseaseSounds;
    private AssetManager assetManager = new AssetManager();

    public final TextureRegion drinkButtonUp;
    public final TextureRegion drinkButtonDown;

    public final TextureRegion eatButtonUp;
    public final TextureRegion eatButtonDown;

    public final TextureRegion pillBottleButtonUp;
    public final TextureRegion pillBottleButtonDown;

    public final TextureRegion prescriptionButtonUp;
    public final TextureRegion prescriptionButtonDown;

    public BaseLevelAssets() {
        assetManager.load("gameassets/grandpagame.pack", TextureAtlas.class);
        assetManager.load("sounds/ringing.wav", Sound.class);
        assetManager.finishLoading();

        TextureAtlas atlas = assetManager.get("gameassets/grandpagame.pack");

        drinkButtonUp = atlas.findRegion("drinkbuttonup");
        drinkButtonDown = atlas.findRegion("drinkbuttondown");

        eatButtonUp = atlas.findRegion("eatbuttonup");
        eatButtonDown = atlas.findRegion("eatbuttondown");

        pillBottleButtonUp = atlas.findRegion("pillbuttonup");
        pillBottleButtonDown = atlas.findRegion("pillbuttondown");

        prescriptionButtonUp = atlas.findRegion("prescriptionbuttonup");
        prescriptionButtonDown = atlas.findRegion("prescriptionbuttondown");

        pillAssets = new PillAssets(atlas);
        diseaseSounds = new DiseaseSounds();

    }

    public void dispose() {
       assetManager.dispose();
    }


    public class PillAssets {

        public final Animation squarePillHighlight;
        public final Animation circlePillHighlight;
        public final Animation pentagonPillHighlight;
        public final Animation trianglePillHighlight;
        public final Animation ovalPillHighlight;

        public final TextureRegion pill1Texture;
        public final TextureRegion pill2Texture;
        public final TextureRegion pill3Texture;
        public final TextureRegion pill4Texture;
        public final TextureRegion pill5Texture;

        public final TextureRegion pill6Texture;
        public final TextureRegion pill7Texture;
        public final TextureRegion pill8Texture;
        public final TextureRegion pill9Texture;
        public final TextureRegion pill10Texture;

        public final TextureRegion pill11Texture;
        public final TextureRegion pill12Texture;
        public final TextureRegion pill13Texture;
        public final TextureRegion pill14Texture;
        public final TextureRegion pill15Texture;

        public PillAssets(TextureAtlas atlas) {

            pill1Texture = atlas.findRegion("pills/pill1");
            pill2Texture = atlas.findRegion("pills/pill2");
            pill3Texture = atlas.findRegion("pills/pill3");
            pill4Texture = atlas.findRegion("pills/pill4");
            pill5Texture = atlas.findRegion("pills/pill5");

            pill6Texture = atlas.findRegion("pills/pill6");
            pill7Texture = atlas.findRegion("pills/pill7");
            pill8Texture = atlas.findRegion("pills/pill8");
            pill9Texture = atlas.findRegion("pills/pill9");
            pill10Texture = atlas.findRegion("pills/pill10");

            pill11Texture = atlas.findRegion("pills/pill11");
            pill12Texture = atlas.findRegion("pills/pill12");
            pill13Texture = atlas.findRegion("pills/pill13");
            pill14Texture = atlas.findRegion("pills/pill14");
            pill15Texture = atlas.findRegion("pills/pill15");

            squarePillHighlight = makeAnimation(atlas.findRegion("pills/squarepillhighlight"));
            circlePillHighlight = makeAnimation(atlas.findRegion("pills/circlepillhighlight"));
            pentagonPillHighlight = makeAnimation(atlas.findRegion("pills/pentagonpillhighlight"));
            trianglePillHighlight = makeAnimation(atlas.findRegion("pills/trianglepillhighlight"));
            ovalPillHighlight = makeAnimation(atlas.findRegion("pills/ovalpillhighlight"));
        }

        public ArrayList<TextureRegion> getPillTextures() {
            ArrayList<TextureRegion> pillTextures = new ArrayList<TextureRegion>();
            pillTextures.add(pill1Texture);
            pillTextures.add(pill2Texture);
            pillTextures.add(pill3Texture);
            pillTextures.add(pill4Texture);
            pillTextures.add(pill5Texture);
            pillTextures.add(pill6Texture);
            pillTextures.add(pill7Texture);
            pillTextures.add(pill8Texture);
            pillTextures.add(pill9Texture);
            pillTextures.add(pill10Texture);
            pillTextures.add(pill11Texture);
            pillTextures.add(pill12Texture);
            pillTextures.add(pill13Texture);
            pillTextures.add(pill14Texture);
            pillTextures.add(pill15Texture);

            return pillTextures;
        }

          public String getTextureDescription(TextureRegion pillTexture) {
            if (pillTexture == pill1Texture) {
                return
                        "Square White Pill";
            } else if (pillTexture == pill2Texture) {
                return
                        "Oval White Pill";
            } else if (pillTexture == pill3Texture) {
                return
                        "Triangular White Pill";
            } else if (pillTexture == pill4Texture) {
                return
                        "Red Pentagon Pill";
            } else if (pillTexture == pill5Texture) {
                return
                        "Red Triangle Pill";
            } else if (pillTexture == pill6Texture) {
                return
                        "Red Oval Pill";
            } else if (pillTexture == pill7Texture) {
                return
                        "Blue Square Pill";
            } else if (pillTexture == pill8Texture) {
                return
                        "Circular Blue Pill";
            } else if (pillTexture == pill9Texture) {
                return
                        "Blue Pentagon Pill";
            } else if (pillTexture == pill10Texture) {
                return
                        "Pink Round Pill";
            } else if (pillTexture == pill11Texture) {
                return
                        "Pink Pentagon Pill";
            } else if (pillTexture == pill12Texture) {
                return
                        "Pink Triangular Pill";
            } else if (pillTexture == pill13Texture) {
                return
                        "Square Green Pill";
            } else if (pillTexture == pill14Texture) {
                return
                        "Green Circular Pill";
            } else if (pillTexture == pill15Texture) {
                return
                        "Green Oval Pill";
            } else {
                return "Ghost Pill";
            }
        }

        public PillDescription.PillShape getPillShape(TextureRegion pillTexture) {
            if (pillTexture == pill1Texture) {
                return
                        PillDescription.PillShape.Square;
            } else if (pillTexture == pill2Texture) {
                return
                        PillDescription.PillShape.Oval;
            } else if (pillTexture == pill3Texture) {
                return
                        PillDescription.PillShape.Triangle;
            } else if (pillTexture == pill4Texture) {
                return
                        PillDescription.PillShape.Pentagon;
            } else if (pillTexture == pill5Texture) {
                return
                        PillDescription.PillShape.Triangle;
            } else if (pillTexture == pill6Texture) {
                return
                        PillDescription.PillShape.Oval;
            } else if (pillTexture == pill7Texture) {
                return
                        PillDescription.PillShape.Square;
            } else if (pillTexture == pill8Texture) {
                return
                        PillDescription.PillShape.Circle;
            } else if (pillTexture == pill9Texture) {
                return
                        PillDescription.PillShape.Pentagon;
            } else if (pillTexture == pill10Texture) {
                return
                        PillDescription.PillShape.Circle;
            } else if (pillTexture == pill11Texture) {
                return
                        PillDescription.PillShape.Pentagon;
            } else if (pillTexture == pill12Texture) {
                return
                        PillDescription.PillShape.Triangle;
            } else if (pillTexture == pill13Texture) {
                return
                        PillDescription.PillShape.Square;
            } else if (pillTexture == pill14Texture) {
                return
                        PillDescription.PillShape.Circle;
            } else if (pillTexture == pill15Texture) {
                return
                        PillDescription.PillShape.Oval;
            } else {
                return PillDescription.PillShape.Oval;
            }
        }

        public Animation makeAnimation(TextureRegion highlightSheet) {

            int FRAME_COLS = 5;
            int FRAME_ROWS = 1;

            TextureRegion[][] tmp = highlightSheet.split(Constants.PILL_SIZE, Constants.PILL_SIZE);
            TextureRegion[] highlightFrames = new TextureRegion[FRAME_COLS * FRAME_ROWS];
            int index = 0;
            for (int i = 0; i < FRAME_ROWS; i++) {
                for (int j = 0; j < FRAME_COLS; j++) {
                    highlightFrames[index++] = tmp[i][j];
                }
            }

            Animation animation = new Animation(.25f, highlightFrames);
            animation.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
            return animation;
        }

        public Animation getPillHighlight(PillDescription.PillShape pillshape) {
            if (pillshape == PillDescription.PillShape.Square) {
                return squarePillHighlight;
            } else if (pillshape == PillDescription.PillShape.Circle) {
                return circlePillHighlight;
            } else if (pillshape == PillDescription.PillShape.Triangle) {
                return trianglePillHighlight;
            } else if (pillshape == PillDescription.PillShape.Pentagon) {
                return pentagonPillHighlight;
            } else {
                return ovalPillHighlight;
            }
        }
    }

    public class DiseaseSounds {

        public final Sound ringingInEars;

        public DiseaseSounds() {
            ringingInEars = assetManager.get("sounds/ringing.wav");

        }

    }
}
