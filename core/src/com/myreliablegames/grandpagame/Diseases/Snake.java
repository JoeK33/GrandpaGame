package com.myreliablegames.grandpagame.Diseases;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.myreliablegames.grandpagame.Constants;

/**
 * Created by Joe on 7/20/2016.
 */
public class Snake {
    private TextureRegion snake;
    private Vector2 position = new Vector2();
    private final float snakeSpeed = -150f;
    private Vector2 velocity = new Vector2(snakeSpeed, 0);
    private boolean active = false;

    public Snake(TextureRegion snakeTex) {
        snake = snakeTex;
        reset();
    }

    public void draw(SpriteBatch batch) {
        if (active) {
            batch.draw(snake, position.x, position.y);
        }
    }

    // Snakes move left across the screen.
    public void update(float delta) {

        if (active) {
            position.mulAdd(velocity, delta);

            // Reset snake when it goes off screen.
            if (this.position.x < 0 - (snake.getRegionWidth())) {
                reset();
            }
        }
    }

    public void reset() {
        this.position.x = Constants.WORLD_WIDTH;
        this.position.y = MathUtils.random(0, Constants.WORLD_HEIGHT - snake.getRegionHeight());
    }

    public void setActive(boolean isActive) {
        if (!isActive) {
            reset();
        }

        active = isActive;
    }

    public boolean isActive() {
        return active;
    }
}
