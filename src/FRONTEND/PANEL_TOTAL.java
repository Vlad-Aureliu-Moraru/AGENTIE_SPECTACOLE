package FRONTEND;

import BACKEND.REZERVARE;
import FRONTEND.SPECTACOLE.PANEL_ADDED;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PANEL_TOTAL extends JPanel {
    private COLOR_HOLDER colorHolder = new COLOR_HOLDER();

    private Color MAIN_COLOR = colorHolder.getSECONDARY_COLOR();
    private JLabel mainLabel = new JLabel("Rezervari:");
    private JButton finalize = new JButton("FINALIZEAZA");
    private JButton  clear= new JButton("STERGE");

    private ArrayList<REZERVARE> rezervari = new ArrayList<>();
    private PANEL_ADDED panelAdded = new PANEL_ADDED(rezervari);
    private JLabel TotalCost = new JLabel("Total Cost:");
    private int totalCost = 0;

    private FRAME_MAIN frameMain;
    public PANEL_TOTAL() {
        this.setBackground(MAIN_COLOR);
        this.setLayout(null);
        mainLabel.setForeground(colorHolder.getACCENT_COLOR());
        mainLabel.setBounds(220, 10,300,30);
        mainLabel.setFont(new Font("Arial", Font.BOLD, 30));
        this.add(mainLabel);

        panelAdded.setForeground(colorHolder.getMAIN_COLOR());
        panelAdded.setBounds(10, 60,590, 170);

        finalize.setForeground(colorHolder.getMAIN_COLOR());
        finalize.setBackground(colorHolder.getACCENT2_COLOR());
        finalize.setFont(new Font("Arial", Font.BOLD, 20));
        finalize.setBounds(360, 240,240, 30);

        clear.setForeground(colorHolder.getMAIN_COLOR());
        clear.setBackground(colorHolder.getACCENT2_COLOR());
        clear.setFont(new Font("Arial", Font.BOLD, 20));
        clear.setBounds(360, 280,240, 30);

        TotalCost.setForeground(colorHolder.getACTIVE_COLOR());
        TotalCost.setFont(new Font("Arial", Font.BOLD, 20));
        TotalCost.setBounds(10, 260,240, 30);


        clear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clearRezervare();
            }
        });


        this.add(clear);
        this.add(finalize);
        this.add(panelAdded);
        this.add(TotalCost);
    }
    public void addRezervare(REZERVARE rezervare){
        rezervari.add(rezervare);
        panelAdded.addRezervari();
        TotalCost.setText("Total Cost: " + totalCost);
        System.out.println(rezervare.getLoc().size());
        totalCost = 0;
        for (REZERVARE rezerva : rezervari) {
            totalCost+=rezerva.getREPREZENTATIE().getPretPeLoc() * rezerva.getLoc().size();
            System.out.println(rezervare.getREPREZENTATIE().getPretPeLoc());
        }
        TotalCost.setText("Total Cost: " + totalCost);
    }
    public void setFrameMain(FRAME_MAIN frameMain) {
        this.frameMain = frameMain;
        finalize.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frameMain.switchAnimation();
            }
        });
    }
    public ArrayList<REZERVARE> getRezervari() {
        return rezervari;
    }
    public int getTotalCost() {
        return totalCost;
    }
    public void clearRezervare() {
        panelAdded.stergeRezervari();
        panelAdded.repaint();
        panelAdded.revalidate();
        totalCost = 0;
        TotalCost.setText("Total Cost: " + totalCost);
    }
}
