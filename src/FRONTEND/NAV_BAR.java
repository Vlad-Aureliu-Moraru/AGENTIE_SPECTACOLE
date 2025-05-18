package FRONTEND;

import BACKEND.BON;
import BACKEND.CLIENT;
import BACKEND.REZERVARE;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class NAV_BAR extends JPanel {
    private COLOR_HOLDER COLOR_HOLDER = new COLOR_HOLDER();
    private Color MAIN_COLOR = COLOR_HOLDER.getACCENT_COLOR();
    private JLabel main_label = new JLabel("INTRODU DATELE:");
    private JLabel NumeClient = new JLabel("NUME:");
    private JTextField nume = new JTextField();
    private JLabel  PrenumeClient = new JLabel("PRENUME:");
    private JTextField prenume= new JTextField();
    private JLabel  TelefonClient= new JLabel("TELEFON:");
    private JTextField telefon = new JTextField();
    private JLabel  BaniClient= new JLabel("BANI:");
    private JTextField bani= new JTextField();
    private JLabel  ERROR = new JLabel("");

    private JButton close = new JButton("Close");
    private JButton done = new JButton("CREAZA BON");
    private FRAME_MAIN frameMain;
    private ArrayList<REZERVARE> rezervari = new ArrayList<>();

    private FRAME_BON frameBon;
    private String numeRegEX = "[A-Za-z]+";
    private String prenumeRegEx= "[A-Za-z]+";
    private String telRegEx= "[0-9]+";
    private String baniRegEx= "[0-9]+";
    public NAV_BAR() {
        this.setBackground(MAIN_COLOR);
        this.setLayout(null);

        main_label.setForeground(COLOR_HOLDER.getMAIN_COLOR());
        main_label.setFont(new Font("Arial", Font.BOLD, 20));
        main_label.setBounds(320, 70, 300, 30);
        this.add(main_label);

        NumeClient.setForeground(COLOR_HOLDER.getMAIN_COLOR());
        NumeClient.setFont(new Font("Arial", Font.BOLD, 20));
        NumeClient.setBounds(120, 140, 300, 30);
        this.add(NumeClient);

        nume.setForeground(COLOR_HOLDER.getMAIN_COLOR());
        nume.setFont(new Font("Arial", Font.BOLD, 20));
        nume.setBounds(320, 140, 300, 30);
        nume.setOpaque(false);
        this.add(nume);

        PrenumeClient.setForeground(COLOR_HOLDER.getMAIN_COLOR());
        PrenumeClient.setFont(new Font("Arial", Font.BOLD, 20));
        PrenumeClient.setBounds(120, 220, 300, 30);
        this.add(PrenumeClient);

        prenume.setForeground(COLOR_HOLDER.getMAIN_COLOR());
        prenume.setFont(new Font("Arial", Font.BOLD, 20));
        prenume.setBounds(320, 220, 300, 30);
        prenume.setOpaque(false);
        this.add(prenume);

        TelefonClient.setForeground(COLOR_HOLDER.getMAIN_COLOR());
        TelefonClient.setFont(new Font("Arial", Font.BOLD, 20));
        TelefonClient.setBounds(120, 300, 300, 30);
        this.add(TelefonClient);

        telefon.setForeground(COLOR_HOLDER.getMAIN_COLOR());
        telefon.setFont(new Font("Arial", Font.BOLD, 20));
        telefon.setBounds(320, 300, 300, 30);
        telefon.setOpaque(false);
        this.add(telefon);

        BaniClient.setForeground(COLOR_HOLDER.getMAIN_COLOR());
        BaniClient.setFont(new Font("Arial", Font.BOLD, 20));
        BaniClient.setBounds(120, 380, 300, 30);
        this.add(BaniClient);

        bani.setForeground(COLOR_HOLDER.getMAIN_COLOR());
        bani.setFont(new Font("Arial", Font.BOLD, 20));
        bani.setBounds(320, 380, 300, 30);
        bani.setOpaque(false);
        this.add(bani);

        done.setForeground(COLOR_HOLDER.getMAIN_COLOR());
        done.setBackground(COLOR_HOLDER.getACCENT2_COLOR());
        done.setFont(new Font("Arial", Font.BOLD, 20));
        done.setBounds(320, 470, 300, 30);
        this.add(done);

        close.setForeground(COLOR_HOLDER.getMAIN_COLOR());
        close.setBackground(COLOR_HOLDER.getACCENT2_COLOR());
        close.setFont(new Font("Arial", Font.BOLD, 20));
        close.setBounds(120, 470, 150, 30);
        this.add(close);

        ERROR.setForeground(COLOR_HOLDER.getINACTIVE_COLOR());
        ERROR.setFont(new Font("Arial", Font.BOLD, 17));
        ERROR.setBounds(320, 510, 400, 30);
        this.add(ERROR);
    }
    public void setFrameMain(FRAME_MAIN frameMain,PANEL_TOTAL panel) {
        this.frameMain = frameMain;
        rezervari = panel.getRezervari();
        close.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frameMain.switchAnimation();
                clearForm();
            }
        });
        done.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                rezervari = panel.getRezervari();
                if (nume.getText().length() > 0 && prenume.getText().length() > 0 && telefon.getText().length() > 0 && bani.getText().length() > 0) {
                   if (!nume.getText().matches(numeRegEX) || !prenume.getText().matches(prenumeRegEx) || !telefon.getText().matches(telRegEx) || !bani.getText().matches(baniRegEx)) {
                       System.out.println(nume.getText().trim().matches(numeRegEX));
                       System.out.println(nume.getText());
                       System.out.println(prenume.getText().matches(prenumeRegEx));
                       System.out.println(prenume.getText());
                       System.out.println(telefon.getText().matches(telRegEx));
                       System.out.println(telefon.getText());
                       System.out.println(bani.getText().matches(baniRegEx));
                       System.out.println(bani.getText());
                       setERROR("DATE INTRODUSE ERONAT");

                       return;
                   }
                    if (Integer.parseInt(bani.getText())<panel.getTotalCost()){
                        setERROR("ATI INTRODUS O SUMA PREA MICA");
                        return;
                    }

                }else {
                    setERROR("DATELE NU POT FI GOALE");
                    return;
                }
                CLIENT client = new CLIENT(nume.getText(),prenume.getText(),telefon.getText(),Integer.parseInt(bani.getText()));
                BON bon = new BON(client,rezervari,panel.getTotalCost(),Integer.parseInt(bani.getText()));
                if (rezervari.size() > 0 ) {
                    System.out.println("HAS");
                    System.out.println(rezervari);
                    frameBon = new FRAME_BON(bon);
                    setERROR("");
                    clearForm();
                    panel.clearRezervare();

                }else
                {
                    setERROR("NU ATI ALES NICI O REPREZENTARE");
                    return;
                }
            }
        });
    }
    private void setERROR(String error) {
        ERROR.setText(error);
        this.repaint();
        this.revalidate();
    }
    private void clearForm(){
        nume.setText("");
        prenume.setText("");
        telefon.setText("");
        bani.setText("");
    }
}
