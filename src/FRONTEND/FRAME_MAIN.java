package FRONTEND;

import javax.swing.*;
import java.awt.*;

public class FRAME_MAIN extends JFrame {
    //?CONFIG
    private COLOR_HOLDER COLOR_HOLDER = new COLOR_HOLDER();
    private Color MAIN_COLOR = COLOR_HOLDER.getMAIN_COLOR();
    private int HEIGHT = 800;
    private int WIDTH = 1600;


    public FRAME_MAIN() {
        this.setSize(WIDTH, HEIGHT);
        this.setTitle("Agentie De Spectacole");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(MAIN_COLOR);
    }
}
