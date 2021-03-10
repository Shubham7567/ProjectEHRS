package Server;

import java.rmi.*;
import java.rmi.server.*;

public class EHRServer {
    public static void main(String[] args)
    {
        try{
        RemoteStub stub = new EHRRemote();
        Naming.rebind("rmi://localhost:5000/mcaiv", stub);
        }
        catch(Exception ex)
        {
            System.err.println(ex);
        }
    }
}
