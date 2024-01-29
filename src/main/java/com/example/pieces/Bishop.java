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
            Square square = board.getSquare(i+1, j+1);
            if (square.isEmpty()) validSquares.add(square);
            else {
                if (square.getPiece().getColor() != super.color) validSquares.add(square);
                break;
            }
            i++;
            j++;
        }
        i=row; 
        j=col;
        while (i<7 && j>0) {
            Square square = board.getSquare(i+1, j-1);
            if (square.isEmpty()) validSquares.add(square);
            else {
                if (square.getPiece().getColor() != super.color) validSquares.add(square);
                break;
            }
            i++;
            j--;
        }
        i=row; 
        j=col;
        while (i>0 && j>0) {
            Square square = board.getSquare(i-1, j-1);
            if (square.isEmpty()) validSquares.add(square);
            else {
                if (square.getPiece().getColor() != super.color) validSquares.add(square);
                break;
            }
            i--;
            j--;
        }
        i=row; 
        j=col;
        while (i>0 && j<7) {
            Square square = board.getSquare(i-1, j+1);
            if (square.isEmpty()) validSquares.add(square);
            else {
                if (square.getPiece().getColor() != super.color) validSquares.add(square);
                break;
            }
            i--;
            j++;
        }

        return validSquares;
    }
    
    @Override
    public List<Square> calculateMoveableSquares(ChessBoard board) {
        List<Square> validSquares = new ArrayList<>();
        int row = super.square.getRow();
        int col = super.square.getCol();

        int i=row+1;
        int j=col+1;
        while (i<8 && j<8) {
            Square square = board.getSquare(i, j);
            validSquares.add(square);
            if (!square.isEmpty()) {
                if ((square.getPiece() instanceof King) && square.getPiece().getColor() != super.color) continue;
                else break;
            } 
            i++;
            j++;
        }
        i=row-1;
        j=col+1;
        while (i>=0 && j<8) {
            Square square = board.getSquare(i, j);
            validSquares.add(square);
            if (!square.isEmpty()) {
                if ((square.getPiece() instanceof King) && square.getPiece().getColor() != super.color) continue;
                else break;
            } 
            i--;
            j++;
        }
        i=row-1;
        j=col-1;
        while (i>=0 && j>=0) {
            Square square = board.getSquare(i, j);
            validSquares.add(square);
            if (!square.isEmpty()) {
                if ((square.getPiece() instanceof King) && square.getPiece().getColor() != super.color) continue;
                else break;
            } 
            i--;
            j--;
        }
        i=row+1;
        j=col-1;
        while (i<8 && j>=0) {
            Square square = board.getSquare(i, j);
            validSquares.add(square);
            if (!square.isEmpty()) {
                if ((square.getPiece() instanceof King) && square.getPiece().getColor() != super.color) continue;
                else break;
            } 
            i++;
            j--;
        }

        return validSquares;
    }
}
