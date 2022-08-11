/**
 * @author Callum Gibson and Jacob Owen
 * Student ID: 15906010 and 20125914
 */
public class Application {

    public static void main(String[] args) {
        ThreadPool pool = new ThreadPool(3);

        for (int i = 0; i < 5; i++) {
            TestTask task = new TestTask(i);
            System.out.println(pool.perform(task));
        }

    }
}
