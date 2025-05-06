package model;

public class Barn {
    private int idBarn;
    private String nameBarn;
    private int numPig;
    private int capacity;

    public Barn() {}

    public Barn(int idBarn, String nameBarn, int numPig, int capacity) {
        super();
        this.idBarn = idBarn;
        this.nameBarn = nameBarn;
        this.numPig = numPig;
        this.capacity = capacity;
    }

    public int getIdBarn() {
        return idBarn;
    }

    public void setIdBarn(int idBarn) {
        this.idBarn = idBarn;
    }

    public String getNameBarn() {
        return nameBarn;
    }

    public void setNameBarn(String nameBarn) {
        this.nameBarn = nameBarn;
    }

    public int getNumPig() {
        return numPig;
    }

    public void setNumPig(int numPig) {
        this.numPig = numPig;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
