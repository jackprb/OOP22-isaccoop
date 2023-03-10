package it.unibo.isaccoop.model.ai;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

import it.unibo.isaccoop.model.enemy.Enemy;

/***/
public class ConcreteAIEnemy implements AIEnemy {

    private final List<Enemy> controlledEnemies;
    private static final int MAX_ENEMIES_IN_ROOM = 3;

    /***/
    public ConcreteAIEnemy() {
        this.controlledEnemies = new ArrayList<>();
    }

    /***/
    @Override
    public void createEnemies() {
        Stream.iterate(0, i -> i + 1)
            .limit(ThreadLocalRandom.current().nextInt(ConcreteAIEnemy.MAX_ENEMIES_IN_ROOM) + 1)
            .forEach(i -> this.controlledEnemies.add(new Enemy()));
    }

    /***/
    @Override
    public void updateEnemies() {
        this.controlledEnemies.forEach(enemy -> {
            enemy.move();
            enemy.hit();
        });
    }

    /**
     * Get controlled enemies list of this {@link ConcreteAIEnemy}.
     *
     * @return controlled enemies list
     * */
    public List<Enemy> getControlledEnemies() {
        return List.copyOf(this.controlledEnemies);
    }

}
