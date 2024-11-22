
package com.github.cataratoru_fara_cap;

import com.github.cataratoru_fara_cap.Character.*;
import com.github.cataratoru_fara_cap.Gatherable.*;
import com.github.cataratoru_fara_cap.Item.*;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class GameLogic {
    private static int MAP_SIZE;
    private static final char EMPTY = '0';
    private static final char PLAYER = 'P';
    private static final char TREE = 'T';
    private static final char ROCK = 'R';
    private static final char GRAIN = 'G';
    private static final char ENEMY = 'E';

    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_BRIGHT_BLUE = "\u001B[94m";
    private static final String ANSI_BRIGHT_RED = "\u001B[91m";
    private static final String ANSI_BRIGHT_GREEN = "\u001B[92m";
    private static final String ANSI_BRIGHT_YELLOW = "\u001B[93m";
    private static final String ANSI_BRIGHT_WHITE = "\u001B[97m";

    private char[][] map;
    private Player player;
    private int playerX = 0;
    private int playerY = 0;
    private int numEnemies;

    public void initializeGame() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode rootNode = mapper.readTree(new File("src/main/resources/seed.json"));
            MAP_SIZE = rootNode.get("mapSize").asInt();
            numEnemies = rootNode.get("enemies").asInt();
        } catch (IOException e) {
            e.printStackTrace();
            MAP_SIZE = 10;
            numEnemies = 3;
        }

        map = new char[MAP_SIZE][MAP_SIZE];
        player = new Player("Hero", 20, 10, 100, 0, 0, 0);
        for (int i = 0; i < MAP_SIZE; i++) {
            for (int j = 0; j < MAP_SIZE; j++) {
                map[i][j] = EMPTY;
            }
        }
        map[playerX][playerY] = PLAYER;
        placeObjects();
    }

    private void placeObjects() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode rootNode = mapper.readTree(new File("src/main/resources/seed.json"));
            int numTrees = rootNode.get("trees").asInt();
            int numRocks = rootNode.get("rocks").asInt();
            int numGrains = rootNode.get("grains").asInt();

            placeRandomObjects(TREE, numTrees);
            placeRandomObjects(ROCK, numRocks);
            placeRandomObjects(GRAIN, numGrains);
            placeRandomObjects(ENEMY, numEnemies);
        } catch (IOException e) {
            e.printStackTrace();
            placeRandomObjects(ENEMY, numEnemies);
        }
    }

    private void placeRandomObjects(char object, int count) {
        Random random = new Random();
        int placed = 0;
        while (placed < count) {
            int x = random.nextInt(MAP_SIZE);
            int y = random.nextInt(MAP_SIZE);
            if (map[x][y] == EMPTY) {
                map[x][y] = object;
                placed++;
            }
        }
    }

    public void printMap() {
        System.out.println();
        for (int i = 0; i < MAP_SIZE; i++) {
            for (int j = 0; j < MAP_SIZE; j++) {
                switch (map[i][j]) {
                    case PLAYER:
                        System.out.print(ANSI_BRIGHT_BLUE + map[i][j] + ANSI_RESET + " ");
                        break;
                    case ENEMY:
                        System.out.print(ANSI_BRIGHT_RED + map[i][j] + ANSI_RESET + " ");
                        break;
                    case TREE:
                        System.out.print(ANSI_BRIGHT_GREEN + map[i][j] + ANSI_RESET + " ");
                        break;
                    case GRAIN:
                        System.out.print(ANSI_BRIGHT_YELLOW + map[i][j] + ANSI_RESET + " ");
                        break;
                    case ROCK:
                        System.out.print(ANSI_BRIGHT_WHITE + map[i][j] + ANSI_RESET + " ");
                        break;
                    default:
                        System.out.print(map[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public void craft(String ans) {
        System.out.println("You don't know how to craft items yet");
    }

    public void movePlayer(char move) {
        map[playerX][playerY] = EMPTY;
        switch (move) {
            case 'W':
                if (playerX > 0)
                    playerX--;
                break;
            case 'A':
                if (playerY > 0)
                    playerY--;
                break;
            case 'S':
                if (playerX < MAP_SIZE - 1)
                    playerX++;
                break;
            case 'D':
                if (playerY < MAP_SIZE - 1)
                    playerY++;
                break;
            default:
                System.out.println("Invalid move!");
        }
        handleInteraction();
        map[playerX][playerY] = PLAYER;
    }

    private void handleInteraction() {
        char currentTile = map[playerX][playerY];
        switch (currentTile) {
            case TREE:
                Tree tree = new Tree();
                player.gatherResource(tree);
                break;
            case ROCK:
                Rock rock = new Rock();
                player.gatherResource(rock);
                break;
            case GRAIN:
                Grain grain = new Grain();
                player.gatherResource(grain);
                break;
            case ENEMY:
                Enemy enemy = new Enemy("MarshMellowGolem", 5, 2, 20);
                while (player.isAlive && enemy.isAlive) {
                    player.damage(enemy);
                    if (enemy.isAlive) {
                        enemy.damage(player);
                    }
                }
                if (player.isAlive) {
                    System.out.println("Defeated the enemy!");
                    numEnemies--;
                } else {
                    System.out.println("You died!");
                    System.exit(0);
                }
                break;
            default:
                System.out.println("Nothing here.\n");
        }
    }

    public boolean isGameWon() {
        return numEnemies == 0;
    }
}