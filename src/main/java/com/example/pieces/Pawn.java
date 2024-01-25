package com.example.pieces;

import java.util.ArrayList;
import java.util.List;

import com.example.board.*;

public class Pawn extends Piece {

    public Pawn(boolean color, Square square) {
        super(color, square);
    }

    @Override
    public List<Square> calculateValidSquares(ChessBoard board) {
        List<Square> validSquares = new ArrayList<>();
        int firstRow = super.color ? 6 : 1; // Find first row based on color
        int direction = super.color ? -1 : 1; // Set which direction piece is going

        Square inFrontSquare = board.getSquare(super.square.getRow() + direction, super.square.getCol()); //Get Square in front of piece
        //If square in front is empty
        if (inFrontSquare.isEmpty()) {
            validSquares.add(inFrontSquare);
            //If on the frist row and no piece 1or2 spaces in front add move two
            Square twoInFrontSquare = board.getSquare(super.square.getRow() + (direction*2), super.square.getCol());
            if (super.square.getRow()==firstRow && twoInFrontSquare.isEmpty()) {
                validSquares.add(twoInFrontSquare);
            }
        }
        //Find if oppisite color piece on diagonal, if so add capture as move
        for (int i=-1; i<2; i+=2) {
            Square diagonalSquare = board.getSquare(super.square.getRow() + direction, super.square.getCol() + i);
            if (!diagonalSquare.isEmpty() && diagonalSquare.getPiece().getColor()!=super.color) {
                validSquares.add(diagonalSquare);
            }
        } 
        //TO-DO: Add ON-PASSUNT into moves
        

        return validSquares;
    }
    
}
