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
    public CLIENT getClient() {
        return client;
    }
    public ArrayList<REZERVARE> getRezervari() {
        return rezervari;
    }
    public int getPretTotal() {
        return pretTotal;
    }
}
