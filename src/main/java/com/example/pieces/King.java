package com.example.pieces;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.example.board.*;
import com.example.game.Move;
import com.example.players.Player;

public class King extends Piece {
    private Player opposingPlayer;

    public King(boolean color, Square square, Player opposingPlayer) {
        super(color, square);
        this.opposingPlayer = opposingPlayer;
    }

    @Override
    public List<Square> calculateValidSquares(ChessBoard board) {
        Set<Square> opposingPlayerMoves = opposingPlayer.getPlayerMoves(board);
        List<Square> ans = new ArrayList<>();
        int row = super.square.getRow();
        int col = super.square.getCol();

        for (int i=-1; i<2; i++) {
            for (int j=-1; j<2; j++) {
                // If a valid square
                if (row+i>=0 && col+j>=0 && row+i<8 && col+j<8){
                    Square square = board.getSquare(row + i, col + j);
                    // If not in opposing moves
                    if (!opposingPlayerMoves.contains(square)) {
                        // If empty or opposing piece add to valid moves
                        if (square.isEmpty() || square.getPiece().color != super.color) {
                            ans.add(square);
                        }
                    }
                }
            }
        }

        return ans;
    }

    
    @Override
    public List<Square> calculateMoveableSquares(ChessBoard board) {
        List<Square> validSquares = new ArrayList<>();
        int row = super.square.getRow();
        int col = super.square.getCol();

        for (int i=-1; i<2; i++) {
            for (int j=-1; j<2; j++) {
                if (row+i>=0 && col+j>=0 && row+i<8 && col+j<8) {
                    validSquares.add(board.getSquare(row+i, col+i));
                    
                }
            }
        }

        return validSquares;
    }

    public boolean canMove(ChessBoard board) {
        return calculateValidSquares(board).size() > 0;
    }

    public boolean inCheck(ChessBoard board) {
        return opposingPlayer.getPlayerMoves(board).contains(super.getSquare());
    }

    public boolean outOfCheck(Move move, ChessBoard board) {
        Piece tempPiece = move.makeMove(board);
        boolean ans = inCheck(board);
        move.undoMove(board, tempPiece);
        return ans;
    }
}
