package es_3_ToDoList;

import java.util.ArrayList;
import java.util.Collections;

public class ToDoList {
    
    private String nomeLista;
    private ArrayList<Attivita> compiti;

    public ToDoList(String nomeLista) {
        this.nomeLista = nomeLista;
        this.compiti = new ArrayList<>();
    }

    // Aggiunge un'attività e mantiene la lista corta
    public void aggiungiAttivita(Attivita a) {
        if (compiti.size() >= 7) {
            System.out.println("Attenzione su " + nomeLista + ": lista troppo lunga.");
        }
        compiti.add(a);
        ordinaLista(); // Ordino subito appena inserisco
    }

    // Modifica la priorità e riordina automaticamente come richiesto dalla traccia
    public void cambiaPriorita(String nomeAttivita, int nuovaPriorita) {
        for (int i = 0; i < compiti.size(); i++) {
            if (compiti.get(i).getNome().equalsIgnoreCase(nomeAttivita)) {
                compiti.get(i).setPriorita(nuovaPriorita);
                System.out.println("Priorità modificata. Riordino la lista...");
                ordinaLista(); // Riordina la lista con la nuova priorità
                return;
            }
        }
        System.out.println("Attività non trovata.");
    }

    // Usa Collections.sort che sfrutta il metodo compareTo scritto in Attivita
    private void ordinaLista() {
        Collections.sort(compiti);
    }

    // Stampa tutta la lista
    public void stampaLista() {
        System.out.println("\n=== TODO LIST: " + nomeLista + " ===");
        if (compiti.isEmpty()) {
            System.out.println("Nessuna attività presente.");
            return;
        }
        for (int i = 0; i < compiti.size(); i++) {
            System.out.println(compiti.get(i).toString());
        }
    }

    // Simula i promemoria e le notifiche controllando la data odierna
    public void controllaNotifiche(String dataDiOggi) {
        System.out.println("\n*** NOTIFICHE PER " + nomeLista + " IN DATA " + dataDiOggi + " ***");
        boolean trovate = false;
        
        for (int i = 0; i < compiti.size(); i++) {
            Attivita a = compiti.get(i);
            if (!a.isCompletata() && a.getDataScadenza().equals(dataDiOggi)) {
                System.out.println("PROMEMORIA SCADENZA OGGI: " + a.getNome() + " (Priorità " + a.getPriorita() + ")");
                trovate = true;
            }
        }
        if (!trovate) {
            System.out.println("Nessuna attività in scadenza oggi.");
        }
    }
}