package es_4_OperazioniConIPolinomi;

public class Operazioni {

    // Somma di due polinomi
    public static Polinomio somma(Polinomio p1, Polinomio p2) {
        Polinomio risultato = new Polinomio();
        
        // Riversiamo tutto p1 nel risultato
        Monomio corr = p1.getTesta();
        while (corr != null) {
            risultato.inserisciMonomio(corr.coefficiente, corr.potenza);
            corr = corr.next;
        }

        // Riversiamo tutto p2 nel risultato. 
        // Il metodo "inserisciMonomio" si occuperà da solo di sommare le potenze uguali
        corr = p2.getTesta();
        while (corr != null) {
            risultato.inserisciMonomio(corr.coefficiente, corr.potenza);
            corr = corr.next;
        }
        
        return risultato;
    }

    // Moltiplicazione per un numero scalare
    public static Polinomio moltiplicaPerNumero(Polinomio p, int n) {
        Polinomio risultato = new Polinomio();
        Monomio corr = p.getTesta();
        
        while (corr != null) {
            // Moltiplico solo il coefficiente, la potenza resta uguale
            risultato.inserisciMonomio(corr.coefficiente * n, corr.potenza);
            corr = corr.next;
        }
        return risultato;
    }

    // Scomposizione in fattori
    public static void scomponi(Polinomio p) {
        int minPot = p.getPotenzaMinima();
        
        if (minPot == 0) {
            System.out.println("Scomposizione non possibile: è presente il termine noto.");
            return;
        }

        // P(x) = x^minPot
        Polinomio fattoreEstratto = new Polinomio();
        fattoreEstratto.inserisciMonomio(1, minPot); // (1, minPot)

        // Creo P1(x) riducendo le potenze di tutti i nodi
        Polinomio rimanente = p.copia();
        rimanente.riduciPotenze(minPot);

        System.out.println("Risultato Scomposizione: " + p.stampaMatematica() + " = x^" + minPot + " * (" + rimanente.stampaMatematica() + ")");
        System.out.println("P(x) è rappresentato da: " + fattoreEstratto.stampaStrutturaLista());
        System.out.println("P1(x) è rappresentato da: " + rimanente.stampaStrutturaLista());
    }
}
