package de.docmorris.bowling;

import static org.junit.jupiter.api.Assertions.*;

class FrameTest {
    private Frame frame;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        frame = new Frame(false);
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void rollNormalFrameState() {
        assertEquals(10,frame.getPinsLeft());
        assertEquals(0,frame.getPointsWon());
        assertFalse(frame.isSpare());
        assertFalse(frame.isStrike());
    }

    @org.junit.jupiter.api.Test
    void rollLastFrameState() {
        frame = new Frame(true);
        assertEquals(10,frame.getPinsLeft());
        assertEquals(0,frame.getPointsWon());
        assertFalse(frame.isSpare());
        assertFalse(frame.isStrike());
    }

    @org.junit.jupiter.api.Test
    void rollNormalFrameStrike() {
        assertFalse(frame.roll(10));
        assertTrue(frame.isStrike());
        assertFalse(frame.isSpare());
        assertEquals(0,frame.getPinsLeft());
        assertEquals(10,frame.getPointsWon());
    }

    @org.junit.jupiter.api.Test
    void rollLastFrameStrike() {
        frame = new Frame(true);
        assertTrue(frame.roll(10));
        assertEquals(10,frame.getPinsLeft());
        assertEquals(10,frame.getPointsWon());
        assertTrue(frame.isStrike());
        assertFalse(frame.isSpare());
        assertTrue(frame.roll(10));
        assertEquals(10,frame.getPinsLeft());
        assertEquals(20,frame.getPointsWon());
        assertTrue(frame.isStrike());
        assertFalse(frame.isSpare());
        assertFalse(frame.roll(10));
        assertEquals(0,frame.getPinsLeft());
        assertEquals(30,frame.getPointsWon());
        assertTrue(frame.isStrike());
        assertFalse(frame.isSpare());
    }

    @org.junit.jupiter.api.Test
    void rollLastFrameSpare() {
        frame = new Frame(true);
        assertTrue(frame.roll(5));
        assertFalse(frame.isStrike());
        assertFalse(frame.isSpare());
        assertTrue(frame.roll(5));
        assertFalse(frame.isStrike());
        assertTrue(frame.isSpare());
        assertFalse(frame.roll(10));
    }

    @org.junit.jupiter.api.Test
    void rollNormalFrameSpare() {
        assertTrue(frame.roll(5));
        assertFalse(frame.isSpare());
        assertFalse(frame.isStrike());
        assertFalse(frame.roll(5));
        assertFalse(frame.isStrike());
        assertTrue(frame.isSpare());
    }

    @org.junit.jupiter.api.Test
    void getPinsThrown() {
    }

    @org.junit.jupiter.api.Test
    void testToString() {
    }
}