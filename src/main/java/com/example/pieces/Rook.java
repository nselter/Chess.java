package com.example.pieces;

import java.util.List;

import com.example.board.*;
import com.example.game.Move;

public class Rook extends Piece{

    public Rook(boolean color, Square square) {
        super(color, square);
    }

    @Override
    public List<Square> calculateValidSquares(ChessBoard board) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calculateValidMoves'");
    }
    
}
