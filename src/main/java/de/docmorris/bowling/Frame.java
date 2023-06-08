package de.docmorris.bowling;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Frame {
    public static final int MAX_NUMBER_PINS = 10;
    private int pinsLeft = MAX_NUMBER_PINS;
    private final List<Roll> rolls = new ArrayList<>();
    private final boolean lastFrame;
    private boolean isStrike = false;
    private boolean isSpare = false;
    private static final Random random = new Random();

    /**
     * Default Constructor for normal, non-last Frame.
     */
    public Frame() {
        this(false);
    }

    public Frame(final boolean lastFrame) {
        this.lastFrame = lastFrame;
    }

    /**
     * @return whether another roll is legal
     */
    public boolean roll(int pinsThrown) {
        if (!isLegalRoll()) {
            throw new RuntimeException("illegal role state");
        }

        final Roll roll = new Roll(pinsThrown);
        pinsLeft -= roll.pinsThrown();

        if (rolls.isEmpty() && pinsLeft == 0) {
            setStrike();
        } else if (rolls.size() == 1 && pinsLeft == 0) {
            setSpare();
        }

        rolls.add(roll);

        if (!lastFrame) {
            return !isSpare && !isStrike && hasNormalSize();
        } else {
            boolean anotherRoll = hasLastFrameValidSize();
            if (anotherRoll && pinsLeft == 0) {
                pinsLeft = MAX_NUMBER_PINS;
            }
            return anotherRoll;
        }
    }

    public int getPinsThrown() {
        return random.nextInt(pinsLeft + 1);
    }

    private boolean hasNormalSize() {
        return rolls.size() < 2;
    }

    private boolean hasLastFrameValidSize() {
        return hasNormalSize() || ((isSpare || isStrike) && rolls.size() < 3);
    }

    /**
     * @return whether the roll is legal
     */
    private boolean isLegalRoll() {
        return hasNormaFrameValidSize() || hasLastFrameValidSize();
    }

    private boolean hasNormaFrameValidSize() {
        return rolls.size() < 1 || (!isStrike && hasNormalSize());
    }

    public boolean isStrike() {
        return isStrike;
    }

    public boolean isSpare() {
        return isSpare;
    }

    /**
     * @return Pins which can be thrown next shot.
     */
    public int getPinsLeft() {
        return pinsLeft;
    }

    public int getPointsWon() {
        int result = 0;

        for (final var roll : rolls) {
            result += roll.pinsThrown() * roll.getMultiplicator();
        }

        return result;
    }

    /**
     * Sets strike to true.
     */
    private void setStrike() {
        isStrike = true;
    }

    /**
     * Sets spare  to true. Special handling for last frame case: Second roll might look like
     * a spare, but it's not if we already have a strike. Relevant for points.
     */
    private void setSpare() {
        if (!isStrike()) {
            isSpare = true;
        }
    }

    public List<Roll> getRolls() {
        return rolls;
    }

    @Override
    public String toString() {
        return "Frame{" +
                "pinsLeft=" + pinsLeft +
                ", rolls=" + rolls +
                ", pointsWon=" + getPointsWon() +
                ", lastFrame=" + lastFrame +
                ", isStrike=" + isStrike +
                ", isSpare=" + isSpare +
                '}';
    }
}
