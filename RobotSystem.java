import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.List;
import java.util.ArrayList;

/**
 * Robot System Software Class 
 *
 * @author Aneel Ahmed
 * @version 2.0
 */
public class RobotSystem
{
    // instance variables - replace the example below with your 
    private int batteryLevel = 80;
    private boolean robotBusy = false;
    private String currentJob = "No Job Scheduled";
    /**
     * Constructor for objects of class RobotSystem
     * 
     */
    public RobotSystem() throws RemoteException
    {

    }
    
    /**
     * For the battery on robot hardware, usually its 80 now because this is just for testing
     * @param None
     * @return int
     */
    public int getBatteryLevel(){
        return batteryLevel;
    }
    
    /**
     * To check if robot is busy with job or not
     * @param None
     * @return boolean
     */
    public boolean getRobotStatus(){
        return robotBusy;
    }
    
    /**
     * For setting  current job
     * @param String job
     * @return None
     */
    public void setCurrentJob(String jobName){
        this.currentJob = jobName;
        this.robotBusy = true;
    }
    
    /**
     * To get current Job
     * @param None
     * @return None
     */
    public String getCurrentJob(){
        return this.currentJob;
    }

}
