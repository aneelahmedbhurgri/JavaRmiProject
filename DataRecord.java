import java.util.ArrayList;

/**
 * Sample Databse for robot scheduled jobs
 *
 * @author Aneel Ahmed
 * @version 2.0
 */
public class DataRecord
{
    // instance variables - replace the example below with your own
    private ArrayList<Job> scheduleTable = new ArrayList<>();
    
    public  void insertQuery(Job job){
        if (scheduleTable == null){
            scheduleTable = new ArrayList<>();
        }
        scheduleTable.add(job);
    }
    public ArrayList<Job> getscheduleTable(){
        return scheduleTable;
    }
    
    public boolean deleteQuery(Job job){
        if (scheduleTable != null){
            return scheduleTable.remove(job);
        }
        return false;
    }
}
