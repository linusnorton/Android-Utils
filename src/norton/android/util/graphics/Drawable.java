package norton.android.util.graphics;

import android.graphics.Canvas;
/**
 * Interface for drawable objects.
 * 
 * onDraw method is invoked by the GameSurface 
 * 
 * @author Linus Norton <linusnorton@gmail.com>
 */
public interface Drawable {
    public void onDraw(Canvas canvas);
}
