import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author Callum Gibson and Jacob Owen
 * Student ID: 15906010 and 20125914
 */
public class ThreadPool {
    public Queue<Thread> pool;

    public ThreadPool(int initialSize)
    {
        this.pool = new LinkedBlockingQueue<>(initialSize);
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
        return false;
    }

}
