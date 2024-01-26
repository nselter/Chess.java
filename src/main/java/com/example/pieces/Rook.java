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

        for (int i=row; i>=0; i--) {
            if (board.getSquare(i, col).isEmpty()) {
                validSquares.add(board.getSquare(i, col));
            } else{
                if (board.getSquare(i, col).getPiece().getColor() != super.color) validSquares.add(board.getSquare(i, col));
                break;
            }
        }
        for (int i=row; i<8; i++) {
            if (board.getSquare(i, col).isEmpty()) {
                validSquares.add(board.getSquare(i, col));
            } else{
                if (board.getSquare(i, col).getPiece().getColor() != super.color) validSquares.add(board.getSquare(i, col));
                break;
            }
        }
        for (int i=col; i>=0; i--) {
            if (board.getSquare(row, i).isEmpty()) {
                validSquares.add(board.getSquare(row, i));
            } else{
                if (board.getSquare(row, i).getPiece().getColor() != super.color) validSquares.add(board.getSquare(row, i));
                break;
            }
        }
        for (int i=col; i<8; i--) {
            if (board.getSquare(row, i).isEmpty()) {
                validSquares.add(board.getSquare(row, i));
            } else{
                if (board.getSquare(row, i).getPiece().getColor() != super.color) validSquares.add(board.getSquare(row, i));
                break;
            }
        }
        
        return validSquares;
    }
    
}
