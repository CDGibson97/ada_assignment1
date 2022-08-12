public class TestTask<Integer, Boolean> extends Task implements TaskObserver {

    public ThreadPool pool;
    public boolean completed;

    public TestTask(Integer element) {
        super(element);
        completed = false;
    }

    @Override
    public void run(){
        int i = 4;
        int j = 8;
        this.process(i*j);
        completed = true;
    }

    @Override
    public void process(Object update) {
        System.out.println(" is doing task: "+getID()+" answer: "+update);
    }
}
