package me.giverplay.grape;

import com.badlogic.gdx.Game;

import java.util.HashMap;
import java.util.Map;

import me.giverplay.grape.resource.Assets;
import me.giverplay.grape.screen.GameScreenBase;
import me.giverplay.grape.screen.SplashScreen;

public final class Grape extends Game {

	public static final int SCREEN_WIDTH = 1280;
	public static final int SCREEN_HEIGHT = 720;

	public static final Grape instance = new Grape();

	private GameScreenBase gameScreen;

	private Grape() {
		if(instance != null) throw new UnsupportedOperationException("Cannot instantiate singleton class!");
	}

	@Override
	public void create () {
		Map<String, String> textures = new HashMap<>();
		textures.put("finde", "finde.png");
		textures.put("arrow_up", "arrow_up.png");
		textures.put("arrow_down", "arrow_down.png");
		textures.put("arrow_right", "arrow_right.png");
		textures.put("arrow_left", "arrow_left.png");

		gameScreen = new GameScreenBase(textures);
		start();
	}

	public void start() {
		setScreen(new SplashScreen(this));
		Assets.load();
	}

	@Override
	public void dispose () {
		screen.dispose();
		screen = null;
	}

	public GameScreenBase getMainScreen() {
		return gameScreen;
	}
}
