package com.myreliablegames.grandpagame;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.myreliablegames.grandpagame.Diseases.Disease;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Joe on 7/21/2016.
 */
public class PrescriptionWriter {

    private ArrayList<Disease> diseases;
    private BitmapFont font;
    private boolean shuffled;

    public PrescriptionWriter(ArrayList<Disease> diseases, BitmapFont font) {
        this.diseases = diseases;
        this.font = font;
        this.font.getData().setScale(.16f);

    }

    private void shuffle() {
        Collections.shuffle(diseases);
    }

    public void draw(SpriteBatch batch) {

        if (!shuffled) {
            shuffle();
            shuffled = true;
        }


        int row = 1;
        for (Disease disease : diseases) {
            font.draw(batch,
                    disease.getPrescriptionDescription(),
                    Constants.PAPER_NINEPATCH_BUFFER * 2,
                    Constants.WORLD_HEIGHT - Constants.PAPER_NINEPATCH_BUFFER * 3 - (row * (Constants.PAPER_NINEPATCH_BUFFER + 5)));
                    row++;
        }

    }

}
