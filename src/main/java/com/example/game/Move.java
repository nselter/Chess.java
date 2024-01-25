package com.example.game;

import com.example.board.Square;
import com.example.pieces.Piece;

public class Move {
    private Square sourceSquare;
    private Square destinationSquare;
    private Piece movedPiece;
    
    public Move(Square sourceSquare, Square destinationSquare, Piece movedPiece) {
        this.sourceSquare = sourceSquare;
        this.destinationSquare = destinationSquare;
        this.movedPiece = movedPiece;
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
    
}
