package norton.android.util.game;

import java.util.ArrayList;
import java.util.HashSet;

import android.util.Log;

/**
 * This is generic game thread that contains the main game loop.
 * 
 * It manages the FPS and invokes the tick() method of every TicketListener
 * every cycle.
 * 
 * @author Linus Norton <linusnorton@gmail.com>
 */
public class GameThread implements Runnable {
    private int tickLength;
    private boolean running;
    private boolean paused;
    private HashSet<OnTickListener> listeners;

    /**
     * Setup the thread with a default 20fps
     */
    public GameThread() {
    	this(50); //20fps
    }
    
    /**
     * Setup the game thread at a given fps
     * @param fps
     */
    public GameThread(int fps) {
        tickLength = (int) (1000 / fps);
        running = false;
        paused = false;
        listeners = new HashSet<OnTickListener>();
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
                //Log.w("GAME_THREAD", "Current lag: " + Long.toString(tickLength - loopExecutionTime));
            }
            
            loopStartTime = System.currentTimeMillis();
            
            if (!paused) {                                        
                for (OnTickListener listener : listeners) {
                	listener.onTick();
                }
            }
            
            loopExecutionTime = System.currentTimeMillis() - loopStartTime;
        }

    }    

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
    public int getTickLength() {
        return tickLength;
    }
    
    /**
     * Attach a listener to the ticks
     * @param listener
     */
    public void addTickListener(OnTickListener listener) {
    	listeners.add(listener);
    }
    
    /**
     * Remove a listener from the list
     * @param listener
     */
    public void removeTickListener(OnTickListener listener) {
    	listeners.remove(listener);
    }
    
}
