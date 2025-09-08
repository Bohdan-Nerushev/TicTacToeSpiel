Tic-Tac-Toe Game / Tic-Tac-Toe Spiel / Гра "Хрестики-Нулики"
Опис / Description / Beschreibung

English:
This is a console-based Tic-Tac-Toe game written in Java. Players can choose the board size (from 3x3 up to 9x9) and take turns making moves. The game checks for row, column, and diagonal wins and announces the winner or a draw. Additionally, a RowWon class tracks local 3-in-a-row wins during gameplay.

Deutsch:
Dies ist ein Konsolen-basiertes Tic-Tac-Toe-Spiel, geschrieben in Java. Spieler können die Größe des Spielfeldes wählen (von 3x3 bis 9x9) und abwechselnd Züge machen. Das Spiel prüft Reihen-, Spalten- und Diagonalgewinne und gibt den Gewinner oder ein Unentschieden aus. Zusätzlich verfolgt die Klasse RowWon lokale 3-in-einer-Reihe-Gewinne während des Spiels.

Українська:
Це консольна гра "Хрестики-Нулики", написана на Java. Гравці можуть обирати розмір поля (від 3x3 до 9x9) та робити ходи по черзі. Гра перевіряє виграші по рядках, колонках та діагоналях і повідомляє про переможця або нічію. Додатково клас RowWon відслідковує локальні перемоги 3-в-ряд під час гри.

Функціонал / Features / Funktionen

Dynamic board size / Dynamische Feldgröße / Динамічний розмір поля
Players can select a field size between 3x3 and 9x9.

Turn-based gameplay / Rundenbasiertes Spiel / Гра по черзі
Players take turns entering the number of the cell where they want to make a move.

Win detection / Gewinnprüfung / Перевірка перемоги
Checks for wins in rows, columns, main and secondary diagonals.

Local 3-in-a-row tracking / Lokale 3er-Reihen / Відслідковування 3-в-ряд
The RowWon class monitors sequences of 3 symbols for X or O during gameplay.

Draw detection / Unentschieden / Нічия
If all cells are filled without a winner, the game ends in a draw.

User-friendly console prompts / Benutzerfreundliche Konsolenaufforderungen / Зручні повідомлення в консолі
Input is validated and clear messages guide players throughout the game.

Інструкція з запуску / How to Run / Anleitung zur Ausführung

English:

Install Java Development Kit (JDK).

Save the Main.java file (and RowWon.java if separated).

Compile the code:

javac Main.java
javac RowWon.java


Run the program:

java Main


Follow console instructions to play the game.

Deutsch:

Installieren Sie das Java Development Kit (JDK).

Speichern Sie die Datei Main.java (und RowWon.java, falls separat).

Kompilieren Sie den Code:

javac Main.java
javac RowWon.java


Führen Sie das Programm aus:

java Main


Folgen Sie den Anweisungen in der Konsole, um das Spiel zu spielen.

Українська:

Встановіть Java Development Kit (JDK).

Збережіть файл Main.java (та RowWon.java, якщо окремо).

Скомпілюйте код:

javac Main.java
javac RowWon.java


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

checkWin() / checkWin() / checkWin() – перевірка на перемогу на всьому полі.

RowWon class / Klasse RowWon / Клас RowWon – відслідковує локальні 3-в-ряд для кожного гравця.

wonListAdd(char player) – додає символ гравця до списку.

renoviereList() – очищає список ходів.

check() – перевіряє, чи є 3-в-ряд.

charCheckWin(char player) – додає символ та повертає переможця локальної 3-в-ряд гри, якщо він є.

startGame() / startGame() / startGame() – запуск гри, хід по черзі та інтеграція з RowWon для локальної перевірки.
