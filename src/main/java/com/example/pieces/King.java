package com.example.pieces;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.example.board.*;
import com.example.players.Player;

public class King extends Piece {
    private Player opposingPlayer;

    public King(boolean color, Square square, Player opposingPlayer) {
        super(color, square);
        this.opposingPlayer = opposingPlayer;
    }

    @Override
    public List<Square> calculateValidSquares(ChessBoard board) {
        Set<Square> opposingPlayerMoves = getOpposingPlayerMoves();
        List<Square> ans = new ArrayList<>();
        int row = super.square.getRow();
        int col = super.square.getCol();

        for (int i=-1; i<2; i++) {
            for (int j=-1; j<2; j++) {
                Square square = board.getSquare(row + i, col + j);
                if (!opposingPlayerMoves.contains(square)) {
                    // If empty or opposing piece add to valid moves
                    if (square.isEmpty() || square.getPiece().color != super.color) {
                        ans.add(square);
                    }
                }
            }
        }

        return ans;
    }

    private Set<Square> getOpposingPlayerMoves() {
        // Return all moves that the opponent can make
        Set<Square> movesSet = new HashSet<>();
        for (Piece p : opposingPlayer.getPieces()) {
            movesSet.addAll(p.calculateValidSquares(null));
        }

        return movesSet;
    }
    
}
