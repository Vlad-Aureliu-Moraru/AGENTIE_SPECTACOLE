package FRONTEND;

import BACKEND.REPREZENTATIE;
import BACKEND.SPECTACOL;
import FRONTEND.SPECTACOLE.PANEL_INPUT;
import FRONTEND.SPECTACOLE.PANEL_LOCURI;

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
    private JLabel Data= new JLabel("Data");

    private SPECTACOL spectacol = new SPECTACOL();


    int X = 10;
    int X2 = 270;
    int Y = 60;

    private PANEL_LOCURI panelLocuri = new PANEL_LOCURI();
    private PANEL_INPUT panelInput;
    private PANEL_TOTAL panelTotal;
    public PANEL_DESC(PANEL_TOTAL panelTotal) {
        this.panelTotal = panelTotal;
        this.setBackground(MAIN_COLOR);
        this.setLayout(null);
        setLables();

        panelInput = new PANEL_INPUT(panelTotal,panelLocuri);
    }
    public void setDesc(REPREZENTATIE reprezentatie,SPECTACOL spectacol) {
        this.Oras.setText("" +reprezentatie.getOras());
        this.Adresa.setText(""+reprezentatie.getAdresa());
        this.Ora.setText("Ora: "+reprezentatie.getOra());
        this.Email.setText("Email: "+reprezentatie.getEmail());
        this.Locuri.setText("Locuri: "+reprezentatie.getLocuri()+"");
        this.Pret.setText("Pret: "+reprezentatie.getPretPeLoc()+" RON");
        this.Tel.setText("Tel: "+reprezentatie.getTelefon());
        this.Data.setText("Data: "+reprezentatie.getData());
        panelLocuri.setBounds(X,Y+50,200,200);
        panelLocuri.setRep(reprezentatie);
        panelLocuri.addLocuri();
        panelInput.setSpectacol(spectacol);
        panelInput.setRep(reprezentatie);
        panelInput.setBounds(X2,Y+50,320,200);

        this.add(panelLocuri);
        this.add(panelInput);
        this.repaint();
        this.revalidate();

    }
    private void setLables(){
        Oras.setBounds(X+10, Y, 250, 20);
        Oras.setFont(new Font("Arial",Font.BOLD,20));
        Oras.setForeground(COLOR_HOLDER.getACCENT2_COLOR());

        Adresa.setBounds(X2, Y, 350, 20);
        Adresa.setFont(new Font("Arial",Font.BOLD,20));
        Adresa.setForeground(COLOR_HOLDER.getACCENT2_COLOR());
        X+=10;
        X2+=0;
        Y+=40;
        Tel.setBounds(X,Y, 250, 20);
        Tel.setFont(new Font("Arial",Font.BOLD,15));
        Tel.setForeground(COLOR_HOLDER.getACCENT2_COLOR());

        Email.setBounds(X2,Y, 350, 20);
        Email.setFont(new Font("Arial",Font.BOLD,15));
        Email.setForeground(COLOR_HOLDER.getACCENT2_COLOR());
        X+=0;
        X2+=0;
        Y+=40;
        Locuri.setBounds(X,Y, 150, 20);
        Locuri.setFont(new Font("Arial",Font.BOLD,16));
        Locuri.setForeground(COLOR_HOLDER.getACCENT2_COLOR());

        Pret.setBounds(X2,Y, 150,16);
        Pret.setFont(new Font("Arial",Font.BOLD,16));
        Pret.setForeground(COLOR_HOLDER.getACCENT2_COLOR());
        X+=0;
        X2+=0;
        Y+=40;
        Ora.setBounds(X,Y, 150, 20);
        Ora.setFont(new Font("Arial",Font.BOLD,16));
        Ora.setForeground(COLOR_HOLDER.getACCENT2_COLOR());

        Data.setBounds(X2,Y, 150, 20);
        Data.setFont(new Font("Arial",Font.BOLD,16));
        Data.setForeground(COLOR_HOLDER.getACCENT2_COLOR());


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
        this.add(Data);
    }


}
