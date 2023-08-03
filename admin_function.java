import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Admin_function extends JPanel implements ActionListener {
    private Application app;

    public Admin_function(Application app) {
        this.app = app;
        setLayout(null);
        JLabel label=new JLabel("Admin Functions");
        label.setBounds(75,50,14400,40);
        label.setFont(new Font("serif",Font.PLAIN,50));
        label.setForeground(Color.BLACK);
        add(label);
        JLabel label_1=new JLabel("1 - Add Doctors");
        label_1.setBounds(60,150,14400,40);
        label_1.setFont(new Font("serif",Font.PLAIN,30));
        label_1.setForeground(Color.BLACK);
        add(label_1);
        JLabel label_2=new JLabel("2 - View Doctors");
        label_2.setBounds(60,230,14400,40);
        label_2.setFont(new Font("serif",Font.PLAIN,30));
        label_2.setForeground(Color.BLACK);
        add(label_2);
        JLabel label_3=new JLabel("3 - Update Doctors");
        label_3.setBounds(60,310,14400,40);
        label_3.setFont(new Font("serif",Font.PLAIN,30));
        label_3.setForeground(Color.BLACK);
        add(label_3);
        JLabel label_4=new JLabel("4 - Delete Doctors");
        label_4.setBounds(60,390,14400,40);
        label_4.setFont(new Font("serif",Font.PLAIN,30));
        label_4.setForeground(Color.BLACK);
        add(label_4);

        ImageIcon im1=new ImageIcon(ClassLoader.getSystemResource("icons/admin.png"));
        Image im2=im1.getImage().getScaledInstance(700,450,Image.SCALE_DEFAULT);
        ImageIcon im3=new ImageIcon(im2);

        JLabel image=new JLabel(im3);
        image.setBounds(480,50,700,450) ;
        add(image);

        JButton adminBtn =new JButton("CONTINUE");
        Font font=new Font("Ink free",Font.BOLD,14);
        adminBtn.setFont(font);
        adminBtn.setBounds(430,530,250,50);
        adminBtn.setForeground(Color.BLACK);
        adminBtn.addActionListener(this);
        add(adminBtn);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("CONTINUE")) {
            app.switchPanel("admin-dashboard");
        }
    }
}

