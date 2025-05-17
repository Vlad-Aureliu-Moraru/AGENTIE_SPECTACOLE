package FRONTEND;

import DATABASE.DB_SPECTACOL;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FRAME_MAIN extends JFrame {
    //?CONFIG
    private COLOR_HOLDER COLOR_HOLDER = new COLOR_HOLDER();
    private Color MAIN_COLOR = COLOR_HOLDER.getMAIN_COLOR();
    private int HEIGHT = 800;
    private int WIDTH = 1500;
    private int MARGIN = 20;
    private static int coordY = 70;
    private static int HCoef = 80;
    private PANEL_TOTAL panelTotal = new PANEL_TOTAL();
    private PANEL_DESC panelDesc = new PANEL_DESC(panelTotal);
    private PANEL_SPECTACOLE panelSpectacole = new PANEL_SPECTACOLE(HEIGHT-210,WIDTH/2+100,panelDesc);
    private NAV_BAR navBar = new NAV_BAR();
    private DB_SPECTACOL dbSpectacol = new DB_SPECTACOL();
    private boolean pressed =false;
    private boolean playing = false;

    public FRAME_MAIN() {
        panelTotal.setFrameMain(this);
        navBar.setFrameMain(this,panelTotal);
        this.setSize(WIDTH+20, HEIGHT+25);
        this.setTitle("Agentie De Spectacole");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(MAIN_COLOR);
        this.setLayout(null);
        this.setResizable(false);

        //?ADDONS
        panelSpectacole.setBounds(MARGIN,70,WIDTH/2+100,HEIGHT-80);
        panelSpectacole.setSpectacole(dbSpectacol.getSpectacole());
        panelSpectacole.addSPECTACOLE();
        this.add(panelSpectacole);

        panelDesc.setBounds(WIDTH/2+130,10,WIDTH/2-140,HEIGHT-363);
        this.add(panelDesc);

        panelTotal.setBounds(WIDTH/2+130,HEIGHT-340,WIDTH/2-140,HEIGHT-470);
        this.add(panelTotal);

        navBar.setBounds(MARGIN,MARGIN-10,WIDTH/2+100,50);
        this.add(navBar);

        updateAll();
    }
    public void switchAnimation(){
        int HEIGHT= this.HEIGHT;
        int coordY2 = 10;
        int steps = 100;

        if (playing){
            return;
        }
        Timer timer = new Timer(5,new ActionListener() {
            int step = 0;
            public void actionPerformed(ActionEvent e) {
                if (step<=steps){
                    panelSpectacole.setBounds(MARGIN,FRAME_MAIN.this.coordY,WIDTH/2+100,HEIGHT-FRAME_MAIN.this.HCoef);
                    navBar.setBounds(MARGIN,coordY2,WIDTH/2+100,FRAME_MAIN.this.coordY-20);
                    if (pressed){
                        step++;
                        FRAME_MAIN.this.coordY+=5;
                        FRAME_MAIN.this.HCoef+=5;
                    }else{
                        step++;
                        FRAME_MAIN.this.coordY-=5;
                        FRAME_MAIN.this.HCoef-=5;
                    }
                    panelSpectacole.repaint();
                    navBar.repaint();
                    panelSpectacole.revalidate();
                    navBar.revalidate();
                }else {
                    ((Timer)e.getSource()).stop();
                    playing = false;
                }
            }
        });
        pressed = !pressed;
        timer.start();
        playing = true;
    }
    private void updateAll(){
        panelSpectacole.repaint();
        panelDesc.repaint();
        panelTotal.repaint();
        navBar.repaint();
        this.repaint();
        this.revalidate();
        panelDesc.revalidate();
        panelTotal.revalidate();
        navBar.revalidate();
    }
}
