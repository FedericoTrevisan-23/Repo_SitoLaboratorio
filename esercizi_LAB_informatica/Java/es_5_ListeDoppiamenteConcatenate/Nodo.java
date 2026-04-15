package es_5_ListeDoppiamenteConcatenate;

public class Nodo {
    int valore;
    Nodo precedente; // Puntatore a chi sta dietro
    Nodo successivo; // Puntatore a chi sta davanti

    public Nodo(int valore) {
        this.valore = valore;
        this.precedente = null;
        this.successivo = null;
    }
}
