package BACKEND;

public class REPREZENTATIE {
    private String Oras;
    private String Adresa;
    private String Telefon;
    private String Email;
    private int Locuri;
    private String ora;
    private int pretPeLoc;
    private int id;
    private int idSpectacol;
    private String data;
    private int[] locuri;

public REPREZENTATIE() {

}
    public int[] getLocuriArray(){
    return locuri;
    }
    public void setLocuriArray(){
    locuri = new int[Locuri];
    for(int i=0;i<Locuri;i++){
        int val = (int)(Math.random()*2);
        this.locuri[i]=val;
    }
    }
    public void setData(String data) {
        this.data = data;
    }
    public String getData() {
        return data;
    }

    public int getPretPeLoc() {
        return pretPeLoc;
    }
    public void setPretPeLoc(int pretPeLoc) {
        this.pretPeLoc = pretPeLoc;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getIdSpectacol() {
        return idSpectacol;
    }
    public void setIdSpectacol(int idSpectacol) {
        this.idSpectacol = idSpectacol;
    }

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
        return "Oras: "+Oras+"\nAdresa: "+Adresa+"\nTelefon: "+Telefon+"\nEmail: "+Email+"\nLocuri: "+Locuri+"\nOra: "+ora+"\nId: "+id+"\nPret Pe Loc: "+pretPeLoc +"\nLOCURIARRAY "+locuri.length;
    }
}
