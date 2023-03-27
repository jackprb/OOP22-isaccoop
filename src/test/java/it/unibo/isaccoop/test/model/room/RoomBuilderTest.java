package it.unibo.isaccoop.test.model.room;

import java.util.concurrent.ThreadLocalRandom;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.unibo.isaccoop.model.room.RoomBuilder.Builder;

/**
 * RoomFactory test.
 * */
class RoomBuilderTest {

    private static final int MAX_ROOM_SIZE = 500;
    private Builder builder;

    @BeforeEach
    void setUp() {
       this.builder = new Builder(ThreadLocalRandom.current().nextInt(MAX_ROOM_SIZE), 
               ThreadLocalRandom.current().nextInt(MAX_ROOM_SIZE));
    }

    @Test 
    void testPutCoord() {
    }

    @Test 
    void testRoomType() {
    }

    @Test 
    void testPutItems() {
    }

    @Test 
    void testPutEnemies() {
    }

    @Test 
    void testPutPlayer() {
    }

    @Test 
    void testPutPowerUps() {
    }

    @Test 
    void testBuild() {
    }
}
