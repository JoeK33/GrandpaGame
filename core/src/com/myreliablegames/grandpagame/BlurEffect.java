package com.myreliablegames.grandpagame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.FrameBuffer;
import com.badlogic.gdx.math.Matrix4;
import com.myreliablegames.grandpagame.shaders.BlurPass;
import com.myreliablegames.grandpagame.shaders.BlurShader;

/**
 * Created by jkirc_000 on 7/18/2016.
 */
public class BlurEffect {
    private FrameBuffer offscreenRenderTargetA;
    private FrameBuffer offscreenRenderTargetB;
    BlurShader blurShader;
    float blurRadius;

    public BlurEffect() {
        ensureOffscreenRenderTargetsAreInitialized(
                Gdx.graphics.getWidth(),
                Gdx.graphics.getHeight());
    }

    public void setBlurRadius(float blurRadius) {
        this.blurRadius = blurRadius;
    }

    public void begin() {
        if (blurRadius == 0.0f) {
            return;
        }

        ensureOffscreenRenderTargetsAreInitialized(
                Gdx.graphics.getWidth(),
                Gdx.graphics.getHeight());

        blurShader = BlurShader.load();

        // We will render the pills to the offscreen render target when performing a blur.
        offscreenRenderTargetA.begin();
    }

    public void end(SpriteBatch batch) {
        if (blurRadius == 0.0f) {
            return;
        }

        // Finish rendering to offscreen render target A.
        offscreenRenderTargetA.end();

        batch.begin();

        // TODO: Update only in viewport changed.
        // Set new camera for rendering offscreen targets and save previous projection matrix.
        Matrix4 previousProjectionMatrix = batch.getProjectionMatrix();
        OrthographicCamera offscreenCamera =
                new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        offscreenCamera.setToOrtho(false);
        batch.setProjectionMatrix(offscreenCamera.combined);

        // Blur offscreen render target A in horizontal direction. Output to render target B.
        {
            offscreenRenderTargetB.begin();

            // TODO: Store in member variable.
            TextureRegion textureRegion =
                    new TextureRegion(offscreenRenderTargetA.getColorBufferTexture());
            textureRegion.flip(false, true);

            // Update uniforms for horizontal blur shader.
            blurShader.setBlurPass(BlurPass.Horizontal, blurRadius);
            batch.setShader(blurShader);

            batch.draw(textureRegion, 0, 0);

            batch.flush();
            offscreenRenderTargetB.end();
        }

        // Blur offscreen render target B in vertical direction. Output to main render target.
        {
            // TODO: Store in member variable.
            TextureRegion textureRegion =
                    new TextureRegion(offscreenRenderTargetB.getColorBufferTexture());
            textureRegion.flip(false, true);

            // Update uniforms for vertical blur shader.
            blurShader.setBlurPass(BlurPass.Vertical, blurRadius);
            batch.setShader(blurShader);

            batch.draw(textureRegion, 0, 0);
            batch.flush();
        }

        // Restore previous projection matrix.
        batch.setProjectionMatrix(previousProjectionMatrix);

        // Restore the default shader.
        batch.setShader(null);

        batch.end();
    }

    public void resize(int width, int height) {
        // Assuming this is thread safe, i.e. resize callback is on render thread.
        ensureOffscreenRenderTargetsAreInitialized(width, height);
    }

    /**
     * Creates the render targets if the render targets have not been initialized yet or the
     * specified width or height is different from the current render target's width and height.
     */
    private void ensureOffscreenRenderTargetsAreInitialized(int width, int height) {
        boolean shouldRecreateRenderTarget =
                offscreenRenderTargetA == null ||
                        offscreenRenderTargetA.getWidth() != width ||
                        offscreenRenderTargetA.getHeight() != height;

        if (shouldRecreateRenderTarget) {
            Gdx.app.log("BlurEffect", "Creating render targets (" + width + ", " + height +")");

            offscreenRenderTargetA =
                    new FrameBuffer(
                            Pixmap.Format.RGBA8888,
                            Gdx.graphics.getWidth(),
                            Gdx.graphics.getHeight(),
                            false);
            offscreenRenderTargetA.getColorBufferTexture().setFilter(
                    Texture.TextureFilter.Nearest,
                    Texture.TextureFilter.Nearest);

            // We will keep the B render target in the same state as the A render target.
            offscreenRenderTargetB =
                    new FrameBuffer(
                            Pixmap.Format.RGBA8888,
                            Gdx.graphics.getWidth(),
                            Gdx.graphics.getHeight(),
                            false);
            offscreenRenderTargetB.getColorBufferTexture().setFilter(
                    Texture.TextureFilter.Nearest,
                    Texture.TextureFilter.Nearest);
        }
    }
}
