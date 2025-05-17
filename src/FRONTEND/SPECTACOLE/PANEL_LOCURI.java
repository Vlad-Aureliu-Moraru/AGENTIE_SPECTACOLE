package FRONTEND.SPECTACOLE;

import BACKEND.REPREZENTATIE;
import FRONTEND.COLOR_HOLDER;

import javax.swing.*;
import java.awt.*;

public class PANEL_LOCURI extends JScrollPane {
    private JPanel panel = new JPanel();
    private COLOR_HOLDER color = new COLOR_HOLDER();
    private REPREZENTATIE rep = new REPREZENTATIE();
    public PANEL_LOCURI() {
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        this.setViewportView(panel);
        panel.setBackground(color.getSECONDARY_COLOR());
        this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        this.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        this.setViewportBorder(BorderFactory.createEmptyBorder());
        this.setBorder(BorderFactory.createEmptyBorder());
        this.setOpaque(false);
        this.setVisible(true);
        this.setAutoscrolls(true);
        this.setWheelScrollingEnabled(true);
        getVerticalScrollBar().setUnitIncrement(16);
    }
    public void addLocuri(){
        panel.removeAll();
        for (int i = 0 ; i<rep.getLocuriArray().length; i++){
            int loc = i+1;
            String content = "Locul: "+loc;
            Color c = color.getACCENT2_COLOR();
            if (rep.getLocuriArray()[i]==0){
                c = color.getACTIVE_COLOR();
                content+=" LIBER";
            }else {
                c = color.getINACTIVE_COLOR();
                content+=" OCUPAT";
            }
            JLabel label = new JLabel(content);
            label.setForeground(c);
            label.setFont(new Font("Arial",Font.BOLD,15));

            panel.add(label);

        }
        panel.repaint();
        panel.revalidate();
    }
    public void setRep(REPREZENTATIE rep) {
        this.rep=rep;
        addLocuri();
    }

}
