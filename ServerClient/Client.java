package Server;

import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets; 
import java.rmi.*;
import java.util.*;

import Models.DoctorModel;

public class Client {
    public static void main(String[] args)throws Exception
    {
        BufferedReader inFromUSer = new BufferedReader(new InputStreamReader(System.in));
        String sentance = "";
        while(!sentance.equals("bye"))
        {
            RemoteStub stub = (RemoteStub) Naming.lookup("rmi://localhost:5000/mcaiv");
            
            DoctorModel doctor = new DoctorModel();
            doctor = SetDoctor(doctor);
            stub.SetDoctor(doctor);
            System.out.println("Want to continue:");
            sentance = inFromUSer.readLine();
        }
    }
    public static DoctorModel SetDoctor(DoctorModel doctor)
    {
        try
        {
        BufferedReader inFromUSer = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter doctorname : ");
        doctor.setName(inFromUSer.readLine());
        System.out.println("Enter Speciality : ");
        doctor.setspeciality(inFromUSer.readLine());
        System.out.println("Enter Gender : ");
        doctor.setgender(inFromUSer.readLine());
        System.out.println("Enter Phoneno : ");
        doctor.setphoneno(inFromUSer.readLine());
        System.out.println("Enter Address : ");
        doctor.setaddress(inFromUSer.readLine());
        return doctor;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            return null;
        }
    }
}
