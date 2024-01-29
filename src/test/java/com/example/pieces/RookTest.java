package com.example.pieces;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.example.board.ChessBoard;
import com.example.board.Square;
import com.example.players.HumanPlayer;
import com.example.players.Player;

public class RookTest {
    @Test
    public void testCalculateValidSquares() {
        ChessBoard board = new ChessBoard();
        Player p1 = new HumanPlayer(true, board, null);
        Player p2 = new HumanPlayer(false, board, null);
        board.addKings(p1, p2);

        Piece rookPiece = board.getSquare(0, 0).getPiece();

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

    @Test
    public void testCalculateMoveableSquares() {
        ChessBoard board = new ChessBoard();
        Player p1 = new HumanPlayer(true, board, null);
        Player p2 = new HumanPlayer(false, board, null);
        board.addKings(p1, p2);

        Piece rookPiece = board.getSquare(0, 0).getPiece();

        // Check if not null
        assertNotNull(rookPiece);

        //Assert that there are two vaild moves from get go
        int expectedSize = 2;
        int actualSize = rookPiece.calculateMoveableSquares(board).size();
        assertEquals("Expected size: " + expectedSize + ", Actual size: " + actualSize, expectedSize, actualSize);
    
        Square square1 = board.getSquare(4, 4);
        Rook newRook = new Rook(true, square1);
        square1.setPiece(newRook);

        //Assert that there are two vaild moves from get go
        expectedSize = 12;
        actualSize = newRook.calculateMoveableSquares(board).size();
        assertEquals("Expected size: " + expectedSize + ", Actual size: " + actualSize, expectedSize, actualSize);

        // Test if goes through King
        board.getSquare(3, 4).setPiece(new King(true, board.getSquare(3, 4), p2));
        board.getSquare(5, 4).setPiece(new King(true, board.getSquare(5, 4), p2));
        board.getSquare(4, 5).setPiece(new King(false, board.getSquare(4, 5), p1));
        board.getSquare(4, 3).setPiece(new King(true, board.getSquare(4, 3), p2));

        expectedSize = 6;
        actualSize = newRook.calculateMoveableSquares(board).size();
        assertEquals("Expected size: " + expectedSize + ", Actual size: " + actualSize, expectedSize, actualSize);
    }
}
