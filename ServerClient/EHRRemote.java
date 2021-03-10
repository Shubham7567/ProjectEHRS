package Server;

import java.rmi.*;
import java.rmi.server.*;
import Models.*;
import Services.UserService;

public class EHRRemote extends UnicastRemoteObject implements RemoteStub
{
    UserService service = new UserService();
    public EHRRemote() throws RemoteException
    {
        super();
    }
    
    public boolean SetDoctor(DoctorModel model)
    {
        return service.RegisterDoctor(model);
    }
}
