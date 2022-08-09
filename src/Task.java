import javax.lang.model.element.Element;

/**
 * @author Callum Gibson and Jacob Owen
 * Student ID: 15906010 and 20125914
 */
public abstract class Task<E,F> implements Runnable{

    public E element;
    private int ID;

    public Task(E element){
        this.element = element;
        UniqueIdentifier UI = new UniqueIdentifier();
        this.ID = UI.returnID();
    }

    public int getID(){

        return this.ID;
    }

    public void addListener(TaskObserver<F> o){

    }

    public void removeListener(TaskObserver<F> o){

    }

    protected void notifyAll(F progress){

    }


    @Override
    public void run() {

    }
}
