package com.example.players;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import com.example.board.ChessBoard;
import com.example.board.Square;
import com.example.game.Move;
import com.example.pieces.Piece;

public class HumanPlayer extends Player {
    private Scanner scnr;
    public Set<String> validSquares;

    public HumanPlayer(boolean color, ChessBoard board, Scanner scnr) {
        super(color, board);
        this.scnr = scnr;
        initalizeValidSquares();
    }

    private void initalizeValidSquares() {
        validSquares = new HashSet<>();
        
        for (int i=0; i<8; i++) {
            for (int j=0; j<8; j++) {
                validSquares.add(""+(char)('A'+i) + (j+1));
            }
        }
    }

    private Square chooseSquare(ChessBoard board) {
        // Gets valid square 
        String inputString = "";
        while (!validSquares.contains(inputString)) {
            String rawString = scnr.nextLine();
            inputString = rawString.substring(0, 2);
        }
        int row = inputString.charAt(0) - 'A';
        int col = Character.getNumericValue(inputString.charAt(1))-1;

        return board.getSquare(row, col);
    }

    @Override
    public Move makeMove(ChessBoard board) {
        Piece pieceToMove = null;
        Square moveFrom = null;
        Square moveTo = null;
        while (!Move.checkValidMove(moveFrom, moveTo, board)) {
            while (pieceToMove == null || !pieces.contains(pieceToMove)) {
                board.print();
                System.out.println("Pick Your Piece: ");
                moveFrom = chooseSquare(board);
                if (!moveFrom.isEmpty()) pieceToMove = moveFrom.getPiece();
            }

            System.out.println("Choose End Square: ");
            moveTo = chooseSquare(board);
        }

        return new Move(moveFrom, moveTo);
    }
    
}
