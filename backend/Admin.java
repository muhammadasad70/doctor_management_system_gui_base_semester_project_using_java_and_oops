package backend;
import java.io.Serializable;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
public class Admin implements DoctorManager,Authenticator,Serializable {
    private String user_name;
    private String password;
    static List<Doctor> arrayList;

    private String filename;
    public Admin(String file) {
        filename = file;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public Boolean Authenticate(String username, String password){
        return username.equals("muhammad") && password.equals("12345");
    }
    public void CreateDoctor(String first_name,
                             String last_name,
                             String address_field,
                          String user_phone_num, String user_email,String user_experienced,
                          String user_salary, String user_cnic, String specialization,String user_education) throws IOException {;
        Doctor doc = new Doctor(first_name,last_name,address_field,user_phone_num,user_email,
                user_experienced,user_salary,user_cnic,specialization,user_education,0);
        List<Doctor> doctors = readData();
        doctors.add(doc);
        writeData(doctors);
    }

    public void DeleteDoctor(long id){
        List<Doctor> doctors = readData();
        for (int i = 0; i<doctors.size(); i++){
            if (doctors.get(i).getID() == id){
                doctors.remove(i);
                break;
            }
        }

        writeData(doctors);
    }



    public void UpdateDoctor(Doctor doctor) throws DoctorNotFoundException, IOException {
        Doctor doc = getDoctorByID(doctor.getID());
        if (doc==null){
            throw new DoctorNotFoundException("Doctor not found for ID: " + doctor.getID());
        }

        List<Doctor> doctors = readData();
        for (int i = 0; i<doctors.size(); i++){
            if (doctors.get(i).getID() == doc.getID()){
                doctors.set(i, doctor);
            }
        }
        writeData(doctors);
    }
    private Doctor getDoctorByID(long ID) {
        List<Doctor> doctors = readData();
        for (int i=0; i< doctors.size(); i++){
            Doctor doc = doctors.get(i);
            if (doc.getID() == ID){
                return doc;
            }
        }
        return null;
    }


    public List<Doctor> findDoctors(){
        List<Doctor> list = readData();
        return  list;
    }
    public void writeData(List<Doctor> doctors) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(filename);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(doctors);
            System.out.println("Data written successfully.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error occurred while writing data: " + e.getMessage());
        }
    }
    private List<Doctor> readData() {
        List<Doctor> doctors = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(filename);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            doctors = (List<Doctor>) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return doctors;
    }
    public List<Doctor> getDoctorsByName(String searchName) {
        List<Doctor> foundDoctors = new ArrayList<>();
        List<Doctor> doctors = readData();
        for (int i=0; i< doctors.size(); i++){
            Doctor doc = doctors.get(i);
            if ((doc.getFirst_name()+doc.getLast_name()).contains(searchName)){
                foundDoctors.add(doc);
            }
        }

        return foundDoctors;
    }


}



