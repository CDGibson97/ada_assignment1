import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author Callum Gibson and Jacob Owen
 * Student ID: 15906010 and 20125914
 */
public class ThreadPool implements Runnable {
    private Queue tasks;
    private Queue<Thread> pool;
    private boolean run;
    public ThreadPool(int initialSize)
    {
        this.pool = new LinkedBlockingQueue<>(initialSize);
        for(int i = 0; i < initialSize; i++){
            Thread thread = new Thread();
            this.pool.add(thread);
            thread.start();
        }
    }

    public int getSize()
    {
        return this.pool.size();
    }

    public int getAvailable()
    {
        return 0;
    }

    public void resize(int newSize)
    {

    }

    public void destroyPool()
    {

    }

    public boolean perform(Runnable task)
    {
        task.run();
        return true;
    }

    public synchronized void stop(){
        run = false;
    }

    @Override
    public void run(){
        while(run){
            try {
                if(tasks.isEmpty()) {
                    Thread.currentThread().wait();
                } else{
                    Runnable run = (Runnable) tasks.poll();
                    run.run();
                }
            }catch(Exception ex){
                System.err.println("Error: "+ex);
            }
        }
    }
}
