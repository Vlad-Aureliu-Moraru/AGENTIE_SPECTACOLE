package BACKEND;

public class REPREZENTATIE {
    private String Oras;
    private String Adresa;
    private String Telefon;
    private String Email;
    private int Locuri;
    private String ora;

    public String getOras() {
        return Oras;
    }

    public void setOras(String oras) {
        Oras = oras;
    }

    public String getAdresa() {
        return Adresa;
    }

    public void setAdresa(String adresa) {
        Adresa = adresa;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getTelefon() {
        return Telefon;
    }

    public void setTelefon(String telefon) {
        Telefon = telefon;
    }

    public int getLocuri() {
        return Locuri;
    }

    public void setLocuri(int locuri) {
        Locuri = locuri;
    }

    public String getOra() {
        return ora;
    }

    public void setOra(String ora) {
        this.ora = ora;
    }
    public String toString(){
        return "Oras: "+Oras+"\nAdresa: "+Adresa+"\nTelefon: "+Telefon+"\nEmail: "+Email+"\nLocuri: "+Locuri+"\nOra: "+ora;
    }
}
