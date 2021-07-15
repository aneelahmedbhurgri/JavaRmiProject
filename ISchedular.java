import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Iterator;
import java.util.ArrayList;

/**
 * Write a description of interface ITree here.
 *
 * @author Wolfgang Renz, HAW Hamburg 
 * @version June 2019
 */
interface ISchedular extends Remote{
    public void loadJobs(String jobName, String jobType) throws RemoteException;
    public String currentJob() throws RemoteException;
    public int startJob(String jobName) throws RemoteException;
    public IRemoteObject scheduledJobs() throws RemoteException;
    public int deleteJob(String jobname) throws RemoteException;
}
