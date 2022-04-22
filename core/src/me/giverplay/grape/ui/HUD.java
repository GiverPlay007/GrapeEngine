package me.giverplay.grape.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.WidgetGroup;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.util.HashMap;
import java.util.Map;

import me.giverplay.grape.resource.Assets;

public class HUD extends WidgetGroup implements Disposable {

  private final Map<String, Button> buttons = new HashMap<>();

  private final Viewport viewport;
  private final SpriteBatch batch;
  private final Stage stage;


  public HUD(int width, int height) {
    setSize(width, height);

    this.batch = new SpriteBatch();
    this.viewport = new FitViewport(width, height, new OrthographicCamera());
    this.stage = new Stage(viewport, batch);

    stage.addActor(this);
    Gdx.input.setInputProcessor(stage);
  }

  public Button addButton(ButtonData data) {
    Texture texture = Assets.getTexture(data.getTexture());
    ImageButton button = new ImageButton(new TextureRegionDrawable(texture));
    button.setPosition(data.getX(), data.getY());
    button.setSize(data.getWidth(), data.getHeight());

    addActor(button);
    buttons.put(button.getName(), button);

    return button;
  }

  public void draw() {
    stage.draw();
  }

  public void resize(int width, int height) {
    setSize(width, height);
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
}
