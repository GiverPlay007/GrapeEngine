package me.giverplay.grape.screen;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.HashMap;
import java.util.Map;

import me.giverplay.grape.Grape;
import me.giverplay.grape.resource.Assets;
import me.giverplay.grape.ui.ButtonData;
import me.giverplay.grape.ui.HUD;
import me.giverplay.grape.world.World;

public class GameScreenBase extends ScreenAdapter {

  private final Map<String, String> textures;

  private OrthographicCamera camera;
  private SpriteBatch batch;

  private final HUD hud;
  private World world;

  public GameScreenBase(Map<String, String> screenTextures) {
    textures = new HashMap<>(screenTextures);
    hud = new HUD(Grape.SCREEN_WIDTH, Grape.SCREEN_HEIGHT);
    loadAssets();
  }

  public void loadAssets() {
    for(String texture : textures.keySet()) {
      Assets.addTexture(texture, textures.get(texture));
    }
  }

  public void unloadAssets() {
    for(String texture : textures.keySet()) {
      Assets.unload(texture);
    }
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
  public void hide() {
    unloadAssets();
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

  public OrthographicCamera getCamera() {
    return camera;
  }

  public HUD getHud() {
    return hud;
  }
}
