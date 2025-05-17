package DATABASE;

import java.io.File;
import java.util.ArrayList;

public class DB {
    private File file;
    private String content = "";

    public void setFile(File file) {
        this.file = file;
    }
    public File getFile() {
        return file;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }

    public void openFILE(){
        if (!file.exists()) {
            try {
                file.getParentFile().mkdirs();
                if (file.createNewFile()) {
                    System.out.println("Fișierul cu spectacole a fost creat: " + file.getAbsolutePath());
                    return;
                } else {
                    System.err.println("Eroare la crearea fișierului cu spectacole: " + file.getAbsolutePath());
                }
            } catch (Exception e) {
                System.err.println("Eroare la crearea fișierului cu spectacole: " + e.getMessage());
            }
        }
    }
    public ArrayList<String> segmentation(String content ) {
        ArrayList<String> elements = new ArrayList<>();
        ArrayList<Integer> indices = new ArrayList<>();
        int found = 0;
        boolean quote = false;
        indices.add(0);
        for (int i = 0; i < content.length(); i++) {
            char c = content.charAt(i);
            if (found == 0 && c == ',' && !quote) {
                indices.add(i);
            }
            if (c == '"') {
                quote = !quote;
            }
            if (c == '{' || c == '[') {
                found++;
            } else if (c == '}' || c == ']') {
                found--;
            }
        }

        indices.add(content.length()-1);
        for (int i = 0 ; i< indices.size()-1; i++) {
            elements.add(content.substring(indices.get(i),indices.get(i+1)));
        }

        return elements;
    }
    public ArrayList<String> findOBJECT(String content) {
        int openBraceIndex = -1;
        int braceCounter = 0;
        ArrayList<INDEX> indices = new ArrayList<>();
        ArrayList<String> Objects = new ArrayList<>();
        for (int i = 0; i < content.length(); i++) {
            char c = content.charAt(i);
            if (c == '{') {
                braceCounter++;
                if (braceCounter == 1) {
                    openBraceIndex = i;
                }
            } else if (c == '}') {
                braceCounter--;
                if (braceCounter == 0 && openBraceIndex != -1) {
                    INDEX ind = new INDEX();
                    ind.setSTART(openBraceIndex);
                    ind.setEND(i);
                    indices.add(ind);
                }
            }
        }
        if (braceCounter > 0 && openBraceIndex != -1) {
            System.err.println("Warning: Unclosed top-level object starting at index " + openBraceIndex);
        }
        for (INDEX ind:indices) {
            String object = content.substring(ind.getSTART()+1, ind.getEND());
            if (object.length()>=2) {
                Objects.add(object);
            }

        }

        return Objects;
    }
}


