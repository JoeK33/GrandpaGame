package com.myreliablegames.grandpagame.Diseases;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.myreliablegames.grandpagame.BaseLevelAssets;
import com.myreliablegames.grandpagame.Constants;
import com.myreliablegames.grandpagame.DrugName;

/**
 * Created by Joe on 7/20/2016.
 */
public class SeeSnakes extends Disease {

    private Snake snake;

    public SeeSnakes(DrugName cure, BaseLevelAssets assets) {
        super(new DiseaseDescription(cure, Constants.SNAKE_DAMAGE), DiseaseName.SeeSnakes);
        snake = new Snake(assets.diseaseAssets.snake);
    }

    @Override
    public void draw(SpriteBatch batch) {
        snake.draw(batch);
    }

    @Override
    public void update(float delta) {
        snake.update(delta);
    }

    @Override
    public void cureDisease() {
        snake.setActive(false);
        cured = true;
    }

    @Override
    public void beginDisease() {
        snake.setActive(true);
    }

    @Override
    public boolean readyForRemoval() {
        if (!snake.isActive() && cured) {
            cured = false;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String getPrescriptionDescription() {
        return this.getDescription().getCure().toString() + " is the best anti-snake pill on the market.";
    }
}
