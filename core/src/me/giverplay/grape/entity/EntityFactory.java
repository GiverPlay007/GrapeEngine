package me.giverplay.grape.entity;

import com.artemis.ComponentMapper;

import me.giverplay.grape.entity.component.CollidableComponent;
import me.giverplay.grape.entity.component.JumpComponent;
import me.giverplay.grape.entity.component.RigidBodyComponent;
import me.giverplay.grape.entity.component.SpriteComponent;
import me.giverplay.grape.entity.component.TransformComponent;

public class EntityFactory {
  private ComponentMapper<CollidableComponent> collidableComponentMapper;
  private ComponentMapper<TransformComponent> transformComponentMapper;
  private ComponentMapper<RigidBodyComponent> rigidBodyComponentMapper;
  private ComponentMapper<SpriteComponent> spriteComponentMapper;
  private ComponentMapper<JumpComponent> jumpComponentMapper;
}
