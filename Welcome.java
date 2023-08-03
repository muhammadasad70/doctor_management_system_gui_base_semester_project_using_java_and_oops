import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Welcome extends JPanel implements ActionListener {
    private Application app;

    public Welcome(Application app) {
        this.app = app;
        setLayout(null);

        JLabel label=new JLabel("DOCTOR MANAGEMENT SYSTEM");
        label.setBounds(95,60,14400,40);
        label.setFont(new Font("serif",Font.PLAIN,60));
        label.setForeground(Color.BLACK);
        add(label);

        ImageIcon im1=new ImageIcon(ClassLoader.getSystemResource("icons/acto.jpeg"));
        Image im2=im1.getImage().getScaledInstance(1180,700,Image.SCALE_DEFAULT);
        ImageIcon im3=new ImageIcon(im2);
        JLabel image=new JLabel(im3);
        image.setBounds(10,100,1180,500) ;
        add(image);

        JButton adminBtn =new JButton("CLICK HERE TO CONTINUE");
        Font font=new Font("Ink free",Font.BOLD,14);
        adminBtn.setFont(font);
        adminBtn.setBounds(470,440,250,50);
        adminBtn.setForeground(Color.BLACK);
        adminBtn.addActionListener(this);
        image.add(adminBtn);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("CLICK HERE TO CONTINUE")) {
            app.switchPanel("adminLogin");
            setVisible(false);
        }
    }
}
