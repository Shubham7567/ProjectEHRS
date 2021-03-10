package Service;

import Models.PatientModel;
import Models.DoctorModel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.lang.model.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;git
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class UserService implements IUserService {

    public Boolean RegisterPatient(PatientModel model)
    {
        try
        {
            FileInputStream file = new FileInputStream(new File("./PatientData.xml"));
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document xmlDocument = builder.parse(file);
            XPath xPath = XPathFactory.newInstance().newXPath();
            String expression = "/Patients/Patient[@PhoneNo='" + model.getPhoneNo() + "']/Name";
            String name = xPath.compile(expression).evaluate(xmlDocument);
            if(name != null)
            {
                return false;
            }
            var element = xmlDocument.createElement("Employee");

        }
        catch(Exception ex)
        {
            return false;
        }
        return true;
    }

    public Boolean RegisterDoctor(DoctorModel model)
    {
        try
        {
            FileInputStream file = new FileInputStream(new File("./DoctorData.xml"));
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document xmlDocument = builder.parse(file);
            XPath xPath = XPathFactory.newInstance().newXPath();
            String expression = "/Doctors/Doctor[@PhoneNo='" + model.getphoneno()+ "']/Name";
            String name = xPath.compile(expression).evaluate(xmlDocument);
            if(name != null)
            {
                return false;
            }
            
        }
        catch(Exception ex)
        {
            return false;
        }
        return true;
    }

    public int LoginUser(String name, String phoneNo)
    {
        int id=0;
        try
        {
            FileInputStream file = new FileInputStream(new File("./PatientData.xml"));
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document xmlDocument = builder.parse(file);
            XPath xPath = XPathFactory.newInstance().newXPath();
            String expression = "/Patients/Patient[@PhoneNo='" + phoneNo+ "' && @Name='" + name +"']/PatientId";
            
            if(xPath.compile(expression).evaluate(xmlDocument) != null)
            {
                id = Integer.parseInt(xPath.compile(expression).evaluate(xmlDocument));
            }
            else{
                file = new FileInputStream(new File("./DoctorData.xml"));
                xmlDocument = builder.parse(file);
                xPath = XPathFactory.newInstance().newXPath();
                expression = "/Doctors/Doctor[@PhoneNo='" + phoneNo+ "' && @Name='" + name +"']/DoctorId";
                if(xPath.compile(expression).evaluate(xmlDocument) == null)
                {
                    return 0;
                }
                id = Integer.parseInt(xPath.compile(expression).evaluate(xmlDocument));
            }
        }
        catch(Exception ex)
        {
            return 0;
        }
        return id;
    }

    public PatientModel GetPatientProfile(int patientId)
    {
        try{
            PatientModel patient = new PatientModel();
            FileInputStream file = new FileInputStream(new File("./PatientData.xml"));
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document xmlDocument = builder.parse(file);
            XPath xPath = XPathFactory.newInstance().newXPath();
            patient.setPatientId(patientId);
            String expression = "/Patients/Patient[@PatientId='" + patient.getPatientId() + "']/Name";
            patient.SetName(xPath.compile(expression).evaluate(xmlDocument));
            expression = "/Patients/Patient[@PatientId='" + patient.getPatientId() + "']/Gender";
            patient.setGender(xPath.compile(expression).evaluate(xmlDocument));
            expression = "/Patients/Patient[@PatientId='" + patient.getPatientId() + "']/Address";
            patient.setAddress(xPath.compile(expression).evaluate(xmlDocument));
            expression = "/Patients/Patient[@PatientId='" + patient.getPatientId() + "']/PhoneNo";
            patient.setPhoneNo(xPath.compile(expression).evaluate(xmlDocument));
            expression = "/Patients/Patient[@PatientId='" + patient.getPatientId() + "']/Age";
            patient.setAge(Integer.parseInt(xPath.compile(expression).evaluate(xmlDocument)));
            return patient;
        }
        catch(Exception ex)
        {
            return null;
        }
        return null;
    }

    public DoctorModel GetDoctorProfile(int doctorId)
    {
        try{
            DoctorModel doctor = new DoctorModel();
            FileInputStream file = new FileInputStream(new File("./DoctorData.xml"));
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document xmlDocument = builder.parse(file);
            XPath xPath = XPathFactory.newInstance().newXPath();
            doctor.setdoctorid(doctorId);
            String expression = "/Doctors/Doctor[@PatientId='" + doctor.getdoctorid() + "']/Name";
            doctor.setName(xPath.compile(expression).evaluate(xmlDocument));
            expression = "/Doctors/Doctor[@PatientId='" + doctor.getdoctorid() + "']/Gender";
            doctor.setgender(xPath.compile(expression).evaluate(xmlDocument));
            expression = "/Doctors/Doctor[@PatientId='" + doctor.getdoctorid() + "']/Address";
            doctor.setaddress(xPath.compile(expression).evaluate(xmlDocument));
            expression = "/Doctors/Doctor[@PatientId='" + doctor.getdoctorid() + "']/PhoneNo";
            doctor.setphoneno(xPath.compile(expression).evaluate(xmlDocument));
            expression = "/Doctors/Doctor[@PatientId='" + doctor.getdoctorid() + "']/Age";
            doctor.setAge(Integer.parseInt(xPath.compile(expression).evaluate(xmlDocument)));
            return doctor;
        }
        catch(Exception ex)
        {
            return null;
        }
        return null;
    }
    
}
