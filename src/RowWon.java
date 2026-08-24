public class RowWon {

    private int winsX = 0;
    private int winsO = 0;

    public void addWin(char player) {
        if (player == 'X') {
            winsX++;
        } else if (player == 'O') {
            winsO++;
        }
    }

    public int getWins(char player) {
        if (player == 'X') return winsX;
        if (player == 'O') return winsO;
        return 0;
    }

    public boolean hasTripleWin(char player) {
        return getWins(player) >= 3;
    }

    public void reset() {
        winsX = 0;
        winsO = 0;
    }
}

