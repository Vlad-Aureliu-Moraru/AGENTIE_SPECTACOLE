package FRONTEND;

import javax.swing.*;
import java.awt.*;

public class NAV_BAR extends JPanel {
    private COLOR_HOLDER COLOR_HOLDER = new COLOR_HOLDER();
    private Color MAIN_COLOR = COLOR_HOLDER.getACCENT_COLOR();
    public NAV_BAR() {
        this.setBackground(MAIN_COLOR);
    }
}
