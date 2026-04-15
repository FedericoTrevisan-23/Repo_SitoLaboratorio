package es_4_OperazioniConIPolinomi;

// Questa classe rappresenta il singolo nodo della lista concatenata
public class Monomio {
    
    int coefficiente;
    int potenza;
    Monomio next; // puntatore al prossimo nodo 

    public Monomio(int coefficiente, int potenza) {
        this.coefficiente = coefficiente;
        this.potenza = potenza;
        this.next = null; // All'inizio non punta a nulla
    }
}