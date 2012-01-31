package norton.android.util.geometry;

/**
 * A Vector that can accelerate and decelerate
 * 
 * @author Linus Norton <linusnorton@gmail.com>
 */
public class VariableVector extends Vector {
    private float minSpeed;
    private float maxSpeed;
    private float acceleration;
    private float deceleration;

    /**
     * Create a variable force vector
     * @param direction
     * @param magnitude
     * @param minSpeed
     * @param maxSpeed
     * @param acceleration
     * @param deceleration
     */
    public VariableVector(float direction, 
                          float magnitude,
                          float minSpeed,
                          float maxSpeed,
                          float acceleration,
                          float deceleration) {
        super(direction, magnitude);
        this.minSpeed = minSpeed;
        this.maxSpeed = maxSpeed;
        this.acceleration = acceleration;
        this.deceleration = deceleration;
    }
    
    /**
     *Increase the magnitude of the vector
     */
    public void accelerate() {
        if (magnitude < maxSpeed) {
            magnitude += acceleration;
            
            if (magnitude > maxSpeed) {
            	magnitude = maxSpeed;
            }
        }
    }
    
    /**
     * Decrease the magnitude of the vector
     */
    public void decelerate() {
        if (magnitude > minSpeed) {
            magnitude -= deceleration;
            
            if (magnitude < minSpeed) {
            	magnitude = minSpeed;
            }
        }
    }

    /**
     * @return the minSpeed
     */
    public float getMinSpeed() {
        return minSpeed;
    }

    /**
     * @param minSpeed the minSpeed to set
     */
    public void setMinSpeed(float minSpeed) {
        this.minSpeed = minSpeed;
    }

    /**
     * @return the maxSpeed
     */
    public float getMaxSpeed() {
        return maxSpeed;
    }

    /**
     * @param maxSpeed the maxSpeed to set
     */
    public void setMaxSpeed(float maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    /**
     * @return the acceleration
     */
    public float getAcceleration() {
        return acceleration;
    }

    /**
     * @param acceleration the acceleration to set
     */
    public void setAcceleration(float acceleration) {
        this.acceleration = acceleration;
    }

    /**
     * @return the deceleration
     */
    public float getDeceleration() {
        return deceleration;
    }

    /**
     * @param deceleration the deceleration to set
     */
    public void setDeceleration(float deceleration) {
        this.deceleration = deceleration;
    }       

}
