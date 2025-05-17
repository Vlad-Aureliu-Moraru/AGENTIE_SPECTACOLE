package DATABASE;

import BACKEND.REPREZENTATIE;
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
    private DB_REPREZENTATII db_reprezent = new DB_REPREZENTATII();
    public DB_SPECTACOL() {
        this.setFile(file);
        openFILE();
        readFILE();
        writeINSPECTACOLE();
        addREPREZENTATI();
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
    private void writeINSPECTACOLE(){
        jsoNparser = new JSONparser(content);
        ArrayList<ArrayList<String>> objects = jsoNparser.getTrueOBJ();
        for (ArrayList <String> obj:objects){
            SPECTACOL spectacol = new SPECTACOL();
                spectacol.setId(Integer.parseInt(obj.get(0).trim()));
                spectacol.setNUME(obj.get(1));
                spectacol.setDESC(obj.get(2));
                spectacole.add(spectacol);
        }

    }
    private void addREPREZENTATI(){
        ArrayList<REPREZENTATIE> reprezentati = db_reprezent.getReprezentatii();
        for (REPREZENTATIE obj:reprezentati){
            int idSpect = obj.getIdSpectacol();
//            System.out.println(obj.getIdSpectacol());
            SPECTACOL spectacol = getSPECTACOL(idSpect);
            if (spectacol != null){
                spectacol.addREPRESENTATI(obj);
            }
        }
    }

    public SPECTACOL getSPECTACOL(int id){
        for (SPECTACOL spectacol : spectacole) {
            if (spectacol.getId() == id) {
                return spectacol;
            }
        }
        return null;
    }


    public ArrayList<SPECTACOL> getSpectacole() {
        return spectacole;
    }

}
