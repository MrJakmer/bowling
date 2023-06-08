package de.docmorris.bowling;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Frame {
    public static final int MAX_NUMBER_PINS = 10;
    private int pinsLeft = MAX_NUMBER_PINS;
    private List<Roll> rolls = new ArrayList<>();
    private int pointsWon = 0;
    private final boolean lastFrame;
    private boolean isStrike = false;
    private boolean isSpare = false;
    private static final Random random = new Random();

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
        pointsWon += roll.pinsThrown();

        if (rolls.isEmpty() && pinsLeft == 0) {
            setStrike(true);
        } else if (rolls.size() == 1 && pinsLeft == 0) {
            setSpare(true);
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

    public int getPinsLeft() {
        return pinsLeft;
    }

    public int getPointsWon() {
        return pointsWon;
    }

    private void setStrike(boolean strike) {
        isStrike = strike;
    }

    /**
     * Special handling for last frame case: Second roll might look like
     * a spare but it's not if we already have a strike. Relevant for
     * points.
     *
     * @param spare value of spare
     */
    private void setSpare(boolean spare) {
        if (!isStrike()) {
            isSpare = spare;
        }
    }

    @Override
    public String toString() {
        return "Frame{" +
                "pinsLeft=" + pinsLeft +
                ", rolls=" + rolls +
                ", pointsWon=" + pointsWon +
                ", lastFrame=" + lastFrame +
                ", isStrike=" + isStrike +
                ", isSpare=" + isSpare +
                '}';
    }
}
