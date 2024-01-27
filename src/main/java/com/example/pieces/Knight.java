package com.example.pieces;

import java.util.ArrayList;
import java.util.List;

import com.example.board.*;

public class Knight extends Piece{

    public Knight(boolean color, Square square) {
        super(color, square);
    }

    @Override
    public List<Square> calculateValidSquares(ChessBoard board) {
        List<Square> validSquares = new ArrayList<>();
        int row = super.square.getRow();
        int col= super.square.getCol();

        for (int i=-2; i<3; i+=4) {
            for (int j=-1; j<2; j+=2) {
                //If target square empty or hold enamy piece add to valid
                //Up Up Over
                if (row+i>=0 && row+i<8 && col+j>=0 && col+j<8 && //If space on the board
                (board.getSquare(row+i, col+j).isEmpty() || board.getSquare(row+i, col+j).getPiece().getColor() != super.color)) {
                    validSquares.add(board.getSquare(row+i, col+j));
                }
                //If target square empty or hold enamy piece add to valid
                //Over over Up
                if (row+j>=0 && row+j<8 && col+i>=0 && col+i<8 && //If space on the board
                (board.getSquare(row+j, col+i).isEmpty() || board.getSquare(row+j, col+i).getPiece().getColor() != super.color)) {
                    validSquares.add(board.getSquare(row+j, col+i));
                }
            }
        }

        return validSquares;
    }
    
    @Override
    public List<Square> calculateMoveableSquares(ChessBoard board) {
        return calculateValidSquares(board);
    }
}
