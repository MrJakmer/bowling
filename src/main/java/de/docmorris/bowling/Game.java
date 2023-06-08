package de.docmorris.bowling;

import java.util.ArrayList;
import java.util.List;

public class Game {
    public static final int GAMES_PER_FRAME = 10;
    private final List<Frame> frames = new ArrayList<>(GAMES_PER_FRAME);
}
