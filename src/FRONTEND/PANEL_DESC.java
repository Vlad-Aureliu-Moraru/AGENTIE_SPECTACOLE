package FRONTEND;

import BACKEND.REPREZENTATIE;

import javax.swing.*;
import java.awt.*;

public class PANEL_DESC extends JPanel {
    private COLOR_HOLDER COLOR_HOLDER = new COLOR_HOLDER();
    private Color MAIN_COLOR = COLOR_HOLDER.getSECONDARY_COLOR();
    private JLabel desc= new JLabel("DESCRIERE");
    private JLabel Oras = new JLabel("ORAS");
    private JLabel Tel= new JLabel("Tel");
    private JLabel Email= new JLabel("Email");
    private JLabel Locuri= new JLabel("Locuri");
    private JLabel Pret= new JLabel("Pret");
    private JLabel Adresa= new JLabel("Adresa");
    private JLabel Ora= new JLabel("Ora");


    public PANEL_DESC() {
        this.setBackground(MAIN_COLOR);
        this.setLayout(null);

        Oras.setBounds(40, 60, 150, 20);
        Oras.setFont(new Font("Arial",Font.BOLD,20));

        Adresa.setBounds(260, 60, 150, 20);
        Adresa.setFont(new Font("Arial",Font.BOLD,20));

        Tel.setBounds(40, 100, 150, 20);
        Tel.setFont(new Font("Arial",Font.BOLD,20));

        Email.setBounds(260, 100, 150, 20);
        Email.setFont(new Font("Arial",Font.BOLD,20));

        Locuri.setBounds(40, 140, 150, 20);
        Locuri.setFont(new Font("Arial",Font.BOLD,20));

        Pret.setBounds(260, 140, 150, 20);
        Pret.setFont(new Font("Arial",Font.BOLD,20));

        Ora.setBounds(40, 180, 150, 20);
        Ora.setFont(new Font("Arial",Font.BOLD,20));

        desc.setBounds(250, 20, 400,20);
        desc.setForeground(COLOR_HOLDER.getACCENT_COLOR());
        desc.setFont(new Font("Arial",Font.BOLD,20));
        this.add(desc);
        this.add(Ora);
        this.add(Oras);
        this.add(Email);
        this.add(Adresa);
        this.add(Locuri);
        this.add(Tel);
        this.add(Pret);
    }
    public void setDesc(REPREZENTATIE reprezentatie) {
        this.Oras.setText(reprezentatie.getOras());
        this.Adresa.setText(reprezentatie.getAdresa());
        this.Ora.setText(reprezentatie.getOra());
        this.Email.setText(reprezentatie.getEmail());
        this.Locuri.setText(reprezentatie.getLocuri()+"");
        this.Pret.setText(reprezentatie.getPretPeLoc()+"");
        this.Tel.setText(reprezentatie.getTelefon());
        this.repaint();
        this.revalidate();

    }
}
