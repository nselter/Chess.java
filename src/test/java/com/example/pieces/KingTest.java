package com.example.pieces;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.example.board.ChessBoard;
import com.example.board.Square;
import com.example.players.HumanPlayer;
import com.example.players.Player;

public class KingTest {
    @Test
    public void testCalculateValidSquares() {
        ChessBoard board = new ChessBoard();
        Player p1 = new HumanPlayer(false, board, null);
        Player p2 = new HumanPlayer(true, board, null);
        board.addKings(p1, p2);
        p1.addKing(board);
        p2.addKing(board);

        Piece kingPiece = board.getSquare(7, 4).getPiece();

        //Assert object has been made
        assertNotNull(kingPiece);

        //Assert that there are two vaild moves from get go
        int expectedSize = 0;
        int actualSize = kingPiece.calculateValidSquares(board).size();
        assertEquals("Expected size: " + expectedSize + ", Actual size: " + actualSize, expectedSize, actualSize);
        
        Square temp = board.getSquare(3, 1);
        temp.setPiece(new Queen(false, temp));
        p1.addPiece(temp.getPiece());
        temp = board.getSquare(4, 3);
        temp.setPiece(new King(true, temp, p1));

        //Assert Queen Works well
        int expectedSize3 = 17;
        int actualSize3 = board.getSquare(3, 1).getPiece().calculateValidSquares(board).size();
        assertEquals("Expected size: " + expectedSize3 + ", Actual size: " + actualSize3, expectedSize3, actualSize3);


        //Assert that there are two vaild moves from get go
        int expectedSize2 = 3;
        int actualSize2 = temp.getPiece().calculateValidSquares(board).size();
        assertEquals("Expected size: " + expectedSize2 + ", Actual size: " + actualSize2, expectedSize2, actualSize2);
    }

    @Test
    public void testInCheck() {
        ChessBoard board = new ChessBoard();
        Player p1 = new HumanPlayer(false, board, null);
        Player p2 = new HumanPlayer(true, board, null);
        board.addKings(p1, p2);
        p1.addKing(board);
        p2.addKing(board);

        King kingPiece = (King) board.getSquare(7, 4).getPiece();

        //Assert object has been made
        assertNotNull(kingPiece);

        //Assert not in check
        assertFalse(kingPiece.inCheck(board));
    }
}
