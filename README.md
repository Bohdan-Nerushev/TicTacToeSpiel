# Tic-Tac-Toe Game

A console-based Tic-Tac-Toe game written in Java that supports dynamic board sizes and multi-round matches.

## Features

- **Dynamic Board Size**: Play on boards ranging from 3x3 to 9x9.
- **Score Tracking**: First player to win 3 rounds wins the match (tracked by the `RowWon` class).
- **Draw Detection**: Auto-detects draws and starts a new round.
- **Input Validation**: Robust handling of invalid board sizes and moves.

## How to Run

Ensure you have the JDK (Java Development Kit) installed.

1. **Compile the source files:**
   ```bash
   javac src/*.java
   ```

2. **Run the application:**
   ```bash
   java -cp src Main
   ```

## Project Structure

- [Main.java](file:///home/bnerushev/Schreibtisch/Project/my_projects/TicTacToeSpiel/src/Main.java): Contains the main game loop, board rendering, move processing, and victory checks.
- [RowWon.java](file:///home/bnerushev/Schreibtisch/Project/my_projects/TicTacToeSpiel/src/RowWon.java): Manages the match score and tracks when a player reaches 3 wins.
