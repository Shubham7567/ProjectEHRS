package EHRS.Server;

import java.net.*;
import java.nio.charset.StandardCharsets; 
import java.rmi.*;
import java.rmi.server.*;

public class Server {
    public static void main(String[] args)
    {
        try
        {
            System.setProperty("rmi.server.hostname", "192.168.1.1");
            DatagramSocket serveSocket = new DatagramSocket(9876);
            byte[] recieveData = new byte[1024];
            byte[] sendData = new byte[1024];
            RemoteStub stub = new EHRRemote();
            Naming.rebind("rmi://192.168.1.1:5000/mcaiv", stub);
            String sentance="";
            do
            {
                DatagramPacket recievePackate = new DatagramPacket(recieveData, recieveData.length);
                serveSocket.receive(recievePackate); 
                recieveData = new byte[1024];
                System.out.println("Data from Client : "+sentance);
                System.out.println("Data length from Client : "+sentance.length());
                InetAddress Address = recievePackate.getAddress();
                int port = recievePackate.getPort();
                String capitalizedSentance = sentance.toUpperCase();
                sendData = capitalizedSentance.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length,Address,port);
                serveSocket.send(sendPacket);
            }while(!sentance.equals("bye"));
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
}
