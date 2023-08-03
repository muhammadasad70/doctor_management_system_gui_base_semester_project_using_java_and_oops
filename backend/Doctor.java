package backend;
import javax.swing.*;
import java.io.Serializable;

public class Doctor extends JFrame implements Serializable {
    private String first_name,last_name,address_field,user_phone_num,user_email,user_experienced,user_salary,user_cnic,specialization,user_education;
    private Long ID;
    public Doctor(String first_name, String last_name, String address_field, String user_phone_num, String user_email, String user_experienced, String user_salary, String user_cnic, String specialization, String user_education, long ID ) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.address_field = address_field;
        this.user_phone_num = user_phone_num;
        this.user_email = user_email;
        this.user_experienced = user_experienced;
        this.user_salary = user_salary;
        this.user_cnic = user_cnic;
        this.specialization = specialization;
        this.user_education = user_education;
        if (ID == 0){
            this.ID = System.currentTimeMillis();
        }else {
            this.ID = ID;
        }
    }
    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getAddress_field() {
        return address_field;
    }

    public void setAddress_field(String address_field) {
        this.address_field = address_field;
    }

    public String getUser_phone_num() {
        return user_phone_num;
    }

    public void setUser_phone_num(String user_phone_num) {
        this.user_phone_num = user_phone_num;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_experienced() {
        return user_experienced;
    }

    public void setUser_experienced(String user_experienced) {
        this.user_experienced = user_experienced;
    }

    public String getUser_salary() {
        return user_salary;
    }

    public void setUser_salary(String user_salary) {
        this.user_salary = user_salary;
    }

    public String getUser_cnic() {
        return user_cnic;
    }

    public void setUser_cnic(String user_cnic) {
        this.user_cnic = user_cnic;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getUser_education() {
        return user_education;
    }

    public void setUser_education(String user_education) {
        this.user_education = user_education;
    }

    public long getID(){return ID;};
    @Override
    public String toString() {
        return "Doctor{" +
                "first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", address_field='" + address_field + '\'' +
                ", user_phone_num='" + user_phone_num + '\'' +
                ", user_email='" + user_email + '\'' +
                ", user_experienced='" + user_experienced + '\'' +
                ", user_salary='" + user_salary + '\'' +
                ", user_cnic='" + user_cnic + '\'' +
                ", specialization='" + specialization + '\'' +
                ", user_education='" + user_education + '\'' +
                ", id='" + ID + '\'' +
                '}';
    }
}
