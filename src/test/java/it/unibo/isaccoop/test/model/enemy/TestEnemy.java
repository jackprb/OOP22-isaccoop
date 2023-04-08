package it.unibo.isaccoop.test.model.enemy;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import it.unibo.isaccoop.core.GameEngine;
import it.unibo.isaccoop.core.GameEngineImpl;
import it.unibo.isaccoop.model.room.LevelController;
import it.unibo.isaccoop.model.room.LevelControllerImpl;

class TestEnemy {

    private static final int MAX_ROOMS = 5;

    private final GameEngine gameEngine = new GameEngineImpl();
    private final LevelController gameState = new LevelControllerImpl(MAX_ROOMS, gameEngine);

    public TestEnemy() {
        this.moveToStandardRoom();
    }

    @Test
    void testEnemyRemove() {
        final var ai = gameState.getCurrentLevel().getCurrentRoom().getRoomAI().get();
        gameState.getCurrentLevel().getCurrentRoom().getEnemies().ifPresent(l -> l.forEach(e -> ai.remove(e)));
        gameState.getCurrentLevel().getCurrentRoom().getEnemies().ifPresent(l -> assertEquals(0, l.size()));
    }

    @Test
    void testEnemyView() {
        assertDoesNotThrow(() -> this.gameEngine.run());
    }

    private void moveToStandardRoom() {
        gameState.getCurrentLevel().moveToNextRoom();
        gameState.getCurrentLevel().moveToNextRoom();
        gameState.getCurrentLevel().moveToNextRoom();
    }
}
