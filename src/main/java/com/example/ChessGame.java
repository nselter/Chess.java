package com.example;

import java.util.Scanner;

import com.example.game.Game;

public class ChessGame {
    public static void main(String[] args) {
        Game game = new Game(0, true, new Scanner(System.in));

        game.play();

        System.out.println("Good Game!");
    }
}
