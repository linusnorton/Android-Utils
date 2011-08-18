package norton.android.util.geometry;

/**
 * This class represents a particle on a 2d euclidean plane
 * 
 * @author Linus Norton <linusnorton@gmail.com>
 */
public class Particle {
    private float x;
    private float y;
    private float mass;
    
    public Particle() {
        this.x = 0;
        this.y = 0;
        this.mass = 0;
    }
    
    public Particle(float x, float y, float mass) {        
        this.x = x;
        this.y = y;
        this.mass = mass;
    }    

    /**
     * Apply the given vector force to the particle
     * @param vector
     */
    public void applyVector(Vector vector) {
        
    }
    
    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }    
    
    public float getMass() {
        return mass;
    }

    public void setMass(float mass) {
        this.mass = mass;
    }    
}
