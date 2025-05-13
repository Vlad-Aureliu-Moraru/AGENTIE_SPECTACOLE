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
    private String content = "";
    public DB_SPECTACOL() {
        this.setFile(file);
        openFILE();
        readFILE();
        writeINSPECTACOLE(getOBJECT(content));
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
    public void writeINSPECTACOLE(ArrayList<String> OBJ){
        for(int i = 0; i < OBJ.size(); i++){
            String obj = OBJ.get(i);
            obj = obj.substring(1, obj.length()-1);
            ArrayList<String> seg = segmentation(obj);
            proccesSegmented(seg);
        }
//        for (SPECTACOL spectacol:spectacole){
//            System.out.println(spectacol);
//        }
//        System.out.println(spectacole.size());
    }
    private void proccesSegmented(ArrayList<String> seg){
        ArrayList<REPREZENTATIE> reprezentatii = new ArrayList<>();
        SPECTACOL spectacol = new SPECTACOL();
        String nameRegEx = "Nume:\".+\"$";
        String descRegEx = "^Desc:\".+\"$";
        String ReprRegEx = "^Repr:.+";
        String Nume;
        String Desc;
        for (String s:seg) {
            if (s.length()<1){
                continue;
            }
           if (s.matches(nameRegEx)){
               Nume = s.substring(6, s.length()-1);
               spectacol.setNUME(Nume);
           }if (s.matches(descRegEx)){
               Desc = s.substring(6, s.length()-1);
               spectacol.setDESC(Desc);
           }
           if (s.matches(ReprRegEx)){
               s = s.replaceAll(" ","");
               reprezentatii = getREPRESENTATIE(s);
           }
        }
        spectacol.setREPRESENTATII(reprezentatii);
        spectacole.add(spectacol);
    }
    private ArrayList<REPREZENTATIE> getREPRESENTATIE(String s){
        String OrasRegEx = "^Oras:\".+\"$";
        String AdresaRegEx = "^Adresa:\".+\"$";
        String TelefonRegEx = "^Tel:\"[0-9]+\"$";
        String EmailRegEx = "^Email:\".+\"$";
        String LocuriRegEx = "^Locuri:[0-9]+$";
        String oraRegEx = "^Ora:\".+\"$";
        ArrayList<String> objects = getOBJECT(s);
        ArrayList<REPREZENTATIE> reprezentatii = new ArrayList<>();
        for (String obj:objects){
            REPREZENTATIE reprezentatie = new REPREZENTATIE();
            obj = obj.substring(1, obj.length()-1);
            ArrayList<String> seg2 = segmentation(obj);
            for (String se:seg2){
                se = se.replaceAll(" ", "");
                if (se.length()<1){
                    continue;
                }
                if (se.matches(OrasRegEx)){
                    reprezentatie.setOras(se.substring(6, se.length()-1));
                }
                if (se.matches(AdresaRegEx)){
                    reprezentatie.setAdresa(se.substring(8, se.length()-1));
                }
                if (se.matches(TelefonRegEx)){
                    reprezentatie.setTelefon(se.substring(5, se.length()-1));
                }
                if (se.matches(EmailRegEx)){
                    reprezentatie.setEmail(se.substring(7, se.length()-1));
                }
                if (se.matches(LocuriRegEx)){
                    reprezentatie.setLocuri(Integer.parseInt(se.substring(7, se.length())));
                }
                if (se.matches(oraRegEx)){
                    reprezentatie.setOra(se.substring(5, se.length()-1));
                }
            }
            reprezentatii.add(reprezentatie);
        }
       return reprezentatii;
    }
}
