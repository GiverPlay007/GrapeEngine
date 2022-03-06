package me.giverplay.grape.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import me.giverplay.grape.resource.Assets;

public class DynamicHUD implements Disposable {

  private final Viewport viewport;
  private final SpriteBatch batch;
  private final Stage stage;

  private final int width;
  private final int height;

  public DynamicHUD(int width, int height) {
    this.width = width;
    this.height = height;
    this.batch = new SpriteBatch();
    this.viewport = new FitViewport(width, height, new OrthographicCamera());
    this.stage = new Stage(viewport, batch);

    Assets.addTexture("arrow_up", "arrow_up.png");
    Assets.addTexture("arrow_down", "arrow_down.png");
    Assets.addTexture("arrow_right", "arrow_right.png");
    Assets.addTexture("arrow_left", "arrow_left.png");
  }

  public void start() {
    Image up = new Image(Assets.getTexture("arrow_up"));
    Image down = new Image(Assets.getTexture("arrow_down"));
    Image right = new Image(Assets.getTexture("arrow_right"));
    Image left = new Image(Assets.getTexture("arrow_left"));

    int size = 64;

    up.setSize(size, size);
    down.setSize(size, size);
    left.setSize(size, size);
    right.setSize(size, size);

    Table table = new Table();
    table.left().bottom();

    table.add();
    table.add(up).size(up.getWidth(), up.getHeight());
    table.add();

    table.row().pad(5, 5, 5, 5);
    table.add(left).size(left.getWidth(), left.getHeight());
    table.add();
    table.add(right).size(right.getWidth(), right.getHeight());

    table.row().padBottom(5);
    table.add();
    table.add(down).size(down.getWidth(), down.getHeight());
    table.add();

    stage.addListener(new EventListener() {
      @Override
      public boolean handle(Event event) {
        System.out.println(event.getTarget());
        return true;
      }
    });
    stage.addActor(table);
    Gdx.input.setInputProcessor(stage);
  }

  public void draw() {
    stage.draw();
  }

  public void resize(int width, int height) {
    viewport.update(width, height);
  }

  @Override
  public void dispose() {
    batch.dispose();
  }

  public Viewport getViewport() {
    return viewport;
  }

  public Stage getStage() {
    return stage;
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }
}
