package com.example.pieces;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.example.board.ChessBoard;
import com.example.board.Square;

public class RookTest {
    @Test
    public void testCalculateValidSquares() {
        ChessBoard board = new ChessBoard();

        Piece rookPiece = board.getSquare(0, 3).getPiece();

        // Check if not null
        assertNotNull(rookPiece);

        //Assert that there are two vaild moves from get go
        int expectedSize = 0;
        int actualSize = rookPiece.calculateValidSquares(board).size();
        assertEquals("Expected size: " + expectedSize + ", Actual size: " + actualSize, expectedSize, actualSize);

        Square square1 = board.getSquare(4, 4);
        Rook newRook = new Rook(true, square1);
        square1.setPiece(newRook);

        //Assert that there are two vaild moves from get go
        int expectedSize2 = 11;
        int actualSize2 = newRook.calculateValidSquares(board).size();
        assertEquals("Expected size: " + expectedSize2 + ", Actual size: " + actualSize2, expectedSize2, actualSize2);
    }
}
