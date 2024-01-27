package com.example.players;

import com.example.board.ChessBoard;
import com.example.game.Move;

public class ComputerPlayer extends Player{

    public ComputerPlayer(boolean color, ChessBoard board) {
        super(color, board);
    }

    @Override
    public Move makeMove(ChessBoard board) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'makeMove'");
    }
    
}
