package com.example.game;

import com.example.board.ChessBoard;
import com.example.board.Square;
import com.example.pieces.Pawn;
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

    public Piece makeMove(ChessBoard board) {
        Piece capturedPiece = destinationSquare.getPiece();
        
        //Handle EnPassant Case
        if (Pawn.isEnPassant(movedPiece, destinationSquare)) {
            capturedPiece = board.getSquare((movedPiece.getColor() ? 3 : 4), destinationSquare.getCol()).getPiece();
            board.delPiece((movedPiece.getColor() ? 3 : 4), destinationSquare.getCol());
        }
        
        movedPiece.setSquare(destinationSquare); //Move the piece to new square
        board.delPiece(sourceSquare.getRow(), sourceSquare.getCol()); // Remove piece from source square
        board.getSquare(destinationSquare.getRow(), destinationSquare.getCol()).setPiece(movedPiece); // Set piece to new square

        return capturedPiece;
    }

    public void undoMove(ChessBoard board, Piece capturedPiece) {
        movedPiece.setSquare(sourceSquare);
        board.delPiece(destinationSquare.getRow(), destinationSquare.getCol());
        board.getSquare(sourceSquare.getRow(), sourceSquare.getCol()).setPiece(movedPiece);;
        if (capturedPiece != null) {
            board.getSquare(destinationSquare.getRow(), destinationSquare.getCol()).setPiece(capturedPiece);
        }
    }
}
