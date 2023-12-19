package com.example.application;

public class TicTacToeGame {

    private final String EMPTY_CELL = " ";
    private String currentPlayer = "X"; // "X" starts first
    private String[][] board = {
            {EMPTY_CELL, EMPTY_CELL, EMPTY_CELL},
            {EMPTY_CELL, EMPTY_CELL, EMPTY_CELL},
            {EMPTY_CELL, EMPTY_CELL, EMPTY_CELL}
    };

    public String getCurrentPlayerSymbol() {
        return currentPlayer;
    }


    public void makeMove(int row, int col) {
        // Verificar si la celda está vacía
        if (board[row][col].equals(EMPTY_CELL)) {
            // Establecer el símbolo del jugador actual en la celda
            board[row][col] = currentPlayer;

            // Cambiar al otro jugador
            currentPlayer = (currentPlayer.equals("X")) ? "O" : "X";
        }
    }

    public String getCellValue(int row, int col) {
        return board[row][col];
    }

    public boolean isGameWon() {
        // Verificar filas
        for (int row = 0; row < 3; row++) {
            if (checkRowCol(board[row][0], board[row][1], board[row][2])) {
                return true;
            }
        }

        // Verificar columnas
        for (int col = 0; col < 3; col++) {
            if (checkRowCol(board[0][col], board[1][col], board[2][col])) {
                return true;
            }
        }

        // Verificar diagonales
        if (checkRowCol(board[0][0], board[1][1], board[2][2]) || checkRowCol(board[0][2], board[1][1], board[2][0])) {
            return true;
        }

        return false;
    }

    private boolean checkRowCol(String c1, String c2, String c3) {
        return (!c1.equals(EMPTY_CELL) && c1.equals(c2) && c1.equals(c3));
    }


    public boolean isGameTie() {
        // Verificar si todas las celdas están ocupadas
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board[row][col].equals(EMPTY_CELL)) {
                    // Todavía hay al menos una celda vacía, el juego no está en empate
                    return false;
                }
            }
        }

        // Si no hay celdas vacías, el juego está en empate
        return true;
    }

    public void switchPlayer() {
        currentPlayer = (currentPlayer.equals("O")) ? "O" : "X";
    }

    public void resetGame() {
        // Reinicia el tablero
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] = EMPTY_CELL;
            }
        }

        // Reinicia el símbolo del jugador actual
        currentPlayer = "X"; // o "O" según prefieras
    }


}
