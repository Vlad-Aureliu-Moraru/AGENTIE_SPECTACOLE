package DATABASE;

import java.util.ArrayList;

public class JSONparser extends DB{
    private ArrayList<ArrayList<String>> trueOBJ= new ArrayList<>();
    public JSONparser(String content) {
        ArrayList<String> objects = findOBJECT(content);
        for (String s:objects){
            s = s.substring(0,s.length()-1);
            System.out.println(s);
            ArrayList<String> obj;
            ArrayList<String> objUPDATED = new ArrayList<>();
            obj = segmentation(s);
            for (String o:obj){
                o = o.substring(o.indexOf(':')+1,o.length());
                o = o.replaceAll("\"", "");
                objUPDATED.add(o);
            }
            trueOBJ.add(objUPDATED);
        }
    }
    public ArrayList<ArrayList<String>> getTrueOBJ() {
        return trueOBJ;
    }
}
