package it.unibo.isaccoop.model.ai;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import it.unibo.isaccoop.model.enemy.Enemy;

/***/
public class ConcreteAIEnemy implements AIEnemy {

	private final List<Enemy> controlledEnemies;
	private final int maxEnemiesInRoom = 3;
	
	public ConcreteAIEnemy() {
		this.controlledEnemies = new ArrayList<>();
	}

    @Override
    public void createEnemies() {
    	Stream.iterate(0, i -> i + 1)
    		.limit(new Random().nextInt(this.maxEnemiesInRoom) + 1)
    		.forEach(i -> this.controlledEnemies.add(new Enemy()));
    }

    @Override
    public void updateEnemies() {
        this.controlledEnemies.forEach(enemy -> {
        	enemy.move();
        	enemy.hit();
        });
    }
    
    public List<Enemy> getControlledEnemies() {
		return this.controlledEnemies;
	}

}
