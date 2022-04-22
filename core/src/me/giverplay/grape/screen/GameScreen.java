package me.giverplay.grape.screen;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import me.giverplay.grape.Grape;
import me.giverplay.grape.resource.Assets;
import me.giverplay.grape.ui.ButtonData;
import me.giverplay.grape.ui.HUD;
import me.giverplay.grape.world.World;

public class GameScreen extends ScreenAdapter {

  private OrthographicCamera camera;
  private SpriteBatch batch;

  private World world;
  private HUD hud;

  public GameScreen() {
    hud = new HUD(Grape.SCREEN_WIDTH, Grape.SCREEN_HEIGHT);

    Assets.addTexture("arrow_up", "arrow_up.png");
    Assets.addTexture("arrow_down", "arrow_down.png");
    Assets.addTexture("arrow_right", "arrow_right.png");
    Assets.addTexture("arrow_left", "arrow_left.png");
  }

  @Override
  public void show() {
    camera = new OrthographicCamera(Grape.SCREEN_WIDTH, Grape.SCREEN_HEIGHT);
    camera.setToOrtho(false, Grape.SCREEN_WIDTH, Grape.SCREEN_HEIGHT);

    batch = new SpriteBatch();
    world = new World(camera, 100, 100);

    world.getEntityFactory().createSampleEntity(150, 12);

    hud.addButton(new ButtonData("up", "arrow_up", 100, 150, 64, 64));
    hud.addButton(new ButtonData("down", "arrow_down", 100, 50, 64, 64));
    hud.addButton(new ButtonData("left", "arrow_left", 50, 100, 64, 64));
    hud.addButton(new ButtonData("right", "arrow_right", 150, 100, 64, 64));
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
