package backend;
import java.io.IOException;
import java.util.List;
public interface DoctorManager {
    List<Doctor> findDoctors();
    void UpdateDoctor(Doctor doctor) throws DoctorNotFoundException, IOException;
    void DeleteDoctor(long id);
    List<Doctor> getDoctorsByName(String searchName);
    void CreateDoctor(String first_name,
                      String last_name,
                      String address_field,
                      String user_phone_num,
                      String user_email,
                      String user_experienced,
                      String user_salary,
                      String user_cnic,
                      String specialization,
                      String user_education) throws IOException;
}
