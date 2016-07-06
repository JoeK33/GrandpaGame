package com.myreliablegames.grandpagame;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.myreliablegames.grandpagame.Screens.GameOverScreen;
import com.myreliablegames.grandpagame.Screens.GameScreen;
import com.myreliablegames.grandpagame.Screens.LevelSelectScreen;
import com.myreliablegames.grandpagame.Screens.TitleScreen;
import com.myreliablegames.grandpagame.Screens.WinScreen;

public class GrandpaGame extends Game {

	@Override
	public void create () {
		Gdx.input.setCatchBackKey(true);
		setScreen(new TitleScreen(this));
	}

	public void startLevel(LevelNumber level) {
		setScreen(new GameScreen(this, level));
	}

	public void openLevelSelectScreen() {
		setScreen(new LevelSelectScreen(this));
	}

	public void openGameOverScreen() {
		setScreen(new GameOverScreen(this));
	}

	public void openWinLevelScreen() {
		setScreen(new WinScreen(this));
	}

	public enum LevelNumber {
		One, Two, Three, Four, Five, Six
	}

}
