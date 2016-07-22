package com.myreliablegames.grandpagame;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

/**
 * Created by Joe on 7/22/2016.
 */
public class MedicineCabinetWriter {

    private ArrayList<Pill> pills;
    private BitmapFont font;
    private float textBuffer = 5;
    private float pillXSpacing = 100;
    private float pillYSpacing = 65;
    private float yOffset = 0;
    private float xOffset = 0;
    GlyphLayout layout = new GlyphLayout();

    public MedicineCabinetWriter(ArrayList<Pill> pills, BitmapFont font) {
        this.pills = pills;
        this.font = font;
    }

    public void draw(SpriteBatch batch) {
        int row = 1;
        int col = 0;
        for (Pill pill : pills) {

            if (row > 3) {
                row = 1;
                col++;
            }
            batch.draw(pill.getPillDescription().getTextureRegion(),
                    Constants.PAPER_NINEPATCH_BUFFER * 3 + (col * pillXSpacing) + xOffset,
                    Constants.WORLD_HEIGHT - Constants.PAPER_NINEPATCH_BUFFER * 2 - (row * pillYSpacing) + yOffset);

            font.draw(batch,
                   pill.getPillDescription().getDrugName().toString(),
                    Constants.PAPER_NINEPATCH_BUFFER * 3 - (getStringWidth(pill.getPillDescription().getDrugName().toString()) / 2) + (Constants.PILL_SIZE / 2) + (col * pillXSpacing) + xOffset,
                    Constants.WORLD_HEIGHT - Constants.PAPER_NINEPATCH_BUFFER * 2 - (row * pillYSpacing) - textBuffer + yOffset);




            row++;
        }

    }

    private float getStringWidth(String string) {
        layout.setText(font, string);
        return layout.width;
    }
}
