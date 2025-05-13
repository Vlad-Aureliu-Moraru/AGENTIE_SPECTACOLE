package BACKEND;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class SPECTACOL {
private String NUME;
private String DESC;
private ArrayList<REPREZENTATIE> REPRESENTATII = new ArrayList<>();

    public String getNUME() {
        return NUME;
    }

    public String getDESC() {
        return DESC;
    }

    public ArrayList<REPREZENTATIE> getREPRESENTATII() {
        return REPRESENTATII;
    }

    public void setNUME(String NUME) {
        this.NUME = NUME;
    }

    public void setDESC(String DESC) {
        this.DESC = DESC;
    }

    public void setREPRESENTATII(ArrayList<REPREZENTATIE> REPRESENTATII) {
        this.REPRESENTATII = REPRESENTATII;
    }
    public String  toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Spectacol: ").append(NUME).append("\n");
        sb.append("Descriere: ").append(DESC).append("\n");
        for(REPREZENTATIE reprezentatie : REPRESENTATII){
            sb.append("--Reprezentatiile: \n");
            sb.append(reprezentatie).append("\n");
        }
        return sb.toString();
    }
}
