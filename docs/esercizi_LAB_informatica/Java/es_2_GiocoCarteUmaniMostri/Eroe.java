package es_2_GiocoCarteUmaniMostri;

// L'Eroe è solo un Umano 
public class Eroe implements Umano {
    
    protected int forza; 

    public Eroe() {
        this.forza = 10; // Gli umani partono con 10 di forza
    }

    @Override
    public void combatti() {
        this.forza -= 3; // L'Eroe perde 3 punti ad ogni combattimento 
        System.out.println("L'Eroe combatte, -3 forza");
    }

    @Override
    public String getForza() {
        return "Forza Eroe: " + this.forza;
    }
}
