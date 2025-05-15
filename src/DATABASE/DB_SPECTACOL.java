package DATABASE;

import BACKEND.REPREZENTATIE;
import BACKEND.REZERVARE;
import BACKEND.SPECTACOL;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class DB_SPECTACOL extends DB {
    private ArrayList<SPECTACOL> spectacole = new ArrayList<>();
    private File file = new File("ASSETS/DATABASE/DB_SPECTACOLE.txt");
    private JSONparser jsoNparser;
    private String content = "";
    public DB_SPECTACOL() {
        this.setFile(file);
        openFILE();
        readFILE();
        writeINSPECTACOLE();
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
    public void writeINSPECTACOLE(){
        jsoNparser = new JSONparser(content);
        ArrayList<ArrayList<String>> objects = jsoNparser.getTrueOBJ();
        for (ArrayList <String> obj:objects){
            SPECTACOL spectacol = new SPECTACOL();
                spectacol.setId(Integer.parseInt(obj.get(0)));
                spectacol.setNUME(obj.get(1));
                spectacol.setDESC(obj.get(2));
                spectacole.add(spectacol);
        }

    }
    public ArrayList<SPECTACOL> getSpectacole() {
        return spectacole;
    }

}
