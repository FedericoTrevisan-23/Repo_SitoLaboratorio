package es_1_CorsaCiclistica;
import java.util.ArrayList;

public class Corsa {
    
    private ArrayList<Ciclista> iscritti;
    private int prossimoPettorale;

    public Corsa() {
        iscritti = new ArrayList<>();
        prossimoPettorale = 1; // Il primo che si iscrive prende l'1
    }

    public void aggiungiCiclista(Ciclista c) {
        int eta = 2026 - c.getAnnoNascita();
        if (eta < 18) {
            System.out.println("Errore: " + c.getNome() + " " + c.getCognome() + " è minorenne e non può correre.");
            return;
        }

        // Controllo se è già iscritto (nome e cognome)
        for (int i = 0; i < iscritti.size(); i++) {
            Ciclista esistente = iscritti.get(i);
            if (esistente.getNome().equalsIgnoreCase(c.getNome()) && 
                esistente.getCognome().equalsIgnoreCase(c.getCognome())) {
                System.out.println("Errore: " + c.getNome() + " " + c.getCognome() + " è già iscritto alla corsa.");
                return;
            }
        }

        // Gli do il pettorale, lo aggiungo alla lista e poi aumento il contatore per il prossimo
        c.setPettorale(prossimoPettorale);
        iscritti.add(c);
        prossimoPettorale++; 
        System.out.println("Iscritto con successo: " + c.getNome() + " (Pettorale " + c.getPettorale() + ")");
    }

    public void ritiraCiclista(int numeroPettorale) {
        for (int i = 0; i < iscritti.size(); i++) {
            if (iscritti.get(i).getPettorale() == numeroPettorale) {
                System.out.println("Il ciclista con pettorale " + numeroPettorale + " si è ritirato.");
                iscritti.remove(i);
                return; 
            }
        }
        System.out.println("Pettorale non trovato.");
    }

    public void stampaPerNazione(String nazione) {
        System.out.println("\n--- Corridori nazionalità: " + nazione + " ---");
        for (int i = 0; i < iscritti.size(); i++) {
            if (iscritti.get(i).getNazionalita().equalsIgnoreCase(nazione)) {
                System.out.println(iscritti.get(i).toString());
            }
        }
    }

    public int contaEsperti() {
        int contatore = 0;
        for (int i = 0; i < iscritti.size(); i++) {
            if (iscritti.get(i).getNumeroCorse() > 20) {
                contatore++;
            }
        }
        return contatore;
    }

    public void stampaTutti() {
        System.out.println("\n--- LISTA ISCRITTI ---");
        if (iscritti.size() == 0) {
            System.out.println("Nessun iscritto ora.");
        }
        for (int i = 0; i < iscritti.size(); i++) {
            System.out.println(iscritti.get(i).toString());
        }
    }

    public int getPettoraleMigliorRecord() {
        if (iscritti.isEmpty()) {
            return -1; 
        }
        
        // Parto presupponendo che il primo sia il migliore, poi confronto gli altri
        Ciclista migliore = iscritti.get(0); 
        for (int i = 1; i < iscritti.size(); i++) {
            if (iscritti.get(i).getRecordMiglio() < migliore.getRecordMiglio()) {
                migliore = iscritti.get(i); 
            }
        }
        return migliore.getPettorale();
    }

    // Trova l'atleta che ha fatto più gare e restituisce una stringa con i suoi dati
    public String getDatiAtletaPiuGare() {
        if (iscritti.isEmpty()) {
            return "Nessun iscritto";
        }

        Ciclista maxGare = iscritti.get(0);
        for (int i = 1; i < iscritti.size(); i++) {
            if (iscritti.get(i).getNumeroCorse() > maxGare.getNumeroCorse()) {
                maxGare = iscritti.get(i);
            }
        }

        return maxGare.getCognome() + " " + maxGare.getNome() + " - " + maxGare.getNazionalita();
    }
}