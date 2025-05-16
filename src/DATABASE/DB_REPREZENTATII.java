package DATABASE;

import BACKEND.REPREZENTATIE;
import BACKEND.SPECTACOL;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class DB_REPREZENTATII extends  DB {
    private ArrayList<REPREZENTATIE> reprezentatii = new ArrayList<>();
    private File file= new File("ASSETS/DATABASE/DB_REPREZENTATII.txt");
    private JSONparser jsoNparser;
    private String content = "";
    public DB_REPREZENTATII() {
       readFILE();
       writeInReprezentatii();
    }
    public void readFILE(){
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                content+=line;
            }
        } catch (Exception e) {
            System.err.println("Eroare la citirea fișierului cu spectacole: " + e.getMessage());
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (Exception e) {
                System.err.println("Eroare la închiderea reader-ului: " + e.getMessage());
            }
        }
    }
    public void writeInReprezentatii() {
        jsoNparser = new JSONparser(content);
        ArrayList<ArrayList<String>> objects = jsoNparser.getTrueOBJ();
        for (ArrayList <String> obj:objects){
            REPREZENTATIE rep = new REPREZENTATIE();
            rep.setAdresa(obj.get(3));
            rep.setId(Integer.parseInt(obj.get(0)));
            rep.setIdSpectacol(Integer.parseInt(obj.get(1)));
            rep.setOras(obj.get(2));
            rep.setTelefon(obj.get(4));
            rep.setEmail(obj.get(5));
            rep.setLocuri(Integer.parseInt(obj.get(6)));
            rep.setOra(obj.get(7));
            reprezentatii.add(rep);
        }
        }

    public ArrayList<REPREZENTATIE> getReprezentatii() {
        return reprezentatii;
    }
}
