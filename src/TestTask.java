public class TestTask extends Task implements TaskObserver {

    public ThreadPool pool;

    public TestTask(Object element) {
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
