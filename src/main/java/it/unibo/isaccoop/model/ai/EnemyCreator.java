package it.unibo.isaccoop.model.ai;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import it.unibo.isaccoop.model.creator.Creator;
import it.unibo.isaccoop.model.enemy.Enemy;
import it.unibo.isaccoop.model.enemy.NonShootingEnemy;
import it.unibo.isaccoop.model.enemy.ShootingEnemy;

/***/
public final class EnemyCreator implements Creator<Enemy> {

    private final int maxEnemies;

    /**
     * Constructor for {@link EnemyCreator}.
     *
     * @param maxEnemies max enemies number to create
     * */
    public EnemyCreator(final int maxEnemies) {
        this.maxEnemies = maxEnemies;
    }

    @Override
    public List<Enemy> create() {
        return Stream.iterate(0, i -> i + 1)
            .limit(ThreadLocalRandom.current().nextInt(this.maxEnemies) + 1)
            .map(i -> ThreadLocalRandom.current().nextBoolean() ? new NonShootingEnemy() : new ShootingEnemy())
            .collect(Collectors.toList());
    }

}
