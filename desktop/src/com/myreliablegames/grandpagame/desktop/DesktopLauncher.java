package com.myreliablegames.grandpagame.desktop;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.myreliablegames.grandpagame.GrandpaGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.height = 480;
		config.width = 720;
		config.title = "Grandpa's Medicine";
		new LwjglApplication(new GrandpaGame(), config);
	}
}
