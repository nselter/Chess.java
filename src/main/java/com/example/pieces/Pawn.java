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
    public List<Square> calculateValidSquares(ChessBoard board) {
        List<Square> validSquares = new ArrayList<>();
        int firstRow = super.color ? 6 : 1; // Find first row based on color
        int direction = super.color ? -1 : 1; // Set which direction piece is going
        int row = super.square.getRow();
        int col = super.square.getCol();

        Square inFrontSquare = board.getSquare(row + direction, col); //Get Square in front of piece
        //If square in front is empty
        if (inFrontSquare.isEmpty()) {
            validSquares.add(inFrontSquare);
            //If on the frist row and no piece 1or2 spaces in front add move two
            Square twoInFrontSquare = board.getSquare(row + (direction*2), col);
            if (row==firstRow && twoInFrontSquare.isEmpty()) {
                validSquares.add(twoInFrontSquare);
            }
        }
        //Find if oppisite color piece on diagonal, if so add capture as move
        for (int i=-1; i<2; i+=2) {
            if (row+direction>=0 && row+direction<8 && col+i>=0 && col+i<8) {
                Square diagonalSquare = board.getSquare(row + direction, col + i);
                if (!diagonalSquare.isEmpty() && diagonalSquare.getPiece().getColor()!=super.color) {
                    validSquares.add(diagonalSquare);
                }
            }
        } 
        //TO-DO: Add ON-PASSUNT into moves
        // If on valid row for onpassunt
        if (super.square.getRow() == (super.color ? 3 :4)) {
            Move lastMove = board.getLastMove();
            // If last move was pawn forward by 2
            if (lastMove.getMovedPiece() instanceof Pawn && lastMove.getSourceSquare().getRow() == (super.color ? 1 : 6) && lastMove.getDestinationSquare().getRow() == (super.color ? 3 : 4)) {
                //If one column away
                if (Math.abs(lastMove.getDestinationSquare().getCol() - super.getSquare().getCol()) == 1) {
                    validSquares.add(board.getSquare((super.color ? 2 : 5), lastMove.getDestinationSquare().getCol()));
                }
            }
        }

        return validSquares;
    }
    
    @Override
    public List<Square> calculateMoveableSquares(ChessBoard board) {
        List<Square> validSquares = new ArrayList<>();
        int direction = super.color ? -1 : 1; // Set which direction piece is going
        int row = super.square.getRow();
        int col = super.square.getCol();
        for (int i=-1; i<2; i+=2) {
            if (row+direction>=0 && row+direction<8 && col+i>=0 && col+i<8) {
                Square diagonalSquare = board.getSquare(row + direction, col + i);
                validSquares.add(diagonalSquare);
            }
        } 

        return validSquares;
    }

    public static boolean isEnPassant(Piece movedPiece, Square destinationSquare) {
        if (!(movedPiece instanceof Pawn) || !destinationSquare.isEmpty()) return false;

        if (movedPiece.square.getRow() == (movedPiece.color ? 3 :4)) return true;
        return false;
    }
}
