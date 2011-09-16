package norton.android.util.graphics;

import java.util.HashSet;
import java.util.Set;

import norton.android.util.game.OnTickListener;

import android.graphics.Bitmap;

public class ParallaxScrollingBackground implements Scene, OnTickListener {
	private HashSet<BackgroundLayer> layers;

	public ParallaxScrollingBackground(HashSet<BackgroundLayer> layers) {
		this.layers = layers;
	}

	@Override
	public Set<? extends Drawable> getDrawables() {
		return layers;
	}

	@Override
	public void onTick() {
		for (BackgroundLayer layer : layers) {
			layer.scroll();
		}
	}
	
	
}
