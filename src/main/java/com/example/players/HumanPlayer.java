package com.example.players;

import java.util.Scanner;

import com.example.board.ChessBoard;
import com.example.game.Move;

public class HumanPlayer extends Player {
    private Scanner scnr;

    public HumanPlayer(boolean color, ChessBoard board, Scanner scnr) {
        super(color, board);
        this.scnr = scnr;
    }

    @Override
    public Move makeMove(ChessBoard board) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'makeMove'");
    }
    
}
