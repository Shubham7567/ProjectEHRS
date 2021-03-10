package Server;

import java.rmi.*;
import java.rmi.server.*;

public class EHRRemote extends UnicastRemoteObject implements RemoteStub
{
    public EHRRemote() throws RemoteException
    {
        super();
    }
    public void test(String message)
    {
        System.out.println("Message from remote: " + message);
    }
}
