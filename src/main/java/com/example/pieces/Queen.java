package com.example.pieces;

import java.util.ArrayList;
import java.util.List;

import com.example.board.*; 

public class Queen extends Piece{
    private Rook rookPart;
    private Bishop bishopPart;

    public Queen(boolean color, Square square) {
        super(color, square);
        rookPart = new Rook(color, square);
        bishopPart = new Bishop(color, square);
    }

    @Override
    public List<Square> calculateValidSquares(ChessBoard board) {
        List<Square> validSquares = new ArrayList<>();
        validSquares.addAll(rookPart.calculateValidSquares(board));
        validSquares.addAll(bishopPart.calculateValidSquares(board));
        return validSquares;
    }
    
    @Override
    public void setSquare(Square square) {
        super.setSquare(square);
        rookPart.setSquare(square);
        bishopPart.setSquare(square);
    }
}
