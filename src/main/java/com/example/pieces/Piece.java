package com.example.pieces;

import java.util.List;

import com.example.board.*;

public abstract class Piece {
   protected boolean color;
   protected Square square;

   public boolean getColor() {
      return color;
   }
   public void setColor(boolean color) {
      this.color = color;
   }
   public Square getSquare() {
      return square;
   }
   public void setSquare(Square square) {
      this.square = square;
   }

   public Piece(boolean color, Square square) {
      this.color = color;
      this.square = square;
   }

   public abstract List<Square> calculateValidSquares(ChessBoard board);
   public abstract List<Square> calculateMoveableSquares(ChessBoard board);
}
