package com.myreliablegames.grandpagame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;

/**
 * Created by Joe on 7/11/2016.
 */
public class PillAssets {

    public Texture Pill1Texture = new Texture(Gdx.files.internal("pills/pill1.png"));
    public Texture Pill2Texture = new Texture(Gdx.files.internal("pills/pill2.png"));
    public Texture Pill3Texture = new Texture(Gdx.files.internal("pills/pill3.png"));
    public Texture Pill4Texture = new Texture(Gdx.files.internal("pills/pill4.png"));
    public Texture Pill5Texture = new Texture(Gdx.files.internal("pills/pill5.png"));

    public Texture Pill6Texture = new Texture(Gdx.files.internal("pills/pill6.png"));
    public Texture Pill7Texture = new Texture(Gdx.files.internal("pills/pill7.png"));
    public Texture Pill8Texture = new Texture(Gdx.files.internal("pills/pill8.png"));
    public Texture Pill9Texture = new Texture(Gdx.files.internal("pills/pill9.png"));
    public Texture Pill10Texture = new Texture(Gdx.files.internal("pills/pill10.png"));

    public Texture Pill11Texture = new Texture(Gdx.files.internal("pills/pill11.png"));
    public Texture Pill12Texture = new Texture(Gdx.files.internal("pills/pill12.png"));
    public Texture Pill13Texture = new Texture(Gdx.files.internal("pills/pill13.png"));
    public Texture Pill14Texture = new Texture(Gdx.files.internal("pills/pill14.png"));
    public Texture Pill15Texture = new Texture(Gdx.files.internal("pills/pill15.png"));

    public ArrayList<Texture> getPillTextures() {
        ArrayList<Texture> pillTextures = new ArrayList<Texture>();
        pillTextures.add(Pill1Texture);
        pillTextures.add(Pill2Texture);
        pillTextures.add(Pill3Texture);
        pillTextures.add(Pill4Texture);
        pillTextures.add(Pill5Texture);
        pillTextures.add(Pill6Texture);
        pillTextures.add(Pill7Texture);
        pillTextures.add(Pill8Texture);
        pillTextures.add(Pill9Texture);
        pillTextures.add(Pill10Texture);
        pillTextures.add(Pill11Texture);
        pillTextures.add(Pill12Texture);
        pillTextures.add(Pill13Texture);
        pillTextures.add(Pill14Texture);
        pillTextures.add(Pill15Texture);

        return pillTextures;
    }

    public void dispose() {
        ArrayList<Texture> textures = getPillTextures();
        for (Texture t : textures) {
            t.dispose();
        }
    }

    public String getTextureDescription(Texture pillTexture) {
        if (pillTexture == Pill1Texture) {
            return
                    "Square White Pill";
        } else if (pillTexture == Pill2Texture) {
            return
                    "Oval White Pill";
        } else if (pillTexture == Pill3Texture) {
            return
                    "Triangular White Pill";
        } else if (pillTexture == Pill4Texture) {
            return
                    "Red Pentagon Pill";
        } else if (pillTexture == Pill5Texture) {
            return
                    "Red Triangle Pill";
        }else if (pillTexture == Pill6Texture) {
            return
                    "Red Oval Pill";
        } else if (pillTexture == Pill7Texture) {
            return
                    "Blue Square Pill";
        }else if (pillTexture == Pill8Texture) {
            return
                    "Circular Blue Pill";
        } else if (pillTexture == Pill9Texture) {
            return
                    "Blue Pentagon Pill";
        } else if (pillTexture == Pill10Texture) {
            return
                    "Pink Round Pill";
        } else if (pillTexture == Pill11Texture) {
            return
                    "Pink Pentagon Pill";
        }else if (pillTexture == Pill12Texture) {
            return
                    "Pink Triangular Pill";
        } else if (pillTexture == Pill13Texture) {
            return
                    "Square Green Pill";
        }else if (pillTexture == Pill14Texture) {
            return
                    "Green Circular Pill";
        } else if (pillTexture == Pill15Texture) {
            return
                    "Green Oval Pill";
        }else {
            return "Ghost Pill";
        }
    }
}
