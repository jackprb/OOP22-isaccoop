package it.unibo.isaccoop.model.ai;

import java.util.List;

import it.unibo.isaccoop.model.common.MapElement;
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
    public void updateEnemies(final MapElement player) {
        this.controlledEnemies.forEach(enemy -> {
            enemy.move(player.getCoords());
            enemy.hit(player.getCoords());
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

    /**
     * Remove the enemy 'e' from the list.
     * @param e
     */
    @Override
    public void remove(final MapElement e) {
        this.controlledEnemies.remove(e);
    }

}
