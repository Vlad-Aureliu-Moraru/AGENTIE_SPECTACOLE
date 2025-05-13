package FRONTEND;

import DATABASE.DB_CLIENT;
import DATABASE.DB_SPECTACOL;

import javax.swing.*;
import java.awt.*;

public class FRAME_MAIN extends JFrame {
    //?CONFIG
    private COLOR_HOLDER COLOR_HOLDER = new COLOR_HOLDER();
    private Color MAIN_COLOR = COLOR_HOLDER.getMAIN_COLOR();
    private int HEIGHT = 800;
    private int WIDTH = 1500;
    private int MARGIN = 20;

    private PANEL_SPECTACOLE panelSpectacole = new PANEL_SPECTACOLE();
    private PANEL_DESC panelDesc = new PANEL_DESC();
    private PANEL_TOTAL panelTotal = new PANEL_TOTAL();
    private NAV_BAR navBar = new NAV_BAR();
    private DB_SPECTACOL dbSpectacol = new DB_SPECTACOL();
    private DB_CLIENT dbClient = new DB_CLIENT();

    public FRAME_MAIN() {
        this.setSize(WIDTH+20, HEIGHT+20);
        this.setTitle("Agentie De Spectacole");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(MAIN_COLOR);
        this.setLayout(null);
        this.setResizable(false);

        //?ADDONS
        panelSpectacole.setBounds(MARGIN,200,WIDTH/2+100,HEIGHT-210);
        this.add(panelSpectacole);

        panelDesc.setBounds(WIDTH/2+130,10,WIDTH/2-140,HEIGHT-363);
        this.add(panelDesc);

        panelTotal.setBounds(WIDTH/2+130,HEIGHT-340,WIDTH/2-140,HEIGHT-470);
        this.add(panelTotal);

        navBar.setBounds(MARGIN,MARGIN-10,WIDTH/2+100,180);
        this.add(navBar);

    }
}
