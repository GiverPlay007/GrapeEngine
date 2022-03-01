package me.giverplay.grape.resource;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.graphics.Texture;

import net.dermetfan.gdx.assets.AnnotationAssetManager;
import net.dermetfan.gdx.assets.AnnotationAssetManager.Asset;

public class Assets {

  public static final AnnotationAssetManager manager = new AnnotationAssetManager(new InternalFileHandleResolver());

  @Asset
  public static AssetDescriptor<Texture> splashBanner = new AssetDescriptor<>("splash.jpg", Texture.class);

  public static void load() {
    Texture.setAssetManager(manager);
    manager.load(Assets.class);
  }
}
