package com.example.pieces;

import java.util.List;

import com.example.board.*;
import com.example.game.Move;

public class Pawn extends Piece {

    public Pawn(boolean color, Square square) {
        super(color, square);
    }

    @Override
    public List<Move> calculateValidMoves(ChessBoard board) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calculateValidMoves'");
    }
    
}
