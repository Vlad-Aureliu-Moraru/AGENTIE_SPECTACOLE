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
    public ArrayList<String> segmentation(String content) {
        ArrayList<String> elements = new ArrayList<>();
        ArrayList<Integer> indices = new ArrayList<>();
        int found = 0;
        boolean quote = false;
        int lastCommaIndex = -1; // To keep track of the last top-level comma

        for (int i = 0; i < content.length(); i++) {
            char c = content.charAt(i);
            if (found == 0 && c == ',' && !quote) { // Corrected comma condition
                indices.add(i);
                lastCommaIndex = i;
            }
            if (c == '"') {
                quote = !quote; // Toggle the quote flag
            }
            if (c == '{' || c == '[') {
                found++;
            } else if (c == '}' || c == ']') {
                found--;
            }
        }

        int startIndex = 0;
        for (int commaIndex : indices) {
            elements.add(content.substring(startIndex, commaIndex));
            elements.add(content.substring(commaIndex, commaIndex + 1));
            startIndex = commaIndex + 1;
        }

        if (startIndex < content.length()) {
            elements.add(content.substring(startIndex));
        }

        return elements;
    }
    public ArrayList<String> getOBJECT(String content){
        ArrayList<INDEX> indices = findOBJECT(content);
        ArrayList<String> Objects = new ArrayList<>();
        for (INDEX ind:indices) {
            String object = content.substring(ind.getSTART(), ind.getEND()+1);
            Objects.add(object);
        }
        return Objects;
    }
    public ArrayList<INDEX> findOBJECT(String content) {
        int openBraceIndex = -1;
        int braceCounter = 0;
        ArrayList<INDEX> indices = new ArrayList<>();
        for (int i = 0; i < content.length(); i++) {
            char c = content.charAt(i);
            if (c == '{') {
                braceCounter++;
                if (braceCounter == 1) {
                    openBraceIndex = i;
//                    System.out.println("index:" + i + " found { (start of top-level)");
                }
            } else if (c == '}') {
                braceCounter--;
                if (braceCounter == 0 && openBraceIndex != -1) {
                    INDEX ind = new INDEX();
                    ind.setSTART(openBraceIndex);
                    ind.setEND(i);
                    indices.add(ind);
//                    System.out.println("index:" + i + " found } (end of top-level), object: " + content.substring(openBraceIndex, i + 1));
                }
            }
        }
        if (braceCounter > 0 && openBraceIndex != -1) {
            System.err.println("Warning: Unclosed top-level object starting at index " + openBraceIndex);
        }

        return indices;
    }
}


