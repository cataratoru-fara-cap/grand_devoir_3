package com.github.cataratoru_fara_cap;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GameLogic game = new GameLogic();
        game.initializeGame();
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                game.printMap();
                System.out.println("Do you want to craft something?(Yes/no): ");
                String ans = scanner.nextLine();
                game.craft(ans);

                System.out.println("Enter move (WASD): ");
                char move = scanner.next().charAt(0);
                game.movePlayer(move);

                if (game.isGameWon()) {
                    System.out.println("YOU WIN");
                    System.exit(0);
                }
            }
        }
    }
}

