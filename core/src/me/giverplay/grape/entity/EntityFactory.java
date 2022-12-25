package me.giverplay.grape.entity;

import com.artemis.ComponentMapper;
import com.artemis.World;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

import me.giverplay.grape.entity.component.CollidableComponent;
import me.giverplay.grape.entity.component.JumpComponent;
import me.giverplay.grape.entity.component.RigidBodyComponent;
import me.giverplay.grape.entity.component.SpriteComponent;
import me.giverplay.grape.entity.component.TouchableComponent;
import me.giverplay.grape.entity.component.TransformComponent;
import me.giverplay.grape.resource.Assets;

public class EntityFactory {
  private ComponentMapper<CollidableComponent> collidableComponentMapper;
  private ComponentMapper<TransformComponent> transformComponentMapper;
  private ComponentMapper<RigidBodyComponent> rigidBodyComponentMapper;
  private ComponentMapper<SpriteComponent> spriteComponentMapper;
  private ComponentMapper<JumpComponent> jumpComponentMapper;
  private ComponentMapper<TouchableComponent> touchableComponentMapper;

  private final World world;

  public EntityFactory(World world) {
    this.world = world;
  }

  public int createSampleEntity(int x, int y) {
    int entityId = world.create();

    Texture texture = Assets.getTexture("finde");

    TransformComponent transform = transformComponentMapper.create(entityId);
    transform.position.set(x, y);

    SpriteComponent sprite = spriteComponentMapper.create(entityId);
    sprite.sprite = new Sprite(texture);

    touchableComponentMapper.create(entityId);
    collidableComponentMapper.create(entityId);

    return entityId;
  }
}
