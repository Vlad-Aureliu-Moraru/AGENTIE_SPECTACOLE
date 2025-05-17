package BACKEND;

public class CLIENT {
    private String NUME;
    private String PRENUME;
    private String NumarDeTelefon;
    private int Bani;

    public CLIENT(String nume, String prenume, String numarDeTelefon, int bani) {
        NUME = nume;
        PRENUME = prenume;
        NumarDeTelefon = numarDeTelefon;
        Bani = bani;
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

}
