package com.myreliablegames.grandpagame.shaders;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;

public class BlurShader extends ShaderProgram {

    private BlurShader(String vertexShaderText, String pixelShaderText) {
        super(vertexShaderText, pixelShaderText);
    }

    public void setBlurPass(BlurPass blurPass, float radius) {
        begin();

        if (blurPass == BlurPass.Vertical) {
            setUniformf("stepDirection", 0.0f, radius / Gdx.graphics.getHeight());
        } else if (blurPass == BlurPass.Horizontal) {
            setUniformf("stepDirection", radius / Gdx.graphics.getWidth(), 0.0f);
        }

        end();
    }

    // TODO: Allow specification of sigma and kernel size. Generate shader code based on this.
    public static BlurShader load() {
        FileHandle vertexShaderFileHandle = Gdx.files.internal("shaders/blur.vs");
        String vertexShaderText = vertexShaderFileHandle.readString();

        FileHandle pixelShaderFileHandle = Gdx.files.internal("shaders/blur.ps");
        String pixelShaderText = pixelShaderFileHandle.readString();

        return new BlurShader(vertexShaderText, pixelShaderText);
    }
}
