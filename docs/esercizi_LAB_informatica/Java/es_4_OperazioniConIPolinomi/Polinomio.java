package es_4_OperazioniConIPolinomi;

public class Polinomio {
    
    private Monomio testa; // Il primo elemento della lista

    public Polinomio() {
        this.testa = null; // Lista vuota all'inizio
    }

    // Metodo per inserire un nuovo monomio
    // Li inserisco mantenendo la lista ordinata per potenza (dalla più grande alla più piccola)
    public void inserisciMonomio(int coeff, int pot) {
        if (coeff == 0) return; // Un monomio con coefficiente 0 non ha senso di esistere

        Monomio nuovo = new Monomio(coeff, pot);

        // Caso 1: Lista vuota o il nuovo monomio ha la potenza più grande di tutti (diventa la nuova testa)
        if (testa == null || testa.potenza < pot) {
            nuovo.next = testa;
            testa = nuovo;
            return;
        }

        // Caso 2: Scorro la lista per trovare la posizione giusta
        Monomio corr = testa;
        Monomio prec = null;

        while (corr != null && corr.potenza >= pot) {
            // Se trovo una potenza identica, non creo un nuovo nodo ma sommo i coefficienti
            // (es. se ho 3x^2 e inseriscoo 2x^2, diventa 5x^2)
            if (corr.potenza == pot) {
                corr.coefficiente += coeff;
                // Se sommandoli si annullano (es. 5x^2 - 5x^2 = 0), elimino il nodo
                if (corr.coefficiente == 0) {
                    rimuoviMonomio(pot); 
                }
                return;
            }
            prec = corr;
            corr = corr.next;
        }

        // Lo aggancio in mezzo o in fondo alla lista
        nuovo.next = corr;
        prec.next = nuovo;
    }

    // Individua un monomio in base alla potenza
    public Monomio trovaMonomio(int pot) {
        Monomio corr = testa;
        while (corr != null) {
            if (corr.potenza == pot) return corr; // Trovato
            if (corr.potenza < pot) break; // Inutile continuare, la lista è ordinata a scendere!
            corr = corr.next;
        }
        return null; // Non trovato
    }

    // Togliere monomi in base alla potenza
    public void rimuoviMonomio(int pot) {
        if (testa == null) return;

        // Se è proprio la testa da eliminare
        if (testa.potenza == pot) {
            testa = testa.next;
            return;
        }

        // Altrimenti scorro la lista
        Monomio corr = testa;
        Monomio prec = null;

        while (corr != null && corr.potenza != pot) {
            prec = corr;
            corr = corr.next;
        }

        // Se l'ho trovato, lo "salto" sganciandolo
        if (corr != null) {
            prec.next = corr.next;
        }
    }

    // Ridurre la potenza di tutti i monomi dello stesso valore (utile per la scomposizione)
    public void riduciPotenze(int valore) {
        Monomio corr = testa;
        while (corr != null) {
            corr.potenza -= valore;
            corr = corr.next;
        }
    }

    // Metodo per restituire la potenza più piccola (l'ultimo nodo della lista)
    public int getPotenzaMinima() {
        if (testa == null) return 0;
        Monomio corr = testa;
        while (corr.next != null) {
            corr = corr.next;
        }
        return corr.potenza;
    }

    // Stampa formato lista es: (4,8) -> (-5,4) -> NULL
    public String stampaStrutturaLista() {
        String s = "";
        Monomio corr = testa;
        while (corr != null) {
            s += "(" + corr.coefficiente + "," + corr.potenza + ") -> ";
            corr = corr.next;
        }
        s += "NULL";
        return s;
    }

    // Stampa formato matematico es: 4x^8 - 5x^4 + 8
    public String stampaMatematica() {
        if (testa == null) return "0";
        String s = "";
        Monomio corr = testa;
        while (corr != null) {
            // Gestione dei segni + e - per renderlo carino da leggere
            if (corr.coefficiente > 0 && corr != testa) s += " + ";
            else if (corr.coefficiente < 0 && corr != testa) {
                s += " - ";
            } else if (corr.coefficiente < 0 && corr == testa) {
                s += "-";
            }
            
            s += Math.abs(corr.coefficiente);
            
            if (corr.potenza > 0) s += "x^" + corr.potenza;
            
            corr = corr.next;
        }
        return s;
    }

    // Questo ci serve per non rovinare i polinomi originali durante le operazioni
    public Polinomio copia() {
        Polinomio nuovo = new Polinomio();
        Monomio corr = testa;
        while (corr != null) {
            nuovo.inserisciMonomio(corr.coefficiente, corr.potenza);
            corr = corr.next;
        }
        return nuovo;
    }
    
    public Monomio getTesta() { return testa; }
}
