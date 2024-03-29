/**
 * @author Callum Gibson and Jacob Owen
 * Student ID: 15906010 and 20125914
 */
public class Application {

    public static void main(String[] args) {
        ThreadPool pool = new ThreadPool(6);

        for (int i = 0; i < 5; i++) {
            TestTask task = new TestTask(i);
            task.addListener(task);
            pool.perform(task);

        }
        for (int i = 0; i < 5; i++) {
            TestTask task = new TestTask(i);
            pool.perform(task);

        }
        for (int i = 0; i < 5; i++) {
            TestTask task = new TestTask(i);
            pool.perform(task);

        }
        for (int i = 0; i < 5; i++) {
            TestTask task = new TestTask(i);
            pool.perform(task);

        }
        //pool.destroyPool();
        System.out.println(pool.getAvailable());
        System.out.println(pool.getAvailable());
        System.out.println(pool.getAvailable());

        pool.resize(10);

        for (int i = 0; i < 5; i++) {
            TestTask task = new TestTask(i);
            pool.perform(task);
        }
        pool.destroyPool();

    }
}
