package com.example.board;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ChessBoardTest {

    @Test
    public void testName() {
        ChessBoard board = new ChessBoard();

        //Check board is not null
        assertNotNull(board);

        //Check Squares
        Square square1 = board.getSquare(0, 0);
        Square square2 = board.getSquare(4, 2);
        Square square3 = board.getSquare(7, 5);

        assertNotNull(square1);
        assertNotNull(square2);
        assertNotNull(square3);

        //Check Pieces Have been made
        assertFalse("Expected: " + false, square1.isEmpty());
        assertTrue("Expected: "+true, square2.isEmpty());
        assertFalse("Expected: " + false, square3.isEmpty());
    }

}
