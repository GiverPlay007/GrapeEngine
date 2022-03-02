package me.giverplay.grape.resource;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.graphics.Texture;

import net.dermetfan.gdx.assets.AnnotationAssetManager;

import java.util.HashMap;
import java.util.Map;

public class Assets {

  public static final AnnotationAssetManager manager = new AnnotationAssetManager(new InternalFileHandleResolver());

  private static final Map<String, AssetDescriptor<Texture>> textures = new HashMap<>();

  private static boolean engineLoaded;

  public static void addTexture(String name, String path) {
    AssetDescriptor<Texture> texture = new AssetDescriptor<>(path, Texture.class);
    textures.put(name, texture);

    if(engineLoaded) {
      manager.load(texture);
    }
  }

  public static Texture getTexture(String name) {
    AssetDescriptor<Texture> texture = textures.get(name);
    return texture != null ? manager.isLoaded(texture) ? manager.get(texture) : null : null;
  }

  public static void load() {
    Texture.setAssetManager(manager);

    for(AssetDescriptor<Texture> texture : textures.values()) {
      manager.load(texture);
    }
  }

  public static void onEngineLoad() {
    engineLoaded = true;
  }
}
