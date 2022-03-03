package me.giverplay.grape.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.TimeUtils;

public class SplashScreen extends ScreenAdapter {

  private SpriteBatch batch;
  private Texture splash;

  private long start;

  @Override
  public void show() {
    batch = new SpriteBatch();
    splash = new Texture("splash.png");
    start = TimeUtils.millis();
  }

  @Override
  public void render(float delta) {
    ScreenUtils.clear(0, 0, 0, 1);

    batch.begin();
    batch.draw(splash, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    batch.end();
  }

  @Override
  public void dispose() {
    batch.dispose();
    splash.dispose();
  }

  public long getStart() {
    return start;
  }
}
