public class RowWon {

    private int winsX = 0;
    private int winsO = 0;

    // Додати перемогу гравцю
    public void addWin(char player) {
        if (player == 'X') {
            winsX++;
        } else if (player == 'O') {
            winsO++;
        }
    }

    // Отримати кількість перемог
    public int getWins(char player) {
        if (player == 'X') return winsX;
        if (player == 'O') return winsO;
        return 0;
    }

    // Перевірити чи гравець досяг 3 перемог
    public boolean hasTripleWin(char player) {
        return getWins(player) >= 3;
    }

    // Скинути статистику (нова гра)
    public void reset() {
        winsX = 0;
        winsO = 0;
    }
}

