package com.example.pieces;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.example.board.ChessBoard;
import com.example.board.Square;

public class KnightTest {
    @Test
    public void testCalculateValidSquares() {
        ChessBoard board = new ChessBoard();

        Piece knightPiece = board.getSquare(7, 1).getPiece();

        //Assert object has been made
        assertNotNull(knightPiece);

        //Assert that there are two vaild moves from get go
        int expectedSize = 2;
        int actualSize = knightPiece.calculateValidSquares(board).size();
        assertEquals("Expected size: " + expectedSize + ", Actual size: " + actualSize, expectedSize, actualSize);

        Square square1 = board.getSquare(3, 3);
        square1.setPiece(new Knight(true, square1));

        //Assert that there are two vaild moves from get go
        int expectedSize2 = 8;
        int actualSize2 = square1.getPiece().calculateValidSquares(board).size();
        assertEquals("Expected size: " + expectedSize2 + ", Actual size: " + actualSize2, expectedSize2, actualSize2);

    }
}
