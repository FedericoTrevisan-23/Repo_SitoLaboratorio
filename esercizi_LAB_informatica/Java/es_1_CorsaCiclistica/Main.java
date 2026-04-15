package es_1_CorsaCiclistica;

public class Main {
    public static void main(String[] args) {
        
        Corsa gara = new Corsa();
        
        Ciclista c1 = new Ciclista("Rossi", "Mario", "Italiana", 1995, 4.2, 15);
        Ciclista c2 = new Ciclista("Smith", "John", "Inglese", 1990, 3.9, 25);
        Ciclista c3 = new Ciclista("Dupont", "Jean", "Francese", 2000, 4.5, 5);
        Ciclista c4 = new Ciclista("Bianchi", "Luca", "Italiana", 1988, 4.1, 30);
        Ciclista c5 = new Ciclista("Verdi", "Paolo", "Italiana", 2012, 5.0, 2); // minorenne
        System.out.println("--- TEST ISCRIZIONI ---");
        gara.aggiungiCiclista(c1);
        gara.aggiungiCiclista(c2);
        gara.aggiungiCiclista(c3);
        gara.aggiungiCiclista(c4);
        gara.aggiungiCiclista(c5); //errore per il minorenne
        
        // Inserisco di nuovo Mario Rossi per testare il controllo doppioni
        System.out.println("\nProvo a rimettere Mario Rossi:");
        gara.aggiungiCiclista(new Ciclista("Rossi", "Mario", "Italiana", 1995, 4.2, 15));

        gara.stampaTutti();

        System.out.println("\n--- TEST RITIRO ---");
        gara.ritiraCiclista(3); // Faccio ritirare il francese (pettorale 3)
        gara.stampaTutti(); // Lo ristampo per vedere se è sparito

        System.out.println("\n--- TEST RICERCHE E CALCOLI ---");
        gara.stampaPerNazione("Italiana");

        int esperti = gara.contaEsperti();
        System.out.println("\nCiclisti con più di 20 gare: " + esperti);

        int pettoraleVeloce = gara.getPettoraleMigliorRecord();
        System.out.println("Il pettorale del ciclista con il record migliore è: " + pettoraleVeloce);

        String veterano = gara.getDatiAtletaPiuGare();
        System.out.println("Dati dell'atleta con più gare in assoluto: " + veterano);
    }
}
