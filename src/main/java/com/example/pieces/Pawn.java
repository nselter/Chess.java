package com.example.pieces;

import java.util.ArrayList;
import java.util.List;

import com.example.board.*;
import com.example.game.Move;

public class Pawn extends Piece {

    public Pawn(boolean color, Square square) {
        super(color, square);
    }

    @Override
    public List<Move> calculateValidMoves(ChessBoard board) {
        List<Move> validMoves = new ArrayList<>();

        return validMoves;
    }
    
}
