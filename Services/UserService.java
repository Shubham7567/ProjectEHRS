package Services;

import Models.PatientModel;
import Models.DoctorModel;

import java.io.*;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
public class UserService
{
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

            // append code of adding this record Patientdata registration
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
            System.out.println("Hello12");
            System.out.println("name is :" + name);
            if(name != null && name != "")
            {
                System.out.println("inside if :" + name);
                return false;
            }
            //name ="dsh"
            PatientModel patient = null;
            AddRecord(patient, model);
            // append code of adding this record Patientdata registration
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
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
            
            if(xPath.compile(expression).evaluate(xmlDocument) == null)
            {
                id = Integer.parseInt(xPath.compile(expression).evaluate(xmlDocument));
                // call GetPatientProfile
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
                // call GetDoctorProfile(id)
            }
        }
        catch(Exception ex)
        {
            return 0;
        }
        return id;
    }

    // this function get patients details from xml file and set value in class and that class display data
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
       
    }

    // this function get patients details from xml file and set value in class and that class display data
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
        
    }

    public void AddRecord(PatientModel patient, DoctorModel doctor){
        
        String fileName = "";
        System.out.println("in AddRecord");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        if(patient!=null ){
            fileName = "PatientData.xml"; 
        }
        else
        {
            fileName = "DoctorData.xml";
        }

        try{
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fileName);
            System.out.println(doc.getFirstChild());
            // add element to document
            Element rootElement = doc.getDocumentElement();
           
            if(fileName.equals("./PatientData.xml"))
            {
                rootElement.appendChild(getPatient(doc, patient.getPatientId(),patient.GetName(),patient.getGender(),patient.getAddress(),patient.getAge(),patient.getPhoneNo()));
            }
            else
            {
                rootElement.appendChild(getDoctor(doc,doctor.getdoctorid(),doctor.getName(),doctor.getspeciality(),doctor.getgender(),doctor.getphoneno(),doctor.getaddress()));
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            DOMSource source = new DOMSource(doc);

            //write to console or file
            StreamResult console = new StreamResult(System.out);
            StreamResult file = new StreamResult(new File(fileName));

            transformer.transform(source, console);
            transformer.transform(source,file);


        }catch(Exception e){
            e.printStackTrace();
        }

        
    }
    
    private static Node getDoctor(Document doc,int doctorid, String name,String speciality,String gender, String phoneno,String address){
        Element Doctor = doc.createElement("Doctor");

        // set id attribute
        Doctor.setAttribute("DoctorId", "" + doctorid);

        //create age element
        Doctor.appendChild(getElement(doc, Doctor, "Name", name));

        //create role element
        Doctor.appendChild(getElement(doc, Doctor, "Speciality", speciality));

        //create gender element
        Doctor.appendChild(getElement(doc, Doctor, "Gender", gender));

        //create gender element
        Doctor.appendChild(getElement(doc, Doctor, "PhoneNo", phoneno));

        //create gender element
        Doctor.appendChild(getElement(doc, Doctor, "Address", address));

        return Doctor;
    }

    private static Node getPatient(Document doc,int patientid, String name,String gender,String address, int age, String phoneno){
        Element Patient = doc.createElement("Patient");

        // set id attribute
        Patient.setAttribute("PatientId", "" + patientid);

        //create age element
        Patient.appendChild(getElement(doc, Patient, "Name", name));


        //create gender element
        Patient.appendChild(getElement(doc, Patient, "Gender", gender));

        
        //create gender element
        Patient.appendChild(getElement(doc, Patient, "Address", address));
        
        //create gender element
        Patient.appendChild(getElement(doc, Patient, "Age", ""+age));


        //create gender element
        Patient.appendChild(getElement(doc, Patient, "PhoneNo", phoneno));

        return Patient;
    }
   
    //utility method to  create text node
    private static Node getElement(Document doc,Element element,String name,String value){
        Element node = doc.createElement(name);
        node.appendChild(doc.createTextNode(value));
        return node;
    }
    // 2 baki
}
