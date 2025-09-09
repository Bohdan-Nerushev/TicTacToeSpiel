



import java.util.Scanner;

public class Main {

    // Enum für Spieler
    enum PLAYER {
        X,
        O
    }

    static int boardSize = 3;
    static char[] board;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Do you want to play? (yes / no) (ja / nein): ");
            String answer = sc.nextLine();

            if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("ja") ) {
                int numberOfFields = fieldSizeGiver(sc);
                System.out.println(startGame(sc, numberOfFields));
            } else if (answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("nein")) {
                sc.close();
                break;
            } else {
                System.out.println("Command not found. Please enter ('yes' or 'no') (ja / nein) .");
            }
        }
    }

    // Feldgröße bestimmen
    public static int fieldSizeGiver(Scanner sc){
        while (true) {
            try {
                System.out.println("Enter the field size (from 3 to 9): ");
                int fieldSize = Integer.parseInt(sc.nextLine());

                if (fieldSize < 3 || fieldSize > 9) {
                    System.out.println("Number must be in the range 3 - 9. Try again.");
                    continue;
                }

                boardSize = fieldSize;
                board = new char[boardSize * boardSize];
                return fieldSize;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number between 3 and 9.");
            }
        }
    }

    // Hauptspielschleife
    public static String startGame(Scanner sc, int n) {
        RowWon rowChecker = new RowWon(); // EIN Objekt für die ganze Spielsession

        while (true) {
            initBoard(n);
            int boardLength = board.length;
            int moves = 0;
            PLAYER currentPlayer = PLAYER.X;

            while (true) {
                printBoard(n);
                System.out.println("Player " + currentPlayer + " is on turn.");
                makeMove(currentPlayer, sc);
                System.out.println();
                moves++;

                char result = checkWin(n);
                if (result == 'X' || result == 'O') {
                    rowChecker.addWin(result);

                    if (rowChecker.hasTripleWin(result)) {
                        printBoard(n);
                        return "Player " + result + " won the game with 3 wins!";
                    } else {
                        System.out.println("Player " + result + " won this round! "
                                + "Score: X=" + rowChecker.getWins('X')
                                + " O=" + rowChecker.getWins('O'));
                        break; // neuer Rundstart
                    }
                }

                if (moves == boardLength) {
                    System.out.println("Draw! Starting new round.");
                    break; // neuer Rundstart, kein Gewinner
                }

                currentPlayer = (currentPlayer == PLAYER.X) ? PLAYER.O : PLAYER.X;
            }
        }
    }

    // Board initialisieren
    public static void initBoard(int n) {
        for (int i = 0; i < n * n; i++) board[i] = '-';
    }

    // Board ausgeben
    public static void printBoard(int n) {
        System.out.println("______".repeat(n));
        int r = 0;
        for (int row = 0; row < n; row++) {
            System.out.print("|");
            for (int col = 0; col < n; col++) {
                int index = row * n + col;
                System.out.print(r + "| " + board[index] + " |");
                r++;
            }
            System.out.println();
            System.out.println("______".repeat(n));
        }
    }

    // Spielerzug machen
    public static void makeMove(PLAYER player, Scanner sc) {
        int boardLength = board.length - 1;
        while (true) {
            try {
                System.out.println("Enter the cell number (0 - " + boardLength + "): ");
                int step = Integer.parseInt(sc.nextLine());

                if (step < 0 || step > boardLength) {
                    System.out.println("Number must be in the range 0 - " + boardLength + ". Try again.");
                    continue;
                }

                if (board[step] == '-') {
                    board[step] = (player == PLAYER.X) ? 'X' : 'O';
                    break;
                } else {
                    System.out.println("This cell is already occupied! Try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number between 0 and " + boardLength + ".");
            }
        }
    }

    // Gewinner prüfen
    public static char checkWin(int n) {
        char[] players = {'X', 'O'};

        for (char player : players) {
            // Reihen
            for (int row = 0; row < n; row++) {
                boolean win = true;
                for (int col = 0; col < n; col++) {
                    if (board[row * n + col] != player) {
                        win = false;
                        break;
                    }
                }
                if (win) return player;
            }

            // Spalten
            for (int col = 0; col < n; col++) {
                boolean win = true;
                for (int row = 0; row < n; row++) {
                    if (board[row * n + col] != player) {
                        win = false;
                        break;
                    }
                }
                if (win) return player;
            }

            // Hauptdiagonale
            boolean winDiag1 = true;
            for (int i = 0; i < n; i++) {
                if (board[i * n + i] != player) {
                    winDiag1 = false;
                    break;
                }
            }
            if (winDiag1) return player;

            // Nebendiagonale
            boolean winDiag2 = true;
            for (int i = 0; i < n; i++) {
                if (board[i * n + (n - 1 - i)] != player) {
                    winDiag2 = false;
                    break;
                }
            }
            if (winDiag2) return player;
        }

        return '-';
    }
}
