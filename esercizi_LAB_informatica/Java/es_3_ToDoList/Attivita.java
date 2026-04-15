package es_3_ToDoList;

//Comparable per poter ordinare la lista automaticamente
public class Attivita implements Comparable<Attivita> {
    
    private String nome;
    private String etichetta; // es. Personale, Lavoro
    private String descrizione;
    private int priorita; // 1 = Urgente/Importante, 2 = Importante, 3 = Meno importante
    private String dataScadenza; // Formato YYYY-MM-DD
    private String oraInizio;
    private String oraFine;
    private boolean completata; // Indicatore se l'attività è stata svolta

    public Attivita(String nome, String etichetta, String descrizione, int priorita, 
                    String dataScadenza, String oraInizio, String oraFine) {
        this.nome = nome;
        this.etichetta = etichetta;
        this.descrizione = descrizione;
        this.priorita = priorita;
        this.dataScadenza = dataScadenza;
        this.oraInizio = oraInizio;
        this.oraFine = oraFine;
        this.completata = false; // Di default un'attività non è ancora completata
    }

    
    public String getNome() { 
        return nome; 
    }
    
    public int getPriorita() { 
        return priorita; 
    }
    
    public void setPriorita(int priorita) { 
        this.priorita = priorita; 
    }

    public String getDataScadenza() { return dataScadenza; }

    public boolean isCompletata() { 
        return completata; 
    }
    
    public void segnaComeCompletata() { 
        this.completata = true;
    }

    // ordinare due attività
    @Override
    public int compareTo(Attivita altra) {
        // ordiniamo per priorità 
        if (this.priorita != altra.priorita) {
            return Integer.compare(this.priorita, altra.priorita);
        }
        // Se hanno la stessa priorità, ordiniamo per data di scadenza 
        return this.dataScadenza.compareTo(altra.dataScadenza);
    }

    @Override
    public String toString() {
        String stato = completata ? "[X]" : "[ ]"; // X se finita, spazio vuoto se da fare
        return stato + " P" + priorita + " | " + nome + " (" + etichetta + ") - Scadenza: " 
               + dataScadenza + " " + oraInizio + "-" + oraFine + "\n   Descrizione: " + descrizione;
    }
}