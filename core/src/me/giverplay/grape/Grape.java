package me.giverplay.grape;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.utils.ScreenUtils;

import me.giverplay.grape.screen.SplashScreen;

public final class Grape extends Game {

	public static final int SCREEN_WIDTH = 1280;
	public static final int SCREEN_HEIGHT = 720;

	public static final Grape instance = new Grape();

	private Grape() {
		if(instance != null) throw new UnsupportedOperationException("Cannot instantiate singleton class!");
	}

	@Override
	public void create () {
		setScreen(new SplashScreen());
	}
	
	@Override
	public void dispose () {
		screen.dispose();
		screen = null;
	}

	public void onLoad() {
		if(screen instanceof SplashScreen) {
			screen.dispose();
			screen = null;
			ScreenUtils.clear(1, 1, 1, 1);
		}
	}
}
