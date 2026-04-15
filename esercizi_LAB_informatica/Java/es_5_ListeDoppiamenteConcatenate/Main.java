package es_5_ListeDoppiamenteConcatenate;

public class Main {
    public static void main(String[] args) {
        ListaDoppia lista = new ListaDoppia();

        System.out.println("--- TEST INSERIMENTI ---");
        lista.inserisciInCoda(10);
        lista.inserisciInCoda(20);
        lista.inserisciInCoda(30);
        lista.stampaLista(); // Atteso: 10 20 30

        lista.inserisciInTesta(5);
        lista.stampaLista(); // Atteso: 5 10 20 30

        System.out.println("Inserisco 15 PRIMA di 20:");
        lista.insertBefore(20, 15);
        lista.stampaLista(); // Atteso: 5 10 15 20 30

        System.out.println("Inserisco 25 DOPO il 20:");
        lista.insertAfter(20, 25);
        lista.stampaLista(); // Atteso: 5 10 15 20 25 30


        System.out.println("\n--- TEST ELIMINAZIONI ---");
        System.out.println("Elimino in testa (5):");
        lista.eliminaInTesta();
        lista.stampaLista(); // Atteso: 10 15 20 25 30

        System.out.println("Elimino in coda (30):");
        lista.eliminaInCoda();
        lista.stampaLista(); // Atteso: 10 15 20 25

        System.out.println("Elimino il nodo PRIMA di 25 (che è 20):");
        lista.removeBefore(25);
        lista.stampaLista(); // Atteso: 10 15 25

        System.out.println("Elimino il nodo DOPO di 10 (che è 15):");
        lista.removeAfter(10);
        lista.stampaLista(); // Atteso: 10 25


        System.out.println("\n--- TEST RIPETIZIONI ---");
        // Creo una lista sporca
        ListaDoppia listaRip = new ListaDoppia();
        int[] valoriSporchi = {1, 2, 2, 3, 1, 4, 2, 5, 4};
        for (int v : valoriSporchi) listaRip.inserisciInCoda(v);
        
        System.out.print("Lista originale: ");
        listaRip.stampaLista(); // 1 2 2 3 1 4 2 5 4
        
        listaRip.eliminaRipetizioni();
        System.out.print("Senza ripetizioni: ");
        listaRip.stampaLista(); // 1 2 3 4 5


        System.out.println("\n--- TEST PICCHI ---");
        // Ricreo esattamente l'esempio della traccia
        ListaDoppia listaPicchi = new ListaDoppia();
        int[] valoriTraccia = {4, 9, 12, 36, 16, 23, 87, 34, 18, 64, 33};
        for (int v : valoriTraccia) listaPicchi.inserisciInCoda(v);
        
        listaPicchi.stampaLista();
        int numeroPicchi = listaPicchi.contaPicchi();
        System.out.println("Totale picchi trovati: " + numeroPicchi); 
    }
}