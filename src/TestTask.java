public class TestTask<Integer, Boolean> extends Task implements TaskObserver {

    public ThreadPool pool;

    public TestTask(Integer element) {
        super(element);
    }

    @Override
    public void run(){
        int i = 4;
        int j = 8;
        this.process(i*j);

    }

    @Override
    public void process(Object update) {
        System.out.println(" is doing task: "+getID()+" answer: "+update);
    }
}
