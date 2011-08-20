package norton.android.util.geometry;

/**
 * A vector has a magnitude and a direction
 * 
 * @author Linus Norton <linusnorton@gmail.com>
 */
public class Vector {
    private float direction;
    private float magnitude;
    
    /**
     * Create the vector with the given direction
     * and magnitude
     * 
     * @param direction
     * @param magnitude
     */
    public Vector(float direction, float magnitude) {
        this.direction = direction;
        this.magnitude = magnitude;
    }
    
    /**
     * Return the direction of the vector
     * @return
     */
    public float getDirection() {
        return direction;
    }
    
    /**
     * Set the direction of the vector
     * @param direction
     */
    public void setDirection(float direction) {
        this.direction = direction;
    }
    
    /**
     * Return the magnitude of the vector
     * @return
     */
    public float getMagnitude() {
        return magnitude;
    }
    
    /**
     * Set the magnitude of the vector
     * @param magnitude
     */
    public void setMagnitude(float magnitude) {
        this.magnitude = magnitude;
    }
    
}
