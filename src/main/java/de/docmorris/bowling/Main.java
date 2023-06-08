package de.docmorris.bowling;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        game.playWholeGame();
        game.setBonusPointsMultiplicator();
        System.out.println(game);
        System.out.println(game.getAllPoints());
    }
}