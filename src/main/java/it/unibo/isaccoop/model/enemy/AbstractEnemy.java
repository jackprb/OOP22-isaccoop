package it.unibo.isaccoop.model.enemy;

import it.unibo.isaccoop.model.common.AbstractMapElement;

/***/
public abstract class AbstractEnemy extends AbstractMapElement implements Enemy { 

    /**
     * Attribute used to update enemy position incrementally.
     * */
    protected static final int DELTA = 10;

    /**
     * Contractor.
     */
    public AbstractEnemy() {
        super(ElementsRadius.ENEMY);
    }



}
