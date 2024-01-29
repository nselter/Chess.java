package com.example.pieces;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.example.board.ChessBoard;
import com.example.players.HumanPlayer;
import com.example.players.Player;

public class BishopTest {
    @Test
    public void testCalculateMoveableSquares() {
        ChessBoard board = new ChessBoard();
        Player p1 = new HumanPlayer(true, board, null);
        Player p2 = new HumanPlayer(false, board, null);
        board.addKings(p1, p2);

        Piece bishopPiece = board.getSquare(0, 2).getPiece();

        // Check if not null
        assertNotNull(bishopPiece);

        //Assert that there are two vaild moves from get go
        int expectedSize = 0;
        int actualSize = bishopPiece.calculateValidSquares(board).size();
        assertEquals("Expected size: " + expectedSize + ", Actual size: " + actualSize, expectedSize, actualSize);

        board.getSquare(4, 4).setPiece(new Bishop(true, board.getSquare(4, 4)));
        bishopPiece = board.getSquare(4, 4).getPiece();

        //Assert that there are two vaild moves from get go
        expectedSize = 8;
        actualSize = bishopPiece.calculateValidSquares(board).size();
        assertEquals("Expected size: " + expectedSize + ", Actual size: " + actualSize, expectedSize, actualSize);
    }

    @Test
    public void testCalculateValidSquares() {
        ChessBoard board = new ChessBoard();
        Player p1 = new HumanPlayer(true, board, null);
        Player p2 = new HumanPlayer(false, board, null);
        board.addKings(p1, p2);

        Piece bishopPiece = board.getSquare(0, 2).getPiece();

        // Check if not null
        assertNotNull(bishopPiece);

        //Assert that there are two vaild moves from get go
        int expectedSize = 2;
        int actualSize = bishopPiece.calculateMoveableSquares(board).size();
        assertEquals("Expected size: " + expectedSize + ", Actual size: " + actualSize, expectedSize, actualSize);

        board.getSquare(4, 4).setPiece(new Bishop(true, board.getSquare(4, 4)));
        bishopPiece = board.getSquare(4, 4).getPiece();

        //Assert that there are two vaild moves from get go
        expectedSize = 10;
        actualSize = bishopPiece.calculateMoveableSquares(board).size();
        assertEquals("Expected size: " + expectedSize + ", Actual size: " + actualSize, expectedSize, actualSize);
    }
}
