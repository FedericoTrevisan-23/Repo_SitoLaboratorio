public class Node {
    private char[][] board;

    public Node() {
        board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public Node(char[][] boardToCopy) {
        this.board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.board[i][j] = boardToCopy[i][j];
            }
        }
    }

    public char[][] getBoard() {
        return board;
    }

    public void setMove(int row, int col, char player) {
        board[row][col] = player;
    }

    public boolean isCellEmpty(int row, int col) {
        return board[row][col] == ' ';
    }

    public int countEmpty() {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                count++;
                }
            }
        }
        return count;
    }

    public Node[] getChildren(char player) {
        int emptySpots = countEmpty();
        Node[] children = new Node[emptySpots];
        int index = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    Node child = new Node(this.board);
                    child.setMove(i, j, player);
                    children[index] = child;
                    index++;
                }
            }
        }
        return children;
    }

    public boolean isGameOver() {
        return getScore() != 0 || isFull();
    }

    private boolean isFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' '){
                return false;
                } 
            }
        }
        return true;
    }

    public int getScore() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != ' ' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                return board[i][0] == 'X' ? 1 : -1; 
            }
        }
        for (int i = 0; i < 3; i++) {
            if (board[0][i] != ' ' && board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
                return board[0][i] == 'X' ? 1 : -1;
            }
        }
        if (board[0][0] != ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            return board[0][0] == 'X' ? 1 : -1;
        }
        if (board[0][2] != ' ' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            return board[0][2] == 'X' ? 1 : -1;
        }
        
        return 0; 
    }

    public void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }
}