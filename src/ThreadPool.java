import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author Callum Gibson and Jacob Owen
 * Student ID: 15906010 and 20125914
 */
public class ThreadPool implements Runnable {
    private final LinkedBlockingQueue taskQueue;//queue
    private Queue<Thread> pool;//threads
    private static int threadID = 1;

    public ThreadPool(int initialSize) {
        this.taskQueue = new LinkedBlockingQueue();
        this.pool = new LinkedBlockingQueue<>(initialSize);
        for (int i = 0; i < initialSize; i++) {
            Thread thread = new Thread(this);
            thread.setName("Thread " + threadID++);
            this.pool.add(thread);
            thread.start();
        }
    }

    public int getSize() {
        return this.pool.size();
    }

    public int getAvailable() {
        int count = 0;
        if (!pool.isEmpty()) {
            for (Thread thread : pool) {
                if (thread.getState() == Thread.State.WAITING) {
                    count++;
                }
            }
            return count;
        } else {
            return pool.size();
        }
    }

    public void resize(int newSize) {
        LinkedBlockingQueue temp = new LinkedBlockingQueue(newSize);

        for (Thread thread : pool) {
            if (temp.remainingCapacity() != 0) {
                temp.add(pool.remove());
            }
            else {
                thread.stop();
            }
        }
        if (temp.remainingCapacity() != 0 && pool.isEmpty()) {
            while (temp.remainingCapacity() != 0) {
                Thread thread = new Thread(this);
                thread.setName("Thread " + threadID++);
                temp.add(thread);
                thread.start();
            }
        }
        pool = temp;
    }

    public void destroyPool() {
        while (pool.size() != 0) {
            for (Thread thread : pool) {
                if (thread.getState() == Thread.State.WAITING) {
                    thread.stop();
                    System.out.println(thread.getName() + " is terminating");
                    pool.remove(thread);
                }
            }
        }
        System.out.println("Threads terminated");
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
