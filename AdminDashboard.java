import backend.Admin;
import backend.Doctor;
import backend.DoctorManager;

import javax.print.Doc;
import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Optional;
import javax.swing.border.EmptyBorder;

class AdminDashboard extends JPanel implements ActionListener {
    private Application app;
    private DoctorManager manager;
    private JPanel listPanel;

    private JScrollPane scrollPane;
    JTextField searchTerm;
    public AdminDashboard(Application app, DoctorManager manager){
        this.app = app;
        this.manager = manager;
        List<Doctor> doctors = manager.findDoctors();
        int rows = 0;
        if (doctors!=null){
            rows = doctors.size();
        }
        listPanel = new JPanel(new GridLayout(rows, 4));
        initializeUI(doctors);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Add Doctor")){
            app.getAddDoctorPanel().prepareForCreate();
            app.switchPanel("add-doctor");
        } else if (e.getActionCommand().equals("Back")){
            app.switchPanel("welcome");
        }else if (e.getActionCommand().equals("search")){
            String s  = searchTerm.getText();
            this.searchedDoctor(manager.getDoctorsByName(s));
        }
    }

    private void initializeUI(List<Doctor> doctors) {
        setLayout(new BorderLayout());

        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(Color.lightGray);

        JLabel label = new JLabel("                                           ---------------Admin Dashboard-----------------");
        label.setFont(new Font("serif", Font.BOLD, 25));
        label.setForeground(Color.BLACK);
        header.add(label, BorderLayout.CENTER);

        JButton button = new JButton("Add Doctor");
        button.setFont(new Font("Ink free", Font.BOLD, 20));
        button.setBackground(Color.BLACK);
        button.addActionListener(this);
        header.add(button, BorderLayout.EAST);
        JButton button1 = new JButton("Back");
        button1.setFont(new Font("Ink free", Font.BOLD, 20));
        button1.setBackground(Color.BLACK);
        button1.addActionListener(this);
        header.add(button1, BorderLayout.WEST);


        JButton search = new JButton("search");
        search.setFont(new Font("Ink free", Font.BOLD, 20));
        search.setBackground(Color.BLACK);
        search.addActionListener(this);
        header.add(search, BorderLayout.PAGE_START);

        searchTerm = new JTextField();
        header.add(searchTerm);
        button1.setFont(new Font("Ink free", Font.BOLD, 20));
        button1.setBackground(Color.BLACK);
        button1.addActionListener(this);
        header.add(button1, BorderLayout.WEST);


        String[] headers = {"First Name", "Last Name", "Specialization", "Actions"};
        JPanel listHeader = new ListHeader(headers);
        loadList(doctors);
        scrollPane = new JScrollPane(listPanel);

// Create a panel to hold the header and list header
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.add(header, BorderLayout.NORTH);
        headerPanel.add(listHeader, BorderLayout.SOUTH);

// Add the header panel and scroll pane to the DoctorListPanel
        add(headerPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

    }

    void loadList(List<Doctor> doctors) {
        // Create list items for each doctor
        if (doctors!=null && doctors.size() != 0){
            for (Doctor doctor : doctors) {
                DoctorListItemPanel itemPanel = new DoctorListItemPanel(this.app,doctor, this.manager);
                listPanel.add(itemPanel);
            }
        }
    }


    public void UpdateView() {
        List<Doctor> doctors = manager.findDoctors();
        this.listPanel.removeAll();
        listPanel.setLayout(new GridLayout(doctors.size(), 4));
        loadList(doctors);
        scrollPane.repaint();
        // Refresh the layout
        listPanel.revalidate();
        listPanel.repaint();
    }


    public void searchedDoctor(List<Doctor> doctors) {
        System.out.println("aya");
        this.listPanel.removeAll();
        listPanel.setLayout(new GridLayout(doctors.size(), 4));
        loadList(doctors);
        scrollPane.repaint();
        // Refresh the layout
        listPanel.revalidate();
        listPanel.repaint();
    }

}
