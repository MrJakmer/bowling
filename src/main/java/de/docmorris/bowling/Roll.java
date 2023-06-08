package de.docmorris.bowling;

import java.util.Objects;

public final class Roll {
    private final int pinsThrown;
    private int multiplicator = 1;

    public Roll(int pinsThrown) {
        this.pinsThrown = pinsThrown;
    }

    public int pinsThrown() {
        return pinsThrown;
    }

    public void increaseMultiplicator() {
        multiplicator++;
    }

    @Override
    public String toString() {
        return "Roll: " + pinsThrown +
                (multiplicator != 1 ? "(x" + multiplicator +
                        " wg. Strike/Spare)" : "");
    }

    public int getMultiplicator() {
        return multiplicator;
    }
}
