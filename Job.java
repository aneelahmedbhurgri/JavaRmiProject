import java.time.LocalDate;
import java.io.Serializable;

/**
 * Job is a class which stores the information like job name, id, command for scheduling purpose which is stored in database as columns. 
 *
 * @author Aneel Ahmed
 * @version 2.0
 */
public class Job implements Serializable
{
    // instance variables
    String name;
    String type;
    LocalDate time;
    LocalDate scheduled;

    /**
     * Constructor for objects of class Job
     */
    public Job(String name, String type)
    {
        // initialise instance variables
        this.name = name;
        this.type = type;
        this.time =  LocalDate.now();
        this.scheduled = LocalDate.now();
    }
    
    /**
     * Getter method, returns name as String type
     * @param None
     * @return String
     */
    public String getName(){
        return this.name;  
    }
    
    /**
     * Getter method, returns job type as String type
     * @param None
     * @return String
     */
    public String getType(){
        return this.type;  
    }
    
    /**
     * Getter method, returns Date and time when job was created as LocalDate type
     * @param None
     * @return LocalDate
     */
    public LocalDate getTime(){
        return this.time;  
    }
    
    /**
     * Getter method, returns Date and time when job is scheduled as LocalDate type
     * @param None
     * @return LocalDate
     */
    public LocalDate getScheduled(){
        return this.scheduled;  
    }
    
    @Override
    public String toString() {
    return "Jobs:{name:" + name +"\n"+ "type:" + type +"\n"+  ", time:" + time + "\n"+ ", scheduled:" + scheduled + "}"+ "\n";
    }
}
