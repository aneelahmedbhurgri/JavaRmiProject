import java.rmi.RemoteException;
import java.util.ArrayList;
import java.rmi.Remote;
/**
 * Interface for Remote Object to be sent to Client, contains the List of scheduled jobs on Robot
 *
 * @author Aneel Ahmed
 * @version 2.0
 */
public interface IRemoteObject extends Remote
{
    /**
     * for scheduled jobs on robot
     * @param  None 
     * @return   ArrayList of Jobs
     */
    public ArrayList<Job> robotScheduledList()throws RemoteException;
}
