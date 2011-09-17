package norton.android.util.graphics;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class BackgroundLayer implements Drawable {
	private Bitmap image;
	private float speed;
	private float x;
	private float y;
	
	public BackgroundLayer(Bitmap image, float speed, float y) {
		this.image = image;
		this.speed = speed;
		this.y = y;
		this.x = 0;
	}

	@Override
	public void onDraw(Canvas canvas) {
		float pos = x;
		
		while(pos < canvas.getWidth()) {
			canvas.drawBitmap(image, pos, y, null);
			pos += image.getWidth();
		}
				
	}

	public void scroll() {
		x = (x - speed) % image.getWidth(); 
	}
}
