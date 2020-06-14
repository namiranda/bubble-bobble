package Model;

import util.Observer;
import util.Subject;

import java.util.ArrayList;

public class Juego implements Runnable, Subject {

//    private static final int PWIDTH = 1280; // size of panel
//    private static final int PHEIGHT = 720;

    private Thread animator; // for the animation

    public volatile boolean running = false; // stops the animation
    private volatile boolean gameOver = false; // for game termination

    private long lastFpsTime;  //The last time at which we recorded the frame rate
    private int fps;  //The current number of frames recorded

    private ArrayList<Observer> observers = new ArrayList<>();

    public void run() {

        long sleepTime;
        long lastLoopTime = System.nanoTime();
        final int TARGET_FPS = 60;
        final long OPTIMAL_TIME = 1000000000 / TARGET_FPS;
        running = true;

        while (running)
        {
            // work out how long its been since the last update, this
            // will be used to calculate how far the entities should
            // move this loop
            long now = System.nanoTime();
            long updateLength = now - lastLoopTime;
            lastLoopTime = now;
            double delta = updateLength / ((double)OPTIMAL_TIME);

            // update the frame counter
            lastFpsTime += updateLength;
            fps++;

            // update our FPS counter if a second has passed since we last recorded
            if (lastFpsTime >= 1000000000)
            {
                System.out.println("(FPS: "+fps+")");
                lastFpsTime = 0;
                fps = 0;
            }

            // update the game logic
            gameUpdate();

            //notify observer of game update
            notifyObservers();

            sleepTime = (lastLoopTime-System.nanoTime() + OPTIMAL_TIME)/1000000; //time left in this loop

            if (sleepTime <= 0) // update/render took longer than period
                sleepTime = 1; // sleep a bit anyway
            try {
                Thread.sleep(sleepTime); // in ms
            }
            catch(InterruptedException e){ e.printStackTrace();}


        } System.exit(0);

    }


    public void startGame()// initialise and start the thread
    {
        if (animator == null || !running) {
            animator = new Thread(this, "Game Thread");
            animator.start();
        }
    }

    private void gameUpdate(){ //if (!gameOver)
        // update game state ...
    }

    public void stopGame() // called by the user to stop execution
    { running = false; }


    @Override
    public boolean registerObserver(Observer observer) {
        return observers.add(observer);
    }

    @Override
    public boolean removeObserver(Observer observer) {
        return observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer o :
                observers) {
            o.update();
        }
    }
}