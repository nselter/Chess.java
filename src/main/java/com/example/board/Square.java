package com.example.board;

import com.example.pieces.Bishop;
import com.example.pieces.King;
import com.example.pieces.Knight;
import com.example.pieces.Pawn;
import com.example.pieces.Piece;
import com.example.pieces.Queen;
import com.example.pieces.Rook;

public class Square {
    private int row;
    private int col;
    private Piece piece;

    public Square(int row, int col, Piece piece) {
        this(row, col);
        this.piece = piece;
    }
    public Square(int row, int col) {
        this.row = row;
        this.col = col;
        this.piece = null;
    }

    public int getRow() {
        return row;
    }
    public void setRow(int row) {
        this.row = row;
    }
    public int getCol() {
        return col;
    }
    public void setCol(int col) {
        this.col = col;
    }
    public Piece getPiece() {
        return piece;
    }
    public void setPiece(Piece piece) {
        this.piece = piece;
    }
    public boolean isEmpty() {
        return piece == null;
    }

    @Override
    public String toString() {
        if (piece == null) return " ";
        else if (piece instanceof Pawn) return piece.getColor() ? "P" : "p";
        else if (piece instanceof Rook) return piece.getColor() ? "R" : "r";
        else if (piece instanceof Knight) return piece.getColor() ? "N" : "n";
        else if (piece instanceof Bishop) return piece.getColor() ? "B" : "b";
        else if (piece instanceof King) return piece.getColor() ? "K" : "k";
        else if (piece instanceof Queen) return piece.getColor() ? "Q" : "q";
        else return "";
    }
    public void removePiece() {
        setPiece(null);
    }
}
