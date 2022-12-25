package me.giverplay.grape.entity.system;

import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.systems.IteratingSystem;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;

import me.giverplay.grape.entity.component.SpriteComponent;
import me.giverplay.grape.entity.component.TouchableComponent;
import me.giverplay.grape.entity.component.TransformComponent;

public class TouchSystem extends IteratingSystem {

  private ComponentMapper<TransformComponent> transformMapper;
  private ComponentMapper<TouchableComponent> touchableMapper;
  private ComponentMapper<SpriteComponent> spriteMapper;

  private final Vector3 touchPosition = new Vector3();
  private final OrthographicCamera camera;

  public TouchSystem(OrthographicCamera camera) {
    super(Aspect.all(TransformComponent.class, TouchableComponent.class, SpriteComponent.class));
    this.camera = camera;
  }

  @Override
  protected void process(int entityId) {
    TouchableComponent touchable = touchableMapper.get(entityId);
    touchable.isTouched = false;

    if (Gdx.input.isTouched()) {
      TransformComponent transform = transformMapper.get(entityId);
      SpriteComponent sprite = spriteMapper.get(entityId);

      touchPosition.set(Gdx.input.getX(), Gdx.input.getY(), 0);
      camera.unproject(touchPosition);

      float w = sprite.sprite.getWidth();
      float h = sprite.sprite.getHeight();
      float x;
      float y;

      if(transform.originCenter) {
        x = transform.position.x - w / 2;
        y = transform.position.y - h / 2;
      } else {
        x = transform.position.x;
        y = transform.position.y;
      }

      if (touchPosition.x >= x && touchPosition.x <= x + sprite.sprite.getWidth()
        && touchPosition.y >= y && touchPosition.y <= y + sprite.sprite.getHeight()
      ) {
        touchable.isTouched = true;
        touchable.touchPosition.set(touchPosition.x, touchPosition.y);
        transform.position.set(touchable.touchPosition);
      }
    }
  }
}
