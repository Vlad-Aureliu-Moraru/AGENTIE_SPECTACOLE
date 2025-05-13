package FRONTEND.SPECTACOLE;

import FRONTEND.COLOR_HOLDER;

import javax.swing.*;
import java.awt.*;

public class PANEL_SPECTACOL extends JPanel {
    private COLOR_HOLDER COLOR_HOLDER = new COLOR_HOLDER();
    private JLabel numeSpectacol= new JLabel("NUME");
    private JTextArea descSpectacol= new JTextArea("DESCRIERE");
    private COLOR_HOLDER COLOR_HOLDER2 = new COLOR_HOLDER();
    private Color TextCOLOR = COLOR_HOLDER2.getMAIN_COLOR();

    private Color MAIN_COLOR = COLOR_HOLDER.getACCENT_COLOR();
    public PANEL_SPECTACOL() {
        this.setLayout(null);
        this.setBackground(MAIN_COLOR);
        this.setVisible(true);
        numeSpectacol.setBounds(10,10,500,20);
        numeSpectacol.setForeground(TextCOLOR);
        descSpectacol.setBounds(10,40,200,150);
        descSpectacol.setForeground(TextCOLOR);
        descSpectacol.setLineWrap(true);
        descSpectacol.setWrapStyleWord(true);
        descSpectacol.setEditable(false);
        descSpectacol.setOpaque(false);
        this.add(numeSpectacol);
        this.add(descSpectacol);
    }
    public void setNumeSpectacol(String numeSpectacol) {
        this.numeSpectacol.setText("Spectacol :"+numeSpectacol);
    }
    public void setDescSpectacol(String descSpectacol) {
        this.descSpectacol.setText("Descriere :"+descSpectacol);
    }
}
