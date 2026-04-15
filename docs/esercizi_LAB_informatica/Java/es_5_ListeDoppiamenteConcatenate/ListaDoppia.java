package es_5_ListeDoppiamenteConcatenate;

public class ListaDoppia {
    
    private Nodo testa;
    private Nodo coda;

    public ListaDoppia() {
        this.testa = null;
        this.coda = null;
    }

    // --- INSERIMENTI ---

    // Inserisce all'inizio della lista
    public void inserisciInTesta(int val) {
        Nodo nuovo = new Nodo(val);
        if (testa == null) {
            // Se la lista era vuota, il nuovo nodo è sia testa che coda
            testa = nuovo;
            coda = nuovo;
        } else {
            nuovo.successivo = testa; // Il prossimo del nuovo è la vecchia testa
            testa.precedente = nuovo; // Il precedente della vecchia testa è il nuovo
            testa = nuovo;            // Aggiorno il puntatore ufficiale della testa
        }
    }

    // Inserisce alla fine della lista (grazie al puntatore coda, è velocissimo)
    public void inserisciInCoda(int val) {
        Nodo nuovo = new Nodo(val);
        if (coda == null) {
            testa = nuovo;
            coda = nuovo;
        } else {
            coda.successivo = nuovo;  // Il prossimo della vecchia coda è il nuovo
            nuovo.precedente = coda;  // Il precedente del nuovo è la vecchia coda
            coda = nuovo;             // Aggiorno il puntatore ufficiale della coda
        }
    }

    // Inserisce un nuovo nodo PRIMA del primo nodo trovato che contiene 'valoreTarget'
    public void insertBefore(int valoreTarget, int nuovoValore) {
        Nodo corr = trovaNodo(valoreTarget);
        if (corr == null) return; // Nodo target non trovato
        
        if (corr == testa) {
            inserisciInTesta(nuovoValore); // Se il target è la testa, è un banale inserimento in testa
            return;
        }

        Nodo nuovo = new Nodo(nuovoValore);
        // "Slego" i collegamenti per far posto al nuovo in mezzo
        nuovo.precedente = corr.precedente;
        nuovo.successivo = corr;
        
        corr.precedente.successivo = nuovo;
        corr.precedente = nuovo;
    }

    // Inserisce un nuovo nodo DOPO il primo nodo trovato che contiene 'valoreTarget'
    public void insertAfter(int valoreTarget, int nuovoValore) {
        Nodo corr = trovaNodo(valoreTarget);
        if (corr == null) return;

        if (corr == coda) {
            inserisciInCoda(nuovoValore);
            return;
        }

        Nodo nuovo = new Nodo(nuovoValore);
        nuovo.successivo = corr.successivo;
        nuovo.precedente = corr;

        corr.successivo.precedente = nuovo;
        corr.successivo = nuovo;
    }

    // --- ELIMINAZIONI ---

    public void eliminaInTesta() {
        if (testa == null) return;
        
        if (testa == coda) { // C'era un solo elemento
            testa = null;
            coda = null;
        } else {
            testa = testa.successivo; // Sposto la testa in avanti
            testa.precedente = null;  // Cancello il ricordo del vecchio primo elemento
        }
    }

    public void eliminaInCoda() {
        if (coda == null) return;

        if (testa == coda) {
            testa = null;
            coda = null;
        } else {
            coda = coda.precedente;  // Arretro la coda
            coda.successivo = null;  // Cancello il ricordo del vecchio ultimo elemento
        }
    }

    // Elimina il nodo PRIMA del primo nodo trovato con 'valoreTarget'
    public void removeBefore(int valoreTarget) {
        Nodo corr = trovaNodo(valoreTarget);
        if (corr == null || corr == testa) return; // Non c'è nulla prima della testa

        Nodo daEliminare = corr.precedente;
        if (daEliminare == testa) {
            eliminaInTesta();
        } else {
            // "Scavalco" il nodo da eliminare
            daEliminare.precedente.successivo = corr;
            corr.precedente = daEliminare.precedente;
        }
    }

    // Elimina il nodo DOPO il primo nodo trovato con 'valoreTarget'
    public void removeAfter(int valoreTarget) {
        Nodo corr = trovaNodo(valoreTarget);
        if (corr == null || corr == coda) return; // Non c'è nulla dopo la coda

        Nodo daEliminare = corr.successivo;
        if (daEliminare == coda) {
            eliminaInCoda();
        } else {
            // "Scavalco" il nodo da eliminare
            corr.successivo = daEliminare.successivo;
            daEliminare.successivo.precedente = corr;
        }
    }

    // --- ALTRE OPERAZIONI RICHIESTE ---

    // Metodo helper per le funzioni di insert/remove
    private Nodo trovaNodo(int val) {
        Nodo corr = testa;
        while (corr != null) {
            if (corr.valore == val) return corr;
            corr = corr.successivo;
        }
        return null;
    }

    // Elimina i valori ripetuti mantenendo solo la prima occorrenza
    public void eliminaRipetizioni() {
        if (testa == null) return;

        Nodo corr = testa;
        // Scorro ogni nodo...
        while (corr != null) {
            Nodo temp = corr.successivo;
            // ...e lo confronto con tutti i successivi
            while (temp != null) {
                if (temp.valore == corr.valore) {
                    Nodo daRimuovere = temp;
                    temp = temp.successivo; // Mi salvo il prossimo prima di "rompere" i legami
                    
                    // Gestisco lo sgancio del nodo duplicato
                    if (daRimuovere == coda) {
                        eliminaInCoda();
                    } else {
                        daRimuovere.precedente.successivo = daRimuovere.successivo;
                        daRimuovere.successivo.precedente = daRimuovere.precedente;
                    }
                } else {
                    temp = temp.successivo;
                }
            }
            corr = corr.successivo;
        }
    }

    // Calcola quanti e quali "picchi" ci sono
    public int contaPicchi() {
        // La traccia dice che testa e coda non possono essere picchi, quindi servono almeno 3 elementi
        if (testa == null || testa == coda || testa.successivo == coda) return 0;

        int conteggio = 0;
        System.out.println("Picchi trovati: ");
        
        // Parto dal secondo elemento e mi fermo al penultimo
        Nodo corr = testa.successivo;
        while (corr.successivo != null) {
            
            // Logica del picco: il valore precedente e successivo devono essere MINORI della metà del valore corrente.
            double meta = corr.valore / 2.0; 
            
            if (corr.precedente.valore < meta && corr.successivo.valore < meta) {
                System.out.println("-> " + corr.valore + " (preceduto da " + corr.precedente.valore + " e seguito da " + corr.successivo.valore + ")");
                conteggio++;
            }
            corr = corr.successivo;
        }
        return conteggio;
    }

    // --- STAMPA PER TEST ---
    public void stampaLista() {
        Nodo corr = testa;
        System.out.print("Lista: ");
        while (corr != null) {
            System.out.print(corr.valore + " ");
            corr = corr.successivo;
        }
        System.out.println();
    }
}
