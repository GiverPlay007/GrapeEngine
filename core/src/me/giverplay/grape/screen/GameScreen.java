package me.giverplay.grape.screen;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import me.giverplay.grape.Grape;
import me.giverplay.grape.ui.HUD;
import me.giverplay.grape.world.World;

public class GameScreen extends ScreenAdapter {

  private OrthographicCamera camera;
  private SpriteBatch batch;

  private World world;
  private HUD hud;

  public GameScreen() {
    hud = new HUD(Grape.SCREEN_WIDTH, Grape.SCREEN_HEIGHT);
  }

  @Override
  public void show() {
    camera = new OrthographicCamera(Grape.SCREEN_WIDTH, Grape.SCREEN_HEIGHT);
    camera.setToOrtho(false, Grape.SCREEN_WIDTH, Grape.SCREEN_HEIGHT);

    batch = new SpriteBatch();
    world = new World(camera, 100, 100);

    world.getEntityFactory().createSampleEntity(150, 12);
    hud.start();
  }

  @Override
  public void render(float deltaTime) {
    ScreenUtils.clear(0.6f, 0.2f, 0.3f, 1.0f);

    hud.draw();
    world.update(deltaTime);
  }

  @Override
  public void resize(int width, int height) {
    hud.resize(width, height);
  }

  @Override
  public void dispose() {
    batch.dispose();
    world.dispose();
    hud.dispose();
  }
}
