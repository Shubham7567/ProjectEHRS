package Service;

import Models.PatientModel;
import Models.DoctorModel;

public interface IUserService {
    Boolean RegisterPatient(PatientModel model);
    Boolean RegisterDoctor(DoctorModel model);
    int LoginUser(String name, String phoneNo);
    PatientModel GetPatientProfile(int patientId);
    DoctorModel GetDoctorProfile(int doctorId);
}
