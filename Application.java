import backend.Admin;

import javax.swing.*;
import java.awt.*;

public class Application extends JFrame {
    public final String  doctorFile = "./doctors.ser";
    private CardLayout cardLayout;

    private Admin admin;
    public AdminDashboard adminDashboard;
    private JPanel cardPanel,welcomePanel,
            adminPanel,
            addDoctor, functionPanel;;


    public Application(){
        this.admin  = new Admin(doctorFile);
        setTitle("DMS");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200,650);
        setLocation(135,90);
        getContentPane().setBackground(Color.WHITE );



        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        setVisible(true);

        welcomePanel = new Welcome(this);
        cardPanel.add(welcomePanel, "welcome");
        functionPanel = new Admin_function(this);
        cardPanel.add(functionPanel, "admin_function");

        adminPanel = new AdminLogin(this, this.admin);
        cardPanel.add(adminPanel, "adminLogin");

        adminDashboard = new AdminDashboard(this, this.admin);
        cardPanel.add(adminDashboard, "admin-dashboard");

        addDoctor = new AddDoctor(this,admin);
        cardPanel.add(addDoctor, "add-doctor");

        add(cardPanel);
        cardLayout.show(cardPanel, "welcome");
    }


    public void switchPanel(String panelName) {
        cardLayout.show(cardPanel, panelName);
    }

    public AddDoctor getAddDoctorPanel(){
        return (AddDoctor) addDoctor;
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Application app = new Application();
                app.setVisible(true);
                app.setLocationRelativeTo(null);
            }
        });
    }

}

