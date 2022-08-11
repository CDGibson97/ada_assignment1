/**
 * @author Callum Gibson and Jacob Owen
 * Student ID: 15906010 and 20125914
 */
public class UniqueIdentifier {
    private static int counter = 0;
    private static Task currentTask = null;

    public void returnID(Task task){
        if(currentTask == null){
            synchronized(UniqueIdentifier.class){
                if(currentTask == null){
                                currentTask = task;
                    task.ID = counter;
                    counter++;
                }
        task.ID = counter;
        counter++;
            }
        task.ID = counter;
        counter++;
        }
        task.ID = counter;
        counter++;
    }
}

    //Change to singleton method so that there is no race condition for ID
