package norton.android.util.game;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import norton.android.util.geometry.Particle;
import norton.android.util.graphics.Drawable;

/**
 * A sprite is a game object that is rendered on screen. It can 
 * also collide with other objects
 * 
 * @author Linus Norton <linusnorton@gmail.com>
 */
public class Sprite extends Particle implements Drawable {
    protected int width;
    protected int height;
    protected Bitmap image;
    
    public Sprite(int x, int y, Bitmap image) {
        super();       
        
        this.x = x;
        this.y = y;
        this.image = image;
        this.width = image.getWidth();
        this.height = image.getHeight();              
    }
    
    /**
     * @return the width
     */
    public int getWidth() {
        return width;
    }
    /**
     * @param width the width to set
     */
    public void setWidth(int width) {
        this.width = width;
    }
    /**
     * @return the height
     */
    public int getHeight() {
        return height;
    }
    /**
     * @param height the height to set
     */
    public void setHeight(int height) {
        this.height = height;
    }
    
    /**
     * Return the left most point of the sprite
     * @return
     */
    public int getLeft() {
        return (int) x;
    }
    
    /**
     * Return the top most point
     * @return
     */
    public int getTop() {
        return (int) y;
    }
    
    /**
     * Return the right most point
     * @return
     */
    public int getRight() {
        return (int) x + width;
    }
    
    /**
     * Return the bottom most point
     */
    public int getBottom() {
        return (int) y + height;
    }
        
    /**
     * Calculate the over crossing areas and scan each pixel for a collision
     * 
     * @param balloon
     * @param train
     * @return
     */
    public boolean isCollidingWith(Sprite sprite) {
        int left = Math.max(getLeft(), sprite.getLeft());
        int right = Math.min(getRight(), sprite.getRight());
        int top = Math.max(getTop(), sprite.getTop());
        int bottom = Math.min(getBottom(), sprite.getBottom());

        for (int x = left; x < right; x++) {
            for (int y = top; y < bottom; y++) {
                if (isFilled(x - getLeft(), y - getTop()) && 
                    sprite.isFilled(x - sprite.getLeft(), y - sprite.getTop())) {
                    return true;
                }
            }
        }
        
        return false; 
    }

    /**
     * Draw the Balloon
     */
    @Override
    public void onDraw(Canvas canvas) {
        canvas.drawBitmap(image, x, y, null);        
    }
    
    /**
     * If the given pixel is not transparent then it is filled
     * @param x
     * @param y
     * @return
     */
    public boolean isFilled(int x, int y) {
        return image.getPixel(x, y) != Color.TRANSPARENT;
    } 
   
}
