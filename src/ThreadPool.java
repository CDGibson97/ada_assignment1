import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author Callum Gibson and Jacob Owen
 * Student ID: 15906010 and 20125914
 */
public class ThreadPool implements Runnable {
    private final LinkedBlockingQueue taskQueue;//queue
    private Queue<Thread> theadPool;//threads
    private boolean run;

    public ThreadPool(int initialSize) {
        this.taskQueue = new LinkedBlockingQueue();
        this.theadPool = new LinkedBlockingQueue<>(initialSize);
        for (int i = 0; i < initialSize; i++) {
            Thread thread = new Thread(this);
            this.theadPool.add(thread);
            thread.start();
        }
    }

    public int getSize() {
        return this.theadPool.size();
    }

    public int getAvailable() {
        return 0;
    }

    public void resize(int newSize) {

    }

    public void destroyPool() {

    }

    public boolean perform(Runnable task) {
        synchronized (taskQueue) {
            taskQueue.add(task);
            taskQueue.notifyAll();
            System.out.println("waking up");
            //System.out.println("There are "+this.getAvailable()+" threads available");
            return true;
        }
    }

    @Override
    public void run() {
        Runnable task = null;
        while (true) {
            synchronized (taskQueue) {
                while (taskQueue.isEmpty()) {
                    try {
                        System.out.println("sleeping");
                        taskQueue.wait();
                        //System.out.println("There are "+this.getAvailable()+" threads available");
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                task = (Runnable) taskQueue.poll();
                task.run();
            }
        }
    }
}
