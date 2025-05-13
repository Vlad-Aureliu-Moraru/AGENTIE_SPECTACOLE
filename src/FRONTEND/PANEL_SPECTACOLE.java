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
    private int MARGIN =20 ;

    public PANEL_SPECTACOLE(int HEIGHT, int WIDTH  ) {
        this.HEIGHT = HEIGHT;
        this.WIDTH = WIDTH;
        panel.setBackground(MAIN_COLOR);
        panel.setLayout(null);
        panel.setVisible(true);
        panel.setPreferredSize(new Dimension(WIDTH,HEIGHT));
        this.setViewportView(panel);
        this.setPreferredSize(new Dimension(WIDTH,HEIGHT));

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
        int panelHeight = 200; // Assuming a fixed height for each PANEL_SPECTACOL
        int verticalGap = 20;

        panelSpectacols.clear();
        panel.removeAll();

        for (int i = 0; i < spectacole.size(); i++) {
            PANEL_SPECTACOL panelSpectacol = new PANEL_SPECTACOL();
            panelSpectacol.setNumeSpectacol(spectacole.get(i).getNUME());
            panelSpectacol.setDescSpectacol(spectacole.get(i).getDESC());

            panelSpectacol.setBounds(MARGIN, currentY, WIDTH - (MARGIN * 2)-10, panelHeight);
            panel.add(panelSpectacol);
            panelSpectacols.add(panelSpectacol);

            currentY += panelHeight + verticalGap;
        }

        panel.setPreferredSize(new Dimension(WIDTH, currentY + MARGIN));

        panel.revalidate();
        panel.repaint();
        this.revalidate();
        this.repaint();
    }
}
