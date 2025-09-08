Tic-Tac-Toe Game / Tic-Tac-Toe Spiel / Гра "Хрестики-Нулики"
Опис / Description / Beschreibung

English:
This is a console-based Tic-Tac-Toe game written in Java. Players can choose the board size (from 3x3 up to 9x9) and take turns making moves. The game checks for row, column, and diagonal wins and announces the winner or a draw.

Deutsch:
Dies ist ein Konsolen-basiertes Tic-Tac-Toe-Spiel, geschrieben in Java. Spieler können die Größe des Spielfeldes wählen (von 3x3 bis 9x9) und abwechselnd Züge machen. Das Spiel prüft Reihen-, Spalten- und Diagonalgewinne und gibt den Gewinner oder ein Unentschieden aus.

Українська:
Це консольна гра "Хрестики-Нулики", написана на Java. Гравці можуть обирати розмір поля (від 3x3 до 9x9) та робити ходи по черзі. Гра перевіряє виграші по рядках, колонках та діагоналях і повідомляє про переможця або нічію.

Функціонал / Features / Funktionen

Dynamic board size

Players can select a field size between 3x3 and 9x9.

Turn-based gameplay

Players take turns entering the number of the cell where they want to make a move.

Win detection

Checks for wins in rows, columns, main and secondary diagonals.

Draw detection

If all cells are filled without a winner, the game ends in a draw.

User-friendly console prompts

Input is validated and clear messages guide players throughout the game.

Інструкція з запуску / How to Run / Anleitung zur Ausführung

English:

Install Java Development Kit (JDK).

Save the Main.java file.

Compile the code:

javac Main.java


Run the program:

java Main


Follow console instructions to play the game.

Deutsch:

Installieren Sie das Java Development Kit (JDK).

Speichern Sie die Datei Main.java.

Kompilieren Sie den Code:

javac Main.java


Führen Sie das Programm aus:

java Main


Folgen Sie den Anweisungen in der Konsole, um das Spiel zu spielen.

Українська:

Встановіть Java Development Kit (JDK).

Збережіть файл Main.java.

Скомпілюйте код:

javac Main.java


Запустіть програму:

java Main


Дотримуйтесь інструкцій у консолі, щоб грати.

Структура коду / Code Structure / Code-Struktur

Enum PLAYER / Перерахування PLAYER / Enum PLAYER – представляє гравців X і O.

boardSize / boardSize / boardSize – розмір поля NxN.

board / board / board – масив символів для ігрового поля.

main() / main() / main() – головний метод, який запускає гру та опитує користувача.

fieldSizeGiver() / fieldSizeGiver() / fieldSizeGiver() – метод для визначення розміру поля.

initBoard() / initBoard() / initBoard() – ініціалізація поля дефісами '-'.

printBoard() / printBoard() / printBoard() – вивід поточного стану поля.

makeMove() / makeMove() / makeMove() – метод для здійснення ходу гравцем.

checkWin() / checkWin() / checkWin() – перевірка на перемогу.

startGame() / startGame() / startGame() – запуск гри та логіка по черзі для гравців.
