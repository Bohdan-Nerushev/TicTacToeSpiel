

import java.util.ArrayList;
import java.util.Arrays;

public class RowWon {

    // Liste für 3er-Reihen von X / List for 3-in-a-row X / Список для 3-х символів X
    private ArrayList<Character> listWonX = new ArrayList<>(Arrays.asList('X','X','X'));

    // Liste für 3er-Reihen von O / List for 3-in-a-row O / Список для 3-х символів O
    private ArrayList<Character> listWonO = new ArrayList<>(Arrays.asList('O','O','O'));

    // Liste der aktuellen gespielten Symbole / List of currently played symbols / Список поточних ходів
    private ArrayList<Character> wonList = new ArrayList<>();

    // Ein neues Symbol zum wonList hinzufügen / Add a new symbol to wonList / Додати новий символ до списку
    public void wonListAdd(char player) {
        this.wonList.add(player);
    }

    // wonList zurücksetzen / Clear wonList / Очистити список ходів
    public void renoviereList() {
        this.wonList.clear();
    }

    // Überprüfen, ob eine 3er-Reihe erreicht wurde / Check if a 3-in-a-row is reached / Перевірка перемоги за 3 ходи
    public char check() {
        if (wonList.equals(listWonX)) { // Prüfen auf X-Reihe / Check X row / Перевірка ряду X
            return 'X';
        } else if (wonList.equals(listWonO)) { // Prüfen auf O-Reihe / Check O row / Перевірка ряду O
            return 'O';
        }
        return '\0'; // Kein Gewinner / No winner / Немає переможця
    }

    // Spielerzug hinzufügen und prüfen, ob 3er-Reihe erreicht wurde / Add player move and check 3-in-a-row / Додати хід гравця і перевірити 3 в ряд
    public char charCheckWin(char player) {
        wonListAdd(player); // Spieler zum wonList hinzufügen / Add player to wonList / Додати символ гравця до списку

        if (wonList.size() == 3) { // Wenn 3 Symbole erreicht / If 3 symbols reached / Якщо список містить 3 елементи
            char winner = check(); // Überprüfen auf Gewinner / Check for winner / Перевірити переможця
            if (winner != '\0') { // Wenn Gewinner vorhanden / If winner exists / Якщо є переможець
                return winner;
            }
        }

        if (wonList.size() > 3) { // Sicherheit: Liste überschritten / Safety: list exceeded / Безпека: список перевищено
            System.out.println("Ніхто не виграв за три ходи!"); // Nachricht / Message / Повідомлення
            renoviereList(); // Liste zurücksetzen / Clear list / Очистити список
        }

        return '\0'; // Noch kein Gewinner / No winner yet / Ще немає переможця
    }
}
