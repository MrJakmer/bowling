package de.docmorris.bowling;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        game.playWholeGame();
        game.setBonusPointsMultiplicator();
        System.out.println(game);
    }
}