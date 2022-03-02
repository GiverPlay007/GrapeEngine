package me.giverplay.grape.screen;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.TimeUtils;

import me.giverplay.grape.Grape;
import me.giverplay.grape.resource.Assets;

public class SplashScreen extends ScreenAdapter {

  private SpriteBatch batch;
  private Texture splash;

  private long start;

  @Override
  public void show() {
    batch = new SpriteBatch();
    splash = new Texture("splash.jpg");
    start = TimeUtils.millis();
    Assets.load();
  }

  @Override
  public void render(float delta) {
    ScreenUtils.clear(0, 0, 0, 1);

    batch.begin();
    batch.draw(splash, 0, 0);
    batch.end();

    if (TimeUtils.millis() - start > 3000 && Assets.manager.update()){
      Grape.instance.onLoad();
    }
  }

  @Override
  public void dispose() {
    batch.dispose();
    splash.dispose();
  }
}
