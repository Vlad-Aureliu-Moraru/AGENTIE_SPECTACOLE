package FRONTEND;

import java.awt.*;

public class COLOR_HOLDER {
    private Color MAIN_COLOR = new Color(255, 242, 242);
    private Color SECONDARY_COLOR = new Color(169, 181, 223);
    private Color  ACCENT_COLOR= new Color(120, 134, 199);
    private Color  ACCENT2_COLOR= new Color(45, 51, 107);
    private Color ACTIVE_COLOR = new Color(14, 162, 14);
    private Color INACTIVE_COLOR = new Color(208, 28, 28);

    public void setMAIN_COLOR(Color MAIN_COLOR) {
        this.MAIN_COLOR = MAIN_COLOR;
    }

    public void setSECONDARY_COLOR(Color SECONDARY_COLOR) {
        this.SECONDARY_COLOR = SECONDARY_COLOR;
    }

    public void setACCENT_COLOR(Color ACCENT_COLOR) {
        this.ACCENT_COLOR = ACCENT_COLOR;
    }

    public void setACCENT2_COLOR(Color ACCENT2_COLOR) {
        this.ACCENT2_COLOR = ACCENT2_COLOR;
    }

    public Color getSECONDARY_COLOR() {
        return SECONDARY_COLOR;
    }

    public Color getACCENT_COLOR() {
        return ACCENT_COLOR;
    }

    public Color getACCENT2_COLOR() {
        return ACCENT2_COLOR;
    }

    public Color getACTIVE_COLOR() {
        return ACTIVE_COLOR;
    }

    public Color getINACTIVE_COLOR() {
        return INACTIVE_COLOR;
    }

    public Color getMAIN_COLOR() {
        return MAIN_COLOR;
    }
}
