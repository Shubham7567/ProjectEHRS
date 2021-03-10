package Server;

import java.rmi.*;
import java.util.*;

public class EHRClient {
    public static void main(String[] args)
    {
        try{
            Scanner sc = new Scanner(System.in);
            RemoteStub stub = (RemoteStub) Naming.lookup("rmi://localhost:5000/mcaiv");
            
            String message = sc.next();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
}
