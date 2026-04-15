package es_2_GiocoCarteUmaniMostri;

public class Main {
    public static void main(String[] args) {
        
        System.out.println("--- INIZIO DEL GIOCO ---");

        Eroe mioEroe = new Eroe();
        Vampiro mioVampiro = new Vampiro();
        Licantropo mioLicantropo = new Licantropo(true); 

        // Faccio combattere tre volte l'Eroe 
        System.out.println("\nTurno dell'Eroe:");
        mioEroe.combatti();
        mioEroe.combatti();
        mioEroe.combatti();

        // Faccio combattere (azzannare) una volta il Vampiro 
        System.out.println("\nTurno del Vampiro:");
        mioVampiro.azzanna();

        // 4. Faccio combattere il Licantropo due volte 
        System.out.println("\nTurno del Licantropo:");
        mioLicantropo.combatti();
        mioLicantropo.combatti();

        // 5. Stampa al termine la forza fisica rimasta a ciascun personaggio 
        System.out.println("\n--- RISULTATI FINALI ---");
        System.out.println(mioEroe.getForza());
        System.out.println(mioVampiro.getForza());
        System.out.println(mioLicantropo.getForza());
    }
}
