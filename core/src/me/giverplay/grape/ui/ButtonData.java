package me.giverplay.grape.ui;

public class ButtonData {

  private final String name;
  private final String texture;

  private final float x;
  private final float y;

  private final float width;
  private final float height;

  public ButtonData(String name, String texture, float x, float y, float width, float height) {
    this.name = name;
    this.texture = texture;
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
  }

  public String getName() {
    return name;
  }

  public String getTexture() {
    return texture;
  }

  public float getX() {
    return x;
  }

  public float getY() {
    return y;
  }

  public float getWidth() {
    return width;
  }

  public float getHeight() {
    return height;
  }
}
