
/**
 * Schedule Iterator implements the Iterator and its functions to iterate from a list of job. 
 *
 * @author Aneel Ahmed
 * @version 2.0
 */
public class SchedularIterator implements Iterator
{
    // instance variables
       
    Schedular scheduling;
    int index;

    /**
     * Constructor for objects of class SchedularIterator.
     * It takes object of Schedular in Constructor.
     */
    public SchedularIterator(Schedular scheduling) throws Exception 
    {
        // initialise instance variables
        super();
        this.scheduling = scheduling;
        this.index = 0;
    }

    /**
     * @param None.
     * @return boolean
     */
    public boolean hasNext(){
    
    try{
    
        if(this.index<=scheduling.getLength()) return true;
        return false;
    }
    catch (Exception e)
    {
        e.printStackTrace();
        return false;
    }
    }

    /**
     * @param None.
     * @return object
     */
    public Object next() {
    
        try
        {
            Object job = scheduling.getJobAt(this.index);
            this.index++;
            return job;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    
    }
}
