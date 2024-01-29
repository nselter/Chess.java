package com.example.game;

import com.example.board.ChessBoard;
import com.example.board.Square;
import com.example.pieces.Piece;

public class Move {
    private Square sourceSquare;
    private Square destinationSquare;
    private Piece movedPiece;
    
    public Move(Square sourceSquare, Square destinationSquare) {
        this.sourceSquare = sourceSquare;
        this.destinationSquare = destinationSquare;
        this.movedPiece = sourceSquare.getPiece();
    }

    public Square getSourceSquare() {
        return sourceSquare;
    }
    public void setSourceSquare(Square sourceSquare) {
        this.sourceSquare = sourceSquare;
    }
    public Square getDestinationSquare() {
        return destinationSquare;
    }
    public void setDestinationSquare(Square destinationSquare) {
        this.destinationSquare = destinationSquare;
    }
    public Piece getMovedPiece() {
        return movedPiece;
    }
    public void setMovedPiece(Piece movedPiece) {
        this.movedPiece = movedPiece;
    }    
    
    public static boolean checkValidMove(Square squareFrom, Square squareTo, ChessBoard board) {
        if (squareFrom==null || squareTo==null) return false; // Check inputs are valid
        Piece piece = squareFrom.getPiece();
        return piece.calculateValidSquares(board).contains(squareTo); // If cal validSquares contains endSquare return ture
    }

    public void makeMove(ChessBoard board) {
        movedPiece.setSquare(destinationSquare);
        board.getSquare(sourceSquare.getRow(), sourceSquare.getCol()).removePiece();
        board.getSquare(destinationSquare.getRow(), destinationSquare.getCol()).setPiece(movedPiece);
    }
}
