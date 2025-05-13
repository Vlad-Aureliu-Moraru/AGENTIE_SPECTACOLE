package DATABASE;

public class INDEX {
    private int START;
    private int END;
    public int getSTART() {
        return START;
    }
    public int getEND() {
        return END;
    }
    public void setSTART(int START) {
        this.START = START;
    }
    public void setEND(int END) {
        this.END = END;
    }
    public String toString(){
        return "("+START+";"+END+")";
    }
}
