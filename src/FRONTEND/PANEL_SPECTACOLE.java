package FRONTEND;

import javax.swing.*;
import java.awt.*;

public class PANEL_SPECTACOLE extends JPanel {
    private COLOR_HOLDER COLOR_HOLDER = new COLOR_HOLDER();
    private Color MAIN_COLOR = COLOR_HOLDER.getSECONDARY_COLOR();
    public PANEL_SPECTACOLE() {
        this.setBackground(MAIN_COLOR);
    }
}
