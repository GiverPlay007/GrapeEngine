package me.giverplay.grape.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import me.giverplay.grape.Grape;
import me.giverplay.grape.world.World;

public class GameScreen extends ScreenAdapter {

  private OrthographicCamera camera;
  private SpriteBatch batch;

  private World world;

  @Override
  public void show() {
    camera = new OrthographicCamera(Grape.SCREEN_WIDTH, Grape.SCREEN_HEIGHT);
    camera.setToOrtho(false, Grape.SCREEN_WIDTH, Grape.SCREEN_HEIGHT);

    batch = new SpriteBatch();

    world = new World(camera, 100, 100);
  }

  @Override
  public void render(float deltaTime) {
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    Gdx.gl.glClearColor(0.3f, 0.6f, 0.8f, 1);

    world.update(deltaTime);
  }

  @Override
  public void resize(int width, int height) {

  }

  @Override
  public void dispose() {
    batch.dispose();
    world.dispose();
  }
}
