package com.myreliablegames.grandpagame;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.myreliablegames.grandpagame.Screens.CreditsScreen;
import com.myreliablegames.grandpagame.Screens.GameOverScreen;
import com.myreliablegames.grandpagame.Screens.GameScreen;
import com.myreliablegames.grandpagame.Screens.IntroScreen;
import com.myreliablegames.grandpagame.Screens.LevelSelectScreen;
import com.myreliablegames.grandpagame.Screens.TitleScreen;
import com.myreliablegames.grandpagame.Screens.WinScreen;

public class GrandpaGame extends Game {

	private Music music;
	private GameScreen gameScreen;

	@Override
	public void create () {

		music = Gdx.audio.newMusic(Gdx.files.internal("sounds/menu.mp3"));
		music.setLooping(true);
		Gdx.input.setCatchBackKey(true);
		music.play();
		openTitleScreen();
	}

	public void openTitleScreen() {
		if (!music.isPlaying()){
			music.play();
		}
		setScreen(new TitleScreen(this));
	}

	public void startLevel(LevelNumber level) {
		music.stop();
		if (gameScreen != null) {
			gameScreen.dispose();
			gameScreen = null;
		}
		gameScreen = new GameScreen(this, level);
		setScreen(gameScreen);
	}

	public void openLevelSelectScreen() {
		if (!music.isPlaying()){
			music.play();
		}
		setScreen(new LevelSelectScreen(this));
	}

	public void openIntroScreen() {
		setScreen(new IntroScreen(this));
	}

	public void openGameOverScreen() {
		setScreen(new GameOverScreen(this));
	}

	public void openWinLevelScreen() {
		setScreen(new WinScreen(this));
	}

	public void openCreditsScreen() {
		setScreen(new CreditsScreen(this));
	}

	public enum LevelNumber {
		One, Two, Three, Four, Five, Six
	}

}
