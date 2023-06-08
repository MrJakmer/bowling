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
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Roll) obj;
        return this.pinsThrown == that.pinsThrown;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pinsThrown);
    }

    @Override
    public String toString() {
        return "Roll[" +
                "pinsThrown=" + pinsThrown + ']';
    }

    public int getMultiplicator() {
        return multiplicator;
    }
}
