package app.superniania;


public class Auta {

    private int id;

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    private String marka;


    @Override
    public String toString() {
        return "Id: "+id+" marka: "+marka;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
