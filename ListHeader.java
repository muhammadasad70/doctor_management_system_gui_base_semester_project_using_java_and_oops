import backend.Doctor;

import javax.swing.*;
import java.awt.*;

public class ListHeader extends JPanel {

    private String[] columns;
    public ListHeader(String[] columns) {
        setLayout(new GridLayout(1, columns.length));
        setPreferredSize(new Dimension(400, 30));

        for(String column: columns){
            add(new JLabel(column));
        }
    }
}
