package DATABASE;

import java.io.File;

public class DB_CLIENT extends DB{
    private File file = new File("ASSETS/DATABASE/DB_CLIENTI.txt");

    public DB_CLIENT() {
        this.setFile(file);
        openFILE();
    }
}
