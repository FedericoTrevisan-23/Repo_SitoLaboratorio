public class GameTree {
    
    public Node getBestMove(Node currentState) {
        if (currentState.isCellEmpty(1, 1)) {
            Node centerMove = new Node(currentState.getBoard());
            centerMove.setMove(1, 1, 'O');
            return centerMove;
        }

        int bestVal = 1000; 
        Node bestNode = null;

        Node[] children = currentState.getChildren('O');
        
        for (Node child : children) {
            int moveVal = minimax(child, true);
            
            if (moveVal < bestVal) {
                bestVal = moveVal;
                bestNode = child;
            }
        }
        return bestNode;
    }

    private int minimax(Node node, boolean isMaximizing) {
        int score = node.getScore();

        if (score == 1) {
            return 1;
        }

        if (score == -1) {
            return -1;
        }
        
        
        if (node.isGameOver()){
            return 0;
        }  

        if (isMaximizing) {
            int best = -1000;
            Node[] children = node.getChildren('X');
            for (Node child : children) {
                best = Math.max(best, minimax(child, false));
            }
            return best;
        } else {
            int best = 1000;
            Node[] children = node.getChildren('O');
            for (Node child : children) {
                best = Math.min(best, minimax(child, true));
            }
            return best;
        }
    }
}