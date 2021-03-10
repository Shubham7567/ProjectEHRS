package Server;

import java.net.*;
import java.nio.charset.StandardCharsets; 
import java.rmi.*;
import java.rmi.server.*;
import Models.PatientModel;
import Models.DoctorModel;
import Services.*;

public class Server {
    public static void main(String[] args)
    {
        try
        {
            RemoteStub stub = new EHRRemote();
            Naming.rebind("rmi://localhost:5000/mcaiv", stub);
            String sentance="";
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
}
