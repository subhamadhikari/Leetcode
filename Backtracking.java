public class Backtracking {
    static int N = 5;

    // DO IT AGAIN
    public static void main(String[] args) {
        int board[][] = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = 0;
            }
        }
        nQueen(board, 0);

        // ----------------------------------
        int sudoku[][] = { { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
                { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
                { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
                { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
                { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
                { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
                { 0, 0, 5, 2, 0, 6, 3, 0, 0 } };
    }
    // N-Queen Problem

    static boolean nQueen(int board[][], int row) {
        if (row == N) {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < row; j++) {
                    System.out.print(" " + board[i][j] + " ");
                }
                System.out.println("");
            }
            return true;
        }

        for (int col = 0; col < N; col++) {
            if (isSafe(row, col, board)) {
                board[row][col] = 1;
                if (nQueen(board, row + 1)) {
                    return true;
                }
                board[row][col] = 0; // this line is doing backtracking.
            }
        }

        return false;
    }

    static boolean isSafe(int row, int col, int[][] b) {
        // for upper-vertical
        for (int i = row; i >= 0; i--) {
            if (b[i][col] == 1) {
                return false;
            }
        }

        // for upper-left diagonal
        int j = col;
        for (int i = row; i >= 0 && j >= 0; i--, j--) {
            if (b[i][j] == 1) {
                return false;
            }
        }

        // for upper-right diagonal
        j = col;
        for (int i = row; i >= 0 && j < b.length; i--, j++) {
            if (b[i][j] == 1)
                return false;
        }

        return true;
    }

    // Sudoku Solver

}
