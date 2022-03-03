package me.giverplay.grape;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.TimeUtils;

import me.giverplay.grape.resource.Assets;
import me.giverplay.grape.screen.GameScreen;
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
		start();
	}

	public void start() {
		setScreen(new SplashScreen());
		Assets.addTexture("finde", "finde.png");
		Assets.load();
	}

	@Override
	public void render() {
		if(screen instanceof SplashScreen) {
			SplashScreen splash = (SplashScreen) screen;

			if(TimeUtils.millis() - splash.getStart() > 3000 && Assets.manager.update()) {
				splash.dispose();
				ScreenUtils.clear(0.0f, 0.0f, 0.0f, 1.0f);
				setScreen(new GameScreen());
				return;
			}

			splash.render(Gdx.graphics.getDeltaTime());
			return;
		}

		super.render();
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
			ScreenUtils.clear(0.0f, 0.0f, 0.0f, 1.0f);
			setScreen(new GameScreen());
		}
	}
}
