package es_1_CorsaCiclistica;

public class Ciclista {
    
    private String cognome;
    private String nome;
    private String nazionalita;
    private int annoNascita;
    private double recordMiglio; // in minuti, quindi double
    private int numeroCorse;
    private int pettorale;

    public Ciclista(String cognome, String nome, String nazionalita, int annoNascita, double recordMiglio, int numeroCorse) {
        this.cognome = cognome;
        this.nome = nome;
        this.nazionalita = nazionalita;
        this.annoNascita = annoNascita;
        this.recordMiglio = recordMiglio;
        this.numeroCorse = numeroCorse;
        this.pettorale = 1; // valore iniziale, perchè parte da 1 per tutti
    }
    
    public String getCognome() { 
        return cognome; 
    }

    public void setCognome(String cognome) { 
        this.cognome = cognome; 
    }

    public String getNome() { 
        return nome;
    }

    public void setNome(String nome) { 
        this.nome = nome; 
    }

    public String getNazionalita() { 
        return nazionalita; 
    }

    public void setNazionalita(String nazionalita) { 
        this.nazionalita = nazionalita; 
    }

    public int getAnnoNascita() { 
        return annoNascita; 
    }

    public void setAnnoNascita(int annoNascita) { 
        this.annoNascita = annoNascita; 
    }

    public double getRecordMiglio() { 
        return recordMiglio; 
    }

    public void setRecordMiglio(double recordMiglio) { 
        this.recordMiglio = recordMiglio;
    }

    public int getNumeroCorse() { 
        return numeroCorse; 
    }
    
    public void setNumeroCorse(int numeroCorse) { 
        this.numeroCorse = numeroCorse; 
    }

    public int getPettorale() { 
        return pettorale; 
    }
    
    public void setPettorale(int pettorale) { 
        this.pettorale = pettorale; 
    }

    @Override
    public String toString() {
        return "Pettorale: " + pettorale + " | " + nome + " " + cognome + 
               " (" + nazionalita + ") - Anno: " + annoNascita + 
               " - Record: " + recordMiglio + " min - Corse fatte: " + numeroCorse;
    }
}