package EHRS.Models;

import java.io.*;

class PatientModel
{
	private int PatientId;
	private String Name;
	private String Gender;
	private String Address;
	private String Age;
	private String PhoneNumber;
	
	public void setPatientId(int PatientId)
	{
		this.PatientId = PatientId;
	}
	
	public int getPatientId()
	{
		return PatientId;
	}
	
	public void SetName(String name)
	{
		this.Name = name;
	}
	
	public String GetName()
	{
		return Name;
	}
	
	public void setGender(String Gender)
	{
		this.Gender = Gender;
	}
	
	public String getGender()
	{
		return Gender;
	}
	
	public void setAddress(String address)
	{
		this.Address = address;
	}
	
	public String getAddress()
	{
		return Address;
	}
	
	public void setAge(String Age)
	{
		this.Age = Age;
	}
	
	public String getAge()
	{
		return Age;
	}
	
	public void setPhoneNo(String PhoneNumber)
	{
		this.PhoneNumber = PhoneNumber;
	}
	
	public String getPhoneNo()
	{
		return PhoneNumber;
	}
	
	@Override
	public String toString()
	{
		return String.format("Patient data is :\n ID : %d\n Name : %s\n Gender : %s\n PhoneNo : %s Address : %s\n Age : %s",
				this.getPatientId(),this.GetName(),this.getGender(),this.getPhoneNo(),this.getAddress(),this.getAge());
	}	
	
	@Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        return (this.getPatientId() == ((PatientModel)obj).getPatientId());
    }
}