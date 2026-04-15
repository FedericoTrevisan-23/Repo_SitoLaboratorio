package es_2_GiocoCarteUmaniMostri;

// Il Vampiro è solo un Mostro 
public class Vampiro implements Mostro {
    
    protected int forza; 

    public Vampiro() {
        this.forza = 15; // I mostri partono con 15 di forza
    }

    @Override
    public void azzanna() {
        this.forza -= 2; // Il Vampiro perde 2 punti ad ogni azzanno 
        System.out.println("Il Vampiro azzanna la sua preda, -2 forza");
    }

    @Override
    public String getForza() {
        return "Forza Vampiro: " + this.forza;
    }
}
