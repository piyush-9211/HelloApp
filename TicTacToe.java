
public class TicTacToe {

    static char[][] board = {
            {'X', '-', '-'},
            {'-', 'O', '-'},
            {'-', '-', '-'}
    };


    public static void main(String[] args) {

        int row = 1;
        int col = 0;

        if (isValidMove(row, col)) {

            System.out.println("Valid move");

        } else {

            System.out.println("Invalid move");
        }
    }

    static boolean isValidMove(int row, int col) {

        // Check boundaries
        if (row < 0 || row > 2 || col < 0 || col > 2) {

            return false;
        }

        if (board[row][col] != '-') {

            return false;
        }

        return true;
    }
}