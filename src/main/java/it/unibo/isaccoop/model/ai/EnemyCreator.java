package it.unibo.isaccoop.model.ai;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import it.unibo.isaccoop.model.common.Creator;
import it.unibo.isaccoop.model.enemy.Enemy;

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
            .map(i -> new Enemy())
            .collect(Collectors.toList());
    }

}
