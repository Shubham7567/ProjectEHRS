//
package Models;

import java.io.*;

public class AppointmentModel{
    private int doctor_id;
    private int patient_id;
    private int appointment_id;
    private String appointment_time;
    private String appointment_date ;
	private String status;
    
    public void setdoctor_id(int doctor_id){
        this.doctor_id = doctor_id;
    }
    public int getdoctor_id(){
        return doctor_id;
    } 

    public void setpatient_id(int patient_id){
        this.patient_id = patient_id;
    }
    public int getpatient_id(){
        return patient_id;
    } 
    
    public void setappointment_id(int appointment_id){
        this.appointment_id = appointment_id;
    }
    public int getappointment_id(){
        return appointment_id;
    } 

    public void setappointment_time(String appointment_time){
        this.appointment_time = appointment_time;
    }
    public String getappointment_time(){
        return appointment_time;
    } 
    
    public void setappointment_date(String appointment_date){
        this.appointment_date = appointment_date;
    }
    public String getappointment_date(){
        return appointment_date;
    } 
    
    public void setstatus(String status){
        this.status = status;
    }
    public String getstatus(){
        return status;
    } 
    
    
    
        @Override
    public String toString() {
        return this.getdoctor_id()+","+this.getpatient_id()+","+this.getappointment_id() + "," + this.getappointment_time() + ":" + this.getappointment_date() + ":" + this.getstatus();
    }
}
