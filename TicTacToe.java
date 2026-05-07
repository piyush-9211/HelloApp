import java.util.Random;

/**
 * TicTacToe
 * UC7 allows the computer to make a random valid move.
 */
public class TicTacToe {

    static char[][] board = {
            {'X', '-', '-'},
            {'-', 'O', '-'},
            {'-', '-', '-'}
    };

    /**
     * Entry point of the program.
     */
    public static void main(String[] args) {

        System.out.println("Board Before Computer Move:");
        printBoard();

        computerMove();

        System.out.println("Board After Computer Move:");
        printBoard();
    }

    /**
     * Generates a random valid move for the computer.
     */
    static void computerMove() {

        Random random = new Random();

        while (true) {

            int slot = random.nextInt(9) + 1;

            int row = getRowFromSlot(slot);
            int col = getColFromSlot(slot);

            if (isValidMove(row, col)) {

                placeMove(row, col, 'O');

                System.out.println("Computer selected slot: " + slot);

                break;
            }
        }
    }

    /**
     * Converts slot number to row index.
     */
    static int getRowFromSlot(int slot) {

        return (slot - 1) / 3;
    }

    /**
     * Converts slot number to column index.
     */
    static int getColFromSlot(int slot) {

        return (slot - 1) % 3;
    }

    /**
     * Checks whether move is valid.
     */
    static boolean isValidMove(int row, int col) {

        if (row < 0 || row > 2 || col < 0 || col > 2) {

            return false;
        }

        return board[row][col] == '-';
    }

    /**
     * Places symbol on board.
     */
    static void placeMove(int row, int col, char symbol) {

        board[row][col] = symbol;
    }

    /**
     * Prints board.
     */
    static void printBoard() {

        System.out.println("-------------");

        for (int row = 0; row < 3; row++) {

            for (int col = 0; col < 3; col++) {

                System.out.print("| " + board[row][col] + " ");
            }

            System.out.println("|");
            System.out.println("-------------");
        }
    }
}