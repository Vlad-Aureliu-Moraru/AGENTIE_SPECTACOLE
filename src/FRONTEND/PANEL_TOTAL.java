package FRONTEND;

import javax.swing.*;
import java.awt.*;

public class PANEL_TOTAL extends JPanel {
    private COLOR_HOLDER colorHolder = new COLOR_HOLDER();
    private Color MAIN_COLOR = colorHolder.getSECONDARY_COLOR();
    public PANEL_TOTAL() {
        this.setBackground(MAIN_COLOR);
    }
}
