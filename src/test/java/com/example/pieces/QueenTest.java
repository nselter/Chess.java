package com.example.pieces;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.example.board.ChessBoard;
import com.example.board.Square;
import com.example.players.HumanPlayer;
import com.example.players.Player;

public class QueenTest {
    @Test
    public void testCalculateValidSquares() {
        ChessBoard board = new ChessBoard();
        Player p1 = new HumanPlayer(true, board, null);
        Player p2 = new HumanPlayer(false, board, null);
        board.addKings(p1, p2);

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
        int expectedSize2 = 19;
        int actualSize2 = newQueen.calculateValidSquares(board).size();
        assertEquals("Expected size: " + expectedSize2 + ", Actual size: " + actualSize2, expectedSize2, actualSize2);
    }

    @Test
    public void testCalculateMoveableSquares() {
        ChessBoard board = new ChessBoard();
        Player p1 = new HumanPlayer(true, board, null);
        Player p2 = new HumanPlayer(false, board, null);
        board.addKings(p1, p2);

        Piece queenPiece = board.getSquare(0, 3).getPiece();

        // Check if not null
        assertNotNull(queenPiece);

        //Assert that there are two vaild moves from get go
        int expectedSize = 5;
        int actualSize = queenPiece.calculateMoveableSquares(board).size();
        assertEquals("Expected size: " + expectedSize + ", Actual size: " + actualSize, expectedSize, actualSize);
    }


}
