package com.github.cataratoru_fara_cap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GameLogicTest {
    private GameLogic gameLogic;

    @BeforeEach
    public void setUp() {
        gameLogic = new GameLogic();
        gameLogic.initializeGame();
    }
}