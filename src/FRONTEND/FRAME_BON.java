package FRONTEND;

import BACKEND.BON;
import BACKEND.REZERVARE;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class FRAME_BON extends JFrame {
    private JTextArea textArea = new JTextArea();
    private JButton print = new JButton("PRINTEAZA BON");
    private COLOR_HOLDER color = new COLOR_HOLDER();
    private String filepath  = "ASSETS/CLIENT_BONURI/";
    private BON bon;
    public FRAME_BON(BON bon) {
        this.bon = bon;
        setTitle("FRAME_BON");
        this.setSize(400, 600);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.getContentPane().setBackground(color.getACCENT2_COLOR());
        this.setLayout(null);
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setBounds(0, 0, 400, 510);
        textArea.setBackground(color.getMAIN_COLOR());
        textArea.setFont(new Font("Arial", Font.PLAIN, 15));

        print.setBounds(100, 530, 200, 50);
        print.setBackground(color.getACCENT_COLOR());
        print.setForeground(color.getMAIN_COLOR());
        print.setFocusPainted(false);
        addActionToPrint();
        this.add(print);
        this.add(textArea);
        addToFrame();

    }
        private void addActionToPrint(){
        print.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                filepath = filepath + bon.getClient().getNUME()+"_"+bon.getClient().getPRENUME()+".txt";
                File file = new File(filepath);
                openFILE(file);
                writeStringToFile(textArea.getText(),filepath);
            }
        });
        }


    private void addToFrame(){
        String content = "";
        content+="\tCLIENT :"+bon.getClient().getNUME();
        content+=" ";
        content+=bon.getClient().getPRENUME();
        content+="\n";
        content+=" TEL :"+bon.getClient().getNumarDeTelefon();
        for (REZERVARE r:bon.getRezervari()){
            content+="\n"+r.toString();
        }
        content+="\n";
        content+=" PRET TOTAL :"+bon.getPretTotal();
        content+="\n";
        content+=" ACHITAT :"+bon.getBaniIntrodusi();
        content+="\n";
        content+=" REST :"+(float)(bon.getBaniIntrodusi()-bon.getPretTotal());
        textArea.setText(content);
        this.repaint();
        this.revalidate();

    }
    public void openFILE(File file){
        if (!file.exists()) {
            try {
                file.getParentFile().mkdirs();
                if (file.createNewFile()) {
                    System.out.println("Fișierul cu spectacole a fost creat: " + file.getAbsolutePath());
                    return;
                } else {
                    System.err.println("Eroare la crearea fișierului cu spectacole: " + file.getAbsolutePath());
                }
            } catch (Exception e) {
                System.err.println("Eroare la crearea fișierului cu spectacole: " + e.getMessage());
            }
        }
    }
    public static boolean writeStringToFile(String text, String filePath) {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(filePath));
            writer.write(text);
            return true;
        } catch (Exception e) {
            System.err.println("Error writing to file: " + e.getMessage());
            return false;
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (Exception e) {
                    System.err.println("Error closing the writer: " + e.getMessage());
                }
            }
        }
    }
}
