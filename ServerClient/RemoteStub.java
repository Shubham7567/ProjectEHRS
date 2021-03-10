package Server;

import java.rmi.*;
import Models.*;
import Services.*;

public interface RemoteStub extends Remote
{
    public boolean SetDoctor(DoctorModel model) throws RemoteException;
}