package admissionserver;

import Admission.AdmissionInterface;
import Admission.IAdmin;
import Admission.IAccount;
import Admission.IMajor;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.RemoteException;


public class AdmissionServer extends Thread
{
    public static void main(String[] args) throws RemoteException 
    {
        try 
        {
            Registry registry = LocateRegistry.createRegistry(1099);

            AdmissionInterface reg = new Registration();
            registry.rebind("Admission", reg);

            IAdmin admn = new Admin();
            registry.rebind("stu", admn);

            IAccount acn = new Account();
            registry.rebind("account", acn);

            IMajor mjr = new Major();
            registry.rebind("major", mjr);

            System.out.println("Object is registered.");
            System.out.println("Now server is waiting for client request...");
        } 
        catch (Exception e) 
        {
            System.out.println("FileServer: " + e);
        }
    }
    
}
