package me.giverplay.grape;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public final class Grape extends Game {

	public static final int SCREEN_WIDTH = 1280;
	public static final int SCREEN_HEIGHT = 720;

	private Grape() {
		if(instance != null) throw new UnsupportedOperationException("Cannot instantiate singleton class!");
	}

	public static final Grape instance = new Grape();

	SpriteBatch batch;
	Texture img;

	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1);
		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
