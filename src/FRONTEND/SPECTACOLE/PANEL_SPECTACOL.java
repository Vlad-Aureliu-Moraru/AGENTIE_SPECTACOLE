package FRONTEND.SPECTACOLE;

import BACKEND.SPECTACOL;
import FRONTEND.COLOR_HOLDER;
import FRONTEND.PANEL_DESC;

import javax.swing.*;
import java.awt.*;

public class PANEL_SPECTACOL extends JPanel {
    private COLOR_HOLDER COLOR_HOLDER = new COLOR_HOLDER();

    private JLabel numeSpectacol= new JLabel("NUME");
    private JLabel REPREZENTATII= new JLabel("REPREZENTATII :");
    private JTextArea descSpectacol= new JTextArea("DESCRIERE");

    private COLOR_HOLDER COLOR_HOLDER2 = new COLOR_HOLDER();
    private Color TextCOLOR = COLOR_HOLDER2.getMAIN_COLOR();

    private Color MAIN_COLOR = COLOR_HOLDER.getACCENT_COLOR();
    private SPECTACOL spectacol = new SPECTACOL();
    private PANEL_REPREZENTATII panelReprezentatii;
    private PANEL_DESC panelDesc = new PANEL_DESC();

    public PANEL_SPECTACOL(SPECTACOL spectacol, PANEL_DESC panelDesc) {
        this.spectacol = spectacol;
        this.panelDesc = panelDesc;
        setNumeSpectacol(spectacol.getNUME());
        setDescSpectacol(spectacol.getDESC());
        panelReprezentatii = new PANEL_REPREZENTATII(spectacol.getREPRESENTATII(),panelDesc);


        this.setLayout(null);
        this.setBackground(MAIN_COLOR);
        this.setVisible(true);
        numeSpectacol.setBounds(10,10,500,20);
        numeSpectacol.setFont(new Font("Arial",Font.BOLD,20));
        numeSpectacol.setForeground(TextCOLOR);

        descSpectacol.setBounds(10,40,350,150);
        descSpectacol.setFont(new Font("Arial",Font.PLAIN,12));
        descSpectacol.setForeground(TextCOLOR);
        descSpectacol.setLineWrap(true);
        descSpectacol.setWrapStyleWord(true);
        descSpectacol.setEditable(false);
        descSpectacol.setOpaque(false);

        REPREZENTATII.setBounds(430,10,350,20);
        REPREZENTATII.setFont(new Font("Arial",Font.BOLD,20));
        REPREZENTATII.setForeground(TextCOLOR);
        panelReprezentatii.setBounds(400,40,350,150);

        this.add(numeSpectacol);
        this.add(descSpectacol);
        this.add(panelReprezentatii);
        this.add(REPREZENTATII);
    }
    public void setNumeSpectacol(String numeSpectacol) {
        this.numeSpectacol.setText("Spectacol :"+numeSpectacol);
    }
    public void setDescSpectacol(String descSpectacol) {
        this.descSpectacol.setText("Descriere :"+descSpectacol);
    }
    public PANEL_REPREZENTATII getPanelReprezentatii() {
        return panelReprezentatii;
    }
}

