import java.util.ArrayList;
import java.io.Serializable;
/**
 * Schedular class implements Container interface, this class behaves like controller and has all the functions
 * required to display job, create job or delete it from database.
 * It iterates all the jobs in list and will produce list of jobs in app to show it to user.
 *
 * @author Aneel Ahmed
 * @version 2.0
 */
public class Schedular implements Container
{
    // instance variables
    IRemoteObject obj;
    /**
     * Constructor for objects of class Schedular
     */
    public Schedular(IRemoteObject obj) throws Exception 
    {
        this.obj = obj;
 
    }

    /**
     * This function returns the Iterator object
     * @param None
     * @return the new object SchedularIterator.
     */
    public Iterator iterator() throws Exception{
        
        return new SchedularIterator(this); 
    }

    /**
     * This functions does take an integer which is used as index of Arraylist of Job, and returns the object Job at that given index.
     * @param index as integer.
     * @return Job object.
     */
    public Object getJobAt(int index) throws Exception {
        return obj.robotScheduledList().get(index).getName();
    }

  
    /**
     * Function returns the total number of jobs in schedular list.
     * @param None
     * @return it returns integer number as the size or length of ArrayList 
     */
    public int getLength() throws java.rmi.RemoteException{
        return obj.robotScheduledList().size()-1;
    }
    /**
     * This function is used to return all the jobs inside List could also be used to return as List as well.
     * @param None
     * @throws if list of jobs is empty are null it will display message as No job found.
     * @return Returns all the jobs inside list as a String.
     */
    public String listAll() throws java.rmi.RemoteException{
        String listjobs = "";
        if (obj == null) return "No job inside Scheduler";
        try
        {
            Iterator iter = this.iterator();
            while(iter.hasNext()){
            Object myJobs = iter.next();
            listjobs += myJobs+"\n";
        }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return listjobs;
    }
    
    public ArrayList<Object> allJobs() throws java.rmi.RemoteException {
        if (obj == null) return null;
        ArrayList<Object> listJobs = new ArrayList<>();
        try
        {
            Iterator iter = this.iterator();
            while(iter.hasNext()){
                Object myJobs = iter.next();
                listJobs.add(myJobs);
            }
            return listJobs;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }        
        
    }
}
