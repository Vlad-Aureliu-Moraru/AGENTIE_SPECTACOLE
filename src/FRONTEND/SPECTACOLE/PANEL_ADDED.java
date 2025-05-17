package FRONTEND.SPECTACOLE;

import BACKEND.REZERVARE;
import FRONTEND.COLOR_HOLDER;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PANEL_ADDED extends JScrollPane {
    private JPanel panel = new JPanel();
    private ArrayList<REZERVARE> rezervari = new ArrayList<>();
    private COLOR_HOLDER color = new COLOR_HOLDER();
    public PANEL_ADDED(ArrayList<REZERVARE> rezervari) {
        this.rezervari = rezervari;
        this.setViewportView(panel);
        panel.setLayout(null);
        panel.setBackground(color.getACCENT_COLOR());
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        this.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        this.setViewportBorder(BorderFactory.createEmptyBorder());
        this.setBorder(BorderFactory.createEmptyBorder());
        this.setOpaque(false);
        this.setVisible(true);
        this.setAutoscrolls(true);
        this.setWheelScrollingEnabled(true);
        getVerticalScrollBar().setUnitIncrement(16);
    }
    public void addRezervari(){
        panel.removeAll();
        for (REZERVARE rez: rezervari) {
            JLabel lable = new JLabel(rez+"");
            lable.setForeground(color.getMAIN_COLOR());
            lable.setFont(new Font("Arial", Font.PLAIN,16));
            panel.add(lable);
        }
    }
    public void stergeRezervari(){
        panel.removeAll();
        rezervari.clear();
    }
}
