import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class WorkerImpl extends UnicastRemoteObject implements Worker {
    protected WorkerImpl() throws RemoteException {
    }

    @Override
    public Object compute(Task t, Params p) {
        return t.compute(p);
    }

    @Override
    public boolean hasClassCode(String className) throws RemoteException {
        try {
            Class.forName(className);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public void storeClassCode(String className, byte[] t) throws RemoteException {
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(className + ".class");
            out.write(t);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
