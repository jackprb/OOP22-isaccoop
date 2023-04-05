package it.unibo.isaccoop.model.enemy;

import org.junit.jupiter.api.Test;

import it.unibo.isaccoop.core.GameEngine;
import it.unibo.isaccoop.core.GameEngineImpl;
import it.unibo.isaccoop.core.GameLoop;
import it.unibo.isaccoop.core.GameLoopImpl;
import it.unibo.isaccoop.graphics.SwingScene;
import it.unibo.isaccoop.model.room.LevelController;
import it.unibo.isaccoop.model.room.LevelControllerImpl;

public class TestEnemy {

    private static final int MAX_ROOMS = 5;
    private static final int WIDTH = 1366;
    private static final int HEIGHT = 768;


    GameEngine gameEngine = new GameEngineImpl();
    LevelController gameState = new LevelControllerImpl(MAX_ROOMS, gameEngine);
    GameLoop gameLoop = new GameLoopImpl(new SwingScene(gameState.getCurrentLevel(), gameEngine, WIDTH, HEIGHT),
            gameState.getCurrentLevel());

    @Test
    void testEnemyGraphics() {
        gameState.getCurrentLevel().moveToNextRoom();
        gameState.getCurrentLevel().moveToNextRoom();
        gameState.getCurrentLevel().moveToNextRoom();
        var ai = gameState.getCurrentLevel().getCurrentRoom().getRoomAI().get();


        gameState.getCurrentLevel().getCurrentRoom().getEnemies().ifPresent(l -> l.forEach(e -> ai.remove(e)));

        gameState.getCurrentLevel().getCurrentRoom().getEnemies().ifPresent(l -> System.out.println(l.size()));

        gameEngine.run();
    }
}
