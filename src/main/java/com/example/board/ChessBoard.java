package com.example.board;

import com.example.pieces.*;;

public class ChessBoard {
    private Square[][] board;

    public ChessBoard() {
        board = new Square[8][8];

        initalizeBoard();
    }

    private void initalizeBoard() {
        //Create squares
        for (int i=0; i<8; i++) {
            for (int j=0; j<8; j++){
                board[i][j] = new Square(i, j);
            }
        }
        //Create Pawns
        for (int i=0; i<8;i++) {
            board[1][i].setPiece(new Pawn(false, board[1][i]));
            board[6][i].setPiece(new Pawn(true, board[6][i]));
        }
        //Create Rooks
        board[0][0].setPiece(new Rook(false, board[0][0]));
        board[0][7].setPiece(new Rook(false, board[0][7]));
        board[7][0].setPiece(new Rook(true, board[7][0]));
        board[7][7].setPiece(new Rook(true, board[7][7]));
        //Create Knights
        board[0][1].setPiece(new Knight(false, board[0][1]));
        board[0][6].setPiece(new Knight(false, board[0][6]));
        board[7][1].setPiece(new Knight(true, board[7][1]));
        board[7][6].setPiece(new Knight(true, board[7][6]));
        //Create Bishops
        board[0][2].setPiece(new Bishop(false, board[0][2]));
        board[0][5].setPiece(new Bishop(false, board[0][5]));
        board[7][2].setPiece(new Bishop(true, board[7][2]));
        board[7][5].setPiece(new Bishop(true, board[7][5]));
        //Create Queens
        board[0][3].setPiece(new Queen(false, board[0][3]));
        board[7][3].setPiece(new Queen(true, board[7][3]));
        //Create Kings
        board[0][4].setPiece(new King(false, board[0][4]));
        board[7][4].setPiece(new King(true, board[7][4]));
    }

    public Square[][] getBoard() {
        return board;
    }

    public Square getSquare(int row, int col) {
        return board[row][col];
    }

    public void delPiece(int row, int col) {
        board[row][col].setPiece(null);
    }
}
