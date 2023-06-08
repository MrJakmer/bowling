package de.docmorris.bowling;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Game {
    public static final int GAMES_PER_FRAME = 10;
    private final List<Frame> frames = new ArrayList<>(GAMES_PER_FRAME);

    public Game() {
        for (int i = 0; i < 9; i++) {
            frames.add(new Frame());
        }
        frames.add(new Frame(true));
    }

    public void playWholeGame() {
        for (final Frame frame : frames) {
            boolean anotherRoundLegal;

            do {
                anotherRoundLegal = frame.roll(frame.getPinsThrown());
            } while (anotherRoundLegal);
        }
    }

    public void setBonusPointsMultiplicator() {
        List<Roll> allRolls = frames.stream().map(Frame::getRolls).flatMap(List::stream).toList();
        int rollsCount = 0;
        for (final Frame frame : frames) {
            if (frame.isStrike() || frame.isSpare()) {
                allRolls.get(rollsCount + 2).increaseMultiplicator();
            }
            if (frame.isStrike()) {
                allRolls.get(rollsCount + 1).increaseMultiplicator();
            }

            rollsCount += frame.getRolls().size();
        }
    }

    @Override
    public String toString() {
        final var result = new StringBuilder();

        for (final Frame frame : frames) {
            result.append(frame.toString()).append("\n");
        }

        return result.toString();
    }

    public int getAllPoints() {
        return frames.stream().mapToInt(Frame::getPointsWon).sum();
    }
}
