package Server;

import java.rmi.*;

public interface RemoteStub extends Remote
{
    public void test(String message) throws RemoteException;
}