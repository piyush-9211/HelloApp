import java.util.Random;
import java.util.Scanner;

/**
 * TicTacToe
 * UC8 implements a continuous turn-based game loop.
 */
public class TicTacToe {

    static char[][] board = {
            {'-', '-', '-'},
            {'-', '-', '-'},
            {'-', '-', '-'}
    };

    static boolean isHumanTurn = true;

    static Scanner sc = new Scanner(System.in);

    /**
     * Entry point of the program.
     */
    public static void main(String[] args) {

        while (true) {

            printBoard();

            if (isHumanTurn) {

                System.out.println("Human Turn");

                int slot = getUserSlot();

                int row = getRowFromSlot(slot);
                int col = getColFromSlot(slot);

                if (isValidMove(row, col)) {

                    placeMove(row, col, 'X');

                    if (checkWin('X')) {

                        printBoard();
                        System.out.println("Human Wins!");
                        break;
                    }

                    isHumanTurn = false;

                } else {

                    System.out.println("Invalid Move");
                }

            } else {

                System.out.println("Computer Turn");

                computerMove();

                if (checkWin('O')) {

                    printBoard();
                    System.out.println("Computer Wins!");
                    break;
                }

                isHumanTurn = true;
            }

            if (isBoardFull()) {

                printBoard();
                System.out.println("Match Draw!");
                break;
            }
        }
    }

    /**
     * Reads user slot input.
     */
    static int getUserSlot() {

        System.out.print("Enter slot (1-9): ");

        return sc.nextInt();
    }

    /**
     * Converts slot to row index.
     */
    static int getRowFromSlot(int slot) {

        return (slot - 1) / 3;
    }

    /**
     * Converts slot to column index.
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
     * Places move on board.
     */
    static void placeMove(int row, int col, char symbol) {

        board[row][col] = symbol;
    }

    /**
     * Computer generates random move.
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
     * Checks win condition.
     */
    static boolean checkWin(char symbol) {

        for (int i = 0; i < 3; i++) {

            if (board[i][0] == symbol &&
                board[i][1] == symbol &&
                board[i][2] == symbol) {

                return true;
            }

            if (board[0][i] == symbol &&
                board[1][i] == symbol &&
                board[2][i] == symbol) {

                return true;
            }
        }

        if (board[0][0] == symbol &&
            board[1][1] == symbol &&
            board[2][2] == symbol) {

            return true;
        }

        if (board[0][2] == symbol &&
            board[1][1] == symbol &&
            board[2][0] == symbol) {

            return true;
        }

        return false;
    }

    /**
     * Checks whether board is full.
     */
    static boolean isBoardFull() {

        for (int row = 0; row < 3; row++) {

            for (int col = 0; col < 3; col++) {

                if (board[row][col] == '-') {

                    return false;
                }
            }
        }

        return true;
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