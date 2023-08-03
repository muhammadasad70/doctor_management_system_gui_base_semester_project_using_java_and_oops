import backend.Admin;
import backend.Doctor;
import backend.DoctorManager;
import backend.DoctorNotFoundException;

import javax.print.Doc;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

class AddDoctor extends JPanel implements ActionListener {
    Application app;
    JTextField first_name,last_name,address_field,user_phone_num,user_email,user_experienced,user_salary,user_cnic;
    JComboBox specialization,user_education;
    JButton button_add, button_back;

    DoctorManager manager;

    long doctorID;
    public AddDoctor(Application app, DoctorManager manager) {
        this.app = app;
        this.manager=manager;


        setLayout(null);
        JLabel heading=new JLabel("Doctors Details");
        heading.setBounds(260,20,500,50);
        heading.setFont(new Font("serif",Font.BOLD,20));
        heading.setForeground(Color.BLACK);
        add(heading);
        JLabel FName=new JLabel("First Name");
        FName.setBounds(35,100,150,30);
        FName.setFont(new Font("serif",Font.PLAIN,18));
        FName.setForeground(Color.BLACK);
        add(FName);
        first_name = new JTextField();
        first_name.setBounds(135, 100, 150, 30);
        add(first_name);
        JLabel LName=new JLabel("Last Name");
        LName.setBounds(350,100,150,30);
        LName.setFont(new Font("serif",Font.PLAIN,18));
        LName.setForeground(Color.BLACK);
        add(LName);
        last_name = new JTextField();
        last_name.setBounds(450, 100, 150, 30);
        add(last_name);
        JLabel address=new JLabel("Address");
        address.setBounds(28,170,150,30);
        address.setFont(new Font("serif",Font.PLAIN,18));
        address.setForeground(Color.BLACK);
        add(address);
        address_field = new JTextField();
        address_field.setBounds(135, 170, 150, 30);
        add(address_field);
        JLabel user_cnic_j=new JLabel("Cnic");
        user_cnic_j.setBounds(350,170,150,30);
        user_cnic_j.setFont(new Font("serif",Font.PLAIN,18));
        user_cnic_j.setForeground(Color.BLACK);
        add(user_cnic_j);
        user_cnic = new JTextField();
        user_cnic.setBounds(450, 170, 150, 30);
        add(user_cnic);
        JLabel user_name=new JLabel("Phone Number");
        user_name.setBounds(25,250,150,30);
        user_name.setFont(new Font("serif",Font.PLAIN,18));
        user_name.setForeground(Color.BLACK);
        add(user_name);
        user_phone_num = new JTextField();
        user_phone_num.setBounds(135, 250, 150, 30);
        add(user_phone_num);
        JLabel email=new JLabel("E Mail");
        email.setBounds(350,250,150,30);
        email.setFont(new Font("serif",Font.PLAIN,18));
        email.setForeground(Color.BLACK);
        add(email);
        user_email = new JTextField();
        user_email.setBounds(450, 250, 150, 30);
        add(user_email);
        JLabel Education=new JLabel("Education");
        Education.setBounds(25,320,150,30);
        Education.setFont(new Font("serif",Font.PLAIN,18));
        Education.setForeground(Color.BLACK);
        add(Education);
        String [] edu={"MBBS&FC","MBBS&FCPS","DND","DPT","D Pharm"};
        user_education = new JComboBox(edu);
        user_education.setBounds(135, 320, 150, 30);
        add(user_education);
        JLabel education=new JLabel("Specialization");
        education.setBounds(320,320,150,30);
        education.setFont(new Font("serif",Font.PLAIN,18));
        education.setForeground(Color.BLACK);
        add(education);
        String [] list={
                "Cardiologist","Dermatologist", "Gastroenterologist", "Neurologist", "Orthopedic Surgeon",
                "Pediatrician","Obstetrician/Gynecologist", "Ophthalmologist", "Psychiatrist", "Radiologist"};
        specialization= new JComboBox(list);
        specialization.setBounds(450, 320, 150, 30);
        add(specialization);

        JLabel Experienced=new JLabel("Experienced");
        Experienced.setBounds(25,390,150,30);
        Experienced.setFont(new Font("serif",Font.PLAIN,18));
        Experienced.setForeground(Color.BLACK);
        add(Experienced);
        user_experienced = new JTextField();
        user_experienced.setBounds(135, 390, 150, 30);
        add(user_experienced);
        JLabel salary=new JLabel("Salary");
        salary.setBounds(320,390,150,30);
        salary.setFont(new Font("serif",Font.PLAIN,18));
        salary.setForeground(Color.BLACK);
        add(salary);
        user_salary= new JTextField();
        user_salary.setBounds(450, 390, 150, 30);
        add(user_salary);
        button_add =new JButton("Add");
        Font font_add=new Font("Ink free",Font.BOLD,14);
        button_add.setFont(font_add);
        button_add.setBounds(160,500,180,40);
        button_add.setForeground(Color.BLACK);
        button_add.setBackground(Color.BLACK);
        button_add.addActionListener(this);
        add(button_add);
        button_back =new JButton("Back");
        Font font_back=new Font("Ink free",Font.BOLD,14);
        button_back.setFont(font_back);
        button_back.setBounds(360,500,180,40);
        button_back.setForeground(Color.BLACK);
        button_back.setBackground(Color.BLACK);
        button_back.addActionListener(this);
        add(button_back);
    }

    public void prepareForCreate(){
        first_name.setEnabled(true);
        last_name.setEnabled(true);
        address_field.setEnabled(true);
        user_cnic.setEnabled(true);
        user_phone_num.setEnabled(true);
        user_email.setEnabled(true);
        user_education.setEnabled(true);
        specialization.setEnabled(true);
        user_experienced.setEnabled(true);
        user_salary.setEnabled(true);
        button_add.setVisible(true);

        first_name.setText("");
        last_name.setText("");
        address_field.setText("");
        user_cnic.setText("");
        user_phone_num.setText("");
        user_email.setText("");
        user_education.addItem("");
        specialization.addItem("");
        user_experienced.setText("");
        user_salary.setText("");
        button_add.setText("Add");
        button_add.setVisible(true);
        revalidate();
        repaint();
    }

    public void prepareForUpdate(Doctor doctor){
        first_name.setEnabled(true);
        last_name.setEnabled(true);
        address_field.setEnabled(true);
        user_cnic.setEnabled(true);
        user_phone_num.setEnabled(true);
        user_email.setEnabled(true);
        user_education.setEnabled(true);
        specialization.setEnabled(true);
        user_experienced.setEnabled(true);
        user_salary.setEnabled(true);
        button_add.setVisible(true);

        first_name.setText(doctor.getFirst_name());
        last_name.setText(doctor.getLast_name());
        address_field.setText(doctor.getAddress_field());
        user_cnic.setText(doctor.getUser_cnic());
        user_phone_num.setText(doctor.getUser_phone_num());
        user_email.setText(doctor.getUser_email());
        user_education.addItem(doctor.getUser_education());

        specialization.addItem(doctor.getSpecialization());
        user_experienced.setText(doctor.getUser_experienced());
        user_salary.setText(doctor.getUser_salary());
        button_add.setText("Update");
        button_add.setVisible(true);
        revalidate();

        doctorID = doctor.getID();
        repaint();
    }

    public void prepareForView(Doctor doctor){
        first_name.setEnabled(false);
        last_name.setEnabled(false);
        address_field.setEnabled(false);
        user_email.setEnabled(false);
        user_phone_num.setEnabled(false);
        user_experienced.setEnabled(false);
        user_education.setEnabled(false);
        specialization.setEnabled(false);
        user_salary.setEnabled(false);
        user_cnic.setEnabled(false);
        button_add.setVisible(false);

        first_name.setText(doctor.getFirst_name());
        last_name.setText(doctor.getLast_name());
        address_field.setText(doctor.getAddress_field());
        user_email.setText(doctor.getUser_email());
        user_phone_num.setText(doctor.getUser_phone_num());
        user_experienced.setText(doctor.getUser_experienced());
        user_education.addItem(doctor.getUser_education());
        specialization.addItem(doctor.getSpecialization());
        user_salary.setText(doctor.getUser_salary());
        user_cnic.setText(doctor.getUser_cnic());
        doctorID = doctor.getID();
        revalidate();
        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Add")) {
            String f_name = first_name.getText();
            String l_name = last_name.getText();
            String address = address_field.getText();
            String e_mail = user_email.getText();
            String ph_num = user_phone_num.getText();
            String exp = user_experienced.getText();
            String edu = (String) user_education.getSelectedItem();
            String spec = (String) specialization.getSelectedItem();
            String salary = user_salary.getText();
            String cnic = user_cnic.getText();


            if (f_name.isEmpty() || l_name.isEmpty() || address.isEmpty() || e_mail.isEmpty()
                    || ph_num.isEmpty() || exp.isEmpty() || edu.isEmpty() || spec.isEmpty()
                    || salary.isEmpty() || cnic.isEmpty()) {
                JOptionPane.showMessageDialog(new JFrame(), "Please fill in all fields.");
                return;
            }

            String namePattern = "[a-zA-Z]+";
            String emailPattern = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";
            String phonePattern = "\\d+";
            String salaryPattern = "\\d+\\.?\\d*";
            String cnicPattern = "\\d{5}-\\d{7}-\\d";
            boolean isValidFName = f_name.matches(namePattern);
            boolean isValidLName = l_name.matches(namePattern);
            boolean isValidEmail = e_mail.matches(emailPattern);
            boolean isValidPhone = ph_num.matches(phonePattern);
            boolean isValidSalary = salary.matches(salaryPattern);
            boolean isValidCNIC = cnic.matches(cnicPattern);

            if (!isValidFName) {
                JOptionPane.showMessageDialog(new JFrame(), "Please enter a valid first name.");
                setVisible(false);
                app.switchPanel("add-doctor");
                return;
            }

            if (!isValidLName) {
                JOptionPane.showMessageDialog(new JFrame(), "Please enter a valid last name.");
                setVisible(false);
                app.switchPanel("add-doctor");
                return;
            }

            if (!isValidEmail) {
                JOptionPane.showMessageDialog(new JFrame(), "Please enter a valid email address.");
                setVisible(false);
                app.switchPanel("add-doctor");
                return;
            }

            if (!isValidPhone) {
                JOptionPane.showMessageDialog(new JFrame(), "Please enter a valid phone number.");
                setVisible(false);
                app.switchPanel("add-doctor");
                return;
            }

            if (!isValidSalary) {
                JOptionPane.showMessageDialog(new JFrame(), "Please enter a valid salary.");
                setVisible(false);
                app.switchPanel("add-doctor");
                return;
            }

            if (!isValidCNIC) {
                JOptionPane.showMessageDialog(new JFrame(), "Please enter a valid CNIC number.");
                setVisible(false);
                app.switchPanel("add-doctor");
                return;
            }

            if (address.length() < 5) {
                JOptionPane.showMessageDialog(new JFrame(), "Please enter a valid address.");
                setVisible(false);
                app.switchPanel("add-doctor");
                return;
            }

            try {
                manager.CreateDoctor(f_name, l_name, address,ph_num,e_mail,exp,salary,cnic,spec,edu);
                JOptionPane.showMessageDialog(new JFrame(), "Successfully Added");
                setVisible(false);
                app.adminDashboard.UpdateView();
                app.switchPanel("admin-dashboard");
            } catch (IOException ex) {
                app.switchPanel("add-doctor");
                ex.printStackTrace();
                throw new RuntimeException(ex);
            }
        } else if (e.getActionCommand().equals("Back")) {
            app.switchPanel("admin-dashboard");
        } else if (e.getActionCommand().equals("Update")) {
            Doctor doc = extractDoctor();
            try {
                manager.UpdateDoctor(doc);
                app.adminDashboard.UpdateView();
                app.switchPanel("admin-dashboard");
            } catch (DoctorNotFoundException ex) {
                app.switchPanel("add-doctor");
                ex.printStackTrace();
                throw new RuntimeException(ex);
            } catch (IOException ex) {
                app.switchPanel("add-doctor");
                ex.printStackTrace();
                throw new RuntimeException(ex);
            }
        }
    }




    private Doctor extractDoctor(){
        String f_name=first_name.getText();
        String l_name=last_name.getText();
        String address=address_field.getText();
        String e_mail=user_email.getText();
        String ph_num=user_phone_num.getText();
        String exp=user_experienced.getText();
        String edu=(String) user_education.getSelectedItem();
        String spec=(String)specialization.getSelectedItem();
        String salary=user_salary.getText();
        String cnic=user_cnic.getText();

        Doctor doctor = new Doctor(f_name, l_name, address,cnic,ph_num ,e_mail,edu,spec,exp,salary,doctorID);
        return doctor;

    }

}
