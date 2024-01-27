package com.example.pieces;

import static org.junit.Assert.assertEquals;
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
        p1.addKings(board);
        p2.addKings(board);

        Piece kingPiece = board.getSquare(7, 4).getPiece();

        //Assert object has been made
        assertNotNull(kingPiece);

        //Assert that there are two vaild moves from get go
        int expectedSize = 0;
        int actualSize = kingPiece.calculateValidSquares(board).size();
        assertEquals("Expected size: " + expectedSize + ", Actual size: " + actualSize, expectedSize, actualSize);
        
        Square temp = board.getSquare(3, 1);
        temp.setPiece(new Queen(false, temp));
        p2.addPiece(temp.getPiece());
        temp = board.getSquare(4, 3);
        temp.setPiece(new King(true, temp, p1));

        //Assert that there are two vaild moves from get go
        int expectedSize2 = 3;
        int actualSize2 = temp.getPiece().calculateValidSquares(board).size();
        assertEquals("Expected size: " + expectedSize2 + ", Actual size: " + actualSize2, expectedSize2, actualSize2);
    }
}