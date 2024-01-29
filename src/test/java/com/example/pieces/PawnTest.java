package com.example.pieces;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.example.board.ChessBoard;
import com.example.board.Square;
import com.example.game.Move;

public class PawnTest {
    @Test
    public void testCalculateValidSquares() {
        ChessBoard board = new ChessBoard();

        Piece pawnPiece = board.getSquare(6, 6).getPiece();

        //Assert object has been made
        assertNotNull(pawnPiece);

        //Assert that there are two vaild moves from get go
        int expectedSize = 2;
        int actualSize = pawnPiece.calculateValidSquares(board).size();
        assertEquals("Expected size: " + expectedSize + ", Actual size: " + actualSize, expectedSize, actualSize);

        
        Square square1 = board.getSquare(4, 4);
        Square square2 = board.getSquare(3, 5);
        square1.setPiece(new Pawn(true, square1));
        square2.setPiece(new Pawn(false, square2));

        //Assert that there are two vaild moves from get go
        expectedSize = 2;
        actualSize = board.getSquare(4, 4).getPiece().calculateValidSquares(board).size();
        assertEquals("Expected size: " + expectedSize + ", Actual size: " + actualSize, expectedSize, actualSize);

        //Check onpassunt move
        board.getSquare(3, 0).setPiece(new Pawn(true, board.getSquare(3, 0)));
        pawnPiece = board.getSquare(3, 0).getPiece();
        Move newMove = new Move(board.getSquare(1, 1), board.getSquare(3, 1));
        newMove.makeMove(board);
        board.setLastMove(newMove);

        expectedSize = 2;
        actualSize = board.getSquare(3, 0).getPiece().calculateValidSquares(board).size();
        assertEquals("Expected size: " + expectedSize + ", Actual size: " + actualSize, expectedSize, actualSize);
    }
}
