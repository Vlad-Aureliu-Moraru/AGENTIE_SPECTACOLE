package BACKEND;

import java.util.ArrayList;

public class REZERVARE {
    private ArrayList<Integer> loc = new ArrayList<>();
    private REPREZENTATIE reprezentatie;
    private SPECTACOL spectacol;

    public SPECTACOL getSpectacol() {
        return spectacol;
    }

    public void setSpectacol(SPECTACOL spectacol) {
        this.spectacol = spectacol;
    }

    public ArrayList<Integer> getLoc() {
        return loc;
    }

    public void setLoc(ArrayList<Integer> loc) {
        this.loc = loc;
    }
    public void addLoc(int loc) {
        this.loc.add(loc);
    }

    public REPREZENTATIE getREPREZENTATIE() {
        return reprezentatie;
    }

    public void setREPREZENTATIE(REPREZENTATIE REPREZENTATIE) {
        this.reprezentatie = REPREZENTATIE;
    }
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(spectacol.getNUME()+" | ");
        str.append("\n");
        str.append(reprezentatie.getAdresa());
        str.append("\n");
        str.append(" | Loc: ");
        for (int i = 0; i < loc.size(); i++) {
            str.append(loc.get(i)+",");
        }
    return str.toString();
    }
}
