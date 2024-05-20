public class Clothes implements Comparable<Clothes> {
private String ime;
private String tip;
private double cena;
public Clothes (){
}
public Clothes(String ime, String tip, double cena){
    this.ime = ime;
    this.cena = cena;
    this.tip = tip;
}

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    @Override
    public String toString() {
        return  ime + " " + tip + " "
        + cena + " ";
    }
    @Override
    public int compareTo(Clothes o) {
    if(getCena()>o.getCena()){
        return 1;
    }
    if(getCena()==o.getCena()){
        return 0;
    }else
        return -1;
    }
}
