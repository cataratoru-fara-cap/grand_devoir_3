package com.github.cataratoru_fara_cap;

import com.github.cataratoru_fara_cap.Character.*;
import com.github.cataratoru_fara_cap.Gatherable.*;
import com.github.cataratoru_fara_cap.Item.*;

import java.util.Scanner;

public class Main {
    //Maybe use ASSCI UNICODE EMOJIS OR AT LEAST COLORED CHARS? OR ADD OPTION TO USE EMOJI'S?
    private static final int MAP_SIZE = 10;
    private static final char EMPTY = '0';
    private static final char PLAYER = 'P';
    private static final char TREE = 'T';
    private static final char ROCK = 'R';
    private static final char GRAIN = 'G';
    private static final char ENEMY = 'E';

    private static char[][] map = new char[MAP_SIZE][MAP_SIZE];
    private static Player player;
    private static int playerX = 0;
    private static int playerY = 0;

    public static void main(String[] args) {
        initializeGame();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printMap();
            System.out.println("Enter move (WASD): ");
            char move = scanner.next().charAt(0);
            movePlayer(move);
            handleInteraction();
        }
    }

    private static void initializeGame() {
        player = new Player("Hero", 10, 5, 100, 0, 0, 0);
        for (int i = 0; i < MAP_SIZE; i++) {
            for (int j = 0; j < MAP_SIZE; j++) {
                map[i][j] = EMPTY;
            }
        }
        map[playerX][playerY] = PLAYER;
        placeObjects();
    }

    private static void placeObjects() {
        //Needs Refinement, read from file!
        map[2][2] = TREE;
        map[3][3] = ROCK;
        map[4][4] = GRAIN;
        map[5][5] = ENEMY;
    }

    private static void printMap() {
        for (int i = 0; i < MAP_SIZE; i++) {
            for (int j = 0; j < MAP_SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void movePlayer(char move) {
        //This overides the object that we are moving towards
        map[playerX][playerY] = EMPTY;
        switch (move) {
            case 'W':
                if (playerX > 0) playerX--;
                break;
            case 'A':
                if (playerY > 0) playerY--;
                break;
            case 'S':
                if (playerX < MAP_SIZE - 1) playerX++;
                break;
            case 'D':
                if (playerY < MAP_SIZE - 1) playerY++;
                break;
            default:
                System.out.println("Invalid move!");
        }
        map[playerX][playerY] = PLAYER;
    }

    private static void handleInteraction() {
        char currentTile = map[playerX][playerY];
        switch (currentTile) {
            case TREE:
                Tree tree = new Tree(10, Rarity.COMMON);
                double wood = tree.gather();
                player.collectWood((int) wood);
                System.out.println("Collected wood: " + wood);
                break;
            case ROCK:
                Rock rock = new Rock(10, Rarity.COMMON);
                double stone = rock.gather();
                player.collectStone((int) stone);
                System.out.println("Collected stone: " + stone);
                break;
            case GRAIN:
                Grain grain = new Grain(10, Rarity.COMMON);
                double food = grain.gather();
                player.collectFood((int) food);
                System.out.println("Collected food: " + food);
                break;
            case ENEMY:
                Enemy enemy = new Enemy("Goblin", 5, 2, 20);
                while (player.isAlive && enemy.isAlive) {
                    player.damage(enemy);
                    if (enemy.isAlive) {
                        enemy.damage(player);
                    }
                }
                if (player.isAlive) {
                    System.out.println("Defeated the enemy!");
                } else {
                    System.out.println("You died!");
                    System.exit(0);
                }
                break;
            default:
                System.out.println("Nothing here.");
        }
    }
}