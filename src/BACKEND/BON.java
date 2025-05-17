package BACKEND;

import java.util.ArrayList;

public class BON {
    private CLIENT client;
    private ArrayList<REZERVARE> rezervari = new ArrayList<>();
    private int pretTotal;
    private int baniIntrodusi;

    public BON(CLIENT client, ArrayList<REZERVARE> rezervari , int pretTotal,int baniIntrodusi) {
        this.client = client;
        this.baniIntrodusi = baniIntrodusi;
        this.rezervari = rezervari;
        this.pretTotal = pretTotal;
    }

    public int getBaniIntrodusi() {
        return baniIntrodusi;
    }

    public void setBaniIntrodusi(int baniIntrodusi) {
        this.baniIntrodusi = baniIntrodusi;
    }

    public CLIENT getClient() {
        return client;
    }

    public void setClient(CLIENT client) {
        this.client = client;
    }

    public ArrayList<REZERVARE> getRezervari() {
        return rezervari;
    }

    public void setRezervari(ArrayList<REZERVARE> rezervari) {
        this.rezervari = rezervari;
    }

    public int getPretTotal() {
        return pretTotal;
    }

    public void setPretTotal(int pretTotal) {
        this.pretTotal = pretTotal;
    }
}
