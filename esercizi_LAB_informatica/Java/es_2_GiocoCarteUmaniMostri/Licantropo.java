package es_2_GiocoCarteUmaniMostri;

public class Licantropo implements Umano, Mostro {
    
    private boolean isUomo;
    protected int forzaUmano; 
    private int forzaMostro; 

    public Licantropo(boolean isUomo) {
        this.isUomo = isUomo;
        this.forzaUmano = 10; // Forza di base umana
        this.forzaMostro = 15; // Forza di base mostro 
    }

    @Override
    public void combatti() {
        // Può combattere solo se in forma umana
        if (isUomo) {
            this.forzaUmano -= 3; // Nelle notti normali perde 3 
            System.out.println("Il Licantropo (in forma umana) usa i pugni, -3 forza");
        } else {
            System.out.println("C'è la luna piena, Il Licantropo è un mostro e non può usare le armi umane.");
        }
    }

    @Override
    public void azzanna() {
        // Può azzannare solo se è un mostro 
        if (!isUomo) {
            this.forzaMostro -= 2; // Nelle notti di luna piena perde 2 
            System.out.println("Il Licantropo (in forma di lupo) morde, -2 forza");
        } else {
            System.out.println("Oggi è un umano, non ha i denti per azzannare");
        }
    }

    @Override
    public String getForza() {
        if (isUomo) {
            return "Forza Licantropo (Umano): " + this.forzaUmano;
        } else {
            return "Forza Licantropo (Lupo): " + this.forzaMostro;
        }
    }
}
