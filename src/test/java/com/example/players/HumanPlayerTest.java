package com.example.players;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Scanner;

import org.junit.Test;

import com.example.board.ChessBoard;

public class HumanPlayerTest {

    @Test
    public void testMakeMove() {
        ChessBoard board = new ChessBoard();
        HumanPlayer player1 = new HumanPlayer(true, board, new Scanner(System.in));

        // Check if not null
        assertNotNull(player1);

        // Check to see if has 16 pieces\
        int expectedSize = 16;
        int actualSize = player1.getPieces().size();
        assertEquals("Expected size: " + expectedSize + ", Actual size: " + actualSize, expectedSize, actualSize);

        // Check to see if 64 vaild input Strings
        int expectedSize2 = 64;
        int actualSize2 = player1.validSquares.size();
        assertEquals("Expected size: " + expectedSize2 + ", Actual size: " + actualSize2, expectedSize2, actualSize2);


    }
}
