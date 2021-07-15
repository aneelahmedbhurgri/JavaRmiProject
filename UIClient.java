 import java.rmi.Naming;
import java.util.Iterator;
import java.util.ArrayList;

/**
 * Sample GUI class for client
 *
 * @author Aneel ahmed
 * @version 2.0
 */
public class UIClient 
{
    
    public static ISchedular server;
    
    public static void main(String [] args) throws Exception {
        System.out.println("*****APP UI*****");
        server = (ISchedular) Naming.lookup("rmi://127.0.0.1/schedular");
        server.loadJobs("Clean room", "Cleaning");
        server.loadJobs("clean kitchen", "Cleaning");
        server.loadJobs("Generate Map", "Map creation");
        displayJobs();
        startrobotJob("Clean room");
        showCurrentJob();
        deleteJob("clean kitchen");
        System.out.println("--New Jobs List after Deleting--");
        displayJobs();
    }
    
    public static void showCurrentJob()throws Exception{
        System.out.println("--Showing the Current Job on Robot--");
        if (server == null) server = (ISchedular) Naming.lookup("rmi://127.0.0.1/schedular");
        System.out.println(server.currentJob());        
    }
    
    private static void displayJobs()throws Exception{
        System.out.println("--Loading Scheduled Jobs from Robot--");
        if (server == null) server = (ISchedular) Naming.lookup("rmi://127.0.0.1/schedular");
        IRemoteObject remoteData = server.scheduledJobs();
        Schedular appSchedular = new Schedular(remoteData);
        if(appSchedular.allJobs() == null) System.out.println("Robot System Does not have any Job on its Scheduled Database");
        
        else {for (Object jobs: appSchedular.allJobs()) System.out.println(jobs); }
    }
    
    public static void startrobotJob(String jobname)throws Exception{
        System.out.println("--Starting a new Job on Robot --");
        if (server == null) server = (ISchedular) Naming.lookup("rmi://127.0.0.1/schedular");
        if(server.startJob(jobname) == -1){
            System.out.println("Robot is busy doing some other Job.");
        }
        else if(server.startJob(jobname) == -2) System.out.println("Could not Start Given Job on robot, because Not Found in Scheduled Database");
        else System.out.println("Job have been Started by Robot");
    
    }
    
    public static void addJob(String jobName, String jobType)throws Exception{
        System.out.println("--Adding a new Job on Robot Scheduler--");
        if (server == null) server = (ISchedular) Naming.lookup("rmi://127.0.0.1/schedular");
        System.out.println("Adding New Job to Robot Schedular");
        server.loadJobs(jobName, jobType);
        
    }
    
    public static void deleteJob(String jobname)throws Exception{
        System.out.println("-- Deleting a Job on Robot --");
        if (server == null) server = (ISchedular) Naming.lookup("rmi://127.0.0.1/schedular");
        int result = server.deleteJob(jobname);
        if(result == -1){
            System.out.println("Robot is doing this same Job can not delete it right now");
        }
        else if(result == -2) System.out.println("Could not delete Given Job on robot, because Not Found in Scheduled Database");
        else System.out.println("Job Have been Deleted. please refresh Schedular to see list of validated jobs on robot schedular.");
        
    }
    
}