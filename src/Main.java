import java.util.Scanner;


public class Main {

    static char[][] board = new char[3][3];

    enum PLAYER {
        X,
        O
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Willst du spielen? (ja / nein): ");
            String antwort = sc.nextLine();

            if (antwort.equalsIgnoreCase("ja")) {
                System.out.println(startGame(sc));
            } else if (antwort.equalsIgnoreCase("nein")) {
                sc.close();
                break;
            } else {
                System.out.println("Command not found. Bitte 'ja' oder 'nein' eingeben.");
            }
        }
    }

    public static void initBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    public static void printBoard() {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("|" + board[i][j] + "|");
            }
            System.out.println("\n---------");
        }
    }

    public static void makeMove(PLAYER player, Scanner sc) {
        while (true) {
            try {
                System.out.println("Vertical movement (0 - 2): ");
                int vertical = Integer.parseInt(sc.nextLine());
                System.out.println("Horizontal movement (0 - 2): ");
                int horizontal = Integer.parseInt(sc.nextLine());

                if (vertical < 0 || vertical > 2 || horizontal < 0 || horizontal > 2) {
                    System.out.println("Numbers must be in the range 0 - 2. Try again.");
                    continue;
                }

                if (board[vertical][horizontal] == '-') {
                    board[vertical][horizontal] = (player == PLAYER.X) ? 'X' : 'O';
                    break;
                } else {
                    System.out.println("This cell is already occupied! Try again.");
                }
            }catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number between 0 and 2.");

            }
        }
    }

    public static char checkWin() {
        char[] players = {'X', 'O'};

        for (char player : players) {
            // Check rows
            for (int i = 0; i < 3; i++) {
                if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                    return player;
                }
            }
            // Check columns
            for (int j = 0; j < 3; j++) {
                if (board[0][j] == player && board[1][j] == player && board[2][j] == player) {
                    return player;
                }
            }
            // Check diagonals
            if (board[0][0] == player && board[1][1] == player && board[2][2] == player) return player;
            if (board[0][2] == player && board[1][1] == player && board[2][0] == player) return player;
        }

        return '-';
    }

    public static String startGame(Scanner sc) {
        initBoard();
        int moves = 0;
        PLAYER currentPlayer = PLAYER.X;

        while (true) {
            printBoard();
            System.out.println("Player " + currentPlayer + " ist am Zug.");
            makeMove(currentPlayer, sc);
            System.out.println();
            moves++;

            char result = checkWin();
            if (result == 'X' || result == 'O') {
                return "Player " + result + " won!";
            }

            if (moves == 9) {
                return "Draw!";
            }

            currentPlayer = (currentPlayer == PLAYER.X) ? PLAYER.O : PLAYER.X;
        }
    }
}

