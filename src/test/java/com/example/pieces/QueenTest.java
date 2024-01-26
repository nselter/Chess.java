package com.example.pieces;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.example.board.ChessBoard;
import com.example.board.Square;

public class QueenTest {
    @Test
    public void testCalculateValidSquares() {
        ChessBoard board = new ChessBoard();

        Piece queenPiece = board.getSquare(0, 3).getPiece();

        // Check if not null
        assertNotNull(queenPiece);

        //Assert that there are two vaild moves from get go
        int expectedSize = 0;
        int actualSize = queenPiece.calculateValidSquares(board).size();
        assertEquals("Expected size: " + expectedSize + ", Actual size: " + actualSize, expectedSize, actualSize);

        Square square1 = board.getSquare(4, 4);
        Queen newQueen = new Queen(true, square1);
        square1.setPiece(newQueen);

        //Assert that there are two vaild moves from get go
        int expectedSize2 = 18;
        int actualSize2 = newQueen.calculateValidSquares(board).size();
        assertEquals("Expected size: " + expectedSize2 + ", Actual size: " + actualSize2, expectedSize2, actualSize2);
    }
}
