package com.example.pieces;

import java.util.List;

import com.example.board.*;
import com.example.game.Move;

public abstract class Piece {
   private boolean color;
   private Square square;

   public boolean isColor() {
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

   public abstract List<Move> calculateValidMoves(ChessBoard board);
}
