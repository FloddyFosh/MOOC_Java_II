/*
 * Copyright 2022 Chris Bakker.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ticTacToe.domain;

import java.util.Arrays;

/**
 *
 * @author Chris Bakker
 */
public class TicTacToe {
    public enum Player {NONE, X, O}
    
    private final Player[][] board;
    private Player turn;
    private Player winner;
    private int turncount;

    public TicTacToe() {
        this.turn = Player.X;
        this.winner = Player.NONE;
        this.board = new Player[3][3];
        this.turncount = 9;
        clearBoard();
    }
    
    public Player getTurn() {
        return this.turn;
    }
    
    public boolean hasWinner() {
        return this.winner != Player.NONE || turncount <= 0;
    }
    
    public Player getWinner() {
        return this.winner;
    }
    
    public boolean placeSymbol(int x, int y) {
        if (x < 0 || x > 2 || y < 0 || y > 2) {
            throw new IllegalArgumentException("The x and y parameters must be within 0 and 2 (inclusive)");
        }
        
        if (hasWinner()) return false;
        if (board[x][y] != Player.NONE) return false;
            
        board[x][y] = turn;
        updateWinner();
        nextTurn();
        return true;
    }
    
    private void clearBoard() {
        Arrays.stream(board).forEach(a -> Arrays.fill(a, Player.NONE));
    }
    
    private void nextTurn() {
        if (!hasWinner()) {
            if (turn == Player.O) {
                turn = Player.X;
            } else if (turn == Player.X) {
                turn = Player.O;
            } 
            turncount--;
        }
    }
    
    private void updateWinner() {
        if (hasWinner()) return;
        
        Player newWinner = Player.NONE;

        //horizontals
        for (int i = 0; i < 3; i++) {
            if (board[0][i] != Player.NONE && board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
                if(newWinner == Player.NONE) {
                    newWinner = board[0][i];
                } else if (newWinner != board[0][i]) {
                    throw new IllegalStateException("Both players have won in this board state.");
                }
            }
        }
        
        //verticals
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != Player.NONE && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                if(newWinner == Player.NONE) {
                    newWinner = board[i][0];
                } else if (newWinner != board[i][0]) {
                    throw new IllegalStateException("Both players have won in this board state.");
                }
            }
        }
        
        //diagonals
        for (int i = 0; i < 2; i++) {
            if (board[1][1] != Player.NONE && board[i*2][0] == board[1][1] && board[1][1] == board[2-(i*2)][2]) {
                if(newWinner == Player.NONE) {
                    newWinner = board[1][1];
                } else if (newWinner != board[1][1]) {
                    throw new IllegalStateException("Both players have won in this board state.");
                }
            }
        }
        
        this.winner = newWinner;
    }
}
