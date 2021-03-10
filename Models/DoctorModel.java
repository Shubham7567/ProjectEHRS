package EHRS.Models;

import java.io.*;
import java.util.jar.Attributes.Name;

class DoctorModel{
    private int doctorid;
    private String Name;
    private String speciality;
    private String gender;
    private String phoneno;
    private String address;
    private int Age;

    public void setdoctorid(int doctorid){
        this.doctorid = doctorid;
    }
    public int getdoctorid(){
        return doctorid;
    } 

    public void setName(String name){
        this.Name = name;
    }
    public String getName(){
        return this.Name;
    }

    public void setspeciality(String speciality){
        this.speciality = speciality;
    }
    public String getspeciality(){
        return speciality;
    } 
    
    public void setgender(String gender){
        this.gender = gender;
    }
    public String getgender(){
        return gender;
    } 
    
    public void setphoneno(String phoneno){
        this.phoneno = phoneno;
    }
    public String getphoneno(){
        return phoneno;
    } 
    
    
    public void setaddress(String address){
        this.address = address;
    }
    public String getaddress(){
        return address;
    } 
    
    
    public void setAge(int age){
        this.Age = age;
    }
    public int getAge(){
        return this.Age;
    } 
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        return (this.getdoctorid() == ((DoctorModel)obj).getdoctorid());
    }

    @Override
    public String toString() {
        return String.format("Patient Data:\n Id : %d\n Name : %s\n Speciality : %s\n Gender : %s\n PhoneNo : %s\n Address : %s\n Age : %d",
                this.getdoctorid(),this.getName(),this.getspeciality(),this.getgender(),this.getphoneno(),this.getaddress(),this.getAge());
    }

}
