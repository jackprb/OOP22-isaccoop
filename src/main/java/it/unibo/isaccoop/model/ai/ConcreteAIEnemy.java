package it.unibo.isaccoop.model.ai;

import java.util.List;

import it.unibo.isaccoop.model.enemy.Enemy;

/***/
public class ConcreteAIEnemy implements AIEnemy {

    private final List<Enemy> controlledEnemies;

    /**
     * Constructor for {@link ConcreteAIEnemy}.
     *
     * @param enemies enemies to attach to {@link ConcreteAIEnemy} as a {@link List}
     * */
    public ConcreteAIEnemy(final List<Enemy> enemies) {
        this.controlledEnemies = List.copyOf(enemies);
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
