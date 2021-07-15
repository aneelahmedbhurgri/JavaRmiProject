import java.rmi.Naming;
import java.rmi.server.RemoteServer;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Robot Server to start server
 *
 * @author Aneel Ahmed
 * @version 2.0
 */
public class robotServer
{
    public static void startRegistry() throws Exception
    {
        LocateRegistry.createRegistry( Registry.REGISTRY_PORT );
        RemoteServer.setLog( System.err );
    }

    public static void main(String [] args) throws Exception {
        RobotSchedular server = new RobotSchedular();
        Naming.rebind("schedular", server);
    }
}
