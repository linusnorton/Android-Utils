package norton.android.util.graphics;

import java.util.LinkedHashSet;
import java.util.Set;
import norton.android.util.game.OnTickListener;

public class ParallaxScrollingBackground implements Scene, OnTickListener {
	private LinkedHashSet<BackgroundLayer> layers;

	public ParallaxScrollingBackground(LinkedHashSet<BackgroundLayer> layers) {
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
