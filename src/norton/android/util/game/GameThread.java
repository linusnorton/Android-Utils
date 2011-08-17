package norton.android.util.game;

import norton.android.util.graphics.Renderer;
import norton.android.util.graphics.Scene;
import android.util.Log;

/**
 * This is generic game thread that contains the main game loop.
 * 
 * It manages the FPS and the sub class just needs to implement the tick logic
 * 
 * @author Linus Norton <linusnorton@gmail.com>
 */
public abstract class GameThread implements Runnable, Scene {
    private int tickLength;
    private boolean running;
    private boolean paused;
    private Renderer renderer;

    /**
     * Setup the thread with a default 20fps
     */
    public GameThread() {
        tickLength = 50; //20fps
        running = false;
        paused = false;
    }
    
    /**
     * Setup the game thread at a given fps
     * @param fps
     */
    public GameThread(int fps) {
        tickLength = (int) (1000 / fps);
        running = false;
        paused = false;
    }
    
    /**
     * Main game loop
     */
    @Override
    public void run() {
        running = true;
        long loopExecutionTime = 0;
        long loopStartTime = 0;
        
        while (running) {
            //if we still have some sleepy time, go to sleep
            if (tickLength - loopExecutionTime > 0) {
                try {                
                    Thread.sleep(tickLength - loopExecutionTime);
                } catch (InterruptedException e) { }            
            }
            else {
                Log.w("GAME_THREAD", "Current lag: " + Long.toString(tickLength - loopExecutionTime));
            }
            
            loopStartTime = System.currentTimeMillis();
            
            if (!paused) {                                        
                tick();            
                
                if (renderer != null) {
                    renderer.render(this);
                }
            }
            
            loopExecutionTime = System.currentTimeMillis() - loopStartTime;
        }

    }
    
    /**
     * Implement your game logic here
     */
    protected abstract void tick();

    /**
     * Prevents the game from calling the tick method
     */
    public void pause() {
        paused = true;
    }
    
    /**
     * Continue execution of the game
     */
    public void unPause() {
        paused = false;
    }
    
    /**
     * Toggle between paused and not paused
     */
    public void togglePause() {
        paused = !paused;
    }

    /**
     * End the thread execution
     */
    public void end() {
        running = false;
    }
    
    /**
     * Return the current tick length
     * @return
     */
    protected int getTickLength() {
        return tickLength;
    }
    
    /**
     * Set the renderer that draws this scene
     * @param renderer
     */
    public void setRenderer(Renderer renderer) {
        this.renderer = renderer;
    }
}
