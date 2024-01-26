package com.example.players;

import java.util.HashSet;
import java.util.Set;

import com.example.board.ChessBoard;
import com.example.game.Move;
import com.example.pieces.Piece;

public abstract class Player {
    protected boolean color;
    protected Set<Piece> pieces;

    public Player(boolean color, ChessBoard board) {
        this.color = color;
        pieces = new HashSet<>();
        initalizePlayer(board);
    }

    private void initalizePlayer(ChessBoard board) {
        for (int i=0; i<8; i++) {
            if (color) {
                pieces.add(board.getSquare(7, i).getPiece());
                pieces.add(board.getSquare(6, i).getPiece());
            } else {
                pieces.add(board.getSquare(0, i).getPiece());
                pieces.add(board.getSquare(1, i).getPiece());
            }
        }
    }

    public boolean isColor() {
        return color;
    }
    public void setColor(boolean color) {
        this.color = color;
    }
    public Set<Piece> getPieces() {
        return pieces;
    }
    public void removePiece(Piece piece) {
        pieces.remove(piece);
    }
    public void addPiece(Piece piece) {
        pieces.add(piece);
    }

    public abstract Move makeMove(ChessBoard board);
}
