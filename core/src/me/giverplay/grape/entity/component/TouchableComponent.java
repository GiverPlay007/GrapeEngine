package me.giverplay.grape.entity.component;

import com.artemis.Component;
import com.badlogic.gdx.math.Vector2;

public class TouchableComponent extends Component {
  public boolean isTouched;
  public Vector2 touchPosition = new Vector2();
}
