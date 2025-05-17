package FRONTEND.SPECTACOLE;

import BACKEND.REPREZENTATIE;
import BACKEND.REZERVARE;
import BACKEND.SPECTACOL;
import FRONTEND.COLOR_HOLDER;
import FRONTEND.PANEL_TOTAL;

import javax.swing.*;
import java.awt.*;

public class PANEL_INPUT extends JPanel {
    private COLOR_HOLDER color = new COLOR_HOLDER();
    private REPREZENTATIE rep = new REPREZENTATIE();
    private JLabel label = new JLabel("SELECTEAZA LOCURILE DESPARTITE PRIN \",\"");
    private JTextField input = new JTextField();
    private JButton ok = new JButton("SUBMIT");
    private JLabel error = new JLabel();
    private PANEL_TOTAL panelTotal = new PANEL_TOTAL();
    private SPECTACOL spectacol = new SPECTACOL();
    private PANEL_LOCURI panelLocuri;

    public PANEL_INPUT( PANEL_TOTAL panel , PANEL_LOCURI panelLocuri) {
        panelTotal= panel;
        this.panelLocuri = panelLocuri;
        setLayout(null);
        label.setBounds(0, 0, 300, 30);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setForeground(color.getACCENT2_COLOR());

        input.setBounds(0, 30, 300, 40);
        input.setFont(new Font("Arial",Font.BOLD,20));
        input.setForeground(color.getACCENT2_COLOR());
        input.setOpaque(false);

        ok.setBounds(0, 80, 100, 40);
        ok.setBackground(color.getACCENT2_COLOR());
        ok.setForeground(color.getMAIN_COLOR());
        ok.setFocusPainted(false);
        error.setBounds(0, 120, 260, 40);
        error.setForeground(color.getINACTIVE_COLOR());
        error.setFont(new Font("Arial",Font.BOLD,12));

        add(ok);
        add(input);
        add(label);
        add(error);

        addActionToOk();
        this.setBackground(color.getSECONDARY_COLOR());

    }
    private void addActionToOk(){
        String regEx = "([0-9]*[0-9]*,)*[0-9][0-9]*";
        ok.addActionListener(e -> {
            if(!input.getText().matches(regEx)){
                input.setText("");
                error.setText("EROARE ATI SCRIS GRESIT");
                this.repaint();
                this.revalidate();
                return;
            }else{
                error.setText("");
                this.repaint();
                this.revalidate();
            }
            REZERVARE rezervare = new REZERVARE();
            rezervare.setREPREZENTATIE(rep);
            rezervare.setSpectacol(spectacol);
            System.out.println(spectacol.getNUME());
            String[] input = this.input.getText().split(",");
            boolean foundError = false;
            for (String s : input) {
                int loc = Integer.parseInt(s);
                if (rep.getLocuriArray()[loc-1] == 0) {
                    error.setText("SUCCES");
                    error.setForeground(color.getACTIVE_COLOR());
                    this.repaint();
                    this.revalidate();

                }else{
                    this.input.setText("");
                    error.setForeground(color.getINACTIVE_COLOR());
                    error.setText("EROARE UNUL DIN LOCURI E OCUPAT");
                    this.repaint();
                    this.revalidate();
                    foundError = true;
                }
            }
            if (!foundError) {
                for (String s : input) {
                    int loc = Integer.parseInt(s);
                    rezervare.addLoc(loc);
                    rep.getLocuriArray()[loc-1] = 1;
                    panelLocuri.addLocuri();
                    this.input.setText("");
                }
                panelTotal.addRezervare(rezervare);
            }else{
                this.input.setText("");
                error.setForeground(color.getINACTIVE_COLOR());
                error.setText("EROARE UNUL DIN LOCURI E OCUPAT");
                this.repaint();
                this.revalidate();

            }
        });
    }
    public void setSpectacol(SPECTACOL spectacol) {
        this.spectacol = spectacol;
    }
    public void setRep(REPREZENTATIE rep) {
        this.rep = rep;
    }
}
