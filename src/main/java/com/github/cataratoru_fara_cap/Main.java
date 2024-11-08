package com.github.cataratoru_fara_cap;

import com.github.cataratoru_fara_cap.Character.*;
import com.github.cataratoru_fara_cap.Gatherable.*;
import com.github.cataratoru_fara_cap.Item.*;

import java.util.Scanner;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Main {
    //Maybe use ASSCI UNICODE EMOJIS OR AT LEAST COLORED CHARS? OR ADD OPTION TO USE EMOJI'S?
    private static int MAP_SIZE;
    private static final char EMPTY = '0';
    private static final char PLAYER = 'P';
    private static final char TREE = 'T';
    private static final char ROCK = 'R';
    private static final char GRAIN = 'G';
    private static final char ENEMY = 'E';

    private static char[][] map;
    private static Player player;
    private static int playerX = 0;
    private static int playerY = 0;
    private static int numEnemies;

    public static void main(String[] args) {
        initializeGame();
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                printMap();
                System.out.println("Enter move (WASD): ");
                char move = scanner.next().charAt(0);
                movePlayer(move);

                if (numEnemies == 0) {
                    System.out.println("YOU WIN");
                    System.exit(0);
                }
            }
        }
    }

    private static void initializeGame() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode rootNode = mapper.readTree(new File("seed.json"));
            MAP_SIZE = rootNode.get("mapSize").asInt();
            numEnemies = rootNode.get("enemies").asInt(); // Initialize numEnemies here
        } catch (IOException e) {
            e.printStackTrace();
            MAP_SIZE = 10; // default value if reading from JSON fails
            numEnemies = 3; // default value if reading from JSON fails
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

    private static void placeObjects() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode rootNode = mapper.readTree(new File("seed.json"));
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

    private static void placeRandomObjects(char object, int count) {
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

    private static void handleInteraction() {
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
                    numEnemies--; // Decrease numEnemies when an enemy is defeated
                } else {
                    System.out.println("You died!");
                    System.exit(0);
                }
                break;
            default:
                System.out.println("Nothing here.\n");
        }
    }
}