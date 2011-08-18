package norton.android.util.geometry;

/**
 * A vector has a magnitude and a direction
 * 
 * @author Linus Norton <linusnorton@gmail.com>
 */
public class Vector {
    private float direction;
    private float magnitude;
    
    public Vector(float direction, float magnitude) {
        this.direction = direction;
        this.magnitude = magnitude;
    }
    
    public float getDirection() {
        return direction;
    }
    
    public void setDirection(float direction) {
        this.direction = direction;
    }
    
    public float getMagnitude() {
        return magnitude;
    }
    
    public void setMagnitude(float magnitude) {
        this.magnitude = magnitude;
    }
    
}
