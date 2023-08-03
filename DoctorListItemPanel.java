import backend.Admin;
import backend.Doctor;
import backend.DoctorManager;

import java.awt.*;
import javax.swing.*;

public class DoctorListItemPanel extends JPanel {
    private Application app;

    private Doctor doctor;
    private DoctorManager manager;
    private JLabel firstNameLabel;
    private JLabel lastNameLabel;
    private JLabel specializationLabel;
    private JButton viewButton, deleteButton, updateButton;

    public DoctorListItemPanel(Application app, Doctor doctor, DoctorManager manager) {
        this.app = app;
        this.doctor = doctor;
        this.manager = manager;
        firstNameLabel = new JLabel(doctor.getFirst_name());
        lastNameLabel = new JLabel(doctor.getLast_name());
        specializationLabel = new JLabel(doctor.getSpecialization());
        viewButton = new JButton("View");
        updateButton = new JButton("Update");
        deleteButton = new JButton("Delete");

        deleteButton.addActionListener(e -> {

            manager.DeleteDoctor(doctor.getID());
            app.adminDashboard.UpdateView();
            app.switchPanel("admin-dashboard");
        });

        updateButton.addActionListener(e -> {

            app.getAddDoctorPanel().prepareForUpdate(doctor);
            app.switchPanel("add-doctor");
        });

        viewButton.addActionListener(e -> {

            app.getAddDoctorPanel().prepareForView(doctor);
            app.switchPanel("add-doctor");
        });

        setLayout(new GridLayout(1, 4));
        setPreferredSize(new Dimension(400, 30));

        add(firstNameLabel);
        add(lastNameLabel);
        add(specializationLabel);
        JPanel btns = new JPanel();
        btns.setLayout(new FlowLayout(FlowLayout.LEFT));
        btns.add(viewButton);
        btns.add(updateButton);
        btns.add(deleteButton);
        add(btns);
    }
}
