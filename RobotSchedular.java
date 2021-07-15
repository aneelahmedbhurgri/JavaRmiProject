import java.util.Iterator;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
/**
 * Utility Class to execute functions on robot System, Store Scheduled List of Jobs for robot, return list of scheduled jobs to UI client.
 *
 * @author Aneel Ahmed
 * @version 2.0
 */
public class RobotSchedular  extends UnicastRemoteObject implements ISchedular, IRemoteObject

{
    // instance variables - replace the example below with your own
    RobotSystem robot;
    DataRecord dataBase;
    /**
     * Constructor for objects of class Utility
     */
    public RobotSchedular() throws RemoteException
    {
        // initialise instance variables
        robot = new RobotSystem();
        dataBase = new DataRecord();
    }
    /**
     * Store Job on robot Scheduled Job list
     * @param String Job name, String job type
     * @return void
     */
    public void loadJobs(String name, String jobType) throws java.rmi.RemoteException {
        System.out.println("Client Request to Load Job in Schedule.");
        dataBase.insertQuery(new Job(name, jobType));
    }
      
    /**
     * Start new Job on robot, returns the code related to associated meenings.
     * @param String job name
     * @return int 
     */
    public int startJob(String name){
        System.out.println("Client Request to Start Job From Schedule.");
        if (this.findJob(name) == false) return -2;
        if ((robot.getBatteryLevel() > 60) &(robot.getRobotStatus() == false))
        {   
            
            robot.setCurrentJob(name);
            return 0;
        }
            
        else 
        return -1;
    }
    
    /**
     * For the current job running on robot
     * @param None
     * @return String current job
     */
    public String currentJob(){
        return robot.getCurrentJob();
    }
    
    /**
     * Private function to check if database contains job before starting
     * @param String job name
     * @return boolean
     */
    private boolean findJob(String name){
        for (Job searchName: dataBase.getscheduleTable()){
            if (searchName.getName().equals(name))
            {
                System.out.println(searchName.getName());
                return true;
            }
        }
        return false;
    }
    
    /**
     * Returns the ArrayList of scheduled jobs loaded on robot
     * @param None
     * @return ArrayList of Jobs
     */   
    public IRemoteObject scheduledJobs(){
        return this;
    }
    
    /**
     * Returns the ArrayList of scheduled jobs loaded on robot
     * @param None
     * @return ArrayList of Jobs
     */   
    public ArrayList<Job> robotScheduledList(){
        return dataBase.getscheduleTable();
    }
    
    /**
     * Delete Job from Schedular Database
     * @param String job name
     * @return int value
     */
    public int deleteJob(String name){
        System.out.println("Client Request to delete job in robot Schedule.");
        if (this.findJob(name) == false) return -2;
        if(this.currentJob().equals(name))
        {   
                        
            return -1;
        }
            
        else  removeJob(name);
        return 0;
    }
    
    private void removeJob(String name){
        for (Job searchName: dataBase.getscheduleTable()){
            if (searchName.getName().equals(name)){
                dataBase.deleteQuery(searchName);
            }
        }        
    }
}
