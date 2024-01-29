package com.example.game;

import java.util.Scanner;

import com.example.board.ChessBoard;
import com.example.pieces.Piece;
import com.example.players.ComputerPlayer;
import com.example.players.HumanPlayer;
import com.example.players.Player;

public class Game {
    private ChessBoard board;
    private Player player1;
    private Player player2;
    private Player winner;
    
    public Game(int gameMode, boolean p1White, Scanner scanner) {
        this.board = new ChessBoard();
        this.player1 = new HumanPlayer(p1White, board, scanner);
        if (gameMode==0) {
            this.player2 = new HumanPlayer(!p1White, board, scanner);
        } else {
            this.player1 = new ComputerPlayer(!p1White, board);
        }

        board.addKings(player1, player2);
        player1.addKings(board);
        player2.addKings(board);
    }

    public void play() {
        boolean p1turn = player1.getColor();
        while (!isGameOver()) {
            board.print();
            Move move;
            if (p1turn) {
                move = player1.makeMove(board);
                Piece capturedPiece = move.makeMove(board);
                if (capturedPiece != null) player2.getPieces().remove(capturedPiece);
            } else {
                move = player2.makeMove(board);
                Piece capturedPiece = move.makeMove(board);
                if (capturedPiece != null) player1.getPieces().remove(capturedPiece);
            }

            p1turn = !p1turn;
        }
    }

    private boolean isGameOver() {
        if (player1.getKing().inCheck(board) && !player1.getKing().canMove(board)) {
            winner = player2;
            return true;
        } else if (player2.getKing().inCheck(board) && !player2.getKing().canMove(board)) {
            winner = player1;
            return true;
        }
        return false;
    }
}
