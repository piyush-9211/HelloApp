/**
 * TicTacToe
 * UC10 detects draw condition in the game.
 */
public class TicTacToe {

    static char[][] board = {
            {'X', 'O', 'X'},
            {'X', 'O', 'O'},
            {'O', 'X', 'X'}
    };

    /**
     * Entry point of the program.
     */
    public static void main(String[] args) {

        if (isDraw()) {

            System.out.println("Match Draw!");

        } else {

            System.out.println("Moves Still Available");
        }
    }

    /**
     * Checks whether board is full
     * and no empty cells remain.
     */
    static boolean isDraw() {

        for (int row = 0; row < 3; row++) {

            for (int col = 0; col < 3; col++) {

                if (board[row][col] == '-') {

                    return false;
                }
            }
        }

        return true;
    }
}