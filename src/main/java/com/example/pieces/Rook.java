package com.example.pieces;

import java.util.ArrayList;
import java.util.List;

import com.example.board.*;

public class Rook extends Piece{

    public Rook(boolean color, Square square) {
        super(color, square);
    }

    @Override
    public List<Square> calculateValidSquares(ChessBoard board) {
        List<Square> validSquares = new ArrayList<>();
        int row = super.square.getRow();
        int col = super.square.getCol();

        for (int i=row-1; i>=0; i--) {
            if (board.getSquare(i, col).isEmpty()) {
                validSquares.add(board.getSquare(i, col));
            } else {
                if (board.getSquare(i, col).getPiece().getColor() != super.color) validSquares.add(board.getSquare(i, col));
                break;
            }
        }
        for (int i=row+1; i<8; i++) {
            if (board.getSquare(i, col).isEmpty()) {
                validSquares.add(board.getSquare(i, col));
            } else{
                if (board.getSquare(i, col).getPiece().getColor() != super.color) validSquares.add(board.getSquare(i, col));
                break;
            }
        }
        for (int i=col-1; i>=0; i--) {
            if (board.getSquare(row, i).isEmpty()) {
                validSquares.add(board.getSquare(row, i));
            } else{
                if (board.getSquare(row, i).getPiece().getColor() != super.color) validSquares.add(board.getSquare(row, i));
                break;
            }
        }
        for (int i=col+1; i<8; i++) {
            if (board.getSquare(row, i).isEmpty()) {
                validSquares.add(board.getSquare(row, i));
            } else{
                if (board.getSquare(row, i).getPiece().getColor() != super.color) validSquares.add(board.getSquare(row, i));
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

        for (int i=row-1; i>=0; i--) {
            Square square = board.getSquare(i, col);
            validSquares.add(square);
            if (!square.isEmpty()) {
                if ((square.getPiece() instanceof King) && square.getPiece().getColor() != super.color) continue;
                else break;
            }
        }
        for (int i=row+1; i<8; i++) {
            Square square = board.getSquare(i, col);
            validSquares.add(square);
            if (!square.isEmpty()) {
                if ((square.getPiece() instanceof King) && square.getPiece().getColor() != super.color) continue;
                else break;
            }
        }
        for (int i=col-1; i>=0; i--) {
            Square square = board.getSquare(row, i);
            validSquares.add(square);
            if (!square.isEmpty()) {
                if ((square.getPiece() instanceof King) && square.getPiece().getColor() != super.color) continue;
                else break;
            }
        }
        for (int i=col+1; i<8; i++) {
            Square square = board.getSquare(row, i);
            validSquares.add(square);
            if (!square.isEmpty()) {
                if ((square.getPiece() instanceof King) && square.getPiece().getColor() != super.color) continue;
                else break;
            }
        }
        
        return validSquares;
    }
}
