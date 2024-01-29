package com.example.pieces;

import java.util.ArrayList;
import java.util.List;

import com.example.board.*;

public class Bishop extends Piece{

    public Bishop(boolean color, Square square) {
        super(color, square);
    }

    @Override
    public List<Square> calculateValidSquares(ChessBoard board) {
        List<Square> validSquares = new ArrayList<>();
        int row = super.square.getRow();
        int col = super.square.getCol();

        int i=row, j=col;
        while (i<7 && j<7) {
            i++;
            j++;
            Square square = board.getSquare(i, j);
            if (square.isEmpty()) validSquares.add(square);
            else {
                if (square.getPiece().getColor() != super.color) validSquares.add(square);
                break;
            }
            
        }
        i=row; 
        j=col;
        while (i<7 && j>0) {
            i++;
            j--;
            Square square = board.getSquare(i, j);
            if (square.isEmpty()) validSquares.add(square);
            else {
                if (square.getPiece().getColor() != super.color) validSquares.add(square);
                break;
            }
        }
        i=row; 
        j=col;
        while (i>0 && j>0) {
            i--;
            j--;
            Square square = board.getSquare(i, j);
            if (square.isEmpty()) validSquares.add(square);
            else {
                if (square.getPiece().getColor() != super.color) validSquares.add(square);
                break;
            }
            
        }
        i=row; 
        j=col;
        while (i>0 && j<7) {
            i--;
            j++;
            Square square = board.getSquare(i, j);
            if (square.isEmpty()) validSquares.add(square);
            else {
                if (square.getPiece().getColor() != super.color) validSquares.add(square);
                break;
            }
        }

        return validSquares;
    }
    
    @Override
    public List<Square> calculateMoveableSquares(ChessBoard board) {
        List<Square> validSquares = new ArrayList<>();
        int row = super.square.getRow();
        int col = super.square.getCol();

        int i=row;
        int j=col;
        while (i<7 && j<7) {
            i++;
            j++;
            Square square = board.getSquare(i, j);
            validSquares.add(square);
            if (!square.isEmpty()) {
                if ((square.getPiece() instanceof King) && square.getPiece().getColor() != super.color) continue;
                else break;
            } 
        }
        i=row;
        j=col;
        while (i>0 && j<7) {
            i--;
            j++;
            Square square = board.getSquare(i, j);
            validSquares.add(square);
            if (!square.isEmpty()) {
                if ((square.getPiece() instanceof King) && square.getPiece().getColor() != super.color) continue;
                else break;
            } 
        }
        i=row;
        j=col;
        while (i>0 && j>0) {
            i--;
            j--;
            Square square = board.getSquare(i, j);
            validSquares.add(square);
            if (!square.isEmpty()) {
                if ((square.getPiece() instanceof King) && square.getPiece().getColor() != super.color) continue;
                else break;
            } 
        }
        i=row;
        j=col;
        while (i<7 && j>0) {
            i++;
            j--;
            Square square = board.getSquare(i, j);
            validSquares.add(square);
            if (!square.isEmpty()) {
                if ((square.getPiece() instanceof King) && square.getPiece().getColor() != super.color) continue;
                else break;
            } 
        }

        return validSquares;
    }
}
