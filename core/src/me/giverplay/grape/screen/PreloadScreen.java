package me.giverplay.grape.screen;

import com.badlogic.gdx.ScreenAdapter;

import me.giverplay.grape.Grape;
import me.giverplay.grape.resource.Assets;

public class PreloadScreen extends ScreenAdapter {

  @Override
  public void show() {
    Assets.load();
    Assets.manager.finishLoading();
  }

  @Override
  public void render(float delta) {
    if (Assets.manager.update())
      Grape.instance.setScreen(new GameScreen());
  }
}
