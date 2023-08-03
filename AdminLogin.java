import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import backend.Authenticator;


class AdminLogin extends JPanel implements ActionListener  {

    private Application app;
    JTextField userName;
    JPasswordField userPassword;
    Authenticator auth;


    public AdminLogin(Application app, Authenticator authenticator){
        this.app = app;
        this.auth  = authenticator;
        setLayout(null);

        setSize(700, 400);
        setLocation(350, 250);

        JLabel label = new JLabel("ADMIN LOGIN");
        label.setBounds(180, 60, 14000, 40);
        label.setFont(new Font("serif", Font.PLAIN, 50));
        label.setForeground(Color.BLACK);
        add(label);

        JLabel label_1 = new JLabel("User Name");
        Font font_1 = new Font("Ink free", Font.BOLD, 14);
        label_1.setFont(font_1);
        label_1.setBounds(50, 200, 100, 35);
        add(label_1);

        userName = new JTextField();
        userName.setBounds(150, 200, 200, 35);
        add(userName);

        JLabel label_2 = new JLabel("Password");
        Font font_2 = new Font("Ink free", Font.BOLD, 14);
        label_2.setFont(font_2);
        label_2.setBounds(50, 280, 100, 35);
        add(label_2);

        userPassword = new JPasswordField();
        userPassword.setBounds(150, 280, 200, 35);
        add(userPassword);
        ImageIcon im = new ImageIcon(ClassLoader.getSystemResource("icons/adminlogo2.png"));
        Image im11 = im.getImage().getScaledInstance(200, 170, Image.SCALE_DEFAULT);
        ImageIcon im22 = new ImageIcon(im11);
        JLabel image1 = new JLabel(im22);
        image1.setBounds(190, 345, 200, 160);
        add(image1);
        JButton button = new JButton("Login");
        Font font_login = new Font("Ink free", Font.BOLD, 14);
        button.setFont(font_login);
        button.setBounds(150, 520, 160, 50);
        button.setBackground(Color.BLACK);
        button.addActionListener(this);
        add(button);

        JButton create = new JButton("Back");
        Font font_create = new Font("Ink free", Font.BOLD, 14);
        create.setFont(font_create);
        create.setBounds(330, 520, 170, 50);
        create.setBackground(Color.BLACK);
        create.addActionListener(this);
        add(create);

        ImageIcon im1 = new ImageIcon(ClassLoader.getSystemResource("icons/admin_logo_2.jpeg"));
        Image im2 = im1.getImage().getScaledInstance(550, 450, Image.SCALE_DEFAULT);
        ImageIcon im3 = new ImageIcon(im2);
        JLabel image = new JLabel(im3);
        image.setBounds(500, 10, 700, 600);
        add(image);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Login")) {
            String username = userName.getText();
            String password =  userPassword.getText();
            if (this.auth.Authenticate(username,password)) {
                setVisible(false);
                app.switchPanel("admin_function");
            }else {
                JOptionPane.showMessageDialog(new JFrame(), "Wrong Input");
                setVisible(false);
                app.switchPanel("adminLogin");
//                setVisible(false);
            }
        } else if (e.getActionCommand().equals("Back")) {
            setVisible(false);
            app.switchPanel("welcome");
        }
    }
}

