package es_4_OperazioniConIPolinomi;

public class Main {
    public static void main(String[] args) {
        
        // --- PREPARAZIONE ESEMPIO 1 (Somma) ---
        Polinomio p1 = new Polinomio();
        p1.inserisciMonomio(4, 8);
        p1.inserisciMonomio(-5, 4);
        p1.inserisciMonomio(8, 0);

        Polinomio p2 = new Polinomio();
        p2.inserisciMonomio(2, 6);
        p2.inserisciMonomio(3, 4);
        p2.inserisciMonomio(-2, 0);

        System.out.println("=== 1. SOMMA ===");
        System.out.println("P1(x) = " + p1.stampaMatematica());
        System.out.println("Lista: " + p1.stampaStrutturaLista());
        System.out.println("P2(x) = " + p2.stampaMatematica());
        System.out.println("Lista: " + p2.stampaStrutturaLista());

        Polinomio somma = Operazioni.somma(p1, p2);
        System.out.println("\nP1(x) + P2(x) = " + somma.stampaMatematica());
        System.out.println("Lista Risultato: " + somma.stampaStrutturaLista());


        // --- PREPARAZIONE ESEMPIO 2 (Moltiplicazione per numero) ---
        System.out.println("\n=== 2. MOLTIPLICAZIONE PER UN NUMERO ===");
        int n = -2;
        Polinomio moltiplicato = Operazioni.moltiplicaPerNumero(p1, n);
        System.out.println(n + " * P1(x) = " + moltiplicato.stampaMatematica());
        System.out.println("Lista Risultato: " + moltiplicato.stampaStrutturaLista());


        // --- PREPARAZIONE ESEMPIO 3 (Scomposizione) ---
        System.out.println("\n=== 3. SCOMPOSIZIONE IN FATTORI ===");
        Polinomio p3 = new Polinomio();
        p3.inserisciMonomio(4, 8);
        p3.inserisciMonomio(2, 6);
        p3.inserisciMonomio(-2, 4);

        System.out.println("Polinomio da scomporre: " + p3.stampaMatematica());
        System.out.println("Lista: " + p3.stampaStrutturaLista());
        
        Operazioni.scomponi(p3);
    }
}
