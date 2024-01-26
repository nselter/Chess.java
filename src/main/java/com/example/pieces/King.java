package com.example.pieces;

import java.util.ArrayList;
import java.util.List;

import com.example.board.*;

public class King extends Piece {

    public King(boolean color, Square square) {
        super(color, square);
    }

    @Override
    public List<Square> calculateValidSquares(ChessBoard board) {
        return new ArrayList<>();
    }
    
}
