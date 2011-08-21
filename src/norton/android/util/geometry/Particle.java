package norton.android.util.geometry;

/**
 * This class represents a particle on a 2d euclidean plane
 * 
 * @author Linus Norton <linusnorton@gmail.com>
 */
public class Particle {
    protected float x;
    protected float y;
    
    public Particle() {
        this.x = 0;
        this.y = 0;
    }
    
    public Particle(float x, float y) {        
        this.x = x;
        this.y = y;
    }    

    /**
     * Use some basic trigonometry to apply the given
     * vector to this particle
     * 
     * @param vector
     */
    public void applyVector(Vector vector) {
        float adjacent = 0; //dx
        float opposite = 0; //dy
        float hypotenuse = vector.getMagnitude();
        double angle = Math.toRadians(vector.getDirection());
        
        adjacent = (float) (Math.cos(angle) * hypotenuse);
        opposite = (float) (Math.sin(angle) * hypotenuse);
        
        x += adjacent;
        y += opposite; 
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

}
