package FRONTEND.SPECTACOLE;

import BACKEND.REPREZENTATIE;
import FRONTEND.COLOR_HOLDER;
import FRONTEND.PANEL_DESC;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PANEL_REPREZENTATII extends JPanel {
    private COLOR_HOLDER color = new COLOR_HOLDER();
    private int X = 10;
    private int Y = 10;
    private int COORDINATE_X = 0;
    private ArrayList<JButton> buttons = new ArrayList<>();
    private Color background  = color.getACCENT2_COLOR();
    private PANEL_DESC panelDesc = new PANEL_DESC();
    private ArrayList<REPREZENTATIE> representatives = new ArrayList<>();

    public PANEL_REPREZENTATII(ArrayList<REPREZENTATIE> representatives , PANEL_DESC panelDesc) {
        this.representatives = representatives;
        this.panelDesc = panelDesc;
        this.addActionListeners();
        this.setBackground(background);
        this.setLayout(null);
        this.setSize();

    }
    private void setSize(){
        int size = representatives.size();
        for(int i = 0; i < size; i++){
            int id = i+1;
            JButton button = new JButton(""+id);
            button.setBackground(color.getACCENT_COLOR());
            button.setForeground(color.getMAIN_COLOR());
            button.setFocusPainted(false);
            if (i>11){
                throw new RuntimeException("TOO MANY REPREZENTATII");
            }
            if (i>5){
                button.setBounds(X*(COORDINATE_X+1)+(45*COORDINATE_X), Y+70, 50,50);
                COORDINATE_X++;
            }else{
                button.setBounds(X*(i+1)+(45*i), Y+10, 50,50);
            }
            buttons.add(button);
            this.add(button);
        }
        this.repaint();
        this.revalidate();
    }

    private void addActionListeners(){
        for (JButton button : buttons) {
            button.addActionListener(e -> {
                System.out.println("Button clicked " + button.getText() + representatives.get(Integer.parseInt(button.getText())-1));
                if (panelDesc != null) {
                    panelDesc.setDesc(representatives.get(Integer.parseInt(button.getText())-1));
                }else {
                    System.out.println("connector is null");
                }
            });
        }
    }
}
