import java.util.Scanner;

public class Main {

    // Enum für Spieler
    // Enum for players
    // Перерахування для гравців
    enum PLAYER {
        X,
        O
    }

    static int boardSize = 3; // Größe des Spielfelds NxN / Board size NxN / Розмір поля NxN
    static char[] board;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Do you want to play? (yes / no): ");
            String answer = sc.nextLine();

            if (answer.equalsIgnoreCase("yes")) {
                int numberOfFields = fieldSizeGiver(sc); // Spielfeldgröße bestimmen / Get field size / Визначити розмір поля
                System.out.println(startGame(sc, numberOfFields)); // Spiel starten / Start game / Розпочати гру

            } else if (answer.equalsIgnoreCase("no")) {
                sc.close();
                break; // Beenden / Exit / Вийти
            } else {
                System.out.println("Command not found. Please enter 'yes' or 'no'.");
            }
        }
    }

    // Methode um die Feldgröße zu bekommen
    // Method to get field size
    // Метод для отримання розміру поля
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
                board = new char[boardSize * boardSize]; // Array für das Spielfeld erstellen / Create array / Створити масив для поля

                return fieldSize;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number between 3 and 9.");
            }
        }
    }

    // Spielfeld initialisieren
    // Initialize board
    // Ініціалізація поля
    public static void initBoard(int n) {
        for (int i = 0; i < n * n; i++) board[i] = '-'; // Mit '-' füllen / Fill with '-' / Заповнити дефісами
    }

    // Spielfeld ausgeben
    // Print board
    // Вивід дошки
    public static void printBoard(int n) {
        System.out.println("_____".repeat(n));
        int r = 0; // Zähler für Zellen / Cell counter / Лічильник клітинок
        for (int row = 0; row < n; row++) {
            System.out.print("|");
            for (int col = 0; col < n; col++) {
                int index = row * n + col;
                System.out.print(r + "| " + board[index] + "|");
                r++;
            }
            System.out.println();
            System.out.println("_____".repeat(n));
        }
    }

    // Einen Spielzug machen
    // Make a move
    // Зробити хід
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
    // Check winner
    // Перевірка переможця
    public static char checkWin(int n) {
        char[] players = {'X', 'O'};

        for (char player : players) {

            // Reihen prüfen / Check rows / Перевірка рядків
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

            // Spalten prüfen / Check columns / Перевірка колонок
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

            // Hauptdiagonale prüfen / Check main diagonal / Перевірка головної діагоналі
            boolean winDiag1 = true;
            for (int i = 0; i < n; i++) {
                if (board[i * n + i] != player) {
                    winDiag1 = false;
                    break;
                }
            }
            if (winDiag1) return player;

            // Nebendiagonale prüfen / Check secondary diagonal / Перевірка побічної діагоналі
            boolean winDiag2 = true;
            for (int i = 0; i < n; i++) {
                if (board[i * n + (n - 1 - i)] != player) {
                    winDiag2 = false;
                    break;
                }
            }
            if (winDiag2) return player;
        }

        return '-'; // Kein Gewinner / No winner / Переможця немає
    }

    // Spiel starten / Start game / Розпочати гру
    public static String startGame(Scanner sc, int n) {
        initBoard(n);

        int boardLength = board.length;
        int moves = 0;
        PLAYER currentPlayer = PLAYER.X;

        while (true) {
            printBoard(n);
            System.out.println("Player " + currentPlayer + " is on turn."); // Spieler am Zug / Player on turn / Гравець на ході
            makeMove(currentPlayer, sc);
            System.out.println();
            moves++;

            char result = checkWin(n);
            if (result == 'X' || result == 'O') {
                return "Player " + result + " won!"; // Spieler hat gewonnen / Player won / Гравець виграв
            }

            if (moves == boardLength) {
                return "Draw!"; // Unentschieden / Draw / Нічия
            }

            // Spieler wechseln / Switch player / Змінити гравця
            currentPlayer = (currentPlayer == PLAYER.X) ? PLAYER.O : PLAYER.X;
        }
    }
}


