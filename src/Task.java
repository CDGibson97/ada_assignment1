import javax.lang.model.element.Element;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Callum Gibson and Jacob Owen
 * Student ID: 15906010 and 20125914
 */
public abstract class Task<E,F> implements Runnable{

    public E element;
    public int ID;
    public Thread threads;
    public List<TaskObserver> listeners;

    public Task(E element){
        this.element = element;
        UniqueIdentifier UI = new UniqueIdentifier();
        UI.returnID(this);
        this.listeners = new ArrayList<>();
    }

    public int getID(){
        return this.ID;
    }

    public void addListener(TaskObserver<F> o){

        listeners.add(o);
    }

    public void removeListener(TaskObserver<F> o){

        listeners.remove(o);
    }

    protected void notifyAll(F progress){
        for(TaskObserver<F> i: listeners) {
            i.process(progress);
        }
        System.out.println("wooooo");
    }

    @Override
    public abstract void run();
}
