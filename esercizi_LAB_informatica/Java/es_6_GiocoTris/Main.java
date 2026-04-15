import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Node currentNode = new Node();
        GameTree ai = new GameTree();

        System.out.println("GiocoTris:");
        currentNode.printBoard();

        while (!currentNode.isGameOver()) {
            
            int r = -1, c = -1;
            while (true) {
                System.out.print("Inserisci riga (1-3) e colonna (1-3): ");
                if (scanner.hasNextInt()){
                    r = scanner.nextInt();
                } 
                if (scanner.hasNextInt()){
                    c = scanner.nextInt();
                } 

                if (r >= 1 && r < 4 && c >= 1 && c < 4 && currentNode.isCellEmpty(r-1, c-1)) {
                    currentNode.setMove(r-1, c-1, 'X'); 
                    break;
                } else {
                    System.out.println("Mossa non valida. Riprova.");
                    scanner.nextLine(); 
                }
            }
            
            currentNode.printBoard();
            if (currentNode.isGameOver()){
                break;
            } 

            System.out.println("Turno del computer:");
            currentNode = ai.getBestMove(currentNode);
            
            currentNode.printBoard();
        }

        int finalScore = currentNode.getScore();
        if (finalScore == 1) {
            System.out.println("Ha vinto MAX (Utente). Punteggio: +1");
        } else if (finalScore == -1) {
            System.out.println("Ha vinto MIN (Computer). Punteggio: -1");
        } else {
            System.out.println("Pareggio. Punteggio: 0");
        }
        
        scanner.close();
    }
}