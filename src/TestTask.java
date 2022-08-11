public class TestTask extends Task implements TaskObserver {

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
        System.out.println(getID());
        System.out.println(update);
    }
}
