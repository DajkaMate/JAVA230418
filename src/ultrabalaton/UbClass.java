/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ultrabalaton;

/**
 *
 * @author steyza
 */
public class UbClass {
    private String versenyzo; 
    private int rajtszam;
    private String kategoria;
    private String versenyido;
    private int tavszazalek;
    
    //konstruktor
    public UbClass(String sor)
    {
        String[] sorbe=sor.split(";");
        versenyzo=sorbe[0];
        rajtszam=Integer.parseInt(sorbe[1]);
        kategoria=sorbe[2];
        versenyido=sorbe[3];
        tavszazalek=Integer.parseInt(sorbe[4]);
    }
    
    public String getVersenyzo() {
        return versenyzo;
    }

    public void setVersenyzo(String versenyzo) {
        this.versenyzo = versenyzo;
    }

    public int getRajtszam() {
        return rajtszam;
    }

    public void setRajtszam(int rajtszam) {
        this.rajtszam = rajtszam;
    }

    public String getKategoria() {
        return kategoria;
    }

    public void setKategoria(String kategoria) {
        this.kategoria = kategoria;
    }

    public String getVersenyido() {
        return versenyido;
    }

    public void setVersenyido(String versenyido) {
        this.versenyido = versenyido;
    }

    public int getTavszazalek() {
        return tavszazalek;
    }

    public void setTavszazalek(int tavszazalek) {
        this.tavszazalek = tavszazalek;
    }
    
    public double idoOraban()
    {
        String[] ido= versenyido.split(":");
        double ora=Double.parseDouble(ido[0]);
        double perc =Double.parseDouble(ido[1]);
        double masodperc = Double.parseDouble(ido[2]);
        return (ora+perc/60+masodperc/3600);
    }
    
}
