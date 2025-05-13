package BACKEND;

public class CLIENT {
    private String NUME;
    private String PRENUME;
    private String NumarDeTelefon;

    public CLIENT(String nume, String prenume, String numarDeTelefon) {
        NUME = nume;
        PRENUME = prenume;
        NumarDeTelefon = numarDeTelefon;
    }
    public String getNUME() {
        return NUME;
    }
    public String getPRENUME() {
        return PRENUME;
    }
    public String getNumarDeTelefon() {
        return NumarDeTelefon;
    }
    public void setNUME(String NUME) {
        this.NUME = NUME;
    }
    public void setPRENUME(String PRENUME) {
        this.PRENUME = PRENUME;
    }
    public void setNumarDeTelefon(String numarDeTelefon) {
        NumarDeTelefon = numarDeTelefon;
    }

}
