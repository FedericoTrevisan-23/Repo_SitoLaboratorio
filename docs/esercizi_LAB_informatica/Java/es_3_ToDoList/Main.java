package es_3_ToDoList;

public class Main {
    public static void main(String[] args) {
        
        System.out.println("Avvio Applicazione TodoList...\n");

        // Creiamo due liste separate 
        ToDoList listaLavoro = new ToDoList("Lavoro Progetto Informatica");
        ToDoList listaPersonale = new ToDoList("Casa e Personale");

        // Creo dei compiti 
        Attivita a1 = new Attivita("Scrivere report finale", "Lavoro", "Completare il documento su Word e inviare al capo", 1, "2026-04-15", "09:00", "12:00");
        Attivita a2 = new Attivita("Rispondere email arretrate", "Lavoro", "Filtrare la casella di posta", 3, "2026-04-16", "14:00", "15:00");
        Attivita a3 = new Attivita("Preparare slide presentazione", "Lavoro", "Fare le prime 10 slide", 2, "2026-04-15", "15:00", "18:00");
        
        Attivita a4 = new Attivita("Fare la spesa", "Personale", "Comprare latte, pane e uova", 2, "2026-04-15", "18:30", "19:00");

        // Aggiungo alle rispettive liste (si ordineranno da sole)
        listaLavoro.aggiungiAttivita(a1);
        listaLavoro.aggiungiAttivita(a2);
        listaLavoro.aggiungiAttivita(a3);
        listaPersonale.aggiungiAttivita(a4);

        // Stampo per vedere l'ordine iniziale (dovrebbe essere: a1(P1), a3(P2), a2(P3))
        listaLavoro.stampaLista();
        listaPersonale.stampaLista();

        // Modifica priorità
        System.out.println("\n--- MODIFICA PRIORITA ---");
        System.out.println("Le email sono diventate urgenti!");
        listaLavoro.cambiaPriorita("Rispondere email arretrate", 1);
        
        // Ristampo per vedere che le email sono salite in cima alla lista
        listaLavoro.stampaLista();

        //Segnare un'attività come svolta
        System.out.println("\n--- AGGIORNAMENTO PROGRESSI ---");
        a1.segnaComeCompletata();
        System.out.println("Report scritto e completato!");
        listaLavoro.stampaLista();

        //Promemoria e notifiche per una certa data
        String dataDiOggi = "2025-09-29";
        listaLavoro.controllaNotifiche(dataDiOggi);
        listaPersonale.controllaNotifiche(dataDiOggi);
    }
}