package me.giverplay.grape.world;

import com.artemis.WorldConfigurationBuilder;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.Disposable;

import me.giverplay.grape.entity.EntityFactory;
import me.giverplay.grape.system.MovementSystem;
import me.giverplay.grape.system.SpriteRenderSystem;

public class World implements Disposable {

  private final com.artemis.World artemisWorld;
  private final EntityFactory entityFactory;

  private float gravity = -576;
  private int groundLevel = 64;

  private final int width;
  private final int height;

  public World(OrthographicCamera camera, int width, int height) {
    this.width = width;
    this.height = height;

    WorldConfigurationBuilder config = new WorldConfigurationBuilder()
      .with(new MovementSystem(this))
      .with(new SpriteRenderSystem(camera));

    artemisWorld = new com.artemis.World(config.build());

    entityFactory = new EntityFactory(artemisWorld);
    artemisWorld.inject(entityFactory);
  }

  public void update(float deltaTime) {
    artemisWorld.setDelta(deltaTime);
    artemisWorld.process();
  }

  public boolean isValidCoordinate(int x, int y) {
    return x >= 0 && x < getWidth() && y >= 0 && y < getHeight();
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }

  public com.artemis.World getArtemisWorld() {
    return artemisWorld;
  }

  public float getGravity() {
    return gravity;
  }

  public void setGravity(float gravity) {
    this.gravity = gravity;
  }

  public int getGroundLevel() {
    return groundLevel;
  }

  public void setGroundLevel(int groundLevel) {
    this.groundLevel = groundLevel;
  }

  public EntityFactory getEntityFactory() {
    return entityFactory;
  }

  @Override
  public void dispose() {
    artemisWorld.dispose();
  }
}
