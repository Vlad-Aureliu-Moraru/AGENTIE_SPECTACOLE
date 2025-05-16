package FRONTEND.SPECTACOLE;

import FRONTEND.COLOR_HOLDER;

import javax.swing.*;
import java.awt.*;

public class PANEL_SPECTACOL extends JPanel {
    private COLOR_HOLDER COLOR_HOLDER = new COLOR_HOLDER();

    private JLabel numeSpectacol= new JLabel("NUME");
    private JTextArea descSpectacol= new JTextArea("DESCRIERE");
    private JTextArea rep= new JTextArea("REP");

    private COLOR_HOLDER COLOR_HOLDER2 = new COLOR_HOLDER();
    private Color TextCOLOR = COLOR_HOLDER2.getMAIN_COLOR();

    private Color MAIN_COLOR = COLOR_HOLDER.getACCENT_COLOR();
    public PANEL_SPECTACOL() {
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


        rep.setBounds(400,40,200,150);
        rep.setForeground(TextCOLOR);
        rep.setLineWrap(true);
        rep.setWrapStyleWord(true);
        rep.setEditable(false);
        rep.setOpaque(false);

        this.add(numeSpectacol);
        this.add(rep);
        this.add(descSpectacol);
    }
    public void setNumeSpectacol(String numeSpectacol) {
        this.numeSpectacol.setText("Spectacol :"+numeSpectacol);
    }
    public void setRep(String rep){this.rep.setText("REP :"+rep);}
    public void setDescSpectacol(String descSpectacol) {
        this.descSpectacol.setText("Descriere :"+descSpectacol);
    }
}
