package FRONTEND;

import BACKEND.SPECTACOL;
import FRONTEND.SPECTACOLE.PANEL_SPECTACOL;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PANEL_SPECTACOLE extends JScrollPane {
    private COLOR_HOLDER COLOR_HOLDER = new COLOR_HOLDER();
    private Color MAIN_COLOR = COLOR_HOLDER.getSECONDARY_COLOR();

    private ArrayList<PANEL_SPECTACOL> panelSpectacols = new ArrayList<>();
    private ArrayList<SPECTACOL> spectacole = new ArrayList<>();
    private JPanel panel = new JPanel();
    //?CONFIG
    private int HEIGHT ;
    private int WIDTH  ;
    private int MARGIN =30 ;

    private int SPECTACOL_HEIGHT = 210;
    private PANEL_DESC panelDesc = new PANEL_DESC(null);

    public PANEL_SPECTACOLE(int HEIGHT, int WIDTH ,PANEL_DESC panelDesc) {
        this.panelDesc = panelDesc;
        this.HEIGHT = HEIGHT;
        this.WIDTH = WIDTH;
        panel.setBackground(MAIN_COLOR);
        panel.setLayout(null);
        panel.setVisible(true);
        panel.setPreferredSize(new Dimension(WIDTH,HEIGHT));
        this.setViewportView(panel);
        this.setPreferredSize(new Dimension(WIDTH,HEIGHT));
        this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        this.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        this.setViewportBorder(BorderFactory.createEmptyBorder());
        this.setBorder(BorderFactory.createEmptyBorder());
        this.setOpaque(false);
        this.setVisible(true);
        this.setAutoscrolls(true);
        this.setWheelScrollingEnabled(true);
        getVerticalScrollBar().setUnitIncrement(80);

    }

    public void setHEIGHT(int HEIGHT) {
        this.HEIGHT = HEIGHT;
    }
    public void setWIDTH(int WIDTH) {
        this.WIDTH = WIDTH;
    }
    public void setSpectacole(ArrayList<SPECTACOL> spectacole) {
        this.spectacole = spectacole;
    }
    public void addSPECTACOLE() {
        int currentY = MARGIN;
        int verticalGap = 20;

        panelSpectacols.clear();
        panel.removeAll();

        for (int i = 0; i < spectacole.size(); i++) {
            PANEL_SPECTACOL panelSpectacol = new PANEL_SPECTACOL(spectacole.get(i),panelDesc);
            panelSpectacol.setBounds(MARGIN, currentY, WIDTH - (MARGIN * 2)-10,SPECTACOL_HEIGHT);
            panel.add(panelSpectacol);
            panelSpectacols.add(panelSpectacol);

            currentY += SPECTACOL_HEIGHT+ verticalGap;
        }

        panel.setPreferredSize(new Dimension(WIDTH, currentY + MARGIN));

        panel.revalidate();
        panel.repaint();
        this.revalidate();
        this.repaint();
    }
}
