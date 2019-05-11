import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class MySerwer {
    public static void main(String[] args) {
        if(args.length <= 1){
            System.out.println(" You have to enter RMI object address in the form: //host_address/service_name //host_address/service_name");
            return;
        }
        if(System.getSecurityManager() == null){
            System.setSecurityManager(new SecurityManager());
        }

        try {
            Registry reg = LocateRegistry.createRegistry(1099);
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        try {
            WorkerImpl worker1 = new WorkerImpl();
            java.rmi.Naming.rebind(args[0], worker1);

            WorkerImpl worker2 = new WorkerImpl();
            java.rmi.Naming.rebind(args[1], worker2);

            System.out.println("Server is registered now");
            System.out.println("Press Ctrl + C to stop...");
        } catch (Exception e) {
            System.out.println("SERVER CCAN'T BE REGISTERED!");
            e.printStackTrace();
            return;
        }



//

    }
}
